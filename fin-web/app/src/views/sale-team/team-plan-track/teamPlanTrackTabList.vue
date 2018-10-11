<style lang="less">
    @import '../../../styles/common.less';
</style>
<style>
    .demo-tabs-style1 > .ivu-tabs-card > .ivu-tabs-content {
        height: 100%;
        margin-top: -16px;
    }

    .demo-tabs-style1 > .ivu-tabs-card > .ivu-tabs-content > .ivu-tabs-tabpane {
        background: #fff;
        padding: 16px;
    }

    .demo-tabs-style1 > .ivu-tabs.ivu-tabs-card > .ivu-tabs-bar .ivu-tabs-tab {
        border-color: transparent;
    }

    .demo-tabs-style1 > .ivu-tabs-card > .ivu-tabs-bar .ivu-tabs-tab-active {
        border-color: #fff;
    }
</style>
<template>
    <div>
        <Row :gutter="4">
            <Form :label-width="100" >
                <Card>
                    <p slot="title">
                        <Icon type="search"></Icon>
                        预警审查

                    </p>
                    <Row>
                        <Col span="12" class="demo-tabs-style1" style=" background: #e3e8ee;padding:16px; width: 100%">
                            <Tabs type="card" :animated="false">
                                <TabPane label="预警详情">
                                    <Table stripe  :data="cTabList" :columns="personTableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                                    <Table stripe  :data="cTabList" :columns="calformulaList"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                                    <Table stripe  :data="cTabList" :columns="calformulaList"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                                    <Row class="margin-top-20">
                                        <Col span="4" offset="9">
                                            <Button type="primary" icon="ios-search" @click.prevent="pageBack" style="margin-right: 70px">查看反馈</Button>

                                        </Col>
                                        <Col span="6" >

                                            <Button type="info" icon="reply" @click.prevent="pageBack" >返回</Button>
                                        </Col>
                                    </Row>
                                </TabPane>
                            </Tabs>
                        </Col>
                    </Row>
                </Card>
            </Form>
        </Row>
    </div>
</template>
<script>
    import {resetWorkHeight} from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';
    export default{
        name: 'teamPlanTrackTabList',
        data () {
            return {
                personTableColumns: [
                    {
                        title: '指标代码',
                        key: 'indicatorcode',
                        align: 'center',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.indicators.indicatorcode)
                            ]);
                        }
                    }, {
                        title: '指标名称',
                        align: 'center',
                        key: 'indicatorname',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.indicators.indicatorname)
                            ]);
                        }
                    }, {
                        title: '客户名称',
                        align: 'center',
                        key: 'customname'
                    }, {
                        title: '所属区域',
                        align: 'center',
                        key: 'areaname'
                    }, {
                        title: '预警信号',
                        align: 'center',
                        key: 'signallamp',
                        render: (h, params) => {
                            const row = params.row;
                            const type = row.signallamp === '1' ? 'primary' : row.signallamp === '2' ? 'success' : row.signallamp === '3' ? 'warning' : row.signallamp === '4' ? 'error' : '';
                            const text = row.signallamp === '1' ? '蓝' : row.signallamp === '2' ? '绿' : row.signallamp === '3' ? '黄' : row.signallamp === '4' ? '红' : '';
                            return h('Button', {
                                props: {
                                    type: type
                                }
                            }, text);
                        }
                    }, {
                        title: '预警级别',
                        align: 'center',
                        key: 'signallevel'
                    }, {
                        title: '预警实际值',
                        align: 'center',
                        key: 'factvalue'
                    }, {
                        title: '预警日期',
                        align: 'center',
                        key: 'alerttime'
                    }, {
                        title: '任务状态',
                        align: 'center',
                        key: 'eventstate',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.eventstate === '0' ? '待处理任务' : '已处理任务')
                            ]);
                        }
                    }
                ],
                calformulaList: [{
                    title: '公式及说明',
                    align: 'center',
                    key: 'calformula',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.indicators.calformula)
                        ]);
                    }
                }]
            };
        },
        computed: {
            ...mapState({
                loading: ({TabList}) => TabList.loading,
                cTabList: ({TabList}) => TabList.cTabList
            })
        },
        methods: {
            ...mapActions([
                'querycomwarningByEventidSto'
            ]),
            /**
             * 初始化
             */
            init () {
                this.querycomwarningByEventid(this.$route.query.eventid);
                console.log(this.cTabList);
            },
            // /**
            //  * 查团队下的人
            //  */
            querycomwarningByEventid (eventid) {
                // console.log(code)
                this.querycomwarningByEventidSto(eventid).then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 页面改变
             */
            // changePage (index) {
            //     this.searchFormDate.pageInfo.pageNo = index;
            //     this.handleTeamMainQueryPerson().then(res => {
            //         resetWorkHeight();
            //         this.$Message.info('查询成功!');
            //         this.searchFormDate.pageInfo.pageNo = 1;
            //     });
            // },
            // /**
            //  * 切换每页条数
            //  */
            // pageSizeChange (newPageSize) {
            //     this.searchFormDate.pageInfo.pageSize = newPageSize;
            //     this.handleTeamMainQueryPerson().then(res => {
            //         resetWorkHeight();
            //         this.$Message.info('查询成功!');
            //     });
            // },
            pageBack () {
                this.$router.push({name: 'teamMainQueryList'});
            }
        },
        mounted () {
            this.init();
        }
    };
</script>
