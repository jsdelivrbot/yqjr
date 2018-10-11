<style>
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Row>
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    查询
                </p>
                <Form ref="formValidate" :model="formValidate" :label-width="100">
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="活动代码:">
                                <Input v-model="formValidate.activeCode" placeholder="请输入活动代码"/>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="活动名称:" >
                                <Input v-model="formValidate.activeName" placeholder="请输入活动名称"/>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="审核类型:">
                                <Select v-model="formValidate.reviewType" style="width:100%" placeholder = "全部">
                                    <Option value="" selected>全部</Option>
                                    <Option value="01" >促销活动新增</Option>
                                    <Option value="02" >促销活动修改</Option>
                                </Select>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="审核状态:" >
                                <Select v-model="formValidate.reviewStatus" style="width:100%" placeholder = "全部">
                                    <Option value="" selected>全部</Option>
                                    <Option value="02" >待审核</Option>
                                    <Option value="03" >审核中</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="4" offset="9">
                            <Button type="primary" icon="search" @click="searchDate">查询</Button>
                        </Col>
                        <Col span="4">
                            <Button icon="refresh" @click="cleanData">重置</Button>
                        </Col>
                    </Row>
                </Form>
            </Card>
        </Row>
        <Row class="margin-top-10">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    表格数据
                </p>
                <Table :data="activeReviewListData" :columns="tableColumns"  :loading="loading" class="margin-top-10"></Table>
                <div style="margin: 10px;overflow: hidden">
                    <div style="float: right;">
                        <Page :total="records" :current="pageNo" :page-size="pageSize" @on-change="changePage" @on-page-size-change="pageSizeChange" size="small" show-total show-sizer></Page>
                    </div>
                </div>
            </Card>
        </Row>
    </div>
</template>

