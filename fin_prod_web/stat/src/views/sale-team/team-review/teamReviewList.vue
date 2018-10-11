<style lang="less">
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
                <Form ref="searchFormDate"  :model="searchFormDate" :label-width="100">
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="团队代码:" >
                                <Input v-model="searchFormDate.teamCode" placeholder="请输入团队代码"></Input>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="团队名称:">
                                <Input v-model="searchFormDate.teamName" placeholder="请输入团队名称"></Input>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="审核类型:" >
                                <Select v-model="searchFormDate.reviewType" style="width:100%" placeholder = "全部">
                                    <Option value="" selected>全部</Option>
                                    <Option value="01" >团队新增</Option>
                                    <Option value="02" >团队修改</Option>
                                </Select>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="审核状态:">
                                <Select v-model="searchFormDate.reviewStatus" style="width:100%" placeholder = "全部">
                                    <Option value="" selected>全部</Option>
                                    <Option value="02" >待审核</Option>
                                    <Option value="03" >审核中</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="4" offset="9">
                            <Button type="primary" icon="search" @click="searchData">查询</Button>
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
                <!--<a href="#" slot="extra" @click.prevent="exportExcel">-->
                    <!--<Icon type="ios-cloud-download"></Icon>-->
                    <!--导出数据-->
                <!--</a>-->
                <Table :data="teamReviewListData" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                <div style="margin: 10px;overflow: hidden" >
                    <div style="float: right;" >
                        <Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total show-sizer :aria-disabled="true"></Page>
                    </div>
                </div>
            </Card>
        </Row>
        <a id="hrefToExportTable" style="postion: absolute;left: -10px;top: -10px;width: 0px;height: 0px;"></a>
    </div>
</template>

<script>
import {resetWorkHeight, getUserCookie} from '@/libs/util.js';
import { mapActions, mapState } from 'vuex';
export default{
    name: 'teamPlanTrackList',
    data () {
        return {
            searchFormDate: {
                teamCode: '',
                teamName: '',
                reviewType: '',
                reviewStatus: '',
                pageInfo: {
                    pageSize: '10',
                    pageNo: '1'
                }
            },
            tableColumns: [
                {
                    title: '团队名称',
                    key: 'teamName',
                    align: 'center',
                    width: 200,
                    fixed: 'left'
                }, {
                    title: '团队代码',
                    align: 'center',
                    width: 200,
                    key: 'teamCode'
                }, {
                    title: '审核类型',
                    key: 'reviewType',
                    width: 200,
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.reviewType === '01' ? '团队新增' : '团队修改')
                        ]);
                    }
                }, {
                    title: '提交人',
                    align: 'center',
                    width: 200,
                    key: 'createName'
                }, {
                    title: '提交时间',
                    key: 'createTime',
                    align: 'center',
                    width: 200,
                    sortable: true
                }, {
                    title: '审核状态',
                    key: 'reviewStatus',
                    align: 'center',
                    width: 200,
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.reviewStatus === '02' ? '待审核' : '审核中')
                        ]);
                    }
                }, {
                    title: '操作',
                    align: 'center',
                    width: 150,
                    fixed: 'right',
                    render: (h, params) => {
                        const reviewStatus = params.row.reviewStatus;
                        const flag = params.row.flag;
                        const user = getUserCookie();
                        const currentUser = user.id;
                        const modifier = params.row.modifier;
                        if (currentUser === 1 || currentUser === 8506) {
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
                                            let routerParam = {id: params.row.id, workId: params.row.workId, teamCode: params.row.teamCode};
                                            this.$router.push({
                                                name: 'teamReviewView',
                                                query: routerParam
                                            });
                                        }
                                    }
                                }, '查看')
                            ]);
                        } else {
                            if (reviewStatus === '02' && flag === '1') {
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
                                                let routerParam = {id: params.row.id, workId: params.row.workId, teamCode: params.row.teamCode};
                                                this.$router.push({
                                                    name: 'teamReviewView',
                                                    query: routerParam
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
                                                let routerParam = {id: params.row.id, workId: params.row.workId};
                                                this.$router.push({
                                                    name: 'teamReviewEdit',
                                                    query: routerParam
                                                });
                                            }
                                        }
                                    }, '审核')
                                ]);
                            } else if (reviewStatus === '03' && currentUser == modifier && flag === '1') {
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
                                                let routerParam = {id: params.row.id, workId: params.row.workId, teamCode: params.row.teamCode};
                                                this.$router.push({
                                                    name: 'teamReviewView',
                                                    query: routerParam
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
                                                let routerParam = {id: params.row.id, workId: params.row.workId};
                                                this.$router.push({
                                                    name: 'teamReviewEdit',
                                                    query: routerParam
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
                                                let routerParam = {id: params.row.id, workId: params.row.workId};
                                                this.$router.push({
                                                    name: 'teamReviewView',
                                                    query: routerParam
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
            loading: ({teamReviewList}) => teamReviewList.loading,
            pageNo: ({teamReviewList}) => teamReviewList.pageNo,
            teamReviewListData: ({teamReviewList}) => teamReviewList.teamReviewListData,
            pageSize: ({teamReviewList}) => teamReviewList.pageSize,
            total: ({teamReviewList}) => teamReviewList.total,
            pages: ({teamReviewList}) => teamReviewList.pages
        })
    },
    methods: {
        ...mapActions([
            'handleQueryTeamReviewList'
        ]),
        /**
         * 初始化
         */
        init () {
            this.searchData();
        },
        /**
         * 点击查询按钮执行查询操作
         */
        searchData () {
            this.handleQueryTeamReviewList(this.searchFormDate).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
            });
        },
        /**
         * 页面改变
         */
        changePage (index) {
            this.searchFormDate.pageInfo.pageNo = index;
            this.handleQueryTeamReviewList(this.searchFormDate).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
                this.searchFormDate.pageInfo.pageNo = 1;
            });
        },
        /**
         * 切换每页条数
         */
        pageSizeChange (newPageSize) {
            this.searchFormDate.pageInfo.pageSize = newPageSize;
            this.handleQueryTeamReviewList(this.searchFormDate).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
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