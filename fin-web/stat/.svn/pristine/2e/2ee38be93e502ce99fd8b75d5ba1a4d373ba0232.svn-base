<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="teamEditData" :rules="ruleValidate" :model="teamEditData"  :label-width="100">
            <Card>
                <p slot="title">
                    <Icon type="edit"></Icon>
                    团队基本信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="区域名称：" >
                            <Input v-model="teamEditData.areaName" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="区域代码：" >
                            <Input v-model="teamEditData.areaCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队名称：" prop="teamName">
                            <Input v-model="teamEditData.teamName" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="团队代码：" >
                            <Input v-model="teamEditData.teamCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队级别：" prop="teamLevel">
                            <Select v-model="teamEditData.teamLevel" style="width:100%">
                                <Option v-for="item in teamLevelList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="团队类别：" >
                            <Select v-model="teamEditData.teamType" style="width:100%" disabled>
                                <Option v-for="item in teamTypeList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队状态：" >
                            <Select v-model="teamEditData.teamStatus" style="width:100%" disabled>
                                <Option v-for="item in teamStatusList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="团队电话：" >
                            <Input v-model="teamEditData.teamPhone" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="邮编：" >
                            <Input v-model="teamEditData.teamZip" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="传真：" >
                            <Input v-model="teamEditData.teamFax" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队地址：" >
                            <Input v-model="teamEditData.teamAddress" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="创建时间：" >
                            <Input v-model="teamEditData.createTime" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="备注：" prop="remark">
                            <Input v-model="teamEditData.remark" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="checkmark" @click="validateTeamName('teamEditData')" :loading="loading">提交审核</Button>
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
    import {resetWorkHeight, getUserCookie} from '@/libs/util.js';
    export default{
        name: 'teamEdit',
        data () {
            const validatePatmentEndCheck = (rule, value, callback) => {
                if (value.length > 265) {
                    callback(new Error('备注最大长度265!'));
                }
                callback();
            };
            return {
                ruleValidate: {
                    teamName: [
                        { required: true, message: '请输入团队名称!', trigger: 'blur' }
                    ],
                    teamLevel: [
                        { required: true, message: '请输入团队级别!', trigger: 'blur' }
                    ],
                    remark: [
                        { required: true, message: '请输入备注!', trigger: 'blur' },
                        { validator: validatePatmentEndCheck }
                    ]
                },
                teamLevelList: [{
                    value: '01',
                    label: '一级'
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
                }]
            };
        },
        computed: {
            ...mapState({
                loading: ({teamEdit}) => teamEdit.loading,
                teamEditData: ({teamEdit}) => teamEdit.teamEditData,
                isSuccess: ({teamEdit}) => teamEdit.isSuccess,
                teamName: ({teamEdit}) => teamEdit.teamName,
                teamEditMsg: ({teamEdit}) => teamEdit.teamEditMsg
            })
        },
        methods: {
            ...mapActions([
                'handelQueryTeamById',
                'handleValidateTeamNameEdit',
                'handleTeamEditSubToRev'
            ]),
            init () {
                this.queryTeamById(this.$route.query.id);
            },
            queryTeamById (id) {
                this.handelQueryTeamById(id).then(res => {
                });
            },
            teamEditSubToRev () { // 提交审核
                const user = getUserCookie();
                this.teamEditData.createName = user.name;
                console.log(this.teamEditData);// 此数据提交
                this.handleTeamEditSubToRev(this.teamEditData).then(res => {
                    if (this.isSuccess) {
                        this.$Modal.success({
                            title: '修改',
                            content: this.teamEditMsg,
                            onOk: () => {
                                this.$router.push({name: 'teamMainTenanceList'});
                            }
                        });
                    } else {
                        this.$Modal.error({
                            title: '提示',
                            content: this.teamEditMsg
                        });
                    }
                });
            },
            validateTeamName (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        console.log(this.teamEditData);// 此数据提交
                        if (this.teamName === this.teamEditData.teamName) {
                            this.teamEditSubToRev();
                        } else {
                            this.handleValidateTeamNameEdit(this.teamEditData.teamName).then(res => {
                                if (this.isSuccess) {
                                    this.teamEditSubToRev();
                                } else {
                                    this.$Modal.warning({
                                        title: '提示',
                                        content: '团队名称重复！'
                                    });
                                }
                            });
                        }
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
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