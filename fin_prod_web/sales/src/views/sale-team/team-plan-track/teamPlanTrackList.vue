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
                <Form ref="searchFormDate" :rules="ruleValidate" :model="searchFormDate" :label-width="100">
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="团队名称:" prop="teamCode">
                                <!--<Input v-model="searchFormDate.teamCode" placeholder="请输入团队代码"></Input>-->
                                <Select  :label-in-value="true"   v-model="searchFormDate.teamCode" filterable remote :remote-method="searchName" @on-change="getCode" :loading="loading" placeholder="请输入团队名称|自动搜索" >
                                    <Option v-for="item in teamNameList"  :value="item.value" :key="item.label" :label="item.label" >{{item.label}}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="团队代码:">
                                <Input v-model="searchFormDate.teamCode" disabled></Input>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="年 份:" prop="year">
                                <DatePicker @on-change="changeYear" type="year" placeholder="查询年份" style="width: 100%" v-bind:clearable="false" v-bind:editable="false" v-bind:value="searchFormDate.year"></DatePicker>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="品 牌:">
                                <Select v-model="searchFormDate.brands" style="width:100%" placeholder="全部">
                                    <Option v-for="item in teamPlanTrackBrandsList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
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
                    表格数据
                </p>
                <a href="#" slot="extra" @click.prevent="exportExcel('searchFormDate')">
                    <Icon type="ios-cloud-download"></Icon>
                    导出数据
                </a>
                <Table :data="queryTeamPlanTrackList" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                <!--<div style="margin: 10px;overflow: hidden" >-->
                    <!--<div style="float: right;" >-->
                        <!--<Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total show-sizer :aria-disabled="true"></Page>-->
                    <!--</div>-->
                <!--</div>-->
            </Card>
        </Row>
        <a id="hrefToExportTable" style="postion: absolute;left: -10px;top: -10px;width: 0px;height: 0px;"></a>
    </div>
</template>

<script>
import table2excel from '@/libs/table2excel.js';
import {resetWorkHeight, formatDate} from '../../../libs/util';
import { mapActions, mapState } from 'vuex';
export default{
    name: 'teamPlanTrackList',
    data () {
        const validateYearCheck = (rule, value, callback) => {
            if (value === '' || value === null) {
                callback(new Error('请选择年份!'));
            }
            callback();
        };
        return {
            ruleValidate: {
                teamCode: [
                    { required: true, message: '请输入团队代码!', trigger: 'blur' }
                ],
                year: [
                    { required: true, message: '请选择年份!', trigger: 'blur' },
                    { validator: validateYearCheck }
                ]
            },
            searchFormDate: {
                teamCode: '',
                teamName: '',
                year: formatDate(new Date(), 'yyyy'),
                brands: '',
                pageInfo: {
                    pageSize: '20',
                    pageNo: '1'
                }
            },
            tableColumns: [
                {
                    title: '月份',
                    key: 'month',
                    align: 'center'
                }, {
                    title: '实际台数',
                    align: 'center',
                    key: 'planNum'
                }, {
                    title: '预算台数',
                    align: 'center',
                    key: 'actualNum'
                }, {
                    title: '达成率',
                    align: 'center',
                    key: 'planRate'
                }, {
                    title: '序时进度',
                    align: 'center',
                    key: 'rate'
                }, {
                    title: '序时进度与达成率差值',
                    align: 'center',
                    key: 'rateCal'
                }
            ],
            excelFileName: '团队计划跟踪'
        };
    },
    computed: {
        ...mapState({
            loading: ({teamPlanTrackList}) => teamPlanTrackList.loading,
            teamPlanTrackBrandsList: ({teamPlanTrackList}) => teamPlanTrackList.teamPlanTrackBrandsList,
            queryTeamPlanTrackList: ({teamPlanTrackList}) => teamPlanTrackList.queryTeamPlanTrackList,
            pageNo: ({teamPlanTrackList}) => teamPlanTrackList.pageNo,
            pageSize: ({teamPlanTrackList}) => teamPlanTrackList.pageSize,
            total: ({teamPlanTrackList}) => teamPlanTrackList.total,
            pages: ({teamPlanTrackList}) => teamPlanTrackList.pages,
            name: ({teamPlanTrackList}) => teamPlanTrackList.name,
            msg: ({teamPlanTrackList}) => teamPlanTrackList.msg,
            isSuccess: ({teamPlanTrackList}) => teamPlanTrackList.isSuccess,
            teamNameList: ({teamPlanTrackList}) => teamPlanTrackList.teamNameList
        })
    },
    methods: {
        ...mapActions([
            'handleTeamPlanQueryBrandsList',
            'handleQueryTeamPlanTrackList',
            'handleQueryTeamPlanTrackName',
            'handleCheckTeamCodeExist',
            'handelSearchTeamName'
        ]),
        /**
         * 初始化
         */
        init () {
            this.searchBrands();
        },
        /**
         * 点击查询按钮执行查询操作
         */
        searchData (name) {
            this.$refs[name].validate((valid) => {
                if (valid) {
                    // this.handleCheckTeamCodeExist(this.searchFormDate.teamCode).then(res => {
                    //     if (this.isSuccess === true) {
                    console.log(this.searchFormDate);
                    this.handleQueryTeamPlanTrackList(this.searchFormDate).then(res => {
                        resetWorkHeight();
                        // this.$Message.info('查询成功!');
                    });
                    //     } else {
                    //         this.$Message.info('请输入正确的团队编码!');
                    //     }
                    // });
                    this.handleQueryTeamPlanTrackName(this.searchFormDate.teamCode);
                } else {
                    this.$Message.error('验证错误!');
                }
            });
        },
        // /**
        //  * 页面改变
        //  */
        // changePage (index) {
        //     this.searchFormDate.pageInfo.pageNo = index;
        //     this.handleQueryTeamPlanTrackList(this.searchFormDate).then(res => {
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
        //     this.handleQueryTeamPlanTrackList(this.searchFormDate).then(res => {
        //         resetWorkHeight();
        //         this.$Message.info('查询成功!');
        //     });
        // },
        /**
         * 重置按钮
         */
        cleanData () {
            window.location.reload();
        },
        /**
         * 导出execl
         */
        exportExcel (name) {
            this.$refs[name].validate((valid) => {
                if (valid) {
                    // table2excel.transform(this.$refs.tableExcel, 'hrefToExportTable', this.excelFileName);
                    console.log(this.searchFormDate);
                    var teamCode = this.searchFormDate.teamCode;
                    var brands = this.searchFormDate.brands;
                    var year = this.searchFormDate.year;
                    window.location = '/mkmm/sales/teamSales/teamSaleExport?teamCode=' + teamCode + '&year=' + year + '&brands=' + brands;
                }
            });
        },
        /**
         * 页面加载时查询品牌
         */
        searchBrands () {
            this.handleTeamPlanQueryBrandsList().then(res => {});
        },
        changeYear (date) {
            this.searchFormDate.year = date;
        },
        /**
         * 团队代码模糊查询
         */
        searchName (name) {
            this.handelSearchTeamName(name).then(res => {});
        },
        getCode (data) {
            this.searchFormDate.teamName = data.label;
        }
    },
    mounted () {
        this.init();
    }
};
</script>