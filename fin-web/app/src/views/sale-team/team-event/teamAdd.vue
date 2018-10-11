<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="formValidate" :rules="ruleValidate" :model="formValidate" :label-width="100">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    主信息
                </p>
                <Row>
                    <Col span="8" offset="2" prop="typecode">
                        <FormItem label="指标类型:">
                            <Select v-model="formValidate.typecode" style="width:200px">
                                <Option v-for="item in indicatorTypes" :value="item.code" :key="item.value">{{ item.name}}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="指标代码:" pop="indicatorcode">
                            <Input placeholder="请输入指标代码" v-model="formValidate.indicatorcode"
                                   style="width:200px"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="是否预警:" prop="alertflag">
                            <Select v-model="formValidate.alertflag" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label
                                    }}
                                </Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="指标名称:" pop="indicatorname">
                            <Input placeholder="请输入指标名称" v-model="formValidate.indicatorname"
                                   style="width:200px"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="上限:" pop="indicatorcaption">
                            <Input placeholder="请输入指标上限" v-model="formValidate.indicatorcaption"
                                   style="width:200px"></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="下限:" pop="indicatorgroup">
                            <Input placeholder="请输入指标下限" v-model="formValidate.indicatorgroup"
                                   style="width:200px"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="信号灯:" prop="signallamp">
                            <Select v-model="formValidate.signallamp" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label
                                    }}
                                </Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="区域范围:" prop="areatype">
                            <Select v-model="formValidate.areatype" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label
                                    }}
                                </Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="区域:" prop="areacode">
                            <Select v-model="formValidate.areacode" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label
                                    }}
                                </Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="维度类别:" prop="dimtype">
                            <Select v-model="formValidate.dimtype" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label
                                    }}
                                </Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="维度代码:" prop="dimcode">
                            <Select v-model="formValidate.dimcode" style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label
                                    }}
                                </Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                            <FormItem label="备注:" pop="remark">
                                <Input placeholder="请输入备注" v-model="formValidate.remark" style="width:200px"></Input>
                            </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="checkmark" @click="subTeamAddToRev('formValidate')"
                                :loading="loading">添加
                        </Button>
                    </Col>
                    <Col span="4">
                        <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                    </Col>
                </Row>
            </Card>
        </Form>
    </div>
</template>
<script>
    import {mapActions, mapState} from 'vuex';
    import {resetWorkHeight, getUserCookie} from '@/libs/util.js';

    export default {
        name: 'teamAdd',
        data () {
            return {
                cityList: [{
                    value: '1',
                    label: '是'
                },
                {
                    value: '0',
                    label: '否'
                }],
                cityList2: [{
                    value: '1',
                    label: '一汽金融公司'
                },
                {
                    value: '0',
                    label: '一汽财务公司'
                }],
                ruleValidate: {
                    teamName: [
                        {required: true, message: '请输入团队名称!', trigger: 'blur'}
                    ],
                    name: [
                        {required: true, message: '请输入指标类型名称!', trigger: 'blur'}
                    ],
                    remark: [
                        {required: true, message: '请输入备注信息!', trigger: 'blur'}
                    ]
                },
                pinpai: [],
                file: null,
                loadingStatus: false,
                formValidate: {
                    typecode: '',
                    indicatorcode: '',
                    indicatortarget: '',
                    indicatorname: '',
                    indicatorcaption: '',
                    indicatorgroup: '',
                    indicatordesc: '',
                    alertflag: '',
                    enabledflag: '',
                    displayorder: '',
                    parentindicatorcode: '',
                    comcode: '',
                    remark: '',
                    calformula: ''
                }
            };
        },
        computed: {
            ...mapState({
                loading: ({teamAdd}) => teamAdd.loading,
                isSuccess: ({teamAdd}) => teamAdd.isSuccess,
                teamData: ({teamAdd}) => teamAdd.teamAddData,
                indicatorTypes: ({teamList}) => teamList.indicatorTypes
            })
        },
        methods: {
            init() {
                const user = getUserCookie();
                this.formValidate.areaName = user.areaName;
                this.formValidate.areaCode = user.areaCode;
                this.formValidate.company = user.comCode;
                this.searchIndicatorTypes();
                console.log(this.indicatorTypes);
            },
            ...mapActions([
                'handleTeamAddToRev', 'handleIndicatorTypes', 'handleIndicatorTypes'
            ]),
            /**
             * 点击查询按钮执行查询指标类型名
             */
            searchIndicatorTypes () {
                this.handleIndicatorTypes(this.searchFormDate).then(res => {
                    resetWorkHeight();
                    this.$Message.info('查询成功!');
                });
            },
            subTeamAddToRev (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        console.log(this.formValidate);// 此数据提交
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
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            },
            pageBack() {
                this.$router.push({name: 'teamMainTenanceList'});
            }
        },
        mounted() {
            this.init();
        }

    };
</script>
