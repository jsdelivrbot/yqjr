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
                <Form ref="searchFormDate" :model="searchFormDate" :label-width="100" :rules="ruleValidate">
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="归属区域名称:" >
                                <Select v-model="searchFormDate.areaCode" placeholder="全部">
                                    <Option v-for="item in areaCodeList" :value="item.value" :label="item.label" :key="item.value">{{item.label}}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="年度:">
                                <DatePicker type="year" v-model="searchFormDate.year" format="yyyy" style="width: 100%" v-bind:clearable="false" v-bind:editable="false"></DatePicker>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="人员姓名:">
                                <Input v-model="searchFormDate.personName" style="width: 100%" placeholder="请输入人员姓名"></Input>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="月份:">
                                <Select v-model="searchFormDate.month">
                                    <Option value='1'>1月</Option>
                                    <Option value='2'>2月</Option>
                                    <Option value='3'>3月</Option>
                                    <Option value='4'>4月</Option>
                                    <Option value='5'>5月</Option>
                                    <Option value='6'>6月</Option>
                                    <Option value='7'>7月</Option>
                                    <Option value='8'>8月</Option>
                                    <Option value='9'>9月</Option>
                                    <Option value='10'>10月</Option>
                                    <Option value='11'>11月</Option>
                                    <Option value='12'>12月</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="销售品牌:">
                                <Select v-model="searchFormDate.brands"  placeholder="全部">
                                    <Option v-for="item in searchDataforCarBrands" :value="item.value" :key="item.value" :label="item.label">{{item.label}}</Option>
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
                <!--<Row type="flex" :gutter="8" >-->
                    <!--<Col>-->
                        <!--<Button icon="button" type="primary" @click="exportData">导出</Button>-->
                    <!--</Col>-->
                <!--</Row>-->
                <p slot="title">
                    <Icon type="search"></Icon>
                    表格数据
                </p>
                <a href="#" slot="extra" @click.prevent="exportPlanExcel">
                    <Icon type="ios-cloud-download"></Icon>
                    导出数据
                </a>
                <Table :data="tableData" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                <div style="margin: 10px;overflow: hidden">
                    <div style="float: right;">
                        <Page :total="total" :current="pageNo" :page-size="pageSize" size="small"  @on-change="changePage" @on-page-size-change="pageSizeChange" show-total show-sizer></Page>
                    </div>
                </div>
            </Card>
        </Row>
        <a id="hrefToExportTable" style="postion: absolute;left: -10px;top: -10px;width: 0px;height: 0px;"></a>
    </div>
</template>

