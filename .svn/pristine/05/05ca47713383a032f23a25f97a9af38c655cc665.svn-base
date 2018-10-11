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
                <Form ref="formValidate" :model="searchFormData" :label-width="100">
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="活动代码:">
                                <Input  placeholder="请输入活动代码" v-model="searchFormData.activeCode" />
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="活动名称:" >
                                <Input placeholder="请输入活动名称" v-model="searchFormData.activeName" />
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="受理开始日期:">
                                <DatePicker type="date" ref="activeStartime" @on-change="formatStartTime" format="yyyy-MM-dd" placeholder="请输入受理开始日期" clearable style="width: 100%"></DatePicker>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="受理结束日期:">
                                <DatePicker  type="date" ref="activeEndtime" @on-change="formatEndTime" format="yyyy-MM-dd" placeholder="请输入受理结束日期" clearable style="width: 100%"></DatePicker>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="归属区域名称:">
                                <Input  placeholder="请输入归属区域" v-model="searchFormData.areaName" />
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
                    促销活动
                </p>
                <Row type="flex" justify="end" :gutter="8" >
                    <Col>
                        <Button icon="android-add"  type="success" @click="addData">新增</Button>
                    </Col>
                </Row>
                <Table :data="activeMainListData" :columns="tableColumns"  :loading="loading" class="margin-top-10"></Table>
                <div style="margin: 10px;overflow: hidden">
                    <div style="float: right;">
                        <Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total show-sizer></Page>
                    </div>
                </div>
            </Card>
        </Row>
    </div>
</template>
<script>
import { mapActions, mapState } from 'vuex';
import {resetWorkHeight} from '@/libs/util.js';
export default{
    name: 'activeMainList',
    data () {
        return {
            searchFormData: {
                activeCode: '',
                activeName: '',
                activeStartTime: '',
                activeEndTime: '',
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
                    width: 120,
                     fixed: 'left',
                    key: 'activeCode'
                }, {
                    title: '活动名称',
                    align: 'center',
                    width: 140,
                    fixed: 'left',
                    key: 'activeName'
                }, {
                    title: '归属区域名称',
                    align: 'center',
                    key: 'areaName',
                    width: 140
                }, {
                    title: '活动品牌',
                    align: 'center',
                    width: 120,
                    key: 'brandsName'
                }, {
                    title: '受理开始日期',
                    align: 'center',
                    width: 120,
                    key: 'activeStartime'
                }, {
                    title: '受理截止日期',
                    align: 'center',
                    width: 120,
                    key: 'activeEndtime'
                }, {
                    title: '预计笔数',
                    align: 'center',
                    width: 120,
                    key: 'expectedCount'
                }, {
                    title: '实际成交笔数',
                    align: 'center',
                    width: 120,
                    key: 'actualTurnoverCount'
                }, {
                    title: '达成率',
                    align: 'center',
                    width: 120,
                    key: 'reachRate'
                }, {
                    title: '活动状态',
                    align: 'center',
                    width: 120,
                    render: (h, params) => {
                        const row = params.row;
                        var systemTime = row.systemTime;
                        var beginTime = row.activeStartime;
                        var endTime = row.activeEndtime;
                        return h('div', [
                            h('div', systemTime > endTime ? '已结束' : systemTime >= beginTime ? '进行中' : '未开始')
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
                                    type: 'primary',
                                    size: 'small'
                                },
                                style: {
                                    marginRight: '6px'
                                },
                                on: {
                                    click: () => {
                                        let routerParam = {activeCode: params.row.activeCode};
                                        this.$router.push({
                                            name: 'activeMainView',
                                            query: routerParam
                                        });
                                    }
                                }
                            }, '查看')
                        ]);
                    }
                }
            ],
            excelFileName: '活动主页'
        };
    },
    computed: {
        ...mapState({
            loading: ({activeMainList}) => activeMainList.loading,
            activeMainListData: ({activeMainList}) => activeMainList.activeMainListData,
            pageNo: ({activeMainList}) => activeMainList.pageNo,
            pageSize: ({activeMainList}) => activeMainList.pageSize,
            total: ({activeMainList}) => activeMainList.total,
            pages: ({activeMainList}) => activeMainList.pages
        })
    },
    methods: {
        ...mapActions([
            'handleActiveMainList'
        ]),
        searchData () {
            this.searchFormData.pageInfo.pageNo = 1;
            this.handleActiveMainList(this.searchFormData).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
            });
        },
        changePage (newPageNum) {
            this.searchFormData.pageInfo.pageNo = newPageNum;
            this.handleActiveMainList(this.searchFormData).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
            });
        },
        pageSizeChange (newPageSize) {
            this.searchFormData.pageInfo.pageSize = newPageSize;
            this.searchFormData.pageInfo.pageNo = 1;
            this.handleActiveMainList(this.searchFormData).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
            });
        },
        cleanData () {
            // this.searchFormData.activeCode = '';
            // this.searchFormData.activeName = '';
            // this.$refs.activeStartime.handleClear();
            // this.$refs.activeEndtime.handleClear();
            // this.searchFormData.areaName = '';
            window.location.reload();
        },
        formatStartTime (e) {
            this.searchFormData.activeStartTime = e;
        },
        formatEndTime (e) {
            this.searchFormData.activeEndTime = e;
        },
        /**
         * 添加活动
         */
        addData () {
            this.$router.push({name: 'activeMainAdd'});
        }
    },
    mounted () {
        this.searchData();
    }
};
</script>