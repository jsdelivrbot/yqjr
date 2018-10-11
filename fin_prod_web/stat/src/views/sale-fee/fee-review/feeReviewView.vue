<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form :label-width="100">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    审核查看
                </p>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="区域名称：" >
                            <Input v-model="feeReviewViewMainData.areaName" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="活动代码：" >
                            <Input v-model="feeReviewViewMainData.activeCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="活动名称：" >
                            <Input v-model="feeReviewViewMainData.activeName" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="首付比例(%)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeReviewViewMainData.patmentBegin" :max="100" :min="1" disabled placeholder="首付比例" style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem >
                                        <Input v-model="feeReviewViewMainData.patmentEnd" :max="100" :min="1" disabled placeholder="首付比例" style="width: 100%"></Input>
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
                                    <Input v-model="feeReviewViewMainData.loanAmtBegin" :min="1" placeholder="贷款金额" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeReviewViewMainData.loanAmtEnd" :min="1" placeholder="贷款金额" disabled style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="贷款期限(月)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeReviewViewMainData.loanTermBegin" :min="1" placeholder="贷款期限" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeReviewViewMainData.loanTermEnd" :min="1" placeholder="贷款期限" disabled style="width: 100%"></Input>
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
                                        <DatePicker v-model="feeReviewViewMainData.activeStartime"  placeholder="受理开始日期" disabled style="width: 100%"></DatePicker>
                                    </FormItem>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem >
                                        <DatePicker  v-model="feeReviewViewMainData.activeEndtime" placeholder="受理结束日期" disabled style="width: 100%"></DatePicker>
                                    </FormItem>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="放款日期">
                            <Row>
                                <Col span="11">
                                    <DatePicker  v-model="feeReviewViewMainData.loanStartime" placeholder="放款开始日期" disabled style="width: 100%"></DatePicker>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <DatePicker  v-model="feeReviewViewMainData.loanEndtime" placeholder="放款结束日期" disabled style="width: 100%"></DatePicker>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="车籍" >
                            <Select v-model="feeReviewViewMainData.carReg"  style="width:100%" disabled>
                                <Option value="00">全部</Option>
                                <Option value="01">法人</Option>
                                <Option value="02">自然人</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="促销活动激励标准：" >
                            <Input v-model="feeReviewViewMainData.avtiveCriterion" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="预计活动笔数：" >
                            <Input v-model="feeReviewViewMainData.expectedCount" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="实际成交笔数：" >
                            <Input v-model="feeReviewViewData.actualTurnoverCount" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="达成率：" >
                            <Input v-model="feeReviewViewData.reachRate" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.dealerFlag">
                <p slot="title">
                    <Icon type="search"></Icon>
                    经销商信息
                </p>
                <Table :columns="dealerColumns" :data="feeReviewViewData.activeDealeList"></Table>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.areaFlag">
                <p slot="title">
                    <Icon type="search"></Icon>
                    区域信息
                </p>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="活动范围：" >
                            <Select v-model="feeReviewViewMainData.inputArea" style="width:100%" placeholder = "全部" disabled>
                                <Option value="1" >区域</Option>
                                <Option value="0" >省市</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.areaRow">
                    <Col span="18" offset="2">
                        <FormItem label="活动区域：" >
                            <Select v-model="feeReviewViewData.areasList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewViewAreaListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.cityRow">
                    <Row>
                        <Col span="18" offset="2">
                            <FormItem label="活动省份：" >
                                <Select v-model="feeReviewViewData.provienceList" style="width:100%" disabled multiple >
                                    <Option v-for="item in feeReviewViewProvinceListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="18" offset="2">
                            <FormItem label="活动城市：" >
                                <Select v-model="feeReviewViewData.cityList" style="width:100%" disabled multiple>
                                    <Option v-for="item in feeReviewViewCityListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="18" offset="2">
                        <FormItem label="活动品牌：" >
                            <Select v-model="feeReviewViewCarData.brandsCode" style="width:100%" disabled >
                                <Option v-for="item in feeReviewViewBrandsListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="活动子品牌：" >
                            <Select v-model="feeReviewViewData.carSeriesList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewViewSeriesListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="活动车型：" >
                            <Select v-model="feeReviewViewData.carModerList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewViewModerListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="18" offset="2">
                        <FormItem label="金融产品：" >
                            <Select v-model="feeReviewViewData.financeProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewViewAllProductListData.financeCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="业务模式：" >
                            <Select v-model="feeReviewViewData.businessCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewViewAllProductListData.businessCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="信贷产品：" >
                            <Select v-model="feeReviewViewData.creditProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewViewAllProductListData.creditCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="营销活动：" >
                            <Select v-model="feeReviewViewData.marketingCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewViewAllProductListData.marketingCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="6" offset="2" >
                        <FormItem label="附加贷：" >
                            <Select v-model="feeReviewViewMainData.additionFlag"  style="width:100%" disabled>
                                <Option value="0">否</Option>
                                <Option value="1">是</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="1" v-show="showFlag.additionFlag">
                        <FormItem label="附加贷金额：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeReviewViewMainData.additionAmtBegin"  disabled ></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeReviewViewMainData.additionAmtEnd"  disabled ></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.additionFlag">
                    <Col span="18" offset="2">
                        <FormItem label="附加贷子项：" >
                            <Select v-model="feeReviewViewData.AdditionalList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewViewAllProductListData.additionalCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="备注：" >
                            <Button type="success" @click="btn_add_appendix">添加附件</Button>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="备注：" >
                            <Input v-model="feeReviewViewMainData.remark" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    费用信息
                </p>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="应付金额(元)：" >
                            <Input v-model="feeReviewViewData.maxBillFee" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="调整金额(元)：" prop="billFee">
                            <Input v-model="feeReviewViewData.billFee"  disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="备注：" prop="remark2">
                            <Input v-model="feeReviewViewData.remark2" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    审核进度
                </p>
                <Table :data="feeReviewViewResult" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                <Row class="margin-top-20">
                    <Col span="4" offset="9">
                        <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                    </Col>
                </Row>
            </Card>
        </Form>
    </div>
