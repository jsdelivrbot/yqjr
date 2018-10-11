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
                    <Row v-show="showFlag.areaFlag">
                        <Col span="8" offset="2">
                            <FormItem label="归属区域代码:" >
                                <Input v-model="searchFormDate.areaCode" placeholder="请输入归属区域代码"></Input>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="归属区域名称:">
                                <Input v-model="searchFormDate.areaName" placeholder="请输入归属区域名称"></Input>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="团队代码:">
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
                <Row type="flex" justify="end" :gutter="8" >
                    <Col>
                        <Button icon="android-add" type="success" @click="addData">新增</Button>
                    </Col>
                    <!--<Col>-->
                        <!--<Button icon="edit" type="warning" @click="editData">修改</Button>-->
                    <!--</Col>-->
                    <!--<Col>-->
                        <!--<Button icon="android-close" type="info" @click="viewData">查看</Button>-->
                    <!--</Col>-->
                </Row>
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
import table2excel from '@/libs/table2excel.js';
import {resetWorkHeight, getUserCookie} from '@/libs/util.js';
import { mapActions, mapState } from 'vuex';
export default{
    name: 'teamList',
    data () {
        return {
            searchFormDate: {
                areaCode: '',
                areaName: '',
                teamCode: '',
                teamName: '',
                pageInfo: {
                    pageSize: '10',
                    pageNo: '1'
                }
            },
            showFlag: {
                areaFlag: false
            },
            tableColumns: [
                {
                    title: '团队名称',
                    key: 'teamName',
                    align: 'center'
                }, {
                    title: '团队代码',
                    key: 'teamCode',
                    align: 'center'
                }, {
                    title: '归属区代码',
                    align: 'center',
                    key: 'areaCode'
                }, {
                    title: '归属区名称',
                    align: 'center',
                    key: 'areaName'
                }, {
                    title: '团队级别',
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.teamLevel === '01' ? '一级' : row.teamLevel === '02' ? '二级' : row.teamLevel === '03' ? '三级' : '')
                        ]);
                    }
                }, {
                    title: '团队类型',
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.teamType === '01' ? '普通' : '')
                        ]);
                    }
                }, {
                    title: '团队状态',
                    key: 'teamStatus',
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.teamStatus === '1' ? '有效' : '无效')
                        ]);
                    }
                }, {
                    title: '操作',
                    align: 'center',
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
                                        let routerParam = {id: params.row.id};
                                        this.$router.push({
                                            name: 'teamMainTenanceView',
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
                                        let routerParam = {id: params.row.id};
                                        this.$router.push({
                                            name: 'teamMainTenanceEdit',
                                            query: routerParam
                                        });
                                    }
                                }
                            }, '修改')
                        ]);
                    }
                }
            ],
            excelFileName: 'data'
        };
    },
    computed: {
        ...mapState({
            loading: ({teamList}) => teamList.loading,
            tableData: ({teamList}) => teamList.teamList,
            pageNo: ({teamList}) => teamList.pageNo,
            pageSize: ({teamList}) => teamList.pageSize,
            total: ({teamList}) => teamList.total,
            pages: ({teamList}) => teamList.pages
        })
    },
    methods: {
        ...mapActions([
            'handleTeamList'
        ]),
        /**
         * 初始化
         */
        init () {
            const user = getUserCookie();
            const roleCode = user.roleCodeList;
            if (roleCode.indexOf('0000') >= 0 || roleCode.indexOf('0001') >= 0 || roleCode.indexOf('0002') >= 0) {
                this.showFlag.areaFlag = true;
            } else {
                this.showFlag.areaFlag = false;
            }
            this.searchData();
        },
        /**
         * 点击查询按钮执行查询操作
         */
        searchData () {
            this.handleTeamList(this.searchFormDate).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
            });
        },
        /**
         * 页面改变
         */
        changePage (index) {
            this.searchFormDate.pageInfo.pageNo = index;
            this.handleTeamList(this.searchFormDate).then(res => {
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
            this.handleTeamList(this.searchFormDate).then(res => {
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
        /**
         * 导出execl
         */
        exportExcel () {
            table2excel.transform(this.$refs.tableExcel, 'hrefToExportTable', this.excelFileName);
        },
        /**
         * 添加数据
         */
        addData () {
            this.$router.push({name: 'teamMainTenanceAdd'});
        },
        /**
         * 修改数据
         */
        editData () {
            this.$router.push({name: 'teamMainTenanceEdit'});
        },
        /**
         * 查看数据
         */
        viewData () {
            this.$router.push({name: 'teamMainTenanceView'});
        }
    },
    mounted () {
        this.init();
    }
    // watch: {
    //     '$route' (to, from) {
    //         // 对路由变化作出响应...
    //         alert(to);
    //         alert(from);
    //         //alert(this.$route.params.id);
    //         this.init();
    //     }
    // }
};
</script>