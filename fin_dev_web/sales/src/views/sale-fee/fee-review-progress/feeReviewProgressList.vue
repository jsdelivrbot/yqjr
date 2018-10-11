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
                                    <Option value="00" >驳回</Option>
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
                <Table :data="feeReviewListProData" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
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
    name: 'feeReviewProgressList',
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
                    title: '归属区域名称',
                    align: 'center',
                    key: 'areaName'
                }, {
                    title: '活动品牌',
                    align: 'center',
                    key: 'brandsName'
                }, {
                    title: '审核状态',
                    align: 'center',
                    key: 'reviewStatus',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.reviewStatus === '02' ? '待审核' : row.reviewStatus === '03' ? '审核中' : row.reviewStatus === '00' ? '驳回' : '')
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
                        const creator = params.row.creator;
                        if (reviewStatus === '00' && flag === '1' && creator == currentUser) {
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
                                                name: 'feeReviewProgressView',
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
                                                name: 'feeReviewProgressEdit',
                                                query: routerParam
                                            });
                                        }
                                    }
                                }, '修改')
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
                                                name: 'feeReviewProgressView',
                                                query: routerParam
                                            });
                                        }
                                    }
                                }, '查看')
                            ]);
                        }
                    }
                }
            ],
            excelFileName: 'data'
        };
    },
    computed: {
        ...mapState({
            loading: ({feeReviewProgressList}) => feeReviewProgressList.loading,
            feeReviewListProData: ({feeReviewProgressList}) => feeReviewProgressList.feeReviewListProData,
            pageNo: ({feeReviewProgressList}) => feeReviewProgressList.pageNo,
            pageSize: ({feeReviewProgressList}) => feeReviewProgressList.pageSize,
            total: ({feeReviewProgressList}) => feeReviewProgressList.total,
            pages: ({feeReviewProgressList}) => feeReviewProgressList.pages
        })
    },
    methods: {
        ...mapActions([
            'handleQueryFeeReviewProgressList'
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
            this.handleQueryFeeReviewProgressList(this.searchFormDate).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
            });
        },
        /**
         * 页面改变
         */
        changePage (index) {
            this.searchFormDate.pageInfo.pageNo = index;
            this.handleQueryFeeReviewProgressList(this.searchFormDate).then(res => {
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
            this.handleQueryFeeReviewProgressList(this.searchFormDate).then(res => {
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