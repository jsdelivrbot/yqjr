<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="teamEditData" :rules="ruleValidate" :model="teamEditData"  :label-width="100">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    指标基本信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="指标类型:" prop="typecode">
                            <Select v-model="formValidate.typecode" style="width:200px">
                                <Option v-for="item in cityList1" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="指标代码:" prop="indicatorcode">
                            <Input  placeholder="请输入指标代码" v-model="formValidate.indicatorcode" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="是否预警:" prop="alertflag">
                            <Select v-model="formValidate.alertflag" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="指标名称:"  pop="indicatorname">
                            <Input  placeholder="请输入指标名称" v-model="formValidate.indicatorname" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="上限:" pop="indicatorcaption">
                            <Input  placeholder="请输入指标上限" v-model="formValidate.indicatorcaption" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="下限:" pop="indicatorgroup">
                            <Input  placeholder="请输入指标下限" v-model="formValidate.indicatorgroup" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="信号灯:" prop="alertflag">
                            <Select v-model="formValidate.alertflag" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="区域范围:" prop="alertflag">
                            <Select v-model="formValidate.alertflag" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="区域:" prop="alertflag">
                            <Select v-model="formValidate.alertflag" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="维度类别:" prop="alertflag">
                            <Select v-model="formValidate.alertflag" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="维度代码:" prop="alertflag">
                            <Select v-model="formValidate.alertflag" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <Col span="12" offset="2" >
                            <FormItem label="备注:" pop="remark">
                                <Input  placeholder="请输入备注" v-model="formValidate.remark" style="width:200px" ></Input>
                            </FormItem>
                        </Col>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="warning" icon="checkmark" @click="teamEditSubToRev('tData')" :loading="loading">修改</Button>
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
            // const validatePatmentEndCheck = (rule, value, callback) => {
            //     if (value.length > 265) {
            //         callback(new Error('备注最大长度265!'));
            //     }
            //     callback();
            // };
            return {
                // ruleValidate: {
                //     teamName: [
                //         { required: true, message: '请输入团队名称!', trigger: 'blur' }
                //     ],
                //     teamLevel: [
                //         { required: true, message: '请输入团队级别!', trigger: 'blur' }
                //     ],
                //     remark: [
                //         { required: true, message: '请输入备注!', trigger: 'blur' },
                //         { validator: validatePatmentEndCheck }
                //     ]
                // },
                teamLevelList: [{
                    value: '100',
                    label: '财务指标'
                },
                    {
                        value: '200',
                        label: '监管指标'
                    },
                    {
                        value: '300',
                        label: '风险预警指标'
                    }],
                teamTypeList: [{
                    value: '0',
                    label: '是'
                },
                    {
                        value: '1',
                        label: '否'
                    }],
                teamStatusList: [{
                    value: '1',
                    label: '一汽金融公司'
                }, {
                    value: '2',
                    label: '一汽财务公司'
                },
                    {
                        value: '3',
                        label: '一汽租赁公司'
                    }
                ]
            };
        },
        computed: {
            ...mapState({
                loading: ({teamEdit}) => teamEdit.loading,
                teamEditData: ({teamEdit}) => teamEdit.teamEditData,
                isSuccess: ({teamEdit}) => teamEdit.isSuccess,
                teamEditMsg: ({teamEdit}) => teamEdit.teamEditMsg
            })
        },
        methods: {
            ...mapActions([
                'handelQueryTeamById',
                'handleTeamEditSubToRev'
            ]),
            init () {
                this.queryTeamById(this.$route.query.id);
                resetWorkHeight();
            },
            queryTeamById (id) {
                this.handelQueryTeamById(id).then(res => {
                });
            },
            teamEditSubToRev (name) { // 提交审核
                this.$refs[name].validate((valid) => {
                    if (valid) {
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
