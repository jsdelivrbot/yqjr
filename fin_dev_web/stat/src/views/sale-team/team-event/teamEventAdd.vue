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
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队名称：" prop="teamName">
                            <Select :label-in-value="true" filterable remote :remote-method="searchTeam"  @on-change='getTeamCode' :loading="loading" placeholder="请输入团队名称|自动搜索" v-model="formValidate.teamName">
                                <Option v-for="item in teamNameList"  :value="item.value" :key="item.label" :label="item.label" >{{item.label}}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="团队代码：" >
                            <Input v-model="formValidate.teamCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="事项年度：" prop="eventYear">
                            <DatePicker type="year" v-model="formValidate.eventYear" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="处理单位" prop="eventApart">
                            <Input v-model="formValidate.eventApart" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="事项分类：" prop="eventType">
                            <Select v-model="formValidate.eventType" style="width:100%">
                                <Option value="0" selected>奖励</Option>
                                <Option value="1" selected>处罚</Option>
                                <Option value="2" selected>其他</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="事项内容：" prop="eventText">
                            <Input v-model="formValidate.eventText" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="checkmark" @click="teamEventAddSub('formValidate')" :loading="loading">提交</Button>
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
import {resetWorkHeight, formatDate, getUserCookie} from '@/libs/util.js';
export default{
    name: 'teamEventAdd',
    data () {
        const validatePatmentEndCheck = (rule, value, callback) => {
            if (value.length > 265) {
                callback(new Error('事项内容最大长度265!'));
            }
            callback();
        };
        const validateEventApartCheck = (rule, value, callback) => {
            if (value.length > 60) {
                callback(new Error('处理单位最大长度60!'));
            }
            callback();
        };
        return {
            ruleValidate: {
                teamName: [
                    { required: true, message: '请输入团队名称!', trigger: 'change' }
                ],
                eventYear: [
                    { required: true, type: 'date', message: '请输入事项年度!', trigger: 'change' }
                ],
                eventApart: [
                    { required: true, message: '请输入处理单位!', trigger: 'blur' },
                    { validator: validateEventApartCheck }
                ],
                eventType: [
                    { required: true, message: '请输入处理类型!', trigger: 'change' }
                ],
                eventText: [
                    { validator: validatePatmentEndCheck }
                ]
            },
            file: null,
            loadingStatus: false,
            formValidate: {
                teamName: '',
                eventApart: '',
                areaName: '',
                areaCode: '',
                company: '',
                teamCode: '',
                eventYear: '',
                eventType: '',
                eventText: ''
            },
            formValidate2: {
                teamName: ''
            }
        };
    },
    computed: {
        ...mapState({
            loading: ({teamEventAdd}) => teamEventAdd.loading,
            teamEventAddData: ({teamEventAdd}) => teamEventAdd.teamEventAddData,
            teamNameList: ({teamEventAdd}) => teamEventAdd.searchTeamData,
            isSuccess: ({teamEventAdd}) => teamEventAdd.isSuccess
        })
    },
    methods: {
        mounted () {
            this.init();
        },
        init () {
            resetWorkHeight();
        },
        ...mapActions([
            'handleTeamEventAddSub',
            'handleQueryBySearchTeam'
        ]),
        teamEventAddSub (name) {
            this.$refs[name].validate((valid) => {
                if (valid) {
                    const user = getUserCookie();
                    this.formValidate.areaName = user.areaName;
                    this.formValidate.areaCode = user.areaCode;
                    this.formValidate.company = user.comCode;
                    console.log(this.formValidate);// 此数据提交
                    this.formValidate.eventYear = formatDate(this.formValidate.eventYear, 'yyyy');
                    this.formValidate.teamName = this.formValidate2.teamName;
                    this.handleTeamEventAddSub(this.formValidate).then(res => {
                        resetWorkHeight();
                        if (this.isSuccess) {
                            this.$Modal.success({
                                title: '提交成功',
                                content: this.teamEventAddData,
                                onOk: () => {
                                    this.$router.push({name: 'teamEventList'});
                                }
                            });
                        } else {
                            this.$Modal.error({
                                title: '提交失败',
                                content: this.teamEventAddData
                            });
                        }
                    });
                } else {
                    this.$Message.error('验证错误!');
                }
            });
        },
        pageBack () {
            this.$router.push({name: 'teamEventList'});
        },
        searchTeam (query) {
            this.handleQueryBySearchTeam(query);
        },
        getTeamCode (data) {
            console.log(data);
            this.formValidate2.teamName = data.label;
            this.formValidate.teamCode = data.value;
        }
    }

};
</script>