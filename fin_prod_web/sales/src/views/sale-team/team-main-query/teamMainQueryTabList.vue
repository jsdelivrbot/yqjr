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
                    销售团队综合信息查询与管理
                </p>
                <Row>
                <Col span="12" class="demo-tabs-style1" style=" background: #e3e8ee;padding:16px; width: 100%">
                    <Tabs :value="name" type="card" :animated="false">
                        <TabPane name="name1" label="团队基本信息">
                            <Row>
                                <Col span="8" offset="2">
                                    <FormItem label="区域名称：" >
                                        <Input v-model="teamMainQueryViewList.areaName" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="8" offset="2">
                                    <FormItem label="区域代码：" >
                                        <Input v-model="teamMainQueryViewList.areaCode" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="8" offset="2">
                                    <FormItem label="团队名称：" >
                                        <Input v-model="teamMainQueryViewList.teamName"  disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="8" offset="2">
                                    <FormItem label="团队代码：" >
                                        <Input v-model="teamMainQueryViewList.teamCode" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="8" offset="2">
                                    <FormItem label="团队等级：" >
                                        <Select v-model="teamMainQueryViewList.teamLevel" style="width:100%" disabled>
                                            <Option v-for="item in teamLevelList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                                <Col span="8" offset="2">
                                    <FormItem label="团队类别：" >
                                        <Select v-model="teamMainQueryViewList.teamType" style="width:100%" disabled>
                                            <Option v-for="item in teamTypeList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="8" offset="2">
                                    <FormItem label="团队状态：" >
                                        <Select v-model="teamMainQueryViewList.teamStatus" style="width:100%" disabled>
                                            <Option v-for="item in teamStatusList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                                <Col span="8" offset="2">
                                    <FormItem label="团队电话：" >
                                        <Input v-model="teamMainQueryViewList.teamPhone" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="8" offset="2">
                                    <FormItem label="邮编：" >
                                        <Input v-model="teamMainQueryViewList.teamZip" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="8" offset="2">
                                    <FormItem label="传真：" >
                                        <Input v-model="teamMainQueryViewList.teamFax" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="8" offset="2">
                                    <FormItem label="生效时间：" >
                                        <Input v-model="teamMainQueryViewList.startTime" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="8" offset="2">
                                    <FormItem label="创建时间：" >
                                        <Input v-model="teamMainQueryViewList.createTime" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="18" offset="2">
                                    <FormItem label="团队地址：" >
                                        <Input v-model="teamMainQueryViewList.teamAddress" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="18" offset="2">
                                    <FormItem label="备注：">
                                        <Input v-model="teamMainQueryViewList.remark" type="textarea" disabled style="width: 100%" :rows="4" :autosize="{minRows: 2,maxRows: 6}"></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row class="margin-top-20">
                                <Col span="4" offset="11">
                                    <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                                </Col>
                            </Row>
                        </TabPane>
                        <TabPane name="name2" label="团队人员信息">
                            <Table stripe  :data="teamMainQueryPersonList" :columns="personTableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                            <Row class="margin-top-20">
                                <Col span="4" offset="11">
                                    <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                                </Col>
                            </Row>
                        </TabPane>
                        <TabPane name="name3" label="团队信息变更轨迹">
                            <Table stripe  :data="teamMainQueryHisList" :columns="hisTableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                            <Row class="margin-top-20">
                                <Col span="4" offset="11">
                                    <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                                </Col>
                            </Row>
                        </TabPane>
                        <TabPane name="name4" label="重大事项记录">
                            <Table stripe  :data="teamMainQueryEventList" :columns="eventTableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                            <Row class="margin-top-20">
                                <Col span="4" offset="11">
                                    <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
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
    import {formatDate} from '../../../libs/util';
    export default{
        name: 'teamMainTabList',
        data () {
            return {
                name: this.$route.query.tabName,
                teamLevelList: [{
                    value: '01',
                    label: '一级'
                }, {
                    value: '02',
                    label: '二级'
                }, {
                    value: '03',
                    label: '三级'
                }],
                teamTypeList: [{
                    value: '01',
                    label: '普通'
                }],
                teamStatusList: [{
                    value: '1',
                    label: '有效'
                }, {
                    value: '0',
                    label: '无效'
                }],
                personTableColumns: [
                    {
                        title: '人员姓名',
                        key: 'personName',
                        align: 'center'
                    }, {
                        title: '人员代码',
                        align: 'center',
                        key: 'personCode'
                    }, {
                        title: '身份证号',
                        align: 'center',
                        key: 'personIdcard'
                    }, {
                        title: '人员性质',
                        align: 'center',
                        key: 'personNature',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.personNature === '0' ? '团队负责人' : '销售经理')
                            ]);
                        }
                    }, {
                        title: '人员级别',
                        align: 'center',
                        key: 'personLevel',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.personLevel === '1' ? '一级' : row.personLevel === '2' ? '二级' : '三级')
                            ]);
                        }
                    }, {
                        title: '入职日期',
                        align: 'center',
                        key: 'personJointime',
                        sortable: true,
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [formatDate(row.personJointime, 'yyyy-MM-dd')]);
                        }
                    }, {
                        title: '人员状态',
                        key: 'personStatus',
                        align: 'center',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.personStatus === '0' ? '无效' : row.personStatus === '1' ? '有效' : '注销')
                            ]);
                        }
                    }
                ],
                hisTableColumns: [
                    {
                        title: '操作类型',
                        key: 'reviewType',
                        align: 'center',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.reviewType === '01' ? '新增' : '修改')
                            ]);
                        }
                    }, {
                        title: '变更时间',
                        key: 'createTime',
                        align: 'center',
                        sortable: true
                    }, {
                        title: '生效日期',
                        align: 'center',
                        key: 'modifyTime'
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
                                            let routerParam = {id: params.row.id, ID: this.$route.query.id, teamCode: this.$route.query.teamCode};
                                            this.$router.push({
                                                name: 'teamMainQueryTabView',
                                                query: routerParam
                                            });
                                        }
                                    }
                                }, '查看')
                            ]);
                        }
                    }
                ],
                eventTableColumns: [
                    {
                        title: '事项年度',
                        key: 'eventYear',
                        align: 'center',
                        sortable: true
                    }, {
                        title: '事项分类',
                        key: 'eventType',
                        align: 'center',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.eventType === '0' ? '奖励' : row.eventType === '1' ? '处罚' : '其他')
                            ]);
                        }
                    }, {
                        title: '处理单位',
                        align: 'center',
                        key: 'eventApart'
                    }, {
                        title: '处理时间',
                        align: 'center',
                        key: 'createTime'
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
                                            let routerParam = {id: params.row.id, ID: this.$route.query.id, teamCode: this.$route.query.teamCode};
                                            this.$router.push({
                                                name: 'teamMainQueryTabEvent',
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
                loading: ({teamMainTabList}) => teamMainTabList.loading,
                teamMainQueryViewList: ({teamMainTabList}) => teamMainTabList.teamMainQueryViewList,
                teamMainQueryPersonList: ({teamMainTabList}) => teamMainTabList.teamMainQueryPersonList,
                teamMainQueryHisList: ({teamMainTabList}) => teamMainTabList.teamMainQueryHisList,
                teamMainQueryEventList: ({teamMainTabList}) => teamMainTabList.teamMainQueryEventList
            })
        },
        methods: {
            ...mapActions([
                'handleTeamMainQueryMainList',
                'handleTeamMainQueryPerson',
                'handleTeamMainQueryHis',
                'handleTeamMainQueryEvent'
            ]),
            /**
             * 初始化
             */
            init () {
                // console.log(this.$route.query)
                this.queryTeamMainById(this.$route.query.id);
                this.queryTeamPersonByTeamCode(this.$route.query.teamCode);
                this.queryTeamHisByTeamCode(this.$route.query.teamCode);
                this.queryTeamEventByTeamCode(this.$route.query.teamCode);
            },
            /**
             * 查团队基本信息
             * @param id
             */
            queryTeamMainById (id) {
                this.handleTeamMainQueryMainList(id).then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 查团队下的人
             */
            queryTeamPersonByTeamCode (code) {
                // console.log(code)
                this.handleTeamMainQueryPerson(code).then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 查团队变更
             */
            queryTeamHisByTeamCode (code) {
                // console.log(code)
                this.handleTeamMainQueryHis(code).then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 查团队事件
             */
            queryTeamEventByTeamCode (code) {
                // console.log(code)
                this.handleTeamMainQueryEvent(code).then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 页面改变
             */
            changePage (index) {
                this.searchFormDate.pageInfo.pageNo = index;
                this.handleTeamMainQueryPerson().then(res => {
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
                this.handleTeamMainQueryPerson().then(res => {
                    resetWorkHeight();
                    // this.$Message.info('查询成功!');
                });
            },
            pageBack () {
                this.$router.push({name: 'teamMainQueryList'});
            }
        },
        mounted () {
            this.init();
        }
    };
</script>