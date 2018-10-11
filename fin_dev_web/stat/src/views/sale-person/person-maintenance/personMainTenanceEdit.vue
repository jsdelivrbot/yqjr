<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="editPersonData" :rules="ruleValidate" :model="editPersonData" :label-width="120">
            <Card>
                <p slot="title">
                    <Icon type="edit"></Icon>
                    人员基本信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="人员代码："   >
                            <Input v-model="editPersonData.personCode" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="人员姓名："   >
                            <Input v-model="editPersonData.personName" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="身份证号：" >
                            <Input v-model="editPersonData.personIdcard" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="出生日期：" >
                            <Input  v-model="editPersonData.personBirth" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="年龄：" >
                            <Input v-model="editPersonData.personAge" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="民族：" >
                            <Input v-model="editPersonData.personEthnic" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="婚姻状况：" >
                            <Input  v-model="editPersonData.personMarr" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="毕业学校：" >
                            <Input  v-model="editPersonData.personSchool"  disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="专业：" >
                            <Input   v-model="editPersonData.personSubject" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="最高学历：" >
                            <Input   v-model="editPersonData.personEdu" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="学位：" >
                            <Input  v-model="editPersonData.personEdulevel" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="工龄：" >
                            <Input  v-model="editPersonData.personWorktime"  disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="参加工作日期：" >
                            <Input disabled v-model="editPersonData.personFirstworktime" ></Input>
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
                            <!--<Select  disabled :label-in-value="true"  disabled v-model="editPersonData.tempTeamName" filterable remote :remote-method="searchTeam"  @on-change='getTeamCode' :loading="loading" placeholder="请输入团队名称|自动搜索" >-->
                                <!--<Option v-for="item in searchTeamData"  :value="item.value" :key="item.label" :label="item.label" >{{item.label}}</Option>-->
                            <!--</Select>-->
                            <Input  v-model="editPersonData.tempTeamName" disabled  ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="团队代码："   >
                            <Input  v-model="editPersonData.teamCode" disabled  ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="归属区域代码：" >
                            <Input   v-model="editPersonData.areaCode"  disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="归属区域名称：" >
                            <Input  v-model="editPersonData.areaName"  disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="人员性质：" prop="personNature">
                            <i-select v-model="editPersonData.personNature" style="width:100%">
                                <i-option v-for="nature in natureList" :value="nature.value" :key="nature.value" >{{ nature.label }}</i-option>
                            </i-select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="人员级别："  prop="personNature">
                            <i-select v-model="editPersonData.personLevel"  disabled style="width:100%">
                                <i-option v-for="level in levelList" :value="level.value" :key="level.value">{{ level.label }}</i-option>
                            </i-select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="人员状态：" prop="personStatus" >
                            <i-select v-model="editPersonData.personStatus"  style="width:100%" v-bind:disabled="disabledFlag">
                                <i-option v-for="status in statusList" :value="status.value"  :key="status.value">{{ status.label }}</i-option>
                            </i-select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="考核开始时间：" prop="personCheckStart">
                            <DatePicker type="date" v-model="editPersonData.personCheckStart" placeholder="请选择开始时间" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="上岗日期："  prop="personUptime">
                            <DatePicker type="date" v-model="editPersonData.personUptime" placeholder="请选择上岗日期" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="转正日期：" prop="personCorrectime">
                            <DatePicker type="date" v-model="editPersonData.personCorrectime" placeholder="请选择转正日期" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="试用期开始日期：" prop="personTryStartime">
                            <DatePicker type="date" v-model="editPersonData.personTryStartime" placeholder="请选择使用期开始日期" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="试用期结束日期："  prop="personTryEndtime">
                            <DatePicker type="date" v-model="editPersonData.personTryEndtime" placeholder="请选择试用期结束日期" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="加入我司日期：" prop="personJointime">
                            <DatePicker type="date"  v-model="editPersonData.personJointime" placeholder="请选择加入我司日期" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <!--<Col span="8" offset="2">-->
                    <!--<FormItem label="生效日期："  prop="startTime">-->
                        <!--<DatePicker type="date"  v-model="editPersonData.startTime" placeholder="请选择生效日期" style="width: 220px"></DatePicker>-->
                    <!--</FormItem>-->
                    <!--</Col>-->
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="负责省份："  >
                        <Select   v-model="editPersonData.provinces"  filterable multiple  :loading="loading" @on-change='getCityList' style="width: 100%">
                            <Option v-for="province in searchProvinceList"  :value="province.value"  :key="province.value">{{ province.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="负责城市：" >
                        <Select  v-model="editPersonData.cities"  :label-in-value="true" filterable multiple  @on-change='getCityArr'  :loading="loading"  style="width: 100%">
                            <Option v-for="city in searchCityList" :value="city.value" :key="city.value" >{{ city.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="负责品牌：" >
                        <Select  v-model="editPersonData.brands"  :label-in-value="true" filterable multiple    @on-change='getBrandArr' :loading="loading" style="width: 100%">
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
                            <Input v-model="editPersonData.personAddress" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="家庭电话："   >
                            <Input  type="text"  v-model="editPersonData.personHomephone" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="移动电话："  prop="personPhone">
                            <Input v-model="editPersonData.personPhone" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="工作电话：" >
                            <Input type="text" v-model="editPersonData.personWorkphone" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="e-mail："  prop="personEmail">
                            <Input v-model="editPersonData.personEmail" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="备注："  prop="remark">
                            <Input  v-model="editPersonData.remark" type="textarea"  style="width:100%" :autosize="{minRows: 2,maxRows: 6}"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="checkmark" @click="addPersonToRev('editPersonData')">提交审核</Button>
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
        name: 'personEdit',
        data: function () {
            const validateRemarkCheck = (rule, value, callback) => {
                if (value.length > 200) {
                    callback(new Error('备注最大长度200!'));
                }
                callback();
            };
            const validatePersonCheckStart = (rule, value, callback) => {
                if (!isEmpty(this.editPersonData.personCheckStart)) {
                    if (new Date(value).getTime() >= new Date(this.editPersonData.personCorrectime).getTime()) {
                        callback(new Error('考核时间不能大于转正时间'));
                    }
                }
                callback();
            };

            const validatePersonUptime = (rule, value, callback) => {
                if (!isEmpty(this.editPersonData.personTryStartime)) {
                    if (new Date(value).getTime() >= new Date(this.editPersonData.personTryStartime).getTime()) {
                        callback(new Error('上岗时间不能大于试用开始时间'));
                    }
                } else if (!isEmpty(this.editPersonData.personUptime)) {
                    if (new Date(value).getTime() >= new Date(this.editPersonData.personTryEndtime).getTime()) {
                        callback(new Error('上岗时间不能大于试用结束时间'));
                    }
                } else if (!isEmpty(this.editPersonData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.editPersonData.personCorrectime).getTime()) {
                        callback(new Error('上岗时间不能大于转正时间'));
                    }
                }
                callback();
            };

            const validatePersonCorrectime = (rule, value, callback) => {
                if (!isEmpty(this.editPersonData.personTryStartime)) {
                    if (new Date(value).getTime() <= new Date(this.editPersonData.personTryStartime).getTime()) {
                        callback(new Error('转正时间不能小于试用开始时间'));
                    }
                } else if (!isEmpty(this.editPersonData.personTryEndtime)) {
                    if (new Date(value).getTime() <= new Date(this.editPersonData.personTryEndtime).getTime()) {
                        callback(new Error('转正时间不能小于试用结束时间'));
                    }
                } else if (!isEmpty(this.editPersonData.personUptime)) {
                    if (new Date(value).getTime() <= new Date(this.editPersonData.personUptime).getTime()) {
                        callback(new Error('转正时间不能小于上岗时间'));
                    }
                } else if (!isEmpty(this.editPersonData.personCheckStart)) {
                    if (new Date(value).getTime() <= new Date(this.editPersonData.personCheckStart).getTime()) {
                        callback(new Error('转正时间不能小于考核开始时间'));
                    }
                } else if (!isEmpty(this.editPersonData.personCheckStart)) {
                    if (new Date(value).getTime() <= new Date(this.editPersonData.personJointime).getTime()) {
                        callback(new Error('转正时间不能小于加入我司时间'));
                    }
                }
                callback();
            };
            const validatePersonTryStartime = (rule, value, callback) => {
                if (!isEmpty(this.editPersonData.personUptime)) {
                    if (new Date(value).getTime() <= new Date(this.editPersonData.personUptime).getTime()) {
                        callback(new Error('试用开始时间不能小于上岗时间'));
                    }
                } else if (!isEmpty(this.editPersonData.personTryEndtime)) {
                    if (new Date(value).getTime() >= new Date(this.editPersonData.personTryEndtime).getTime()) {
                        callback(new Error('试用开始时间不能大于试用结束时间'));
                    }
                } else if (!isEmpty(this.editPersonData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.editPersonData.personCorrectime).getTime()) {
                        callback(new Error('试用开始时间不能大于转正时间'));
                    }
                }
                callback();
            };
            const validatePersonTryEndtime = (rule, value, callback) => {
                if (!isEmpty(this.editPersonData.personUptime)) {
                    if (new Date(value).getTime() <= new Date(this.editPersonData.personUptime).getTime()) {
                        callback(new Error('试用结束时间不能小于上岗时间'));
                    }
                } else if (!isEmpty(this.editPersonData.personTryStartime)) {
                    if (new Date(value).getTime() <= new Date(this.editPersonData.personTryStartime).getTime()) {
                        callback(new Error('试用结束时间不能小于试用期开始时间'));
                    }
                } else if (!isEmpty(this.editPersonData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.editPersonData.personCorrectime).getTime()) {
                        callback(new Error('试用结束时间不能大于转正时间'));
                    }
                }
                callback();
            };
            const validatePersonJointime = (rule, value, callback) => {
                if (!isEmpty(this.editPersonData.personCorrectime)) {
                    if (new Date(value).getTime() >= new Date(this.editPersonData.personCorrectime).getTime()) {
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
                        { required: true, message: '请填写备注!', trigger: 'blur' },
                        { validator: validateRemarkCheck }
                    ]

                },
                searchPerson: '',
                tempTeamName: '',
                disabledFlag: true
            };
        },
        computed: {
            ...mapState({
                editPersonData: ({personEdit}) => personEdit.editPersonData,
                searchTeamData: ({personEdit}) => personEdit.searchTeamData,
                searchProvinceList: ({personEdit}) => personEdit.searchProvinceList,
                searchCityList: ({personEdit}) => personEdit.searchCityList,
                searchBrandList: ({personEdit}) => personEdit.searchBrandList,
                loading: ({personEdit}) => personEdit.loading,
                personNatureValidate: ({personEdit}) => personEdit.personNatureValidate,
                msg: ({personEdit}) => personEdit.msg,
                isSuccess: ({personEdit}) => personEdit.isSuccess
            })
        },
        methods: {
            ...mapActions([
                'handleQueryBySearchPerson',
                'handleQueryBySearchTeam',
                'handleQueryProvinceList',
                'handleQueryCityList',
                'handleQueryBrandList',
                'handleEditPersonToRev',
                'handleResetEditPersonData',
                'handleValidatePersonEditNature',
                'handleGetPersonData'
            ]),
            /**
             * 初始化页面高度，省份数据，品牌数据
             */
            init () {
                this.getProvinceList();
            },
            /**
             * 登录名查询登录信息
             */
            searchUser () {
                this.handleQueryBySearchPerson(this.editPersonData.searchPerson).then(res => {
                    resetWorkHeight();
                    this.$forceUpdate();
                    if (!this.isSuccess) {
                        this.$Modal.success({
                            title: '提示',
                            content: this.msg
                        });
                    }
                });
            },
            pageBack () {
                this.$router.push({name: 'personList'});
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
                this.editPersonData.teamName = data.label;
                this.editPersonData.teamCode = data.value;
            },
            /**
             * 获取省份数据
             */
            getProvinceList () {
                this.handleQueryProvinceList().then(res => {
                    this.handleQueryBrandList().then(res => {
                        this.getPersonData();
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
                            this.editPersonData.provinces = allArr;
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
                            this.editPersonData.cities = allArr;
                            break;
                        }
                    }
                }
            },
            getBrandArr (data) {
                console.log(this.editPersonData.brands);
            },
            submitEditData () {
                this.handleEditPersonToRev(this.editPersonData).then(res => {
                    resetWorkHeight();
                    if (this.isSuccess) {
                        this.$Modal.success({
                            title: '提示',
                            content: this.msg,
                            onOk: () => {
                                this.$router.push({name: 'personList'});
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
                console.log(this.editPersonData);
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        console.log(this.editPersonData);// 此数据提交
                        const personNature = this.editPersonData.personNature;
                        console.log(personNature)
                        if (personNature === '0' && this.personNatureValidate !== this.editPersonData.personNature) {
                            this.handleValidatePersonEditNature(this.editPersonData.teamCode).then(res => {
                                if (!this.isSuccess) {
                                    this.$Modal.warning({
                                        title: '提示',
                                        content: this.msg
                                    });
                                } else {
                                    this.submitEditData();
                                }
                            });
                        } else {
                            this.submitEditData();
                        }
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            },
            getPersonData () {
                this.handleGetPersonData(this.$route.query.id).then(res => {
                    if (!isEmpty(this.editPersonData.provinces)) {
                        this.handleQueryCityList(this.editPersonData.provinces).then(res => {
                            this.editPersonData.cities = this.editPersonData.cities;
                        });
                    }
                    var nowDate = new Date();
                    var date = formatDate(nowDate, 'yyyy-MM-dd');
                    var time1 = parseInt(date.replace(/-/g, ''));
                    var time2 = parseInt(this.editPersonData.startTime.replace(/-/g, ''));
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