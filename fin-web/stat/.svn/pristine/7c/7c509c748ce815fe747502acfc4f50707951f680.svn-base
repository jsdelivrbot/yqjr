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
                    <Col span="8" offset="2">
                        <FormItem label="指标类型:" prop="typecode">
                            <Select v-model="formValidate.typecode" clearable="true"	 style="width:200px">
                                <Option v-for="item in iTypesO" :value="item.code" :key="item.value">{{ item.name}}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="指标代码:" prop="indicatorcode">
                            <Input  placeholder="请输入指标代码" v-model="formValidate.indicatorcode"  style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="指标对象:" prop="indicatortarget">
                            <Input  placeholder="请输入指标对象" v-model="formValidate.indicatortarget" maxlength="100" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="指标名称:"  prop="indicatorname">
                            <Input  placeholder="请输入指标名称" v-model="formValidate.indicatorname" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="指标主题:" prop="indicatorcaption">
                            <Input  placeholder="请输入指标主题" v-model="formValidate.indicatorcaption" maxlength="100" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="指标小类:" prop="indicatorgroup">
                            <Input  placeholder="请输入指标小类" v-model="formValidate.indicatorgroup" maxlength="100" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="指标说明:" prop="indicatordesc">
                            <Input  placeholder="请输入指标说明" v-model="formValidate.indicatordesc" maxlength="100" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="6" offset="2">
                        <FormItem label="指标级别:"  prop="indlevel">
                              <Select v-model="formValidate.indlevel" clearable="true"	 style="width:200px">
                                    <Option v-for="item in indLevelList" :value="item.value" :key="item.value">{{ item.value}}</Option>
                              </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="是否预警:" prop="alertflag">
                            <Select v-model="formValidate.alertflag " clearable="true"	 style="width:200px">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="是否启用:" prop="enabledflag">
                            <Select v-model="formValidate.enabledflag " clearable="true"	 style="width:200px">
                                <Option v-for="item in cityList1" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="显示顺序:" prop="displayorder">
                            <Input  placeholder="请输入显示顺序" v-model="formValidate.displayorder" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="上级指标:" prop="parentindicatorcode">
                            <Input  placeholder="请输入上级指标" v-model="formValidate.parentindicatorcode" style="width:200px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="预警频率:">
                            <Select v-model="formValidate.alertcycle" clearable="true"	 style="width:200px">
                                <Option v-for="item in cityList8" :value="item.label" :key="item.value">{{
                                    item.label }}
                                </Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" >
                        <FormItem label="归属公司:" prop="comcode">
                            <Select v-model="formValidate.comcode " clearable="true"	 style="width:200px">
                                <Option v-for="item in com" :value="item.value" :key="item.value">{{ item.name }}</Option>
                            </Select>
                        </FormItem>
                    </Col>

                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="公式:" prop="calformula">
                            <Input  type="textarea" placeholder="请输入公式" v-model="formValidate.calformula" maxlength="300" style="width:710px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2" >
                        <FormItem label="备注:" prop="remark">
                            <Input type="textarea" placeholder="请输入备注" maxlength="300" v-model="formValidate.remark" style="width:710px" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="checkmark" @click="subTeamAddToRev('formValidate')" :loading="loading">添加</Button>
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
    import {resetWorkHeight, getUserCookie, isEmpty} from '@/libs/util.js';
    export default{
        name: 'indicatorAdd',
        data () {
            return {
                ruleValidate: {
                    typecode: [
                        { required: true, message: '请选择指标类型!', trigger: 'blur' }
                    ],
                    indicatorcode: [
                        { required: true, message: '请输入指标代码!', trigger: 'blur' }
                        // { validator: validateCode }
                    ],
                    indicatorname: [
                        { required: true, message: '请输入指标名称!', trigger: 'blur' }
                    ]
                },
                indLevelList: [{
                    value: 0
                },
                {
                    value: 1
                },
                {
                    value: 2
                },
                {
                    value: 3
                },
                {
                    value: 4
                },
                {
                    value: 5
                },
                {
                    value: 6
                }
                ],
                cityList: [{
                    value: '1',
                    label: '是'
                },
                {
                    value: '0',
                    label: '否'
                }],
                cityList1: [{
                    value: 1,
                    label: '是'
                },
                {
                    value: 0,
                    label: '否'
                }],
                cityList8: [{
                    value: '年',
                    label: '年'
                },
                {
                    value: '月',
                    label: '月'
                },
                {
                    value: '日',
                    label: '日'
                }
                ],
                cityList2: [{
                    value: '1',
                    label: '一汽汽车金融公司'
                },
                {
                    value: '0',
                    label: '一汽财务公司'
                },
                {
                    value: '3',
                    label: '一汽汽车租赁公司'
                }
                ],
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
                    alertflag: '1',
                    enabledflag: 1,
                    displayorder: '',
                    parentindicatorcode: '',
                    comcode: '1',
                    remark: '',
                    calformula: ''
                }
            };
        },
        computed: {
            ...mapState({
                loading: ({indicatorAdd}) => indicatorAdd.loading,
                isSuccess: ({indicatorAdd}) => indicatorAdd.isSuccess,
                teamData: ({indicatorAdd}) => indicatorAdd.teamAddData,
                iTypesO: ({indicatorAdd}) => indicatorAdd.itypes,
                msg: ({indicatorAdd}) => indicatorAdd.msg,
                com: ({indicatorAdd}) => indicatorAdd.com,
                // mcode: ({indicatorAdd}) => indicatorAdd.mcode,
                indLevel: ({indicatorsList}) => indicatorsList.indLevel
            })
        },
        methods: {
            init () {
                const user = getUserCookie();
                this.formValidate.areaName = user.areaName;
                this.formValidate.areaCode = user.areaCode;
                this.formValidate.company = user.comCode;
                this.handleIndLevel().then(res => {
                    resetWorkHeight();
                    console.log(this.indLevel);
                });
                this.searchITy();
                console.log(this.formValidate.comcode);
                this.formValidate.code = 'Company';
                this.formValidate.flag = 0;
                this.handelCom(this.formValidate).then(res => {
                });
                console.log(this.com);
            },
            searchITy () {
                this.handleITy().then(res => {
                    resetWorkHeight();
                });
            },
            ...mapActions([
                'handleTeamAddToRev', 'handleITy', 'handleIndLevel', 'handelSelIndicator', 'handelCom'
            ]),
            // selIndicatorCode () {
            //     this.handelSelIndicator(this.formValidate.indicatorcode).then(res => {
            //         resetWorkHeight();
            //     });
            //     !isEmpty(this.mcode) {
            //         this.validateCode;
            //     }
            //     console.log(this.mcode);
            // },
            suD () {
                this.handleTeamAddToRev(this.formValidate).then(res => {
                    console.log(this.formValidate);
                    if (this.isSuccess) {
                        this.$Modal.success({
                            title: '提交成功',
                            content: this.teamData,
                            onOk: () => {
                                this.$router.push({name: 'indicatorList'});
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
            subTeamAddToRev (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        const user = getUserCookie();
                        this.formValidate.creator = user.id;
                        this.handelSelIndicator(this.formValidate.indicatorcode).then(res => {
                            if (this.isSuccess) {
                                this.suD();
                            } else {
                                this.$Modal.error({
                                    title: '提示',
                                    content: this.msg
                                });
                            }
                            resetWorkHeight();
                        });
                        console.log(this.formValidate);// 此数据提交
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            },
            pageBack () {
                this.$router.push({name: 'indicatorList'});
            }
        },
        mounted () {
            this.init();
        }

    };
</script>