<script>
    import {resetWorkHeight, formatDate} from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';
    import table2excel from '@/libs/table2excel.js';
    export default {
        name: 'salePlanTrackList',
        data () {
            return {
                searchFormDate: {
                    areaCode: '',
                    year: formatDate(new Date(), 'yyyy'),
                    personName: '',
                    month: '1',
                    brands: '',
                    pageInfo: {
                        pageNo: 1,
                        pageSize: 10
                    }
                },
                ruleValidate: {

                },
                tableColumns: [
                    {
                        title: '归属区域名称',
                        key: 'areaName',
                        width: 150,
                        align: 'center',
                        fixed: 'left'
                    },
                    {
                        title: '人员姓名',
                        width: 150,
                        align: 'center',
                        key: 'personName',
                        fixed: 'left'
                    },
                    {
                        title: '人员性质',
                        width: 150,
                        align: 'center',
                        key: 'personType',
                        render: (h, params) => {
                            return ('div', [
                                h('div', params.row.personType === '1' ? '销售经理' : params.row.personType === '0' ? '团队负责人' : '')
                            ]);
                        }
                    },
                    {
                        title: '月实际台数达成量',
                        width: 150,
                        align: 'center',
                        key: 'monthActualNum'
                    },
                    {
                        title: '月台数预算',
                        width: 150,
                        align: 'center',
                        key: 'monthPlanNum'
                    },
                    {
                        title: '月台数预算达成率(%)',
                        width: 150,
                        align: 'center',
                        key: 'monthPlanRate'
                    },
                    {
                        title: '月序时进度(%)',
                        width: 150,
                        align: 'center',
                        key: 'monthRate'
                    },
                    {
                        title: '月达成率与序时进度差值(%)',
                        width: 150,
                        align: 'center',
                        key: 'monthRateCal'
                    },
                    {
                        title: '年台数实际达成量',
                        width: 150,
                        align: 'center',
                        key: 'yearActualNum'
                    },
                    {
                        title: '年台数预算数',
                        width: 150,
                        align: 'center',
                        key: 'yearPlanNum'
                    },
                    {
                        title: '年台数预算数达成率(%)',
                        width: 150,
                        align: 'center',
                        key: 'yearPlanRate'
                    },
                    {
                        title: '年序时进度(%)',
                        width: 150,
                        align: 'center',
                        key: 'yearRate'
                    },
                    {
                        title: '年达成率与序时进度差值(%)',
                        width: 150,
                        align: 'center',
                        key: 'yearRateCal'
                    }
                ],
                excelFileName: '销售计划导出'
            };
        },
        computed: {
            ...mapState({
                areaCodeList: ({salePlanTrackList}) => salePlanTrackList.areaCodeList,
                tableData: ({salePlanTrackList}) => salePlanTrackList.planTrackVoList,
                loading: ({salePlanTrackList}) => salePlanTrackList.loading,
                total: ({salePlanTrackList}) => salePlanTrackList.total,
                pageNo: ({salePlanTrackList}) => salePlanTrackList.pageNo,
                pageSize: ({salePlanTrackList}) => salePlanTrackList.pageSize,
                searchDataforCarBrands: ({salePlanTrackList}) => salePlanTrackList.searchDataforCarBrands
            })
        },
        methods: {
            init () {
                this.initArea();
                this.initCarBrands();
                this.searchData();
            },
            ...mapActions([
                'handelInitArea',
                'handelSearchDataForMes',
                'handelSearchDateForCarBrands'
            ]),
            /**
             * 初始化加载区域信息
             */
            initArea () {
                this.handelInitArea().then(res => {
                });
            },
            /**
             * 重置按钮
             */
            cleanData () {
                window.location.reload();
            },
            /**
             * 导出操作
             */
            exportData () {
                table2excel.transform(this.$refs.tableExcel, 'hrefToExportTable', this.excelFileName);
            },
            /**
             * 点击查询按钮进行数据查询
             */
            searchData () {
                console.log('join search');
                this.handelSearchDataForMes(this.searchFormDate).then(res => {
                    resetWorkHeight();
                    // this.$Message.info('查询成功');
                });
            },
            /**
             * 页面改变
             */
            changePage (index) {
                this.searchFormDate.pageInfo.pageNo = index;
                this.handelSearchDataForMes(this.searchFormDate).then(res => {
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
                this.handelSearchDataForMes(this.searchFormDate).then(res => {
                    resetWorkHeight();
                    // this.$Message.info('查询成功!');
                });
            },
            /**
             * 加载全部销售品牌
             */
            initCarBrands () {
                this.handelSearchDateForCarBrands().then(res => {
                });
            },
            /**
             * 导出计划
             */
            exportPlanExcel () {
                // var name = 'searchFormDate';
                // this.$refs[name].validate((valid) => {
                //     if (valid) {
                var exportYear = formatDate(this.searchFormDate.year, 'yyyy');
                var areaCode = this.searchFormDate.areaCode;
                var brands = this.searchFormDate.brands;
                var month = this.searchFormDate.month;
                var personName = this.searchFormDate.personName;
                window.location = '/mkmm/sales/planTracks/createTrackExcel' + '?year=' + exportYear + '&areaCode=' + areaCode + '&brands=' + brands + '&month=' + month + '&personName=' + personName;
                // } else {
                //     this.$Message.error('请输入导出年份!');
                // }
                // });
            }
        },
        mounted () {
            this.init(); // 加载初始化信息
        }
    };
</script>

<style scoped>

</style>