</template>
<script>
import { mapActions, mapState } from 'vuex';
import {resetWorkHeight, isEmpty, formatDate} from '@/libs/util.js';
export default{
    name: 'feeReviewView',
    data () {
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
            tableColumns: [
                {
                    title: '审核类型',
                    key: 'type',
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.type === '01' ? '新增' : row.type === '02' ? '修改' : '')
                        ]);
                    }
                }, {
                    title: '审核级别',
                    key: 'reviewLevel',
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.reviewLevel === '1' ? '一级审核' : row.reviewLevel === '2' ? '二级审核' : '')
                        ]);
                    }
                }, {
                    title: '审核状态',
                    key: 'reviewStatus',
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', row.reviewStatus === '04' ? '审核通过' : row.reviewStatus === '00' ? '驳回' : row.reviewStatus === '03' ? '审核中' : '')
                        ]);
                    }
                }, {
                    title: '审核时间',
                    key: 'modifyTime',
                    align: 'center',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', formatDate(row.modifyTime, 'yyyy-MM-dd hh:mm:ss'))
                        ]);
                    }
                }, {
                    title: '审核人',
                    align: 'center',
                    key: 'modifierName'
                }, {
                    title: '审核意见',
                    key: 'opinion',
                    align: 'center',
                    render: (h, params) => {
                        return h('div', [
                            h('span', {
                                style: {
                                    display: 'inline-block',
                                    width: '100%',
                                    overflow: 'hidden',
                                    textOverflow: 'ellipsis',
                                    whiteSpace: 'nowrap'
                                },
                                domProps: {
                                    title: params.row.opinion
                                }
                            }, params.row.opinion)
                        ]);
                    }
                }
            ]
        };
    },
    computed: {
        ...mapState({
            loading: ({feeReviewView}) => feeReviewView.loading,
            feeReviewViewData: ({feeReviewView}) => feeReviewView.feeReviewViewData,
            feeReviewViewMainData: ({feeReviewView}) => feeReviewView.feeReviewViewMainData,
            feeReviewViewCarData: ({feeReviewView}) => feeReviewView.feeReviewViewCarData,
            feeReviewViewAreaListData: ({feeReviewView}) => feeReviewView.feeReviewViewAreaListData,
            feeReviewViewProvinceListData: ({feeReviewView}) => feeReviewView.feeReviewViewProvinceListData,
            feeReviewViewCityListData: ({feeReviewView}) => feeReviewView.feeReviewViewCityListData,
            feeReviewViewBrandsListData: ({feeReviewView}) => feeReviewView.feeReviewViewBrandsListData,
            feeReviewViewSeriesListData: ({feeReviewView}) => feeReviewView.feeReviewViewSeriesListData,
            feeReviewViewModerListData: ({feeReviewView}) => feeReviewView.feeReviewViewModerListData,
            feeReviewViewAllProductListData: ({feeReviewView}) => feeReviewView.feeReviewViewAllProductListData,
            feeReviewViewResult: ({feeReviewView}) => feeReviewView.feeReviewViewResult
        })
    },
    methods: {
        ...mapActions([
            'handelQueryFeeReviewByCode',
            'handelQueryFeeReviewViewWork',
            'handelFeeReviewProvinceList',
            'handelFeeReviewCityList',
            'handelFeeReviewAreaList',
            'handelFeeReviewBrandsList',
            'handelFeeReviewSeriesList',
            'handelFeeReviewModerList',
            'handelFeeReviewAllProductList'
        ]),
        init () {
            this.queryActiveAreaList();
            this.queryActiveProvinceList();
            this.queryActiveBrandsList();
            this.showActiveProductList();
            this.queryFeeReviewListByCode(this.$route.query.businessCode);
            this.queryFeeReviewWork(this.$route.query.businessCode);
            // this.queryTeamReviewWork(this.$route.query.teamCode);
            resetWorkHeight();
        },
        queryFeeReviewListByCode (data) {
            // console.log(data)
            this.handelQueryFeeReviewByCode(data).then(res => {
                resetWorkHeight();
                const inputDeale = this.feeReviewViewData.activeMain.inputDeale;
                // console.log(this.feeReviewViewData)
                this.judgmentInputFlag(inputDeale);
                this.showCarBrandsList();
                this.showActiveProduct();
                this.judgmentAdditionFlag();
                resetWorkHeight();
            });
        },
        queryFeeReviewWork (code) {
            this.handelQueryFeeReviewViewWork(code).then(res => {});
        },
        /**
         * 判断是否附加贷
         */
        judgmentAdditionFlag () {
            const addFlag = this.feeReviewViewData.activeMain.additionFlag;
            if (addFlag === '0') {
                this.showFlag.additionFlag = false;
            } else {
                this.showFlag.additionFlag = true;
                var Additionals = [];
                Additionals = this.feeReviewViewData.activeAdditional.additionalCode.split(',');
                this.feeReviewViewData.AdditionalList = Additionals;
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
                if (this.feeReviewViewData.activeMain.inputArea === '1') { // 区域
                    this.showFlag.areaRow = true;
                    this.showFlag.cityRow = false;
                    this.queryActiveArea();
                } else { // 省市
                    this.showFlag.areaRow = false;
                    this.showFlag.cityRow = true;
                    this.queryActiveProvince();
                    resetWorkHeight();
                }
            }
        },
        /**
         * 加载子品牌
         */
        showCarBrandsList () {
            const brands = this.feeReviewViewData.activeCar.seriesCode;
            this.handelFeeReviewSeriesList(brands).then(res => {
                resetWorkHeight();
            });
            this.showCarBrands();
        },
        /**
         * 展示子品牌
         */
        showCarBrands () {
            var carSeries = [];
            carSeries = this.feeReviewViewData.activeCar.seriesCode.split(',');
            // console.log(carSeries)
            this.feeReviewViewData.carSeriesList = carSeries;
            this.showCarModer();
            resetWorkHeight();
        },
        /**
         * 展示车型
         */
        showCarModer () {
            this.handelFeeReviewModerList(this.feeReviewViewData.activeCar.moderCode).then(res => {
            });
            var carModers = [];
            carModers = this.feeReviewViewData.activeCar.moderCode.split(',');
            this.feeReviewViewData.carModerList = carModers;
            resetWorkHeight();
        },
        /**
         * 初始化查询区域
         * @param name
         */
        queryActiveAreaList () {
            this.handelFeeReviewAreaList().then(res => {
                resetWorkHeight();
            });
        },
        /**
         * 回显区域
         */
        queryActiveArea () {
            var areas = [];
            areas = this.feeReviewViewData.activeArea.areaCode.split(',');
            this.feeReviewViewData.areasList = areas;
            resetWorkHeight();
        },
        /**
         * 展示省
         * @param name
         */
        queryActiveProvinceList () {
            this.handelFeeReviewProvinceList().then(res => {
                resetWorkHeight();
            });
        },
        /**
         * 回显省份
         */
        queryActiveProvince () {
            var provienceArr = [];
            var provienceList = [];
            provienceArr = this.feeReviewViewData.activeArea.provinceCode.split(',');
            this.feeReviewViewData.provienceList = provienceArr;
            // console.log(provienceArr)
            for (var i = 0; i < provienceArr.length; i++) {
                provienceList.push(provienceArr);
            }
            // console.log(provienceArr)
            // console.log(provienceList)
            this.queryActiveCityList(provienceList);
            this.queryActiveCity();
            resetWorkHeight();
        },
        /**
         * 加载市
         * @param name
         */
        queryActiveCityList (data) {
            // console.log(data)
            if (!isEmpty(data)) {
                this.handelFeeReviewCityList(data).then(res => {
                    resetWorkHeight();
                });
            }
        },
        /**
         * 展示市
         * @param name
         */
        queryActiveCity () {
            var citys = [];
            citys = this.feeReviewViewData.activeArea.cityCode.split(',');
            this.feeReviewViewData.cityList = citys;
            resetWorkHeight();
        },
        /**
         * 加载品牌
         */
        queryActiveBrandsList () {
            this.handelFeeReviewBrandsList().then(res => {
            });
        },
        /**
         * 加载所有活动产品
         */
        showActiveProductList () {
            this.handelFeeReviewAllProductList().then(res => {
            });
        },
        /**
         * 展示活动产品
         */
        showActiveProduct () {
            var businessCodes = [];
            var marketingCodes = [];
            businessCodes = this.feeReviewViewData.activeBusiness.businessCode.split(',');
            this.feeReviewViewData.businessCodeList = businessCodes;

            marketingCodes = this.feeReviewViewData.activeMarketing.marketingCode.split(',');
            this.feeReviewViewData.marketingCodeList = marketingCodes;
            this.showActiveProList();
            resetWorkHeight();
        },
        /**
         * 显示金融信贷产品
         */
        showActiveProList () {
            var financeProdCodes = [];
            var creditProdCodes = [];
            const length = this.feeReviewViewData.activeProdList.length;
            if (length > 0) {
                for (var i = 0; i < length; i++) {
                    if (this.feeReviewViewData.activeProdList[i].prodType === '01') { // 金融产品
                        financeProdCodes = this.feeReviewViewData.activeProdList[i].prodCode.split(',');
                        this.feeReviewViewData.financeProdCodeList = financeProdCodes;
                    } else { // 信贷产品
                        creditProdCodes = this.feeReviewViewData.activeProdList[i].prodCode.split(',');
                        this.feeReviewViewData.creditProdCodeList = creditProdCodes;
                    }
                }
            }
        },
        /**
         * 附件链接
         */
        btn_add_appendix () {
            window.open('http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>' + this.feeReviewViewData.activeMain.additionalId + '</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >');
        },
        pageBack () {
            this.$router.push({name: 'feeReviewList'});
        }
    },
    mounted () {
        this.init();
    }
};
</script>