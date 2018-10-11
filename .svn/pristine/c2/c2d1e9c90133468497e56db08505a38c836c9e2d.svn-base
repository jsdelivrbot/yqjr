<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="searchPersonData" :rules="ruleValidate" :model="searchPersonData" :label-width="120">
            <Card>
                <p slot="title">
                    <Icon type="edit"></Icon>
                    人员基本信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="登录用户名：" >
                        <Input v-model="searchPersonData.searchPerson">
                        <Button slot="append"  @click.prevent="searchUser"icon="ios-search"></Button>
                        </Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员姓名："   >
                        <Input v-model="searchPersonData.personName" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="身份证号：" >
                        <Input v-model="searchPersonData.personIdcard" disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="出生日期：" >
                        <Input  v-model="searchPersonData.personBirth" disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="年龄：" >
                        <Input v-model="searchPersonData.personAge" disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="民族：" >
                        <Input v-model="searchPersonData.personEthnic" disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="婚姻状况：" >
                        <Input  v-model="searchPersonData.personMarr" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="毕业学校：" >
                        <Input  v-model="searchPersonData.personSchool"  disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="专业：" >
                        <Input   v-model="searchPersonData.personSubject" disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="最高学历：" >
                        <Input  v-model="searchPersonData.personEdu" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="学位：" >
                        <Input  v-model="searchPersonData.personEdulevel" disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="工龄：" >
                        <Input v-model="searchPersonData.personWorktime"  disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="参加工作日期：" >
                        <Input disabled v-model="searchPersonData.personFirstworktime" ></Input>
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
                    <FormItem label="团队名称：" prop="tempTeamName">
                        <Select  :label-in-value="true"   v-model="searchPersonData.tempTeamName" filterable remote :remote-method="searchTeam"  @on-change='getTeamCode' :loading="loading" placeholder="请输入团队名称|自动搜索" >
                            <Option v-for="item in searchTeamData"  :value="item.value" :key="item.label" :label="item.label" >{{item.label}}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="团队代码："   >
                        <Input  v-model="searchPersonData.teamCode" disabled  ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="归属区域代码：" >
                        <Input   v-model="searchPersonData.areaCode"  disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="归属区域名称：" >
                        <Input  v-model="searchPersonData.areaName"  disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员性质：" prop="personNature">
                        <i-select v-model="searchPersonData.personNature" style="width:100%;">
                            <i-option v-for="nature in natureList" :value="nature.value" :key="nature.value" >{{ nature.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="人员级别："  prop="personNature">
                        <i-select v-model="searchPersonData.personLevel" style="width:100%;">
                            <i-option v-for="level in levelList" :value="level.value" :key="level.value">{{ level.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员状态：" prop="personStatus">
                        <i-select v-model="searchPersonData.personStatus" disabled style="width:100%;">
                            <i-option v-for="status in statusList" :value="status.value"  :key="status.value">{{ status.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="考核开始时间：" prop="personCheckStart">
                        <DatePicker type="date" v-model="searchPersonData.personCheckStart" placeholder="请选择开始时间" style="width: 100%;"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="上岗日期："  prop="personUptime">
                        <DatePicker type="date" v-model="searchPersonData.personUptime" placeholder="请选择上岗日期" style="width: 100%;"></DatePicker>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="转正日期：" prop="personCorrectime">
                        <DatePicker type="date" v-model="searchPersonData.personCorrectime" placeholder="请选择转正日期" style="width: 100%;"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="试用期开始日期：" prop="personTryStartime">
                        <DatePicker type="date" v-model="searchPersonData.personTryStartime" placeholder="请选择使用期开始日期" style="width: 100%;"></DatePicker>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="试用期结束日期："  prop="personTryEndtime">
                        <DatePicker type="date" v-model="searchPersonData.personTryEndtime" placeholder="请选择试用期结束日期" style="width: 100%;"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="加入我司日期：" prop="personJointime">
                        <DatePicker type="date"  v-model="searchPersonData.personJointime" placeholder="请选择加入我司日期" style="width: 100%;"></DatePicker>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="生效日期："  prop="startTime">
                        <DatePicker type="date"  v-model="searchPersonData.startTime" placeholder="请选择生效日期" style="width: 100%;"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="负责省份："  >
                        <Select   v-model="searchPersonData.provinces"  filterable multiple  :loading="loading" @on-change='getCityList' style="width: 100%;">
                            <Option v-for="province in searchProvinceList"  :value="province.value"  :key="province.value">{{ province.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="负责城市：" >
                        <Select  v-model="searchPersonData.cities"  :label-in-value="true" filterable multiple  @on-change='getCityArr'  :loading="loading"  style="width: 100%;">
                            <Option v-for="city in searchCityList" :value="city.value" :key="city.value" >{{ city.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="负责品牌：" >
                        <Select  v-model="searchPersonData.brands" :label-in-value="true"  filterable multiple  :loading="loading" style="width: 100%;">
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
                        <Input v-model="searchPersonData.personAddress" ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="家庭电话："   >
                        <Input  type="text"  v-model="searchPersonData.personHomephone" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="移动电话："  prop="personPhone">
                        <Input v-model="searchPersonData.personPhone" ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="工作电话：" prop="personWorkphone">
                        <Input type="text" v-model="searchPersonData.personWorkphone" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="e-mail："  prop="personEmail">
                        <Input v-model="searchPersonData.personEmail" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="备注："  prop="remark">
                        <Input  v-model="searchPersonData.remark" type="textarea" :autosize="{minRows: 2,maxRows: 2}" style="width:100%;"></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                    <Button type="primary" icon="checkmark" @click="addPersonToRev('searchPersonData')">提交审核</Button>
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

    import {resetWorkHeight, isEmpty} from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';
    export default{
        name: 'personAdd',
        data: function () {
            const validateRemarkCheck = (rule, value, callback) => {
                if (value.length > 200) {
                    callback(new Error('备注最大长度200!'));
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
            const validatePersonCheckStart = (rule, value, callback) => {
                if (!isEmpty(this.searchPersonData.personCheckStart)) {
                    if (new Date(value).getTime() >= new Date(this.searchPersonData.personCorrectime).getTime()) {
                        callback(new Error('考核时间不能大于转正时间'));
                    }
                }
                callback();
            };

            const validatePersonUptime = (rule, value, callback) => {
                if (!isEmpty(this.searchPersonData.personTryStartime)) {
                    if (new Date(value).getTime() >= new Date(this.searchPersonData.personTryStartime).getTime()) {
                        callback(new Error('上岗时间不能大于试用开始时间'));
                    }
                } else if (!isEmpty(this.searchPersonData.personUptime)) {
                    if (new Date(value).getTime() >= new Date(this.searchPersonData.personTryEndtime).getTime()) {
                        callback(new Error('上岗时间不能大于试用结束时间'));
                    }
                } else if (!isEmpty(this.searchPersonData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.searchPersonData.personCorrectime).getTime()) {
                        callback(new Error('上岗时间不能大于转正时间'));
                    }
                }
                callback();
            };

            const validatePersonCorrectime = (rule, value, callback) => {
                if (!isEmpty(this.searchPersonData.personTryStartime)) {
                    if (new Date(value).getTime() <= new Date(this.searchPersonData.personTryStartime).getTime()) {
                        callback(new Error('转正时间不能小于试用开始时间'));
                    }
                } else if (!isEmpty(this.searchPersonData.personTryEndtime)) {
                    if (new Date(value).getTime() <= new Date(this.searchPersonData.personTryEndtime).getTime()) {
                        callback(new Error('转正时间不能小于试用结束时间'));
                    }
                } else if (!isEmpty(this.searchPersonData.personUptime)) {
                    if (new Date(value).getTime() <= new Date(this.searchPersonData.personUptime).getTime()) {
                        callback(new Error('转正时间不能小于上岗时间'));
                    }
                } else if (!isEmpty(this.searchPersonData.personCheckStart)) {
                    if (new Date(value).getTime() <= new Date(this.searchPersonData.personCheckStart).getTime()) {
                        callback(new Error('转正时间不能小于考核开始时间'));
                    }
                } else if (!isEmpty(this.searchPersonData.personCheckStart)) {
                    if (new Date(value).getTime() <= new Date(this.searchPersonData.personJointime).getTime()) {
                        callback(new Error('转正时间不能小于加入我司时间'));
                    }
                }
                callback();
            };
            const validatePersonTryStartime = (rule, value, callback) => {
                if (!isEmpty(this.searchPersonData.personUptime)) {
                    if (new Date(value).getTime() <= new Date(this.searchPersonData.personUptime).getTime()) {
                        callback(new Error('试用开始时间不能小于上岗时间'));
                    }
                } else if (!isEmpty(this.searchPersonData.personTryEndtime)) {
                    if (new Date(value).getTime() >= new Date(this.searchPersonData.personTryEndtime).getTime()) {
                        callback(new Error('试用开始时间不能大于试用结束时间'));
                    }
                } else if (!isEmpty(this.searchPersonData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.searchPersonData.personCorrectime).getTime()) {
                        callback(new Error('试用开始时间不能大于转正时间'));
                    }
                }
                callback();
            };
            const validatePersonTryEndtime = (rule, value, callback) => {
                if (!isEmpty(this.searchPersonData.personUptime)) {
                    if (new Date(value).getTime() <= new Date(this.searchPersonData.personUptime).getTime()) {
                        callback(new Error('试用结束时间不能小于上岗时间'));
                    }
                } else if (!isEmpty(this.searchPersonData.personTryStartime)) {
                    if (new Date(value).getTime() <= new Date(this.searchPersonData.personTryStartime).getTime()) {
                        callback(new Error('试用结束时间不能小于试用期开始时间'));
                    }
                } else if (!isEmpty(this.searchPersonData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.searchPersonData.personCorrectime).getTime()) {
                        callback(new Error('试用结束时间不能大于转正时间'));
                    }
                }
                callback();
            };
            const validatePersonJointime = (rule, value, callback) => {
                if (!isEmpty(this.searchPersonData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.searchPersonData.personCorrectime).getTime()) {
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
                if(!isEmpty(value)) {
                    if (myreg.test(value)) {
                        callback();
                    } else if (phone.test(value)) {
                        callback();
                    } else {
                        callback(new Error('请输入正确的电话格式'));
                    }
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
                        { validator: validateWorkphone}
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
                        { required: true, message: '请填写备注!', trigger: 'blur' },
                        { validator: validateRemarkCheck }
                    ]

                },
                searchPerson: ''

            };
        },
        computed: {
            ...mapState({
                searchPersonData: ({personAdd}) => personAdd.searchPersonData,
                searchTeamData: ({personAdd}) => personAdd.searchTeamData,
                searchProvinceList: ({personAdd}) => personAdd.searchProvinceList,
                searchCityList: ({personAdd}) => personAdd.searchCityList,
                searchBrandList: ({personAdd}) => personAdd.searchBrandList,
                loading: ({personAdd}) => personAdd.loading,
                msg: ({personAdd}) => personAdd.msg,
                isSuccess: ({personAdd}) => personAdd.isSuccess
            })
        },
        methods: {
            ...mapActions([
                'handleQueryBySearchPerson',
                'handleQueryBySearchTeam',
                'handleQueryProvinceList',
                'handleQueryCityList',
                'handleQueryBrandList',
                'handleAddPersonToRev',
                'handleValidatePersonNature',
                'handleResetSearchPersonData'
            ]),
            /**
             * 初始化页面高度，省份数据，品牌数据
             */
            init () {
                resetWorkHeight();
                this.getProvinceList();
                this.getBrandList();
            },
            /**
             * 登录名查询登录信息
             */
            searchUser () {
                this.handleQueryBySearchPerson(this.searchPersonData.searchPerson).then(res => {
                    this.searchPersonData.personStatus = '0';
                    resetWorkHeight();
                    this.$forceUpdate();
                    if (!this.isSuccess) {
                        this.$Modal.error({
                            title: '提示',
                            content: this.msg
                        });
                    }
                });
            },
            pageBack () {
                this.handleResetSearchPersonData().then(res => {
                    this.$router.push({name: 'personList'});
                });
            },
            /**
             * 团队名字模糊远程查询
             */
            searchTeam (query) {
                this.handleQueryBySearchTeam(query).then(res => {
                    console.log(this.searchTeamData);
                });
            },
            /**
             * 获取团队代码
             */
            getTeamCode (data) {
                this.searchPersonData.teamName = data.label;
                this.searchPersonData.teamCode = data.value;
            },
            /**
             * 获取省份数据
             */
            getProvinceList () {
                this.handleQueryProvinceList().then(res => {
                });
            },
            /**
             * 获取城市数据
             */
            getCityList (data) {
                var allArr = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        allArr.push('00');
                        this.searchPersonData.provinces = allArr;
                        break;
                    }
                }
                this.handleQueryCityList(data).then(res => {
                });
            },
            /**
             * 获取品牌数据
             */
            getBrandList () {
                this.handleQueryBrandList().then(res => {
                });
            },
            getCityArr: function (data) {
                var allArr = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i].value === '00' && data.length > 1) {
                        allArr.push('00');
                        this.searchPersonData.cities = allArr;
                        break;
                    }
                }
            },
            submitAddData () {
                this.handleAddPersonToRev(this.searchPersonData).then(res => {
                    resetWorkHeight();
                    if (this.isSuccess) {
                        this.$Modal.success({
                            title: '提示',
                            content: this.msg,
                            onOk: () => {
                                this.handleResetSearchPersonData().then(res => {
                                    this.$router.push({name: 'personList'});
                                });
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
            addPersonToRev (name) {
                console.log(this.searchPersonData);
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        console.log(this.searchPersonData);// 此数据提交
                        const personNature = this.searchPersonData.personNature;
                        console.log(personNature)
                        if (personNature === '0') {
                            this.handleValidatePersonNature(this.searchPersonData.teamCode).then(res => { // 校验团队负责人唯一性
                                if (!this.isSuccess) {
                                    this.$Modal.warning({
                                        title: '提示',
                                        content: this.msg
                                    });
                                } else {
                                    this.submitAddData();
                                }
                            });
                        } else {
                            this.submitAddData();
                        }
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