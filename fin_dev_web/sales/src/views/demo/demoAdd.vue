<style lang="less">
    @import '../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="formValidate" :rules="ruleValidate" :model="formValidate" :label-width="100">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    主信息
                </p>
                <a href="#" slot="extra" @click.prevent="pageBack">
                    <Icon type="arrow-return-left"></Icon>
                    返回
                </a>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="活动名称" prop="activeName">
                            <Input v-model="formValidate.activeName" placeholder="请输入活动名称" clearable></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="首付比例">
                            <Row>
                                <Col span="11">
                                    <Input v-model="formValidate.patmentBegin" :max="100" :min="1" placeholder="Select date" style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem prop="patmentEnd">
                                        <Input v-model="formValidate.patmentEnd" :max="100" :min="1" placeholder="Select time" style="width: 100%"></Input>
                                    </FormItem>
                                 </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="贷款金额" required>
                            <Row>
                                <Col span="11">
                                    <Input v-model="formValidate.loanAmtBegin" :min="1" placeholder="Select date" style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="formValidate.loanAmtEnd" :min="1" placeholder="Select time" style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="贷款期限" required>
                            <Row>
                                <Col span="11">
                                    <Input v-model="formValidate.loanTermBegin" :min="1" :max="48" placeholder="Select date" style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="formValidate.loanTermEnd" :min="1" :max="48" placeholder="Select time" style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="受理日期">
                            <Row>
                                <Col span="11">
                                <FormItem prop="activeStartime">
                                    <DatePicker v-model="formValidate.activeStartime"  placeholder="受理开始日期" style="width: 100%"></DatePicker>
                                </FormItem>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                <FormItem prop="activeEndtime">
                                    <DatePicker  v-model="formValidate.activeEndtime" placeholder="受理结束日期" style="width: 100%"></DatePicker>
                                </FormItem>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="放款日期">
                            <Row>
                                <Col span="11">
                                    <DatePicker  v-model="formValidate.loanStartime" placeholder="放款开始日期" style="width: 100%"></DatePicker>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <DatePicker  v-model="formValidate.loanEndtime" placeholder="放款结束日期" style="width: 100%"></DatePicker>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="车籍" prop="carReg">
                            <Select v-model="formValidate.carReg"  style="width:100%">
                                <Option value="0">法人</Option>
                                <Option value="1">自然人</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    品牌信息
                </p>
                <Row>
                    <Col span="20" offset="2">
                    <FormItem label="活动品牌">
                        <Select v-model="pinpai" multiple>
                            <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="2">
                    <FormItem label="活动子品牌">
                        <Select v-model="pinpai" multiple>
                            <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="2">
                    <FormItem label="活动车型">
                        <Select v-model="pinpai" multiple>
                            <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                        </Select>
                    </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    附件信息
                </p>
                <Upload
                        :before-upload="handleUpload"
                        action="//jsonplaceholder.typicode.com/posts/">
                    <Button type="ghost" icon="ios-cloud-upload-outline">请选择文件</Button>
                </Upload>
                <div v-if="file !== null">文件名称: {{ file.name }} <Button type="text" @click="upload" :loading="loadingStatus">{{ loadingStatus ? '上传中' : '点击上传' }}</Button></div>
                <Row>
                    <Col span="5" offset="9">
                    <Button type="success" long @click="handleSubmit('formValidate')">提交</Button>
                    </Col>
                </Row>
            </Card>
        </Form>
    </div>
</template>
<script>
export default{
    name: 'demoAdd',
    data () {
        // 自定义验证
        const validatePatmentEndCheck = (rule, value, callback) => {
            if (value <= this.formValidate.patmentBegin) {
                callback(new Error('自定义验证!'));
            }
            callback();
        };
        return {
            cityList: [
                {
                    value: 'New York',
                    label: 'New York'
                },
                {
                    value: 'London',
                    label: 'London'
                },
                {
                    value: 'Sydney',
                    label: 'Sydney'
                },
                {
                    value: 'Ottawa',
                    label: 'Ottawa'
                },
                {
                    value: 'Paris',
                    label: 'Paris'
                },
                {
                    value: 'Canberra',
                    label: 'Canberra'
                }
            ],
            pinpai: [],
            file: null,
            loadingStatus: false,
            formValidate: {
                activeName: '', // 活动名称
                patmentBegin: 0, // 首付比例起始值
                patmentEnd: 0, // 首付比例终止值
                loanAmtBegin: 0, // 贷款金额起始值
                loanAmtEnd: 0, // 贷款金额终止值
                loanTermBegin: 0, // 贷款金额起始月
                loanTermEnd: 0, // 贷款金额终止月
                activeStartime: '', // 受理开始日期
                activeEndtime: '', // 受理结束日期
                loanStartime: '', // 放款开始日期
                loanEndtime: '', // 放款结束日期
                carReg: ''// 车籍
            },
            ruleValidate: {
                activeName: [
                    { required: true, message: '请输入活动名称!', trigger: 'blur' }
                ],
                patmentEnd: [
                    { validator: validatePatmentEndCheck }
                ],
                activeStartime: [
                    { required: true, type: 'date', message: '请录入受理开始日期!', trigger: 'change' }
                ],
                activeEndtime: [
                    { required: true, type: 'date', message: '请录入受理结束日期!', trigger: 'change' }
                ],
                carReg: [
                    { required: true, message: '请选择车籍!', trigger: 'change' }
                ]
            }
        };
    },
    methods: {
        pageBack () {
            this.$router.push({name: 'demoList'});
        },
        handleUpload (file) {
            this.file = file;
            return false;
        },
        upload () {
            this.loadingStatus = true;
            setTimeout(() => {
                this.file = null;
                this.loadingStatus = false;
                this.$Message.success('Success');
            }, 1500);
        },
        handleSubmit (name) {
            this.$refs[name].validate((valid) => {
                if (valid) {
                    console.log(this.formValidate);// 此数据提交
                    this.$Notice.config({
                        top: 200,
                        duration: 3
                    });
                    this.$Notice.success({
                        title: '通知',
                        desc: '提交成功!'
                    });
                } else {
                    this.$Message.error('验证错误!');
                }
            });
        }
    }

};
</script>