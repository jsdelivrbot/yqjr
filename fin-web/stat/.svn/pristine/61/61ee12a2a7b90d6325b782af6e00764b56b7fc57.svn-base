<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="formValidate" :rules="ruleValidate" :model="formValidate" :label-width="100">
            <Card>
                <p slot="title">
                    <Icon type="edit"></Icon>
                    主信息
                </p>
                <Row v-show="false">
                    <Col span="8" offset="2">
                        <FormItem label="公司：" >
                            <Input v-model="formValidate.company" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="区域名称：" >
                            <Input v-model="formValidate.areaName" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="区域代码：" >
                            <Input v-model="formValidate.areaCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队名称："  prop="teamName">
                            <Input v-model="formValidate.teamName" placeholder="请选择团队名称"></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="团队级别："  prop="teamLevel">
                            <Select v-model="formValidate.teamLevel" style="width:100%" placeholder="请选择团队级别">
                                <Option value="01" selected>一级</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队类型：" prop="teamType">
                            <Select v-model="formValidate.teamType" style="width:100%" placeholder="请选择团队类型">
                                <Option value="01" selected>普通</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="生效日期：" prop="startTime">
                            <DatePicker  @on-change="getStartTime" type="date" placeholder="请选择生效日期" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队状态：" prop="teamStatus">
                            <Select v-model="formValidate.teamStatus" style="width:100%" placeholder="请选择团队状态">
                                <Option value="0" selected>无效</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="邮编：" prop="teamZip">
                            <Input v-model="formValidate.teamZip" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队电话：" prop="teamPhone">
                            <Input v-model="formValidate.teamPhone" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="传真：" prop="teamFax">
                            <Input v-model="formValidate.teamFax"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="团队地址：" prop="teamAddress">
                            <Input v-model="formValidate.teamAddress"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="备注：" prop="remark">
                            <Input v-model="formValidate.remark" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="checkmark" @click="subTeamAddToRev('formValidate')" :loading="loading">提交审核</Button>
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
import { mapActions, mapState } from 'vuex';
import {resetWorkHeight, getUserCookie, isEmpty, formatDate} from '@/libs/util.js';
export default{
    name: 'teamAdd',
    data () {
        const validatePatmentEndCheck = (rule, value, callback) => {
            if (value.length > 265) {
                callback(new Error('备注最大长度265!'));
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
        const validateTeamAddress = (rule, value, callback) => {
            if (value.length > 60) {
                callback(new Error('团队地址最大长度60!'));
            }
            callback();
        };
        const validateTeamZip = (rule, value, callback) => {
            var reg = /^[0-9]{6}$/;
            if (!isEmpty(value)) {
                if (!reg.test(value)) {
                    callback(new Error('请输入正确的邮编!'));
                }
            }
            callback();
        };
        const validateTeamPhone = (rule, value, callback) => {
            var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
            var phone = /^0\d{2,3}-?\d{7,8}$/;
            if (!isEmpty(value)) {
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
        const validateTeamFax = (rule, value, callback) => {
            var reg = /^0\d{2}[- ]?\d{8}|0\d{3}[- ]?\d{7}$/;
            if (!isEmpty(value)) {
                if (!reg.test(value)) {
                    callback(new Error('请输入正确的传真格式!'));
                }
            }
            callback();
        };
        return {
            ruleValidate: {
                teamName: [
                    { required: true, message: '请输入团队名称!', trigger: 'blur' }
                ],
                teamLevel: [
                    { required: true, message: '请输入团队级别!', trigger: 'change' }
                ],
                teamType: [
                    { required: true, message: '请输入团队类型!', trigger: 'change' }
                ],
                startTime: [
                    { required: true, message: '请输入团队生效时间!', trigger: 'blur' },
                    { validator: validateStartDateCheck }
                ],
                teamStatus: [
                    { required: true, message: '请输入团队状态!', trigger: 'change' }
                ],
                remark: [
                    { required: true, message: '请输入备注!', trigger: 'blur' },
                    { validator: validatePatmentEndCheck }
                ],
                teamAddress: [
                    { validator: validateTeamAddress }
                ],
                teamZip: [
                    { validator: validateTeamZip }
                ],
                teamPhone: [
                    { validator: validateTeamPhone }
                ],
                teamFax: [
                    { validator: validateTeamFax }
                ]
            },
            pinpai: [],
            file: null,
            loadingStatus: false,
            formValidate: {
                teamName: '',
                areaName: '',
                areaCode: '',
                company: '',
                teamLevel: '',
                teamSatus: '',
                teamType: '',
                teamZip: '',
                startTime: '',
                teamPhone: '',
                teamFax: '',
                teamAddress: '',
                remark: ''
            }
        };
    },
    computed: {
        ...mapState({
            loading: ({teamAdd}) => teamAdd.loading,
            isSuccess: ({teamAdd}) => teamAdd.isSuccess,
            teamData: ({teamAdd}) => teamAdd.teamAddData
        })
    },
    methods: {
        init () {
            const user = getUserCookie();
            this.formValidate.areaName = user.areaName;
            this.formValidate.areaCode = user.areaCode;
            this.formValidate.company = user.comCode;
        },
        ...mapActions([
            'handleTeamAddToRev',
            'handleValidateTeamName'
        ]),
        subTeamAddToRev (name) {
            this.$refs[name].validate((valid) => {
                if (valid) {
                    console.log(this.formValidate);// 此数据提交
                    this.handleValidateTeamName(this.formValidate.teamName).then(res => {
                        if (this.isSuccess) {
                            this.submitData();
                        } else {
                            this.$Modal.warning({
                                title: '提示',
                                content: '团队名称重复！'
                            });
                        }
                    });
                } else {
                    this.$Message.error('验证错误!');
                }
            });
        },
        submitData () {
            this.handleTeamAddToRev(this.formValidate).then(res => {
                if (this.isSuccess) {
                    this.$Modal.success({
                        title: '提交成功',
                        content: this.teamData,
                        onOk: () => {
                            this.$router.push({name: 'teamMainTenanceList'});
                        }
                    });
                } else {
                    this.$Modal.error({
                        title: '提示',
                        content: this.teamData
                    });
                }
                resetWorkHeight();
            });
        },
        getStartTime (date) {
            this.formValidate.startTime = date;
        },
        pageBack () {
            this.$router.push({name: 'teamMainTenanceList'});
        }
    },
    mounted () {
        this.init();
    }

};
</script>