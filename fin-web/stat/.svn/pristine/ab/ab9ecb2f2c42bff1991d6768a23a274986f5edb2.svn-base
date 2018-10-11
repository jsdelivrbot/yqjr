<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="feeDoPayEditData" :rules="ruleValidate" :model="feeDoPayEditData"  :label-width="140">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    费用动支
                </p>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="区域名称：" >
                            <Input v-model="feeDoPayEditMainData.areaName" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="活动代码：" >
                            <Input v-model="feeDoPayEditMainData.activeCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="活动名称：" >
                            <Input v-model="feeDoPayEditMainData.activeName" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="首付比例(%)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeDoPayEditMainData.patmentBegin" :max="100" :min="1" disabled placeholder="Select date" style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem >
                                        <Input v-model="feeDoPayEditMainData.patmentEnd" :max="100" :min="1" disabled placeholder="Select time" style="width: 100%"></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="贷款金额(元)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeDoPayEditMainData.loanAmtBegin" :min="1" placeholder="Select date" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeDoPayEditMainData.loanAmtEnd" :min="1" placeholder="Select time" disabled style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="贷款期限(月)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeDoPayEditMainData.loanTermBegin" :min="1" placeholder="Select date" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeDoPayEditMainData.loanTermEnd" :min="1" placeholder="Select time" disabled style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="受理日期">
                            <Row>
                                <Col span="11">
                                    <FormItem >
                                        <DatePicker v-model="feeDoPayEditMainData.activeStartime"  placeholder="受理开始日期" disabled style="width: 100%"></DatePicker>
                                    </FormItem>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem >
                                        <DatePicker  v-model="feeDoPayEditMainData.activeEndtime" placeholder="受理结束日期" disabled style="width: 100%"></DatePicker>
                                    </FormItem>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="放款日期">
                            <Row>
                                <Col span="11">
                                    <DatePicker  v-model="feeDoPayEditMainData.loanStartime" placeholder="放款开始日期" disabled style="width: 100%"></DatePicker>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <DatePicker  v-model="feeDoPayEditMainData.loanEndtime" placeholder="放款结束日期" disabled style="width: 100%"></DatePicker>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="车籍" >
                            <Select v-model="feeDoPayEditMainData.carReg"  style="width:100%" disabled>
                                <Option value="00">全部</Option>
                                <Option value="01">法人</Option>
                                <Option value="02">自然人</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="促销活动激励标准：" >
                            <Input v-model="feeDoPayEditMainData.avtiveCriterion" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="预计活动笔数：" >
                            <Input v-model="feeDoPayEditMainData.expectedCount" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="实际成交笔数：" >
                            <Input v-model="feeDoPayEditData.actualTurnoverCount" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="达成率：" >
                            <Input v-model="feeDoPayEditData.reachRate" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.dealerFlag">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    经销商信息
                </p>
                <Table :columns="dealerColumns" :data="feeDoPayEditData.activeDealeList"></Table>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.areaFlag">
                <p slot="title">
                    <Icon type="search"></Icon>
                    区域信息
                </p>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="活动范围：" >
                            <Select v-model="feeDoPayEditMainData.inputArea" style="width:100%" placeholder = "全部" disabled>
                                <Option value="1" >区域</Option>
                                <Option value="0" >省市</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.areaRow">
                    <Col span="20" offset="1">
                        <FormItem label="活动区域：" >
                            <Select v-model="feeDoPayEditData.areasList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeDoPayEditAreaListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.cityRow">
                    <Row>
                        <Col span="20" offset="1">
                            <FormItem label="活动省份：" >
                                <Select v-model="feeDoPayEditData.provienceList" style="width:100%" disabled multiple >
                                    <Option v-for="item in feeDoPayEditProvinceListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="20" offset="1">
                            <FormItem label="活动城市：" >
                                <Select v-model="feeDoPayEditData.cityList" style="width:100%" disabled multiple>
                                    <Option v-for="item in feeDoPayEditCityListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    品牌信息
                </p>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="活动品牌：" >
                            <Select v-model="feeDoPayEditCarData.brandsCode" style="width:100%" disabled >
                                <Option v-for="item in feeDoPayEditBrandsListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="活动子品牌：" >
                            <Select v-model="feeDoPayEditData.carSeriesList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeDoPayEditSeriesListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="活动车型：" >
                            <Select v-model="feeDoPayEditData.carModerList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeDoPayEditModerListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    产品信息
                </p>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="金融产品：" >
                            <Select v-model="feeDoPayEditData.financeProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeDoPayEditAllProductListData.financeCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="业务模式：" >
                            <Select v-model="feeDoPayEditData.businessCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeDoPayEditAllProductListData.businessCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="信贷产品：" >
                            <Select v-model="feeDoPayEditData.creditProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeDoPayEditAllProductListData.creditCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="营销活动：" >
                            <Select v-model="feeDoPayEditData.marketingCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeDoPayEditAllProductListData.marketingCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="6" offset="1" >
                        <FormItem label="附加贷：" >
                            <Select v-model="feeDoPayEditMainData.additionFlag"  style="width:100%" disabled>
                                <Option value="0">否</Option>
                                <Option value="1">是</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="12" offset="2" v-show="showFlag.additionFlag">
                        <FormItem label="附加贷金额：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeDoPayEditMainData.additionAmtBegin"  disabled ></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeDoPayEditMainData.additionAmtEnd"  disabled ></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.additionFlag">
                    <Col span="20" offset="1">
                        <FormItem label="附加贷子项：" >
                            <Select v-model="feeDoPayEditData.AdditionalList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeDoPayEditAllProductListData.additionalCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    附件信息
                </p>
                <Row>
                    <Col span="8" offset="1">
                        <FormItem label="备注：" >
                            <Button type="success" @click="btn_add_appendix">添加附件</Button>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="备注：" >
                            <Input v-model="feeDoPayEditMainData.remark" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    费用调整
                </p>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="应付金额(元)：" >
                            <Input v-model="feeDoPayEditData.maxBillFee" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="调整金额(元)：" prop="billFee">
                            <Input v-model="feeDoPayEditData.billFee"  ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="备注：" prop="remark2">
                            <Input v-model="feeDoPayEditData.remark2" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="checkmark" @click="feeEditSubToRev('feeDoPayEditData')" :loading="loading">提交审核</Button>
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
    import {resetWorkHeight, isEmpty} from '@/libs/util.js';
    export default{
        name: 'feeDoPayEdit',
        data () {
            const validatePatmentEndCheck = (rule, value, callback) => {
                if (value.length > 265) {
                    callback(new Error('备注最大长度265!'));
                }
                callback();
            };
            const validateMonenyFormatCheck = (rule, value, callback) => {
                var isNum = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
                if (!isNum.test(value)) {
                    callback(new Error('请输入正确格式的金额!'));
                }
                callback();
            };
            const validateMonenyCheck = (rule, value, callback) => {
                var mixBill = this.feeDoPayEditData.maxBillFee;
                if (mixBill < value) {
                    callback(new Error('调整金额应小于应付金额!'));
                }
                callback();
            };
            return {
                showFlag: {
                    dealerFlag: true,
                    areaFlag: true,
                    areaRow: true,
                    cityRow: true,
                    additionFlag: true
                },
                dealerColumns: [
                    {
                        title: '经销商代码',
                        align: 'center',
                        key: 'dealerCode'
                    }, {
                        title: '经销商名称',
                        align: 'center',
                        key: 'dealerName'
                    }, {
                        title: '活动上限/辆',
                        align: 'center',
                        key: 'activeNumber'
                    }
                ],
                ruleValidate: {
                    remark2: [
                        { required: true, message: '请输入备注!', trigger: 'blur' },
                        { validator: validatePatmentEndCheck }
                    ],
                    billFee: [
                        { required: true, message: '请输入金额!', trigger: 'blur' },
                        { validator: validateMonenyFormatCheck },
                        { validator: validateMonenyCheck }
                    ]
                }
            };
        },
        computed: {
            ...mapState({
                loading: ({feeDoPayEdit}) => feeDoPayEdit.loading,
                feeDoPayEditData: ({feeDoPayEdit}) => feeDoPayEdit.feeDoPayEditData,
                feeDoPayEditMainData: ({feeDoPayEdit}) => feeDoPayEdit.feeDoPayEditMainData,
                feeDoPayEditCarData: ({feeDoPayEdit}) => feeDoPayEdit.feeDoPayEditCarData,
                feeDoPayEditAreaListData: ({feeDoPayEdit}) => feeDoPayEdit.feeDoPayEditAreaListData,
                feeDoPayEditProvinceListData: ({feeDoPayEdit}) => feeDoPayEdit.feeDoPayEditProvinceListData,
                feeDoPayEditCityListData: ({feeDoPayEdit}) => feeDoPayEdit.feeDoPayEditCityListData,
                feeDoPayEditBrandsListData: ({feeDoPayEdit}) => feeDoPayEdit.feeDoPayEditBrandsListData,
                feeDoPayEditSeriesListData: ({feeDoPayEdit}) => feeDoPayEdit.feeDoPayEditSeriesListData,
                feeDoPayEditModerListData: ({feeDoPayEdit}) => feeDoPayEdit.feeDoPayEditModerListData,
                feeDoPayEditAllProductListData: ({feeDoPayEdit}) => feeDoPayEdit.feeDoPayEditAllProductListData,
                feeDoPayEditMsg: ({feeDoPayEdit}) => feeDoPayEdit.feeDoPayEditMsg,
                isSuccess: ({feeDoPayEdit}) => feeDoPayEdit.isSuccess
            })
        },
        methods: {
            ...mapActions([
                'handelFeeQueryActiveByCode',
                'handelFeeQueryProvinceList',
                'handelFeeQueryCityList',
                'handelFeeQueryAreaList',
                'handelFeeQueryBrandsList',
                'handelFeeQuerySeriesList',
                'handelFeeQueryModerList',
                'handelFeeQueryAllProductList',
                'handleFeeEditSubToRev'
            ]),
            init () {
                this.queryActiveAreaList();
                this.queryActiveProvinceList();
                this.queryActiveBrandsList();
                this.showActiveProductList();
                this.queryFeeQueryActiveByCode(this.$route.params.businessCode);
                resetWorkHeight();
            },
            queryFeeQueryActiveByCode (code) {
                this.handelFeeQueryActiveByCode(code).then(res => {
                    if (!this.isSuccess) {
                        this.$Modal.error({
                            title: '提示',
                            content: this.feeDoPayEditMsg,
                            onOk: () => {
                                this.$router.push({name: 'feeDoPayList'});
                            }
                        });
                    }
                    const inputDeale = this.feeDoPayEditData.activeMain.inputDeale;
                    // console.log(this.feeDoPayEditData)
                    this.judgmentInputFlag(inputDeale);
                    this.showCarBrandsList();
                    this.showActiveProduct();
                    this.judgmentAdditionFlag();
                    resetWorkHeight();
                });
            },
            /**
             * 判断是否附加贷
             */
            judgmentAdditionFlag () {
                const addFlag = this.feeDoPayEditData.activeMain.additionFlag;
                if (addFlag === '0') {
                    this.showFlag.additionFlag = false;
                } else {
                    this.showFlag.additionFlag = true;
                    var Additionals = [];
                    Additionals = this.feeDoPayEditData.activeAdditional.additionalCode.split(',');
                    this.feeDoPayEditData.AdditionalList = Additionals;
                }
            },
            /**
             * 判断是显示区域或经销商
             * @param inputDeale
             */
            judgmentInputFlag (inputDeale) {
                if (inputDeale === '1') {
                    this.showFlag.dealerFlag = true;
                    this.showFlag.areaFlag = false;
                } else {
                    this.showFlag.dealerFlag = false;
                    this.showFlag.areaFlag = true;
                    if (this.feeDoPayEditData.activeMain.inputArea === '1') { // 区域
                        this.showFlag.areaRow = true;
                        this.showFlag.cityRow = false;
                        this.queryActiveArea();
                    } else { // 省市
                        this.showFlag.areaRow = false;
                        this.showFlag.cityRow = true;
                        this.queryActiveProvince();
                    }
                }
            },
            /**
             * 加载子品牌
             */
            showCarBrandsList () {
                const brands = this.feeDoPayEditData.activeCar.seriesCode;
                this.handelFeeQuerySeriesList(brands).then(res => {
                });
                this.showCarBrands();
            },
            /**
             * 展示子品牌
             */
            showCarBrands () {
                var carSeries = [];
                carSeries = this.feeDoPayEditData.activeCar.seriesCode.split(',');
                // console.log(carSeries)
                this.feeDoPayEditData.carSeriesList = carSeries;
                this.showCarModer();
            },
            /**
             * 展示车型
             */
            showCarModer () {
                this.handelFeeQueryModerList(this.feeDoPayEditData.activeCar.moderCode).then(res => {
                });
                var carModers = [];
                carModers = this.feeDoPayEditData.activeCar.moderCode.split(',');
                this.feeDoPayEditData.carModerList = carModers;
            },
            /**
             * 初始化查询区域
             * @param name
             */
            queryActiveAreaList () {
                this.handelFeeQueryAreaList().then(res => {
                });
            },
            /**
             * 回显区域
             */
            queryActiveArea () {
                var areas = [];
                areas = this.feeDoPayEditData.activeArea.areaCode.split(',');
                this.feeDoPayEditData.areasList = areas;
            },
            /**
             * 展示省
             * @param name
             */
            queryActiveProvinceList () {
                this.handelFeeQueryProvinceList().then(res => {
                });
            },
            /**
             * 回显省份
             */
            queryActiveProvince () {
                var provienceArr = [];
                var provienceList = [];
                provienceArr = this.feeDoPayEditData.activeArea.provinceCode.split(',');
                this.feeDoPayEditData.provienceList = provienceArr;
                // console.log(provienceArr)
                for (var i = 0; i < provienceArr.length; i++) {
                    provienceList.push(provienceArr);
                }
                // console.log(provienceArr)
                // console.log(provienceList)
                this.queryActiveCityList(provienceList);
                this.queryActiveCity(provienceList);
            },
            /**
             * 加载市
             * @param name
             */
            queryActiveCityList (data) {
                // console.log(data)
                if (!isEmpty(data)) {
                    this.handelFeeQueryCityList(data).then(res => {
                    });
                }
            },
            /**
             * 展示市
             * @param name
             */
            queryActiveCity (data) {
                var citys = [];
                citys = this.feeDoPayEditData.activeArea.cityCode.split(',');
                this.feeDoPayEditData.cityList = citys;
            },
            /**
             * 加载品牌
             */
            queryActiveBrandsList () {
                this.handelFeeQueryBrandsList().then(res => {
                });
            },
            /**
             * 加载所有活动产品
             */
            showActiveProductList () {
                this.handelFeeQueryAllProductList().then(res => {
                });
            },
            /**
             * 展示活动产品
             */
            showActiveProduct () {
                var businessCodes = [];
                var marketingCodes = [];
                businessCodes = this.feeDoPayEditData.activeBusiness.businessCode.split(',');
                this.feeDoPayEditData.businessCodeList = businessCodes;

                marketingCodes = this.feeDoPayEditData.activeMarketing.marketingCode.split(',');
                this.feeDoPayEditData.marketingCodeList = marketingCodes;
                this.showActiveProList();
            },
            /**
             * 显示金融信贷产品
             */
            showActiveProList () {
                var financeProdCodes = [];
                var creditProdCodes = [];
                const length = this.feeDoPayEditData.activeProdList.length;
                if (length > 0) {
                    for (var i = 0; i < length; i++) {
                        if (this.feeDoPayEditData.activeProdList[i].prodType === '01') { // 金融产品
                            financeProdCodes = this.feeDoPayEditData.activeProdList[i].prodCode.split(',');
                            this.feeDoPayEditData.financeProdCodeList = financeProdCodes;
                        } else { // 信贷产品
                            creditProdCodes = this.feeDoPayEditData.activeProdList[i].prodCode.split(',');
                            this.feeDoPayEditData.creditProdCodeList = creditProdCodes;
                        }
                    }
                }
            },
            /**
             * 附件链接
             */
            btn_add_appendix () {
                window.open('http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>' + this.feeDoPayEditData.activeMain.additionalId + '</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >');
            },
            /**
             * 提交审核
             * @param name
             */
            feeEditSubToRev (name) { // 提交审核
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        console.log(this.feeDoPayEditData);// 此数据提交
                        this.handleFeeEditSubToRev(this.feeDoPayEditData).then(res => {
                            if (this.isSuccess) {
                                this.$Modal.success({
                                    title: '发起动支',
                                    content: this.feeDoPayEditMsg,
                                    onOk: () => {
                                        this.$router.push({name: 'feeDoPayList'});
                                    }
                                });
                            } else {
                                this.$Modal.error({
                                    title: '发起动支',
                                    content: this.feeDoPayEditMsg,
                                    onOk: () => {
                                        this.$router.push({name: 'feeDoPayList'});
                                    }
                                });
                            }
                        });
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            },
            pageBack () {
                this.$router.push({name: 'feeDoPayList'});
            }
        },
        mounted () {
            this.init();
        }
    };
</script>