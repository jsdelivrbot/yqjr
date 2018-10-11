<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="personReviewEditData" :rules="ruleValidate" :model="personReviewEditData" :label-width="120">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    人员基本信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员代码："   >
                        <Input v-model="personReviewEditData.personCode" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="人员姓名："   >
                        <Input v-model="personReviewEditData.personName" disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="身份证号：" >
                        <Input v-model="personReviewEditData.personIdcard" disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="出生日期：" >
                        <Input  v-model="personReviewEditData.personBirth" disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="年龄：" >
                        <Input v-model="personReviewEditData.personAge" disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="民族：" >
                        <Input v-model="personReviewEditData.personEthnic" disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="婚姻状况：" >
                        <Input  v-model="personReviewEditData.personMarr" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="毕业学校：" >
                        <Input  v-model="personReviewEditData.personSchool"  disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="专业：" >
                        <Input   v-model="personReviewEditData.personSubject" disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="最高学历：" >
                        <Input   v-model="personReviewEditData.personEdu" disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="学位：" >
                        <Input  v-model="personReviewEditData.personEdulevel" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="工龄：" >
                        <Input  v-model="personReviewEditData.personWorktime"  disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="参加工作日期：" >
                        <Input disabled v-model="personReviewEditData.personFirstworktime" ></Input>
                    </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    入职信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="团队名称：" prop="tempTeamName">
                        <Input  v-model="personReviewEditData.teamName" disabled  ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="团队代码："   >
                        <Input  v-model="personReviewEditData.teamCode" disabled  ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="归属区域代码：" >
                        <Input   v-model="personReviewEditData.areaCode"  disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="归属区域名称：" >
                        <Input  v-model="personReviewEditData.areaName"  disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员性质：" prop="personNature">
                        <i-select v-model="personReviewEditData.personNature" disabled style="width:100%">
                            <i-option v-for="nature in natureList" :value="nature.value" :key="nature.value" >{{ nature.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="人员级别："  prop="personNature">
                        <i-select v-model="personReviewEditData.personLevel"  disabled style="width:100%">
                            <i-option v-for="level in levelList" :value="level.value" :key="level.value">{{ level.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员状态：" prop="personStatus">
                        <i-select v-model="personReviewEditData.personStatus"   disabled style="width:100%">
                            <i-option v-for="status in statusList" :value="status.value"  :key="status.value">{{ status.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="考核开始时间：" prop="personCheckStart">
                        <DatePicker type="date"  disabled v-model="personReviewEditData.personCheckStart"  style="width: 100%"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="上岗日期："  prop="personUptime">
                        <DatePicker type="date"   disabled v-model="personReviewEditData.personUptime"  style="width: 100%"></DatePicker>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="转正日期：" prop="personCorrectime">
                        <DatePicker type="date"  disabled  v-model="personReviewEditData.personCorrectime"  style="width: 100%"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="试用期开始日期：" prop="personTryStartime">
                        <DatePicker type="date"  disabled  v-model="personReviewEditData.personTryStartime"  style="width: 100%"></DatePicker>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="试用期结束日期："  prop="personTryEndtime">
                        <DatePicker type="date"  disabled v-model="personReviewEditData.personTryEndtime"  style="width: 100%"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="加入我司日期：" prop="personJointime">
                            <DatePicker type="date"   disabled v-model="personReviewEditData.personJointime"  style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <!--<Col span="8" offset="2">-->
                    <!--<FormItem label="生效日期："  prop="startTime">-->
                    <!--<DatePicker type="date"  v-model="editPersonData.startTime" placeholder="请选择生效日期" style="width: 220px"></DatePicker>-->
                    <!--</FormItem>-->
                    <!--</Col>-->
                </Row>
                <!--<Row>-->
                <!--<Col span="8" offset="2">-->
                <!--<FormItem label="负责省份："  >-->
                <!--<Select   v-model="personReviewEditData.provinces"  filterable multiple  :loading="loading" @on-change='getCityList' style="width: 650px">-->
                <!--<Option v-for="province in searchProvinceList"  :value="province.value"  :key="province.value">{{ province.label }}</Option>-->
                <!--</Select>-->
                <!--</FormItem>-->
                <!--</Col>-->
                <!--</Row>-->
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="负责省份：" >
                            <Select   disabled v-model="personReviewEditData.tempProvinces"  :label-in-value="true" filterable multiple placeholder="" :loading="loading"  style="width: 100%">
                                <Option v-for="item in searchProvinceList" :value="item.value" :key="item.value" >{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="负责城市：" >
                        <Select   disabled v-model="personReviewEditData.tempCities"  :label-in-value="true" filterable multiple placeholder="" :loading="loading"  style="width: 100%">
                            <Option v-for="item in searchCityList" :value="item.value" :key="item.value" >{{ item.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="负责品牌：" >
                        <Select  disabled  v-model="personReviewEditData.tempBrands"  :label-in-value="true" filterable multiple  placeholder=""  :loading="loading" style="width: 100%">
                            <Option v-for="item in searchBrandList" :value="item.value" :key="item.value" >{{ item.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    联系信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="家庭住址：" >
                        <Input  disabled v-model="personReviewEditData.personAddress" ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="家庭电话："   >
                        <Input   disabled type="text"  v-model="personReviewEditData.personHomephone" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="移动电话："  prop="personPhone">
                        <Input disabled  v-model="personReviewEditData.personPhone" ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="工作电话：" >
                        <Input  disabled type="text" v-model="personReviewEditData.personWorkphone" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="e-mail："  prop="personEmail">
                        <Input  disabled v-model="personReviewEditData.personEmail" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="备注："  prop="remark">
                        <Input   disabled v-model="personReviewEditData.remark" type="textarea"  style="width:100%"></Input>
                    </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    审核信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="审核结果：" prop="reviewStatus">
                        <Select v-model="personReviewEditData.reviewStatus" style="width:100%" @on-change='getReviewStatusName'>
                            <Option value="04" >通过</Option>
                            <Option value="00" >驳回</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="审核意见：" prop="opinion">
                        <Input v-model="opinionData" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}"></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                    <Button type="primary" icon="checkmark" @click="personReviewSub('personReviewEditData')">提交审核</Button>
                    </Col>
                    <Col span="4" >
                    <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                    </Col>
                </Row>
            </Card>
        </Form>
    </div>
</template>

<script>
    /* eslint-disable no-console */

    import {resetWorkHeight, isEmpty, formatDate} from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';
    export default{
        name: 'personReviewEdit',
        data: function () {
            const validateOpinionCheck = (rule, value, callback) => {
                if (!isEmpty(this.opinionData)) {
                    if (value.length > 265) {
                        callback(new Error('审核意见最大长度265!'));
                    }
                }
                callback();
            };
            return {
                opinionData: '同意',
                natureList: [
                    {
                        value: '0',
                        label: '团队负责人'
                    },
                    {
                        value: '1',
                        label: '销售经理'
                    }
                ],
                levelList: [
                    {
                        value: '1',
                        label: '一级'
                    }
                ],
                statusList: [
                    {
                        value: '1',
                        label: '有效'
                    },
                    {
                        value: '0',
                        label: '无效'
                    },
                    {
                        value: '2',
                        label: '注销'
                    }
                ],
                tableColumns: [
                    {
                        title: '审批意见',
                        key: 'opinion'
                    }, {
                        title: '审批结果',
                        key: 'reviewStatus',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.reviewStatus === '04' ? '通过' : '驳回')
                            ]);
                        }
                    }, {
                        title: '审核级别',
                        key: 'reviewLevel',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.reviewLevel === '1' ? '一级' : '二级')
                            ]);
                        }
                    }, {
                        title: '审核时间',
                        key: 'modifyTime',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', formatDate(row.modifyTime, 'yyyy-MM-dd hh:mm:ss'))
                            ]);
                        }
                    }
                ],
                ruleValidate: {
                    opinion: [
                        { required: true, message: '请输入审核意见!', trigger: 'blur' },
                        { validator: validateOpinionCheck }
                    ],
                    reviewStatus: [
                        { required: true, message: '请选择审核结果!', trigger: 'change' }
                    ]
                },
                searchPerson: '',
                tempTeamName: ''
            };
        },
        computed: {
            ...mapState({
                personReviewEditData: ({personReviewEdit}) => personReviewEdit.personReviewEditData,
                searchBrandList: ({personReviewEdit}) => personReviewEdit.searchBrandList,
                searchProvinceList: ({personReviewEdit}) => personReviewEdit.searchProvinceList,
                searchCityList: ({personReviewEdit}) => personReviewEdit.searchCityList,
                loading: ({personReviewEdit}) => personReviewEdit.loading,
                msg: ({personReviewEdit}) => personReviewEdit.msg,
                isSuccess: ({personReviewEdit}) => personReviewEdit.isSuccess,
                workFlowMes: ({personReviewEdit}) => personReviewEdit.workFlowMes
            })
        },
        methods: {
            ...mapActions([
                'handlePersonReviewEditData',
                'handelUpdatePersonStatus',
                'handlePersonReviewBrandsList',
                'handelPersonReviewCityList',
                'handelPersonReviewProvinceList',
                'handelPersonReviewToSubmit'
            ]),
            /**
             * 初始化页面高度，省份数据，品牌数据
             */
            init () {
                this.queryPersonProvinceList();
                resetWorkHeight();
            },
            pageBack () {
                this.$router.push({name: 'personReviewList'});
            },
            queryPersonBrandsList () {
                this.handlePersonReviewBrandsList().then(res => {
                    this.getPersonData();
                    this.updatePersonStatus();
                });
            },
            /**
             * 将审核状态更改为审核中
             */
            updatePersonStatus () {
                this.handelUpdatePersonStatus(this.$route.query.personCode).then(res => {
                });
            },
            /**
             * 调用审核查看公用接口获取人员审核数据
             */
            getPersonData () {
                this.handlePersonReviewEditData(this.$route.query.id).then(res => {
                    this.queryPersonCityList();
                });
            },
            getReviewStatusName (value) {
                if (value === '04') {
                    this.opinionData = '同意';
                } else {
                    this.opinionData = '';
                }
            },
            /**
             * 展示省市
             * @param name
             */
            queryPersonProvinceList () {
                this.handelPersonReviewProvinceList().then(res => {
                    resetWorkHeight();
                    this.queryPersonBrandsList();
                });
            },
            queryPersonCityList () {
                if (!isEmpty(this.personReviewEditData.tempProvinces)) {
                    this.handelPersonReviewCityList(this.personReviewEditData.tempProvinces).then(res => {
                        this.personReviewEditData.tempCities = this.personReviewEditData.tempCities;
                    });
                }
            },
            personReviewSub: function (name) { // 提交审核
                this.personReviewEditData.opinion = this.opinionData;
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        if (this.personReviewEditData.reviewStatus === '04' && this.workFlowMes.type === '01') {
                            if (new Date(this.personReviewEditData.startTime).getTime() < new Date().getTime()) {
                                this.$Message.error('对不起，生效时间已过，请驳回重新提交！');
                                return;
                            }
                        }
                        this.personReviewEditData.workid = this.$route.query.workId;
                        this.personReviewEditData.personTeamReviewId = this.$route.query.id;
                        console.log(this.personReviewEditData);// 此数据提交
                        this.handelPersonReviewToSubmit(this.personReviewEditData).then(res => {
                            if (this.isSuccess) {
                                this.$Modal.success({
                                    title: '提交审核',
                                    content: this.msg,
                                    onOk: () => {
                                        this.$router.push({name: 'personReviewList'});
                                    }
                                });
                            } else {
                                this.$Modal.error({
                                    title: '提交审核',
                                    content: this.msg
                                });
                            }
                        });
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            }
        },
        mounted () {
            this.init();
        }
    };
</script>