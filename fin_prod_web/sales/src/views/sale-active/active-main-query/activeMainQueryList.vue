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
                <Form ref="searchFormDate" :model="searchFormDate" :label-width="100">
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="活动代码:" >
                                <Input v-model="searchFormDate.activeCode" placeholder="请输入活动代码"></Input>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="活动名称:">
                                <Input v-model="searchFormDate.activeName" placeholder="请输入活动名称"></Input>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="活动状态:">
                                <Select v-model="searchFormDate.activeStatus" style="width:100%" placeholder = "全部">
                                    <Option value="" selected>全部</Option>
                                    <Option value="01" >未开始</Option>
                                    <Option value="02" >进行中</Option>
                                    <Option value="03" >已结算</Option>
                                </Select>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="动支状态:">
                                <Select v-model="searchFormDate.billStatus" style="width:100%" placeholder = "全部">
                                    <Option value="" selected>全部</Option>
                                    <Option value="00" >未动支</Option>
                                    <Option value="01" >已动支</Option>
                                    <Option value="02" >动支已发送</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="受理开始日期:" >
                                <DatePicker  @on-change="getActiveStartTime" type="date" placeholder="选择开始日期" style="width:100%;"></DatePicker>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="受理截止日期:">
                                <DatePicker  @on-change="getActiveEndTime" type="date" placeholder="选择截止日期" style="width:100%;"></DatePicker>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="活动品牌:" >
                                <Select v-model="searchFormDate.brandsCode" style="width:100%" placeholder = "全部">
                                    <Option v-for="item in brandsCodeList" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    活动信息列表
                </p>
                <Table :data="tableData" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
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
import {resetWorkHeight} from '@/libs/util.js';
import { mapActions, mapState } from 'vuex';
export default{
    name: 'activeMainQueryList',
    data () {
        return {
            searchFormDate: {
                activeCode: '',
                activeName: '',
                activeStatus: '',
                billStatus: '',
                activeStartTime: '',
                activeEndTime: '',
                brandsCode: '',
                areaName: '',
                pageInfo: {
                    pageSize: '10',
                    pageNo: '1'
                }
            },
            tableColumns: [
                {
                    title: '活动代码',
                    align: 'center',
                    width: 140,
                    fixed: 'left',
                    key: 'activeCode'
                }, {
                    title: '活动名称',
                    key: 'activeName',
                    align: 'center',
                    fixed: 'left',
                    width: 140
                }, {
                    title: '归属区域名称',
                    key: 'areaName',
                    align: 'center',
                    width: 140
                    // sortable: true
                }, {
                    title: '活动品牌',
                    key: 'brandsName',
                    align: 'center',
                    width: 120
                }, {
                    title: '受理开始日期',
                    key: 'activeStartime',
                    align: 'center',
                    width: 120
                }, {
                    title: '受理截止日期',
                    key: 'activeEndtime',
                    align: 'center',
                    width: 120

                }, {
                    title: '预计笔数',
                    key: 'expectedCount',
                    align: 'center',
                    width: 120
                }, {
                    title: '实际成交笔数',
                    key: 'actualTurnoverCount',
                    align: 'center',
                    width: 120
                }, {
                    title: '达成率',
                    key: 'reachRate',
                    align: 'center',
                    width: 120
                }, {
                    title: '活动状态',
                    key: 'activeStatus',
                    align: 'center',
                    width: 120,
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.activeStatus === '01' ? '未开始' : row.activeStatus === '02' ? '进行中' : row.activeStatus === '03' ? '已结束' : '')
                        ]);
                    }
                }, {
                    title: '动支状态',
                    key: 'billStatus',
                    align: 'center',
                    width: 120,
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.billStatus === '00' ? '未动支' : row.billStatus === '01' ? '已动支' : row.billStatus === '02' ? '动支已发送' : '')
                        ]);
                    }
                }, {
                    title: '操作',
                    align: 'center',
                    width: 140,
                    fixed: 'right',
                    render: (h, params) => {
                        return h('div', [
                            h('Button', {
                                props: {
                                    type: 'success',
                                    size: 'small'
                                },
                                style: {
                                    marginRight: '6px'
                                },
                                on: {
                                    click: () => {
                                        let routerParam = {activeCode: params.row.activeCode};
                                        this.$router.push({
                                            name: 'activeMainQueryView',
                                            query: routerParam
                                        });
                                    }
                                }
                            }, '查看')
                        ]);
                    }
                }
            ]
        };
    },
    computed: {
        ...mapState({
            loading: ({activeMainQueryList}) => activeMainQueryList.loading,
            tableData: ({activeMainQueryList}) => activeMainQueryList.activeMainQueryList,
            brandsCodeList: ({activeMainQueryList}) => activeMainQueryList.brandsCodeList,
            pageNo: ({activeMainQueryList}) => activeMainQueryList.pageNo,
            pageSize: ({activeMainQueryList}) => activeMainQueryList.pageSize,
            total: ({activeMainQueryList}) => activeMainQueryList.total,
            pages: ({activeMainQueryList}) => activeMainQueryList.pages,
            isSuccess: ({activeMainQueryList}) => activeMainQueryList.isSuccess,
            msg: ({activeMainQueryList}) => activeMainQueryList.msg
        })
    },
    methods: {
        ...mapActions([
            'handleActiveMainQueryList',
            'handleActiveMainBrandsCodeQueryList'
        ]),
        /**
         * 初始化
         */
        init () {
            // 获取品牌下拉列表的数据
            this.getBrandsCode();
            resetWorkHeight();
        },
        // 获取品牌信息
        getBrandsCode () {
            this.handleActiveMainBrandsCodeQueryList().then(res => {
                this.searchData();
            });
        },
        /**
         * 点击查询按钮执行查询操作
         */
        searchData: function () {
            this.handleActiveMainQueryList(this.searchFormDate).then(res => {
                if (!this.isSuccess) {
                    this.$Message.info(this.msg);
                }
                resetWorkHeight();
            });
        },
        // 点击重置按钮执行重置操作
        cleanData () {
            window.location.reload();
        },
        /**
         * 页面改变
         */
        changePage (index) {
            this.searchFormDate.pageInfo.pageNo = index;
            this.handleActiveMainQueryList(this.searchFormDate).then(res => {
                // if (this.isSuccess) {
                //     this.$Message.info(this.msg);
                // } else {
                //     this.$Message.info(this.msg);
                // }
                resetWorkHeight();
                this.searchFormDate.pageInfo.pageNo = 1;
            });
        },
        /**
         * 切换每页条数
         */
        pageSizeChange (newPageSize) {
            this.searchFormDate.pageInfo.pageSize = newPageSize;
            this.handleActiveMainQueryList(this.searchFormDate).then(res => {
                // if (this.isSuccess) {
                //     this.$Message.info(this.msg);
                // } else {
                //     this.$Message.info(this.msg);
                // }
                resetWorkHeight();
            });
        },
        /**
         * 时间查询
         */
        getActiveStartTime (date) {
            this.searchFormDate.activeStartTime = date;
        },
        getActiveEndTime (date) {
            this.searchFormDate.activeEndTime = date;
        }
    },
    mounted () {
        this.init();
    }
};
</script>