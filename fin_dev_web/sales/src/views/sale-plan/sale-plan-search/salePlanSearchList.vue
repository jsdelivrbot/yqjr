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
        <Row>
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    查询
                </p>
                <Form ref="searchFormDate" :rules="ruleValidate" :model="searchFormDate" :label-width="100">
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="年份:" prop="year" >
                                <DatePicker type="year" @on-change="getYear" style="width: 100%" placeholder="请输入年份" v-bind:clearable="false" v-bind:editable="false" v-bind:value="searchFormDate.year"></DatePicker>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2" v-show="false">
                            <FormItem label="品牌:">
                                <Input v-model="searchFormDate.brands" ></Input>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="4" offset="9">
                            <Button type="primary" icon="search" @click="searchData('searchFormDate')">查询</Button>
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
                    计划数据
                </p>
                <a href="#" slot="extra" @click.prevent="exportPlanExcel">
                    <Icon type="ios-cloud-download"></Icon>
                    年计划导出
                </a>
                <Row>
                    <Col span="12" class="demo-tabs-style1" style=" background: #e3e8ee;padding:16px; width: 100%">
                        <Tabs type="card" :animated="false" @on-click="changeBrands" >
                            <TabPane
                                    v-for="(item, index) in brandsList"
                                    :key="index"
                                    :label="item.label"
                                    :name="item.value">
                                <Table :data="tableData" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                                <div style="margin: 10px;overflow: hidden">
                                    <div style="float: right;">
                                        <Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total  show-sizer placement="top" ></Page>
                                    </div>
                                </div>
                            </TabPane>
                        </Tabs>
                    </Col>
                </Row>
            </Card>
        </Row>
    </div>
</template>

<script>
    import {formatDate} from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';
    export default {
        name: 'salePlanSearchList',
        data () {
            const validateYearCheck = (rule, value, callback) => {
                const queryYear = this.searchFormDate.year;
                if (queryYear === '' || queryYear === null) {
                    callback(new Error('请选择年份!'));
                }
                callback();
            };
            return {
                searchFormDate: {
                    year: formatDate(new Date(), 'yyyy'),
                    brands: '621',
                    pageInfo: {
                        pageSize: '10',
                        pageNo: '1'
                    }
                },
                ruleValidate: {
                    year: [
                        {required: false, message: '请选择年份!', trigger: 'blur'},
                        {validator: validateYearCheck}
                    ]
                },
                tableColumns: [
                    {
                        title: '人员姓名',
                        key: 'personName',
                        fixed: 'left',
                        align: 'center',
                        width: 150
                    }, {
                        title: '人员代码',
                        key: 'personCode',
                        align: 'center',
                        fixed: 'left',
                        width: 150
                    }, {
                        title: '一月',
                        key: 'january',
                        width: 100,
                        align: 'center'
                    }, {
                        title: '二月',
                        key: 'february',
                        width: 100,
                        align: 'center'
                    }, {
                        title: '三月',
                        key: 'march',
                        width: 100,
                        align: 'center'
                    }, {
                        title: '四月',
                        key: 'april',
                        width: 100,
                        align: 'center'
                    }, {
                        title: '五月',
                        key: 'may',
                        width: 100,
                        align: 'center'
                    }, {
                        title: '六月',
                        key: 'june',
                        width: 100,
                        align: 'center'
                    }, {
                        title: '七月',
                        key: 'jule',
                        width: 100,
                        align: 'center'
                    }, {
                        title: '八月',
                        key: 'august',
                        width: 100,
                        align: 'center'
                    }, {
                        title: '九月',
                        key: 'september',
                        width: 100,
                        align: 'center'
                    }, {
                        title: '十月',
                        key: 'october',
                        width: 100,
                        align: 'center'
                    }, {
                        title: '十一月',
                        key: 'november',
                        width: 100,
                        align: 'center'
                    }, {
                        title: '十二月',
                        key: 'december',
                        width: 100,
                        align: 'center'
                    }
                ]
            };
        },
        computed: {
            ...mapState({
                loading: ({salePlanSearchList}) => salePlanSearchList.loading,
                tableData: ({salePlanSearchList}) => salePlanSearchList.personPlanListData,
                brandsList: ({salePlanSearchList}) => salePlanSearchList.brandsList,
                pageNo: ({salePlanSearchList}) => salePlanSearchList.pageNo,
                pageSize: ({salePlanSearchList}) => salePlanSearchList.pageSize,
                total: ({salePlanSearchList}) => salePlanSearchList.total,
                pages: ({salePlanSearchList}) => salePlanSearchList.pages
            })
        },
        methods: {
            ...mapActions([
                'handleSearchCarBrands',
                'handleQueryPersonPlanList'
            ]),
            /**
             * 初始化
             */
            init () {
                this.handleSearchCarBrands().then(res => {
                    this.searchData();
                });
            },
            /**
             * 点击查询按钮执行查询操作
             */
            searchData () {
                var name2 = 'searchFormDate';
                this.$refs[name2].validate((valid) => {
                    if (valid) {
                        console.log(this.searchFormDate)
                        this.handleQueryPersonPlanList(this.searchFormDate).then(res => {
                        });
                    } else {
                        this.$Message.error('请输入查询年份!');
                    }
                });
            },
            getYear (data) {
                this.searchFormDate.year = data;
            },
            /**
             * 重置按钮
             */
            cleanData () {
                window.location.reload();
            },
            /**
             * 切换品牌
             */
            changeBrands (data) {
                console.log(data)
                var name = 'searchFormDate';
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.searchFormDate.brands = data;
                        this.handleQueryPersonPlanList(this.searchFormDate).then(res => {
                        });
                    } else {
                        this.$Message.error('请输入查询年份!');
                    }
                });
            },
            /**
             * 导出计划
             */
            exportPlanExcel () {
                var name = 'searchFormDate';
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        var exportYear = this.searchFormDate.year;
                        window.location = '/mkmm/sales/personPlans/createPlanExcel?year=' + exportYear;
                    } else {
                        this.$Message.error('请输入导出年份!');
                    }
                });
            },
            /**
             * 页面改变
             */
            changePage (index) {
                this.searchFormDate.pageInfo.pageNo = index;
                var name2 = 'searchFormDate';
                this.$refs[name2].validate((valid) => {
                    if (valid) {
                        this.handleQueryPersonPlanList(this.searchFormDate).then(res => {
                            this.searchFormDate.pageInfo.pageNo = 1;
                        });
                    } else {
                        this.$Message.error('请输入查询年份!');
                    }
                });
            },
            /**
             * 切换每页条数
             */
            pageSizeChange (newPageSize) {
                this.searchFormDate.pageInfo.pageSize = newPageSize;
                var name2 = 'searchFormDate';
                this.$refs[name2].validate((valid) => {
                    if (valid) {
                        this.handleQueryPersonPlanList(this.searchFormDate).then(res => {
                        });
                    } else {
                        this.$Message.error('请输入查询年份!');
                    }
                });
            }
        },
        mounted () {
            this.init();
        }
    };
</script>

<style scoped>

</style>