<script>
    import {resetWorkHeight, formatDate, getUserCookie} from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';
    export default {
        name: 'activeReviewList',
        data () {
            return {
                formValidate: {
                    activeCode: '',
                    activeName: '',
                    reviewType: '',
                    reviewStatus: '',
                    pageInfo: {
                        pageNo: 1,
                        pageSize: 10
                    }
                },
                tableColumns: [
                    {
                        title: '活动代码',
                        align: 'center',
                        key: 'activeCode'
                    },
                    {
                        title: '活动名称',
                        align: 'center',
                        key: 'activeName'
                    },
                    {
                        title: '审核类型',
                        key: 'reviewType',
                        align: 'center',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.reviewType === '01' ? '新增' : '修改')
                            ]);
                        }
                    },
                    {
                        title: '提交人',
                        align: 'center',
                        key: 'creatorName'
                    },
                    {
                        title: '提交时间',
                        key: 'createTime',
                        align: 'center',
                        render: (h, params) => {
                            const row = params.row;
                            const time = formatDate(row.createTime, 'yyyy-MM-dd');
                            return h('div', [time]);
                        }
                    },
                    {
                        title: '审核状态',
                        key: 'reviewStatus',
                        align: 'center',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', [row.reviewStatus === '02' ? '待审核' : '审核中'])
                            ]);
                        }
                    },
                    {
                        title: '操作',
                        align: 'center',
                        render: (h, params) => {
                            let currentUser = getUserCookie().id;
                            let reviewStatus = params.row.reviewStatus;
                            if (currentUser === '1' || currentUser === '8506') {
                                return h('div', [
                                    h('Button', {
                                        props: {
                                            type: 'primary',
                                            size: 'small'
                                        },
                                        style: {
                                            marginRight: '6px'
                                        },
                                        on: {
                                            click: () => {
                                                let paramsId = {id: params.row.id, type: 'query', code: params.row.activeCode};
                                                this.$router.push({
                                                    name: 'activeReviewView', // 查看页面Store
                                                    query: paramsId
                                                });
                                            }
                                        }
                                    }, '查看')
                                ]);
                            } else {
                                if (reviewStatus === '02') {
                                    return h('div', [
                                        h('Button', {
                                            props: {
                                                type: 'primary',
                                                size: 'small'
                                            },
                                            style: {
                                                marginRight: '6px'
                                            },
                                            on: {
                                                click: () => {
                                                    let paramsId = {id: params.row.id, type: 'query', code: params.row.activeCode};
                                                    this.$router.push({
                                                        name: 'activeReviewView', // 查看页面Store
                                                        query: paramsId
                                                    });
                                                }
                                            }
                                        }, '查看'),
                                        h('Button', {
                                            props: {
                                                type: 'warning',
                                                size: 'small'
                                            },
                                            on: {
                                                click: () => {
                                                    let paramsMes = {id: params.row.id, type: 'update'};
                                                    this.$router.push({
                                                        name: 'activeReviewEdit', // 审核页面store
                                                        query: paramsMes
                                                    });
                                                }
                                            }
                                        }, '审核')
                                    ]);
                                } else if (reviewStatus === '03' && currentUser == params.row.modifier) {
                                    return h('div', [
                                        h('Button', {
                                            props: {
                                                type: 'primary',
                                                size: 'small'
                                            },
                                            style: {
                                                marginRight: '6px'
                                            },
                                            on: {
                                                click: () => {
                                                    let paramsId = {id: params.row.id, type: 'query', code: params.row.activeCode};
                                                    this.$router.push({
                                                        name: 'activeReviewView', // 查看页面Store
                                                        query: paramsId
                                                    });
                                                }
                                            }
                                        }, '查看'),
                                        h('Button', {
                                            props: {
                                                type: 'warning',
                                                size: 'small'
                                            },
                                            on: {
                                                click: () => {
                                                    let paramsMes = {id: params.row.id, type: 'update'};
                                                    this.$router.push({
                                                        name: 'activeReviewEdit', // 审核页面store
                                                        query: paramsMes
                                                    });
                                                }
                                            }
                                        }, '审核')
                                    ]);
                                } else {
                                    return h('div', [
                                        h('Button', {
                                            props: {
                                                type: 'primary',
                                                size: 'small'
                                            },
                                            style: {
                                                marginRight: '6px'
                                            },
                                            on: {
                                                click: () => {
                                                    let paramsId = {id: params.row.id, type: 'query', code: params.row.activeCode};
                                                    this.$router.push({
                                                        name: 'activeReviewView', // 查看页面Store
                                                        query: paramsId
                                                    });
                                                }
                                            }
                                        }, '查看')
                                    ]);
                                }
                            }
                        }
                    }
                ]
            };
        },
        computed: {
            ...mapState({
                activeReviewListData: ({activeReviewList}) => activeReviewList.activeReviewListData,
                loading: ({activeReviewList}) => activeReviewList.loading,
                total: ({activeReviewList}) => activeReviewList.total,
                pageNo: ({activeReviewList}) => activeReviewList.pageNo,
                pageSize: ({activeReviewList}) => activeReviewList.pageSize,
                records: ({activeReviewList}) => activeReviewList.records
            })
        },
        methods: {
            ...mapActions([
                'handleActiveReviewList',
                'handleDemoList'
            ]),
            init () {
                this.searchDate();
                resetWorkHeight();
            },
            searchDate () {
                this.handleActiveReviewList(this.formValidate).then(res => {
                    resetWorkHeight();
                });
            },
            changePage (newPageNum) {
                this.formValidate.pageInfo.pageNo = newPageNum;
                this.handleActiveReviewList(this.formValidate).then(res => {
                });
            },
            pageSizeChange (newPageSize) {
                this.formValidate.pageInfo.pageSize = newPageSize;
                this.formValidate.pageInfo.pageNo = 1;
                this.handleActiveReviewList(this.formValidate).then(res => {
                });
            },
            /**
             * 重置按钮
             */
            cleanData () {
                window.location.reload();
            }

        },
        mounted () {
            this.init();
        }
    };
</script>

<style scoped>

</style>