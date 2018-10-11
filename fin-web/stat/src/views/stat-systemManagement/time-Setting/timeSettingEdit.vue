<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="formValidate" :rules="ruleValidate" :model="formValidate"  :label-width="100">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    修改自动任务
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="类名称："  prop="beanName">
                            <Input v-model="formValidate.beanName" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="方法名称："  prop="methodName">
                            <Input v-model="formValidate.methodName" ></Input>
                        </FormItem>
                    </Col>
                </Row>

                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="传入参数："  prop="params">
                            <Input v-model="formValidate.params" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="cron表达式："  prop="cronExpression">
                            <Input v-model="formValidate.cronExpression" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="备注："  prop="code">
                            <Input v-model="formValidate.remark" ></Input>
                        </FormItem>
                    </Col>
                </Row>

                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="checkmark" @click="confirm('formValidate')" :loading="loading">确认修改</Button>
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

    import { mapActions, mapState } from 'vuex';
    import {resetWorkHeight} from '@/libs/util.js';
    export default{
        name: 'timeSetting',
        data () {
            // const validatePatmentEndCheck = (rule, value, callback) => {
            //     if (value.length > 265) {
            //         callback(new Error('备注最大长度265!'));
            //     }
            //     callback();
            // };
            return {
                ruleValidate: {
                    beanName: [
                        { required: true, message: '请输入类名称!', trigger: 'blur' }
                    ],
                    methodName: [
                        { required: true, message: '请输入方法名称!', trigger: 'blur' }
                    ],
                    cronExpression: [
                        { required: true, message: '请输入cron表达式!', trigger: 'blur' }
                    ]
                }
            };
        },
        computed: {
            ...mapState({
                loading: ({timeSettingEdit}) => timeSettingEdit.loading,
                formValidate: ({timeSettingEdit}) => timeSettingEdit.timeSettingEdit,
                isSuccess: ({timeSettingEdit}) => timeSettingEdit.isSuccess,
                teamEditMsg: ({timeSettingEdit}) => timeSettingEdit.timeSettingMsg
            })
        },
        methods: {
            ...mapActions([
                'FindById',
                'Update'
            ]),
            init () {
                this.FindById(this.$route.query.id).then(res => { });
                resetWorkHeight();
            },
            confirm (name) { // 提交审核
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        console.log('---------');
                        console.log(this.formValidate);
                        this.Update(this.formValidate).then(res => {
                            if (this.isSuccess) {
                                this.$Modal.success({
                                    title: '修改',
                                    content: this.teamEditMsg,
                                    onOk: () => {
                                        this.$router.push({name: 'timeSettingList'});
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
                this.$router.push({name: 'timeSettingList'});
            }
        },
        mounted () {
            this.init();
        }
    };
</script>
