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
                            <FormItem label="人员代码:" >
                                <Input placeholder="请输入人员代码" v-model="searchFormDate.personCode" style="width:270px"></Input>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="人员姓名:">
                                <Input  placeholder="请输入人员姓名" v-model="searchFormDate.personName" style="width:270px" ></Input>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="人员性质:">
                                <Select v-model="searchFormDate.personNature" style="width:270px" placeholder="全部">
                                    <Option placeholder="请选择人员性质"   v-for="item in personNatureList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                        <FormItem label="人员状态:">
                            <Select v-model="searchFormDate.personStatus" style="width:270px" placeholder="全部">
                                <Option placeholder="请选择人员状态"   v-for="item in personStatusList" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                <Row type="flex" justify="end" :gutter="8" >
                    <Col>
                        <Button icon="android-add"  type="success" @click="addData">添加</Button>
                    </Col>
                    <!--<Col>-->
                        <!--<Button icon="edit" type="warning" @click="editData">修改</Button>-->
                    <!--</Col>-->
                    <!--<Col>-->
                        <!--<Button icon="android-close" type="error" @click="delData">删除</Button>-->
                    <!--</Col>-->
                </Row>
                <Table :data="tableData" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                <div style="margin: 10px;overflow: hidden;">
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
import {resetWorkHeight} from '@/libs/util.js';
import { mapActions, mapState } from 'vuex';
export default{
    name: 'personList',
    data () {
        return {
            personNatureList: [{
                value: '',
                label: '全部'
            }, {
                value: '1',
                label: '销售经理'
            }, {
                value: '0',
                label: '团队负责人'

            }],
            personStatusList: [{
                value: '',
                label: '全部'
            }, {
                value: '0',
                label: '无效'
            }, {
                value: '1',
                label: '有效'
            }, {
                value: '2',
                label: '注销'
            }],
            searchFormDate: {
                personCode: '',
                personName: '',
                personStatus: '',
                personNature: '',
                pageInfo: {
                    pageSize: '10',
                    pageNo: '1'

                }
            },
            tableColumns: [
                // {
                //     type: 'selection',
                //     width: 60,
                //     align: 'center'
                // },
                {
                    title: '人员代码',
                    align: 'center',
                    key: 'personCode'
                }, {
                    title: '人员姓名',
                    align: 'center',
                    key: 'personName'
                }, {
                    title: '人员性质',
                    align: 'center',
                    key: 'personNature',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.personTeam.personNature === '0' ? '团队负责人' : row.personTeam.personNature === '1' ? '销售经理' : '')
                        ]);
                    }
                }, {
                    title: '团队代码',
                    align: 'center',
                    key: 'teamCode',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.personTeam.teamCode)
                        ]);
                    }

                }, {
                    title: '团队名称',
                    key: 'teamName',
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.teamMain.teamName)
                        ]);
                    }
                }, {
                    title: '归属区名称',
                    key: 'areaName',
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.teamMain.areaName)
                        ]);
                    }
                }, {
                    title: '人员状态',
                    key: 'personStatus',
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.personTeam.personStatus === '1' ? '有效' : row.personTeam.personStatus === '0' ? '无效' : row.personTeam.personStatus === '2' ? '注销' : '')
                        ]);
                    }
                }, {
                    title: '操作',
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        const personStatus = row.personTeam.personStatus;
                        if (personStatus === '2') {
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
                                            let personId = {id: params.row.id};
                                            this.$router.push({
                                                name: 'personMainTenanceView',
                                                query: personId
                                            });
                                        }
                                    }
                                }, '查看')
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
                                            let personId = {id: params.row.id};
                                            this.$router.push({
                                                name: 'personMainTenanceView',
                                                query: personId
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
                                            let personId = {id: params.row.id};
                                            this.$router.push({
                                                name: 'personMainTenanceEdit',
                                                query: personId
                                            });
                                        }
                                    }
                                }, '修改')
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
            loading: ({personList}) => personList.loading,
            tableData: ({personList}) => personList.personList,
            pageNo: ({personList}) => personList.pageNo,
            total: ({personList}) => personList.total,
            pageSize: ({personList}) => personList.pageSize,
            pages: ({personList}) => personList.pages

        })
    },
    methods: {
        ...mapActions([
            'handlePersonList'
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
            this.handlePersonList(this.searchFormDate).then(res => {
                resetWorkHeight();
                this.searchFormDate.pageInfo.pageNo = 1;
                // this.$Message.info('查询成功!');
            });
        },
        /**
         * 页面改变
         */
        changePage: function (index) {
            this.searchFormDate.pageInfo.pageNo = index;
            this.searchData();
        },
        /**
         * 切换每页条数
         */
        pageSizeChange: function (newPageSize) {
            this.searchFormDate.pageInfo.pageSize = newPageSize;
            this.searchData();
        },
        /**
         * 查询取消按钮
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
            this.$router.push({name: 'personMainTenanceAdd'});
        }

    },
    mounted () {
        this.init();
    }
};
</script>