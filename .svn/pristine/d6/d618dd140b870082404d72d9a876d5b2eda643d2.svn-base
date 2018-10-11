<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="personReviewProgressData" :rules="ruleValidate" :model="personReviewProgressData" :label-width="120">
            <Card>
                <p slot="title">
                    <Icon type="edit"></Icon>
                    人员基本信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员代码："   >
                        <Input v-model="personReviewProgressData.personCode" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="人员姓名："   >
                        <Input v-model="personReviewProgressData.personName" disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="身份证号：" >
                        <Input v-model="personReviewProgressData.personIdcard" disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="出生日期：" >
                        <Input  v-model="personReviewProgressData.personBirth" disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="年龄：" >
                        <Input v-model="personReviewProgressData.personAge" disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="民族：" >
                        <Input v-model="personReviewProgressData.personEthnic" disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="婚姻状况：" >
                        <Input  v-model="personReviewProgressData.personMarr" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="毕业学校：" >
                        <Input  v-model="personReviewProgressData.personSchool"  disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="专业：" >
                        <Input   v-model="personReviewProgressData.personSubject" disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="最高学历：" >
                        <Input   v-model="personReviewProgressData.personEdu" disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="学位：" >
                        <Input  v-model="personReviewProgressData.personEdulevel" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="工龄：" >
                        <Input  v-model="personReviewProgressData.personWorktime"  disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="参加工作日期：" >
                        <Input disabled v-model="personReviewProgressData.personFirstworktime" ></Input>
                    </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    入职信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="团队名称：" prop="teamName">
                        <Input  v-model="personReviewProgressData.teamName" disabled  ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="团队代码："   >
                        <Input  v-model="personReviewProgressData.teamCode" disabled  ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="归属区域代码：" >
                        <Input   v-model="personReviewProgressData.areaCode"  disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="归属区域名称：" >
                        <Input  v-model="personReviewProgressData.areaName"  disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员性质：" prop="personNature">
                        <i-select v-model="personReviewProgressData.personNature" style="width:100%">
                            <i-option v-for="nature in natureList" :value="nature.value" :key="nature.value" >{{ nature.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="人员级别："  prop="personNature">
                        <i-select v-model="personReviewProgressData.personLevel"  disabled style="width:100%">
                            <i-option v-for="level in levelList" :value="level.value" :key="level.value">{{ level.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员状态：" prop="personStatus">
                        <i-select v-model="personReviewProgressData.personStatus"  style="width:100%" v-bind:disabled="disabledFlag">
                            <i-option v-for="status in statusList" :value="status.value"  :key="status.value">{{ status.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="考核开始时间：" prop="personCheckStart">
                        <DatePicker type="date" v-model="personReviewProgressData.personCheckStart" placeholder="请选择开始时间" style="width: 100%"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="上岗日期："  prop="personUptime">
                        <DatePicker type="date" v-model="personReviewProgressData.personUptime" placeholder="请选择上岗日期" style="width: 100%"></DatePicker>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="转正日期：" prop="personCorrectime">
                        <DatePicker type="date" v-model="personReviewProgressData.personCorrectime" placeholder="请选择转正日期" style="width: 100%"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="试用期开始日期：" prop="personTryStartime">
                        <DatePicker type="date" v-model="personReviewProgressData.personTryStartime" placeholder="请选择使用期开始日期" style="width: 100%"></DatePicker>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="试用期结束日期："  prop="personTryEndtime">
                        <DatePicker type="date" v-model="personReviewProgressData.personTryEndtime" placeholder="请选择试用期结束日期" style="width: 100%"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="加入我司日期：" prop="personJointime">
                        <DatePicker type="date"  v-model="personReviewProgressData.personJointime" placeholder="请选择加入我司日期" style="width: 100%"></DatePicker>
                    </FormItem>
                    </Col>
                    <Col  v-if="personReviewProgressData.reviewType == '01'" span="8" offset="2" >
                    <FormItem label="生效日期："  prop="startTime">
                        <DatePicker type="date"  v-model="personReviewProgressData.startTime" placeholder="请选择生效日期" style="width: 220px"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="负责省份："  >
                        <Select   v-model="personReviewProgressData.provinces"  filterable multiple  :loading="loading" @on-change='getCityList' style="width: 100%">
                            <Option v-for="province in searchProvinceList"  :value="province.value"  :key="province.value">{{ province.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="负责城市：" >
                        <Select  v-model="personReviewProgressData.cities"  :label-in-value="true" filterable multiple  @on-change='getCityArr'  :loading="loading"  style="width: 100%;">
                            <Option v-for="city in searchCityList" :value="city.value" :key="city.value" >{{ city.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="负责品牌：" >
                        <Select  v-model="personReviewProgressData.brands"  :label-in-value="true" filterable multiple    @on-change='getBrandArr' :loading="loading" style="width: 100%;">
                            <Option v-for="brand in searchBrandList" :value="brand.value" :key="brand.value" >{{ brand.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    联系信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="家庭住址：" >
                        <Input v-model="personReviewProgressData.personAddress" ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="家庭电话："   >
                        <Input  type="text"  v-model="personReviewProgressData.personHomephone" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="移动电话："  prop="personPhone">
                        <Input v-model="personReviewProgressData.personPhone" ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="工作电话：" >
                        <Input type="text" v-model="personReviewProgressData.personWorkphone" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="e-mail："  prop="personEmail">
                        <Input v-model="personReviewProgressData.personEmail" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="备注："  prop="remark">
                            <Input  v-model="personReviewProgressData.remark" type="textarea"  style="width:100%; " :autosize="{minRows: 2,maxRows: 6}"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                    <Button type="primary" icon="checkmark" @click="subPersonReviewProgressData('personReviewProgressData')">提交审核</Button>
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
        name: 'personReviewProgressEdit',
        data: function () {
            const validatePersonCheckStart = (rule, value, callback) => {
                if (!isEmpty(this.personReviewProgressData.personCheckStart)) {
                    if (new Date(value).getTime() >= new Date(this.personReviewProgressData.personCorrectime).getTime()) {
                        callback(new Error('考核时间不能大于转正时间'));
                    }
                }
                callback();
            };
            const validateStartDateCheck = (rule, value, callback) => {
                var date = new Date(value);
                var now = new Date();
                if (date.getTime() <= now.getTime()) {
                    callback(new Error('生效日期需大于当天!'));
                }
                callback();
            };
            const validatePersonUptime = (rule, value, callback) => {
                if (!isEmpty(this.personReviewProgressData.personTryStartime)) {
                    if (new Date(value).getTime() >= new Date(this.personReviewProgressData.personTryStartime).getTime()) {
                        callback(new Error('上岗时间不能大于试用开始时间'));
                    }
                } else if (!isEmpty(this.personReviewProgressData.personUptime)) {
                    if (new Date(value).getTime() >= new Date(this.personReviewProgressData.personTryEndtime).getTime()) {
                        callback(new Error('上岗时间不能大于试用结束时间'));
                    }
                } else if (!isEmpty(this.personReviewProgressData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.personReviewProgressData.personCorrectime).getTime()) {
                        callback(new Error('上岗时间不能大于转正时间'));
                    }
                }
                callback();
            };

            const validatePersonCorrectime = (rule, value, callback) => {
                if (!isEmpty(this.personReviewProgressData.personTryStartime)) {
                    if (new Date(value).getTime() <= new Date(this.personReviewProgressData.personTryStartime).getTime()) {
                        callback(new Error('转正时间不能小于试用开始时间'));
                    }
                } else if (!isEmpty(this.personReviewProgressData.personTryEndtime)) {
                    if (new Date(value).getTime() <= new Date(this.personReviewProgressData.personTryEndtime).getTime()) {
                        callback(new Error('转正时间不能小于试用结束时间'));
                    }
                } else if (!isEmpty(this.personReviewProgressData.personUptime)) {
                    if (new Date(value).getTime() <= new Date(this.personReviewProgressData.personUptime).getTime()) {
                        callback(new Error('转正时间不能小于上岗时间'));
                    }
                } else if (!isEmpty(this.personReviewProgressData.personCheckStart)) {
                    if (new Date(value).getTime() <= new Date(this.personReviewProgressData.personCheckStart).getTime()) {
                        callback(new Error('转正时间不能小于考核开始时间'));
                    }
                } else if (!isEmpty(this.personReviewProgressData.personCheckStart)) {
                    if (new Date(value).getTime() <= new Date(this.personReviewProgressData.personJointime).getTime()) {
                        callback(new Error('转正时间不能小于加入我司时间'));
                    }
                }
                callback();
            };
            const validatePersonTryStartime = (rule, value, callback) => {
                if (!isEmpty(this.personReviewProgressData.personUptime)) {
                    if (new Date(value).getTime() <= new Date(this.personReviewProgressData.personUptime).getTime()) {
                        callback(new Error('试用开始时间不能小于上岗时间'));
                    }
                } else if (!isEmpty(this.personReviewProgressData.personTryEndtime)) {
                    if (new Date(value).getTime() >= new Date(this.personReviewProgressData.personTryEndtime).getTime()) {
                        callback(new Error('试用开始时间不能大于试用结束时间'));
                    }
                } else if (!isEmpty(this.personReviewProgressData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.personReviewProgressData.personCorrectime).getTime()) {
                        callback(new Error('试用开始时间不能大于转正时间'));
                    }
                }
                callback();
            };
            const validatePersonTryEndtime = (rule, value, callback) => {
                if (!isEmpty(this.personReviewProgressData.personUptime)) {
                    if (new Date(value).getTime() <= new Date(this.personReviewProgressData.personUptime).getTime()) {
                        callback(new Error('试用结束时间不能小于上岗时间'));
                    }
                } else if (!isEmpty(this.personReviewProgressData.personTryStartime)) {
                    if (new Date(value).getTime() <= new Date(this.personReviewProgressData.personTryStartime).getTime()) {
                        callback(new Error('试用结束时间不能小于试用期开始时间'));
                    }
                } else if (!isEmpty(this.personReviewProgressData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.personReviewProgressData.personCorrectime).getTime()) {
                        callback(new Error('试用结束时间不能大于转正时间'));
                    }
                }
                callback();
            };
            const validatePersonJointime = (rule, value, callback) => {
                if (!isEmpty(this.personReviewProgressData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.personReviewProgressData.personCorrectime).getTime()) {
                        callback(new Error('加入我司时间不能大于转正时间'));
                    }
                }
                callback();
            };
            const validatePhone = (rule, value, callback) => {
                var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
                var phone = /^0\d{2,3}-?\d{7,8}$/;
                if (myreg.test(value)) {
                    callback();
                } else if (phone.test(value)) {
                    callback();
                } else {
                    callback(new Error('请输入正确的电话格式'));
                }
                callback();
            };
            const validateWorkphone = (rule, value, callback) => {
                var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
                var phone = /^0\d{2,3}-?\d{7,8}$/;
                if (myreg.test(value)) {
                    callback();
                } else if (phone.test(value)) {
                    callback();
                } else {
                    callback(new Error('请输入正确的电话格式'));
                }
                callback();
            };
            const validateHomephone = (rule, value, callback) => {
                var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
                var phone = /^0\d{2,3}-?\d{7,8}$/;
                if (myreg.test(value)) {
                    callback();
                } else if (phone.test(value)) {
                    callback();
                } else {
                    callback(new Error('请输入正确的电话格式'));
                }
                callback();
            };
            return {
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
                ruleValidate: {
                    tempTeamName: [
                        { required: true, message: '请输入人员名称!', trigger: 'change' }
                    ],
                    personStatus: [
                        { required: true, message: '请选择状态！', trigger: 'change' }
                    ],
                    personNature: [
                        { required: true, message: '请选择人员性质!', trigger: 'change' }
                    ],
                    personLevel: [
                        { required: true, message: '请选择人员级别!', trigger: 'change' }
                    ],
                    personCheckStart: [
                        { validator: validatePersonCheckStart }
                    ],
                    personUptime: [
                        { validator: validatePersonUptime }
                    ],
                    personCorrectime: [
                        { validator: validatePersonCorrectime }
                    ],
                    personTryStartime: [
                        { validator: validatePersonTryStartime }
                    ],
                    personTryEndtime: [
                        { validator: validatePersonTryEndtime }
                    ],
                    personJointime: [
                        { required: true, type: 'date', message: '请选择加入我司时间!', trigger: 'blur' },
                        { validator: validatePersonJointime }
                    ],
                    startTime: [
                        { required: true, type: 'date', message: '请选择生效日期!', trigger: 'blur' },
                        { validator: validateStartDateCheck }
                    ],
                    personWorkphone: [
                        { validator: validateWorkphone }
                    ],
                    personHomephone: [
                        { validator: validateHomephone }
                    ],
                    personPhone: [
                        { required: true, message: '请正确输入移动电话!', trigger: 'change' },
                        { validator: validatePhone }
                    ],
                    personEmail: [
                        { required: false, type: 'email', message: '请正确输入email格式', trigger: 'change' }
                    ],
                    remark: [
                        { required: true, message: '请填写备注!', trigger: 'blur' }
                    ]

                },
                searchPerson: '',
                disabledFlag: true,
                tempTeamName: ''
            };
        },
        computed: {
            ...mapState({
                personReviewProgressData: ({personReviewProgressEdit}) => personReviewProgressEdit.personReviewProgressData,
                searchProvinceList: ({personEdit}) => personEdit.searchProvinceList,
                searchCityList: ({personEdit}) => personEdit.searchCityList,
                searchBrandList: ({personEdit}) => personEdit.searchBrandList,
                loading: ({personReviewProgressEdit}) => personReviewProgressEdit.loading,
                msg: ({personReviewProgressEdit}) => personReviewProgressEdit.msg,
                isSuccess: ({personReviewProgressEdit}) => personReviewProgressEdit.isSuccess
            })
        },
        methods: {
            ...mapActions([
                'handleQueryProvinceList',
                'handleQueryCityList',
                'handleQueryBrandList',
                'handleSubPersonReviewProgressData',
                'handleValidatePersonReviewProNature',
                'handleQueryPersonReviewProgressData'
            ]),
            /**
             * 初始化页面高度，省份数据，品牌数据
             */
            init () {
                this.getProvinceList();
            },
            pageBack () {
                this.$router.push({name: 'personReviewProgressList'});
            },
            /**
             * 获取省份数据
             */
            getProvinceList () {
                this.handleQueryProvinceList().then(res => {
                    this.handleQueryBrandList().then(res => {
                        this.getPersonReviewProgressData();
                    });
                });
            },
            /**
             * 获取城市数据
             */
            getCityList (data) {
                if (!isEmpty(data)) {
                    var allArr = [];
                    for (var i = 0; i < data.length; i++) {
                        if (data[i] === '00' && data.length > 1) {
                            allArr.push('00');
                            this.personReviewProgressData.provinces = allArr;
                            break;
                        }
                    }
                    this.handleQueryCityList(data).then(res => {
                    });
                }
            },
            /**
             * 获取品牌数据
             */
            getBrandList () {
                this.handleQueryBrandList().then(res => {
                });
            },
            getCityArr (data) {
                if (!isEmpty(data)) {
                    var allArr = [];
                    for (var i = 0; i < data.length; i++) {
                        if (data[i].value === '00' && data.length > 1) {
                            allArr.push('00');
                            this.personReviewProgressData.cities = allArr;
                            break;
                        }
                    }
                }
            },
            getBrandArr (data) {
                console.log(this.personReviewProgressData.brands);
            },
            submitProgressEditData () {
                this.handleSubPersonReviewProgressData(this.personReviewProgressData).then(res => {
                    resetWorkHeight();
                    if (this.isSuccess) {
                        this.$Modal.success({
                            title: '提示',
                            content: this.msg,
                            onOk: () => {
                                this.$router.push({name: 'personReviewProgressList'});
                            }
                        });
                    } else {
                        this.$Modal.error({
                            title: '提示',
                            content: this.msg
                        });
                    }
                });
            },
            subPersonReviewProgressData (name) {
                console.log(this.personReviewProgressData);
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        console.log(this.personReviewProgressData);// 此数据提交
                        const personNature = this.personReviewProgressData.personNature;
                        console.log(personNature)
                        if (personNature === '0') {
                            this.handleValidatePersonReviewProNature(this.personReviewProgressData.teamCode).then(res => {
                                if (!this.isSuccess) {
                                    this.$Modal.warning({
                                        title: '提示',
                                        content: this.msg
                                    });
                                } else {
                                    this.submitProgressEditData();
                                }
                            });
                        } else {
                            this.submitProgressEditData();
                        }
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            },
            getPersonReviewProgressData () {
                this.handleQueryPersonReviewProgressData(this.$route.query.id).then(res => {
                    if (!isEmpty(this.personReviewProgressData.provinces)) {
                        this.handleQueryCityList(this.personReviewProgressData.provinces).then(res => {
                            this.personReviewProgressData.cities = this.personReviewProgressData.cities;
                        });
                    }
                    var nowDate = new Date();
                    var date = formatDate(nowDate, 'yyyy-MM-dd');
                    var time1 = parseInt(date.replace(/-/g, ''));
                    var time2 = parseInt(this.personReviewProgressData.startTime.replace(/-/g, ''));
                    if (time1 < time2) {
                        this.disabledFlag = true;
                    } else {
                        this.disabledFlag = false;
                    }
                });
            }
        },
        mounted () {
            this.init();
        }
    };
</script>