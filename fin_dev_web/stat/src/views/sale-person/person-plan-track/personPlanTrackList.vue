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
                <Form ref="formValidate" :rules="ruleValidate" :model="formValidate" :label-width="100">
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="人员姓名：" prop="personCode">
                                <!--<Input v-model="formValidate.personName" ></Input>-->
                                <Select  :label-in-value="true"   v-model="formValidate.personCode" filterable remote :remote-method="searchName" @on-change="getCode" :loading="loading" placeholder="请输入人员姓名|自动搜索" >
                                    <Option v-for="item in searchMes"  :value="item.value" :key="item.label" :label="item.label" >{{item.label}}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="人员编码：">
                                <Input v-model="formValidate.personCode" disabled></Input>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="年份：" prop="year">
                                <DatePicker type="year" @on-change="changeYear" style="width: 100%" placeholder="请输入年份"></DatePicker>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="品牌：">
                                <Select v-model="formValidate.brands" style="width:100%" placeholder="全部">
                                    <Option v-for="item in personPlanTrackBrandsList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="4" offset="9">
                            <Button type="primary" icon="search" @click="searchDataPerson('formValidate')">查询</Button>
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
                <a href="#" slot="extra" @click.prevent="exportExcel('formValidate')">
                    <Icon type="ios-cloud-download"></Icon>
                    导出数据
                </a>
                <Table :data="tableDate" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                <!--<div style="margin: 10px;overflow: hidden">-->
                    <!--<div style="float: right;">-->
                        <!--<Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total show-sizer></Page>-->
                    <!--</div>-->
                <!--</div>-->
            </Card>
        </Row>
        <a id="hrefToExportTable" style="postion: absolute;left: -10px;top: -10px;width: 0px;height: 0px;"></a>
    </div>
</template>

<script>
    import table2excel from '@/libs/table2excel.js';
    import {formatDate, resetWorkHeight} from '../../../libs/util';
    import { mapActions, mapState } from 'vuex';
    export default {
        name: 'personPlanTrackList',
        data () {
            const validateYearCheck = (rule, value, callback) => {
                if (value === '' || value === null) {
                    callback(new Error('请选择年份!'));
                }
                callback();
            };
            return {
                formValidate: {
                    personName: '',
                    personCode: '',
                    year: '',
                    brands: '',
                    pageInfo: {
                        pageSize: '20',
                        pageNo: '1'
                    }
                },
                ruleValidate: {
                    personCode: [
                        {required: true, message: '请输入人员姓名!', trigger: 'change'}
                    ],
                    year: [
                        {required: true, message: '请选择年份!', trigger: 'blur'},
                        {validator: validateYearCheck}
                    ]
                },
                tableColumns: [
                    {
                        title: '月',
                        align: 'center',
                        key: 'month'
                    },
                    {
                        title: '预算台数',
                        align: 'center',
                        key: 'planNum'
                    },
                    {
                        title: '实际台数',
                        align: 'center',
                        key: 'actualNum'
                    },
                    {
                        title: '达成率',
                        align: 'center',
                        key: 'planRate'
                    },
                    {
                        title: '序时进度',
                        align: 'center',
                        key: 'rate'
                    },
                    {
                        title: '达成率与序时进度差值',
                        align: 'center',
                        key: 'rateCal'
                    }
                ],
                excelFileName: '人员计划跟踪'
            };
        },
        computed: {
            ...mapState({
                loading: ({personPlanTrackList}) => personPlanTrackList.loading,
                tableDate: ({personPlanTrackList}) => personPlanTrackList.personPlanTrackData,
                pageNo: ({personPlanTrackList}) => personPlanTrackList.pageNo,
                pageSize: ({personPlanTrackList}) => personPlanTrackList.pageSize,
                total: ({personPlanTrackList}) => personPlanTrackList.total,
                pages: ({personPlanTrackList}) => personPlanTrackList.pages,
                personPlanTrackBrandsList: ({personPlanTrackList}) => personPlanTrackList.personPlanTrackBrandsList,
                isSuccess: ({personPlanTrackList}) => personPlanTrackList.isSuccess,
                searchMes: ({personPlanTrackList}) => personPlanTrackList.searchMes
            })
        },
        methods: {
            ...mapActions([
                'handlePersonPlanTrack',
                'handlePersonPlanQueryBrandsList',
                'handlePersonPlanTrackName',
                'handleCheckPersonCodeExist',
                'handelSearchPerosnName'
            ]),
            init () {
                this.searchBrands();
            },
            // changePage (newPageNum) {
            //     this.formValidate.pageInfo.pageNo = newPageNum;
            //     this.handlePersonPlanTrack(this.formValidate).then(res => {
            //         this.$Message.info('查询成功!');
            //     });
            // },
            // pageSizeChange (newPageSize) {
            //     this.formValidate.pageInfo.pageSize = newPageSize;
            //     this.handleDemoList(this.searchFormData).then(res => {
            //         this.$Message.info('查询成功!');
            //     });
            // },
            /**
             * 页面加载时查询品牌
             */
            searchBrands () {
                this.handlePersonPlanQueryBrandsList().then(res => {});
            },

            /**
             * 点击查询按钮执行查询操作
             */
            searchDataPerson (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        // this.handleCheckPersonCodeExist(this.formValidate.personCode).then(res => {
                        //     console.log();
                        //     if (this.isSuccess === true) {
                        // this.handlePersonPlanTrackName(this.formValidate.personCode);
                        console.log(this.formValidate);
                        this.handlePersonPlanTrack(this.formValidate).then(res => {
                            resetWorkHeight();
                            // this.$Message.info('查询成功');
                        });
                        // } else {
                        //     this.$Message.info('请输入正确的人员编码!');
                        // }
                        // });
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            },
            /**
             * 页面改变
             */
            changePage (index) {
                this.formValidate.pageInfo.pageNo = index;
                this.handlePersonPlanTrack(this.formValidate).then(res => {
                    resetWorkHeight();
                    // this.$Message.info('查询成功!');
                    this.formValidate.pageInfo.pageNo = 1;
                });
            },
            /**
             * 导出execl
             */
            exportExcel (name) {
                // table2excel.transform(this.$refs.tableExcel, 'hrefToExportTable', this.excelFileName);
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        // table2excel.transform(this.$refs.tableExcel, 'hrefToExportTable', this.excelFileName);
                        console.log(this.formValidate);
                        var personCode = this.formValidate.personCode;
                        var brands = this.formValidate.brands;
                        var year = this.formValidate.year;
                        window.location = '/mkmm/sales/personSales/personSaleExport?personCode==' + personCode + '&year=' + year + '&brands=' + brands;
                    }
                });
            },
            /**
             * 切换每页条数
             */
            pageSizeChange (newPageSize) {
                this.formValidate.pageInfo.pageSize = newPageSize;
                this.handlePersonPlanTrack(this.formValidate).then(res => {
                    resetWorkHeight();
                    // this.$Message.info('查询成功!');
                });
            },
            /**
             * 重置按钮
             */
            cleanData () {
                window.location.reload();
            },
            changeYear (date) {
                this.formValidate.year = date;
            },
            /**
             * 人员代码模糊查询
             */
            searchName (code) {
                this.handelSearchPerosnName(code).then(res => {});
            },
            getCode (data) {
                this.formValidate.personName = data.label;
            }
        },
        mounted () {
            this.init();
        }

    };
</script>

<style scoped>

</style>