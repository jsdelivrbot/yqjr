<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="feeReviewProEditData" :rules="ruleValidate" :model="feeReviewProEditData" :label-width="140">
            <Card>
                <p slot="title">
                    <Icon type="edit"></Icon>
                    审核查看
                </p>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="区域名称：" >
                            <Input v-model="feeReviewProEditMainData.areaName" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="活动代码：" >
                            <Input v-model="feeReviewProEditMainData.activeCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="活动名称：" >
                            <Input v-model="feeReviewProEditMainData.activeName" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="首付比例(%)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeReviewProEditMainData.patmentBegin" :max="100" :min="1" disabled placeholder="Select date" style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem >
                                        <Input v-model="feeReviewProEditMainData.patmentEnd" :max="100" :min="1" disabled placeholder="Select time" style="width: 100%"></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="贷款金额(元)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeReviewProEditMainData.loanAmtBegin" :min="1" placeholder="Select date" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeReviewProEditMainData.loanAmtEnd" :min="1" placeholder="Select time" disabled style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="贷款期限(月)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeReviewProEditMainData.loanTermBegin" :min="1" placeholder="Select date" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeReviewProEditMainData.loanTermEnd" :min="1" placeholder="Select time" disabled style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="受理日期">
                            <Row>
                                <Col span="11">
                                    <FormItem >
                                        <DatePicker v-model="feeReviewProEditMainData.activeStartime"  placeholder="受理开始日期" disabled style="width: 100%"></DatePicker>
                                    </FormItem>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem >
                                        <DatePicker  v-model="feeReviewProEditMainData.activeEndtime" placeholder="受理结束日期" disabled style="width: 100%"></DatePicker>
                                    </FormItem>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="放款日期">
                            <Row>
                                <Col span="11">
                                    <DatePicker  v-model="feeReviewProEditMainData.loanStartime" placeholder="放款开始日期" disabled style="width: 100%"></DatePicker>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <DatePicker  v-model="feeReviewProEditMainData.loanEndtime" placeholder="放款结束日期" disabled style="width: 100%"></DatePicker>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="车籍" >
                            <Select v-model="feeReviewProEditMainData.carReg"  style="width:100%" disabled>
                                <Option value="00">全部</Option>
                                <Option value="01">法人</Option>
                                <Option value="02">自然人</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="促销活动激励标准：" >
                            <Input v-model="feeReviewProEditMainData.avtiveCriterion" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="预计活动笔数：" >
                            <Input v-model="feeReviewProEditMainData.expectedCount" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="实际成交笔数：" >
                            <Input v-model="feeReviewProEditData.actualTurnoverCount" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="达成率：" >
                            <Input v-model="feeReviewProEditData.reachRate" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.dealerFlag">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    经销商信息
                </p>
                <Table :columns="dealerColumns" :data="feeReviewProEditData.activeDealeList"></Table>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.areaFlag">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    区域信息
                </p>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="活动范围：" >
                            <Select v-model="feeReviewProEditMainData.inputArea" style="width:100%" placeholder = "全部" disabled>
                                <Option value="1" >区域</Option>
                                <Option value="0" >省市</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.areaRow">
                    <Col span="20" offset="2">
                        <FormItem label="活动区域：" >
                            <Select v-model="feeReviewProEditData.areasList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProEditAreaListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.cityRow">
                    <Row>
                        <Col span="20" offset="2">
                            <FormItem label="活动省份：" >
                                <Select v-model="feeReviewProEditData.provienceList" style="width:100%" disabled multiple >
                                    <Option v-for="item in feeReviewProEditProvinceListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="20" offset="2">
                            <FormItem label="活动城市：" >
                                <Select v-model="feeReviewProEditData.cityList" style="width:100%" disabled multiple>
                                    <Option v-for="item in feeReviewProEditCityListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    品牌信息
                </p>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="活动品牌：" >
                            <Select v-model="feeReviewProEditCarData.brandsCode" style="width:100%" disabled >
                                <Option v-for="item in feeReviewProEditBrandsListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="活动子品牌：" >
                            <Select v-model="feeReviewProEditData.carSeriesList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProEditSeriesListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="活动车型：" >
                            <Select v-model="feeReviewProEditData.carModerList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProEditModerListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    产品信息
                </p>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="金融产品：" >
                            <Select v-model="feeReviewProEditData.financeProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProEditAllProductListData.financeCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="业务模式：" >
                            <Select v-model="feeReviewProEditData.businessCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProEditAllProductListData.businessCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="信贷产品：" >
                            <Select v-model="feeReviewProEditData.creditProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProEditAllProductListData.creditCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="营销活动：" >
                            <Select v-model="feeReviewProEditData.marketingCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProEditAllProductListData.marketingCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="6" offset="2" >
                        <FormItem label="附加贷：" >
                            <Select v-model="feeReviewProEditMainData.additionFlag"  style="width:100%" disabled>
                                <Option value="0">否</Option>
                                <Option value="1">是</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="13" offset="1" v-show="showFlag.additionFlag">
                        <FormItem label="附加贷金额：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeReviewProEditMainData.additionAmtBegin"  disabled ></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeReviewProEditMainData.additionAmtEnd"  disabled ></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.additionFlag">
                    <Col span="20" offset="2">
                        <FormItem label="附加贷子项：" >
                            <Select v-model="feeReviewProEditData.AdditionalList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProEditAllProductListData.additionalCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="9" offset="2">
                        <FormItem label="备注：" >
                            <Button type="success" @click="btn_add_appendix">添加附件</Button>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="2">
                        <FormItem label="备注：" >
                            <Input v-model="feeReviewProEditMainData.remark" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}" disabled></Input>
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
                    <Col span="9" offset="2">
                        <FormItem label="应付金额(元)：" >
                            <Input v-model="feeReviewProEditData.maxBillFee" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="调整金额(元)：" prop="billFee">
                            <Input v-model="feeReviewProEditData.billFee"  ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="2">
                        <FormItem label="备注：" prop="remark2">
                            <Input v-model="feeReviewProEditData.remark2" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="checkmark" @click="feeReviewProSub('feeReviewProEditData')" :loading="loading">提交审核</Button>
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
        name: 'feeReviewProEdit',
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
                var mixBill = this.feeReviewProEditData.maxBillFee;
                if (mixBill < value) {
                    callback(new Error('调整金额应小于应付金额!'));
                }
                callback();
            };
            return {
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
                },
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
                ]
            };
        },
        computed: {
            ...mapState({
                loading: ({feeReviewProEdit}) => feeReviewProEdit.loading,
                feeReviewProEditData: ({feeReviewProEdit}) => feeReviewProEdit.feeReviewProEditData,
                feeReviewProEditMainData: ({feeReviewProEdit}) => feeReviewProEdit.feeReviewProEditMainData,
                feeReviewProEditCarData: ({feeReviewProEdit}) => feeReviewProEdit.feeReviewProEditCarData,
                feeReviewProEditAreaListData: ({feeReviewProEdit}) => feeReviewProEdit.feeReviewProEditAreaListData,
                feeReviewProEditProvinceListData: ({feeReviewProEdit}) => feeReviewProEdit.feeReviewProEditProvinceListData,
                feeReviewProEditCityListData: ({feeReviewProEdit}) => feeReviewProEdit.feeReviewProEditCityListData,
                feeReviewProEditBrandsListData: ({feeReviewProEdit}) => feeReviewProEdit.feeReviewProEditBrandsListData,
                feeReviewProEditSeriesListData: ({feeReviewProEdit}) => feeReviewProEdit.feeReviewProEditSeriesListData,
                feeReviewProEditModerListData: ({feeReviewProEdit}) => feeReviewProEdit.feeReviewProEditModerListData,
                feeReviewProEditAllProductListData: ({feeReviewProEdit}) => feeReviewProEdit.feeReviewProEditAllProductListData,
                isSuccess: ({feeReviewProEdit}) => feeReviewProEdit.isSuccess,
                feeReviewProEditMsg: ({feeReviewProEdit}) => feeReviewProEdit.feeReviewProEditMsg
            })
        },
        methods: {
            ...mapActions([
                'handelQueryFeeReviewProEditByCode',
                'handelFeeReviewProEditProvinceList',
                'handelFeeReviewProEditCityList',
                'handelFeeReviewProEditAreaList',
                'handelFeeReviewProEditBrandsList',
                'handelFeeReviewProEditSeriesList',
                'handelFeeReviewProEditModerList',
                'handelFeeReviewProEditAllProductList',
                'handelFeeReviewProToSubmit'
            ]),
            init () {
                this.queryActiveAreaList();
                this.queryActiveProvinceList();
                this.queryActiveBrandsList();
                this.showActiveProductList();
                this.queryFeeReviewProEditById(this.$route.query.businessCode);
                resetWorkHeight();
            },
            queryFeeReviewProEditById (data) {
                this.handelQueryFeeReviewProEditByCode(data).then(res => {
                    if (!this.isSuccess) {
                        this.$Modal.error({
                            title: '提示',
                            content: this.feeReviewProEditMsg,
                            onOk: () => {
                                this.$router.push({name: 'feeReviewProgressList'});
                            }
                        });
                    }
                    const inputDeale = this.feeReviewProEditData.activeMain.inputDeale;
                    // console.log(this.feeReviewProEditData)
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
                const addFlag = this.feeReviewProEditData.activeMain.additionFlag;
                if (addFlag === '0') {
                    this.showFlag.additionFlag = false;
                } else {
                    this.showFlag.additionFlag = true;
                    var Additionals = [];
                    Additionals = this.feeReviewProEditData.activeAdditional.additionalCode.split(',');
                    this.feeReviewProEditData.AdditionalList = Additionals;
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
                    if (this.feeReviewProEditData.activeMain.inputArea === '1') { // 区域
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
                const brands = this.feeReviewProEditData.activeCar.brandsCode;
                this.handelFeeReviewProEditSeriesList(brands).then(res => {
                });
                this.showCarBrands();
            },
            /**
             * 展示子品牌
             */
            showCarBrands () {
                var carSeries = [];
                carSeries = this.feeReviewProEditData.activeCar.seriesCode.split(',');
                // console.log(carSeries)
                this.feeReviewProEditData.carSeriesList = carSeries;
                this.showCarModer();
            },
            /**
             * 展示车型
             */
            showCarModer () {
                this.handelFeeReviewProEditModerList(this.feeReviewProEditData.activeCar.moderCode).then(res => {
                });
                var carModers = [];
                carModers = this.feeReviewProEditData.activeCar.moderCode.split(',');
                this.feeReviewProEditData.carModerList = carModers;
            },
            /**
             * 初始化查询区域
             * @param name
             */
            queryActiveAreaList () {
                this.handelFeeReviewProEditAreaList().then(res => {
                });
            },
            /**
             * 回显区域
             */
            queryActiveArea () {
                var areas = [];
                areas = this.feeReviewProEditData.activeArea.areaCode.split(',');
                this.feeReviewProEditData.areasList = areas;
            },
            /**
             * 展示省
             * @param name
             */
            queryActiveProvinceList () {
                this.handelFeeReviewProEditProvinceList().then(res => {
                });
            },
            /**
             * 回显省份
             */
            queryActiveProvince () {
                var provienceArr = [];
                var provienceList = [];
                provienceArr = this.feeReviewProEditData.activeArea.provinceCode.split(',');
                this.feeReviewProEditData.provienceList = provienceArr;
                // console.log(provienceArr)
                for (var i = 0; i < provienceArr.length; i++) {
                    provienceList.push(provienceArr);
                }
                // console.log(provienceArr)
                // console.log(provienceList)
                this.queryActiveCityList(provienceList);
                this.queryActiveCity();
            },
            /**
             * 加载市
             * @param name
             */
            queryActiveCityList (data) {
                // console.log(data)
                if (!isEmpty(data)) {
                    this.handelFeeReviewProEditCityList(data).then(res => {
                    });
                }
            },
            /**
             * 展示市
             * @param name
             */
            queryActiveCity () {
                var citys = [];
                citys = this.feeReviewProEditData.activeArea.cityCode.split(',');
                this.feeReviewProEditData.cityList = citys;
            },
            /**
             * 加载品牌
             */
            queryActiveBrandsList () {
                this.handelFeeReviewProEditBrandsList().then(res => {
                });
            },
            /**
             * 加载所有活动产品
             */
            showActiveProductList () {
                this.handelFeeReviewProEditAllProductList().then(res => {
                });
            },
            /**
             * 展示活动产品
             */
            showActiveProduct () {
                var businessCodes = [];
                var marketingCodes = [];
                businessCodes = this.feeReviewProEditData.activeBusiness.businessCode.split(',');
                this.feeReviewProEditData.businessCodeList = businessCodes;

                marketingCodes = this.feeReviewProEditData.activeMarketing.marketingCode.split(',');
                this.feeReviewProEditData.marketingCodeList = marketingCodes;
                this.showActiveProList();
            },
            /**
             * 显示金融信贷产品
             */
            showActiveProList () {
                var financeProdCodes = [];
                var creditProdCodes = [];
                const length = this.feeReviewProEditData.activeProdList.length;
                if (length > 0) {
                    for (var i = 0; i < length; i++) {
                        if (this.feeReviewProEditData.activeProdList[i].prodType === '01') { // 金融产品
                            financeProdCodes = this.feeReviewProEditData.activeProdList[i].prodCode.split(',');
                            this.feeReviewProEditData.financeProdCodeList = financeProdCodes;
                        } else { // 信贷产品
                            creditProdCodes = this.feeReviewProEditData.activeProdList[i].prodCode.split(',');
                            this.feeReviewProEditData.creditProdCodeList = creditProdCodes;
                        }
                    }
                }
            },
            /**
             * 附件链接
             */
            btn_add_appendix () {
                window.open('http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>' + this.feeReviewProEditData.activeMain.additionalId + '</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >');
            },
            feeReviewProSub (name) { // 提交审核
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        console.log(this.feeReviewProEditData);// 此数据提交
                        this.handelFeeReviewProToSubmit(this.feeReviewProEditData).then(res => {
                            if (this.isSuccess) {
                                this.$Modal.success({
                                    title: '提交审核',
                                    content: this.feeReviewProEditMsg,
                                    onOk: () => {
                                        this.$router.push({name: 'feeReviewProgressList'});
                                    }
                                });
                            } else {
                                this.$Modal.error({
                                    title: '消息',
                                    content: this.feeReviewProEditMsg
                                });
                            }
                        });
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            },
            pageBack () {
                this.$router.push({name: 'feeReviewProgressList'});
            }
        },
        mounted () {
            this.init();
        }
    };
</script>