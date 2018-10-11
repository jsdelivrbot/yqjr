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
        <Form :label-width="140" >
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    销售人员综合信息查询与管理
                </p>
                <Row>
                <Col span="12" class="demo-tabs-style1" style=" background: #e3e8ee;padding:16px; width: 100%">
                    <Tabs :value="name" type="card" :animated="false">
                        <TabPane name="name1" label="人员基本信息">
                            <Card style="margin-top:10px;">
                                <p slot="title">
                                   基本信息
                                </p>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="人员代码：" >
                                        <Input v-model="personMainQueryViewData.personCode" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="人员姓名：" >
                                        <Input v-model="personMainQueryViewData.personName" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="身份证号：" >
                                        <Input v-model="personMainQueryViewData.personIdcard"  disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="出生日期：" >
                                        <Input v-model="personMainQueryViewData.personBirth" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="年龄：" >
                                        <Input v-model="personMainQueryViewData.personAge" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="民族：" >
                                        <Input v-model="personMainQueryViewData.personEthnic" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="婚姻状况：" >
                                        <Input v-model="personMainQueryViewData.personMarr" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="毕业学校：" >
                                        <Input v-model="personMainQueryViewData.personSchool" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="专业：" >
                                        <Input v-model="personMainQueryViewData.personSubject" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="最高学历：" >
                                        <Input v-model="personMainQueryViewData.personEdu" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="学位：" >
                                        <Input v-model="personMainQueryViewData.personEdulevel" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="工龄：" >
                                        <Input v-model="personMainQueryViewData.personWorktime" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="参加工作日期：" >
                                        <Input v-model="personMainQueryViewData.personFirstworktime" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            </Card>
                            <Card style="margin-top:10px;">
                                <p slot="title">
                                    入职信息
                                </p>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="团队名称：" >
                                        <Input v-model="personMainQueryViewData.teamMain.teamName" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="团队代码：" >
                                        <Input v-model="personMainQueryViewData.personTeam.teamCode" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="归属区域代码：" >
                                        <Input v-model="personMainQueryViewData.personTeam.areaCode" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="归属区域名称：" >
                                        <Input v-model="personMainQueryViewData.teamMain.areaName" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="人员性质：" >
                                        <!--<Input v-model="personMainQueryViewData.personTeam.personNature" disabled ></Input>-->
                                        <Select v-model="personMainQueryViewData.personTeam.personNature" style="width:100%" disabled>
                                            <Option v-for="item in personNatureList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="人员级别：" >
                                        <!--<Input v-model="personMainQueryViewData.personTeam.personLevel" disabled ></Input>-->
                                        <Select v-model="personMainQueryViewData.personTeam.personLevel" style="width:100%" disabled>
                                            <Option v-for="item in personLevelList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="人员状态：" >
                                        <!--<Input v-model="personMainQueryViewData.personTeam.personStatus" disabled ></Input>-->
                                        <Select v-model="personMainQueryViewData.personTeam.personStatus" style="width:100%" disabled>
                                            <Option v-for="item in personStatusList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="考核开始日期：" >
                                        <Input v-model="personMainQueryViewData.personTeam.personCheckStart" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="上岗日期：" >
                                        <Input v-model="personMainQueryViewData.personTeam.personUptime" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="转正日期：" >
                                        <Input v-model="personMainQueryViewData.personTeam.personCorrectime" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="试用期开始日期：" >
                                        <Input v-model="personMainQueryViewData.personTeam.personTryStartime" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="试用期结束日期：" >
                                        <Input v-model="personMainQueryViewData.personTeam.personTryEndtime" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="加入我司日期：" >
                                        <Input v-model="personMainQueryViewData.personTeam.personJointime" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="生效日期：" >
                                        <Input v-model="personMainQueryViewData.startTime" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="20" offset="1">
                                    <FormItem label="负责省份：" >
                                        <Select style="width:100%" disabled  v-model="personMainQueryViewData.personCity.provinceCode" placeholder=""  filterable multiple  :loading="loading">
                                            <Option v-for="province in searchProvinceList"  :value="province.value"  :key="province.value">{{ province.label }}</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="20" offset="1">
                                    <FormItem label="负责城市：" >
                                        <Select  style="width:100%" disabled v-model="personMainQueryViewData.personCity.cityCode"  placeholder="" :label-in-value="true" filterable multiple   :loading="loading">
                                            <Option v-for="city in searchCityList" :value="city.value" :key="city.value" >{{ city.label }}</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="20" offset="1">
                                    <FormItem label="负责品牌：" >
                                        <Select style="width:100%" disabled v-model="personMainQueryViewData.personBrand.brandCode"  placeholder="" :label-in-value="true"  filterable multiple  :loading="loading" >
                                            <Option v-for="brand in searchBrandList" :value="brand.value" :key="brand.value" >{{ brand.label }}</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                            </Row>
                            </Card>
                            <Card style="margin-top:10px;">
                                <p slot="title">
                                    联系信息
                                </p>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="家庭住址：" >
                                        <Input v-model="personMainQueryViewData.personAddress" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="家庭电话：" >
                                        <Input v-model="personMainQueryViewData.personHomephone" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="移动电话：" >
                                        <Input v-model="personMainQueryViewData.personPhone" disabled ></Input>
                                    </FormItem>
                                </Col>
                                <Col span="9" offset="2">
                                    <FormItem label="工作电话：" >
                                        <Input v-model="personMainQueryViewData.personWorkphone" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="9" offset="1">
                                    <FormItem label="e-mail：" >
                                        <Input v-model="personMainQueryViewData.perrsonEmail" disabled ></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="20" offset="1">
                                    <FormItem label="备注：" >
                                        <Input disabled v-model="personMainQueryViewData.remark" type="textarea" :autosize="{minRows: 2,maxRows: 6}" style="width:100%"></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                            <!--返回按钮-->
                            <Row>
                                <Col span="4" offset="11">
                                    <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                                </Col>
                            </Row>
                            </Card>
                        </TabPane>
                        <TabPane name="name2" label="人员定级历史信息">
                            <Table stripe  :data="personMainQueryHisList" :columns="hisTableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                            <!--返回按钮-->
                            <Row class="margin-top-20">
                                <Col span="4" offset="11">
                                    <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                                </Col>
                            </Row>
                        </TabPane>
                        <TabPane name="name3" label="人员基本信息变更轨迹">
                            <Table stripe  :data="personMainQueryChangeList" :columns="changeTableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                            <!--返回按钮-->
                            <Row class="margin-top-20">
                                <Col span="4" offset="11">
                                    <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                                </Col>
                            </Row>
                        </TabPane>
                        <TabPane name="name4" label="重大事项记录">
                            <Table stripe  :data="personMainQueryEventList" :columns="eventTableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                            <!--返回按钮-->
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
    import {resetWorkHeight, isEmpty} from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';
    export default{
        name: 'personMainTabList',
        data () {
            return {
                name: this.$route.query.tabName,
                personLevelList: [{
                    value: '1',
                    label: '一级'
                }, {
                    value: '2',
                    label: '二级'
                }, {
                    value: '3',
                    label: '三级'
                }],
                personNatureList: [{
                    value: '0',
                    label: '团队负责人'
                }, {
                    value: '1',
                    label: '销售经理'
                }],
                personStatusList: [{
                    value: '1',
                    label: '有效'
                }, {
                    value: '0',
                    label: '无效'
                }, {
                    value: '2',
                    label: '注销'
                }],
                hisTableColumns: [
                    {
                        title: '年度',
                        align: 'center',
                        key: 'createTime'
                    }, {
                        title: '人员级别',
                        align: 'center',
                        key: 'personLevel'
                    }
                ],
                changeTableColumns: [
                    {
                        title: '变更类型',
                        align: 'center',
                        key: 'reviewType',
                        render: (h, params) => {
                            const row = params.row;
                            if (!isEmpty(row.reviewFlag)) {
                                return h('div', [
                                    h('div', '新增')
                                ]);
                            } else {
                                return h('div', [
                                    h('div', '修改')
                                ]);
                            }
                        }
                    }, {
                        title: '变更时间',
                        align: 'center',
                        key: 'modifyTime',
                        sortable: true
                    }, {
                        title: '生效日期',
                        align: 'center',
                        key: 'startTime'
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
                                            let routerParam = {id: params.row.id, ID: this.$route.query.id, personCode: this.$route.query.personCode};
                                            this.$router.push({
                                                name: 'personMainQueryTabView',
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
                        align: 'center',
                        key: 'eventYear',
                        sortable: true
                    }, {
                        title: '事项分类',
                        align: 'center',
                        key: 'transcode1',
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
                                            let routerParam = {id: params.row.id, ID: this.$route.query.id, personCode: this.$route.query.personCode};
                                            this.$router.push({
                                                name: 'personMainQueryTabEvent',
                                                query: routerParam
                                            });
                                        }
                                    }
                                }, '查看')
                            ]);
                        }
                    }
                ],
                searchFormDate: {
                    personCode: this.$route.query.personCode,
                    pageInfo: {
                        pageSize: '10',
                        pageNo: '1'
                    }
                }
            };
        },
        computed: {
            ...mapState({
                loading: ({personMainTabList}) => personMainTabList.loading,
                personMainQueryViewData: ({personMainTabList}) => personMainTabList.personMainQueryViewData,
                searchProvinceList: ({personAdd}) => personAdd.searchProvinceList,
                searchCityList: ({personAdd}) => personAdd.searchCityList,
                searchBrandList: ({personAdd}) => personAdd.searchBrandList,
                personMainQueryHisList: ({personMainTabList}) => personMainTabList.personMainQueryHisList,
                personMainQueryChangeList: ({personMainTabList}) => personMainTabList.personMainQueryChangeList,
                personMainQueryEventList: ({personMainTabList}) => personMainTabList.personMainQueryEventList,
                isSuccess: ({personMainTabList}) => personMainTabList.isSuccess,
                msg: ({personMainTabList}) => personMainTabList.msg
            })
        },
        methods: {
            ...mapActions([
                'handleQueryProvinceList',
                'handleQueryCityList',
                'handleQueryBrandList',
                'handlePersonMainQueryMainList',
                'handlePersonMainQueryGradingHistory',
                'handlePersonMainQueryChangeTrack',
                'handlePersonMainQueryEvent'
            ]),
            /**
             * 初始化
             */
            init () {
                // console.log(this.$route.query)
                this.getProvinceList();
                // this.queryPersonMainById();
                this.queryPersonHisByPersonCode(this.searchFormDate);
                this.queryPersonChangeByPersonCode(this.$route.query.personCode);
                this.queryPersonEventByPersonCode(this.searchFormDate);
                resetWorkHeight();
            },
            // 获取省会列表
            getProvinceList () {
                this.handleQueryProvinceList().then(res => {
                    this.handleQueryBrandList().then(res => {
                        this.queryPersonMainById();
                    });
                });
            },
            /**
             * 查人员基本信息
             * @param id
             */
            queryPersonMainById () {
                this.handlePersonMainQueryMainList(this.$route.query.id).then(res => {
                    if (!isEmpty(this.personMainQueryViewData.personCity.provinceCode)) {
                        this.handleQueryCityList(this.personMainQueryViewData.personCity.provinceCode).then(res => {
                            this.personMainQueryViewData.personCity.cityCode = this.personMainQueryViewData.personCity.cityCode;
                        });
                    }
                    this.$Message.info(this.msg);
                    resetWorkHeight();
                    // this.$forceUpdate();
                });
            },
            /**
             * 查人员定级历史信息
             */
            queryPersonHisByPersonCode (data) {
                // console.log(code)
                this.handlePersonMainQueryGradingHistory(data).then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 查人员基本信息变更轨迹
             */
            queryPersonChangeByPersonCode (code) {
                // console.log(code)
                this.handlePersonMainQueryChangeTrack(code).then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 查重大事项记录
             */
            queryPersonEventByPersonCode (data) {
                // console.log(code)
                this.handlePersonMainQueryEvent(data).then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 页面改变
             */
            changePage (index) {
                this.searchFormDate.pageInfo.pageNo = index;
                this.handlePersonMainQueryGradingHistory().then(res => {
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
                this.handlePersonMainQueryGradingHistory().then(res => {
                    resetWorkHeight();
                    // this.$Message.info('查询成功!');
                });
            },
            pageBack () {
                this.$router.push({name: 'personMainQueryList'});
            }
        },
        mounted () {
            this.init();
        }
    };
</script>