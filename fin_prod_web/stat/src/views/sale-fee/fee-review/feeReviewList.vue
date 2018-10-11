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
                <Form ref="formValidate" :model="searchFormDate" :label-width="100">
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="活动名称:" >
                                <Input placeholder="请输入活动名称" v-model="searchFormDate.businessName" ></Input>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="活动代码:">
                                <Input  placeholder="请输入活动代码" v-model="searchFormDate.businessCode" ></Input>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="审核类型:" >
                                <Select v-model="searchFormDate.reviewType" style="width:100%" placeholder = "全部">
                                    <Option value="" selected>全部</Option>
                                    <Option value="01" >费用动支</Option>
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
                <!--<Row type="flex" justify="end" :gutter="8" >-->
                    <!--<Col>-->
                        <!--<Button icon="edit" type="warning" @click="doPay">发起动支</Button>-->
                    <!--</Col>-->
                    <!--<Col>-->
                        <!--<Button icon="search" type="primary" @click="queryDet">查看明细</Button>-->
                    <!--</Col>-->
                <!--</Row>-->
                <Table :data="feeReviewListData" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                <div style="margin: 10px;overflow: hidden">
                    <div style="float: right;">
                        <Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total show-sizer></Page>
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
    name: 'feeReviewList',
    data () {
        return {
            searchFormDate: {
                businessName: '',
                businessCode: '',
                reviewType: '',
                reviewStatus: '',
                pageInfo: {
                    pageSize: '10',
                    pageNo: '1'
                }
            },
            tableColumns: [
                {
                    title: '活动名称',
                    align: 'center',
                    key: 'businessName'
                }, {
                    title: '活动代码',
                    align: 'center',
                    key: 'businessCode'
                }, {
                    title: '审核类型',
                    key: 'reviewType',
                    align: 'center',
                    render: (h) => {
                        return h('div', [
                            h('div', '活动费用动支')
                        ]);
                    }
                }, {
                    title: '提交人',
                    align: 'center',
                    key: 'creatorName'
                }, {
                    title: '提交时间',
                    align: 'center',
                    key: 'createTime'
                }, {
                    title: '审核状态',
                    align: 'center',
                    key: 'reviewStatus',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.reviewStatus === '02' ? '待审核' : row.reviewStatus === '03' ? '审核中' : '')
                        ]);
                    }
                }, {
                    title: '操作',
                    align: 'center',
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
                                            let routerParam = {businessCode: params.row.businessCode};
                                            this.$router.push({
                                                name: 'feeReviewView',
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
                                                let routerParam = {businessCode: params.row.businessCode};
                                                this.$router.push({
                                                    name: 'feeReviewView',
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
                                                let routerParam = {businessCode: params.row.businessCode};
                                                this.$router.push({
                                                    name: 'feeReviewEdit',
                                                    query: routerParam
                                                });
                                            }
                                        }
                                    }, '审核')
                                ]);
                            } else if (reviewStatus === '03' && flag === '1' && modifier == currentUser) {
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
                                                let routerParam = {businessCode: params.row.businessCode};
                                                this.$router.push({
                                                    name: 'feeReviewView',
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
                                                let routerParam = {businessCode: params.row.businessCode};
                                                this.$router.push({
                                                    name: 'feeReviewEdit',
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
                                                let routerParam = {businessCode: params.row.businessCode};
                                                this.$router.push({
                                                    name: 'feeReviewView',
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
            ],
            excelFileName: 'data'
        };
    },
    computed: {
        ...mapState({
            loading: ({feeReviewList}) => feeReviewList.loading,
            feeReviewListData: ({feeReviewList}) => feeReviewList.feeReviewListData,
            pageNo: ({feeReviewList}) => feeReviewList.pageNo,
            pageSize: ({feeReviewList}) => feeReviewList.pageSize,
            total: ({feeReviewList}) => feeReviewList.total,
            pages: ({feeReviewList}) => feeReviewList.pages
        })
    },
    methods: {
        ...mapActions([
            'handleQueryFeeReviewList'
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
            this.handleQueryFeeReviewList(this.searchFormDate).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
            });
        },
        /**
         * 页面改变
         */
        changePage (index) {
            this.searchFormDate.pageInfo.pageNo = index;
            this.handleQueryFeeReviewList(this.searchFormDate).then(res => {
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
            this.handleQueryFeeReviewList(this.searchFormDate).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
            });
        },
        handleSelectData (row) {
            this.searchFormDate.rowData = row;
        },
        /**
         * 重置
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