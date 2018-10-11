<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form :label-width="140">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    审核查看
                </p>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="区域名称：" >
                            <Input v-model="feeReviewProViewMainData.areaName" disabled style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="活动代码：" >
                            <Input v-model="feeReviewProViewMainData.activeCode" disabled style="width: 100%" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="活动名称：" >
                            <Input v-model="feeReviewProViewMainData.activeName" disabled style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="首付比例(%)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeReviewProViewMainData.patmentBegin" :max="100" :min="1" disabled placeholder="首付比例" style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem >
                                        <Input v-model="feeReviewProViewMainData.patmentEnd" :max="100" :min="1" disabled placeholder="首付比例" style="width: 100%"></Input>
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
                                    <Input v-model="feeReviewProViewMainData.loanAmtBegin" :min="1" placeholder="贷款金额" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeReviewProViewMainData.loanAmtEnd" :min="1" placeholder="贷款金额" disabled style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="贷款期限(月)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeReviewProViewMainData.loanTermBegin" :min="1" placeholder="贷款期限" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeReviewProViewMainData.loanTermEnd" :min="1" placeholder="贷款期限" disabled style="width: 100%"></Input>
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
                                        <DatePicker v-model="feeReviewProViewMainData.activeStartime"  placeholder="受理开始日期" disabled style="width: 100%"></DatePicker>
                                    </FormItem>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem >
                                        <DatePicker  v-model="feeReviewProViewMainData.activeEndtime" placeholder="受理结束日期" disabled style="width: 100%"></DatePicker>
                                    </FormItem>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="放款日期">
                            <Row>
                                <Col span="11">
                                    <DatePicker  v-model="feeReviewProViewMainData.loanStartime" placeholder="放款开始日期" disabled style="width: 100%"></DatePicker>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <DatePicker  v-model="feeReviewProViewMainData.loanEndtime" placeholder="放款结束日期" disabled style="width: 100%"></DatePicker>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="车籍" >
                            <Select v-model="feeReviewProViewMainData.carReg"   style="width: 100%" disabled>
                                <Option value="00">全部</Option>
                                <Option value="01">法人</Option>
                                <Option value="02">自然人</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="促销活动激励标准：" >
                            <Input v-model="feeReviewProViewMainData.avtiveCriterion" disabled style="width: 100%" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="预计活动笔数：" >
                            <Input v-model="feeReviewProViewMainData.expectedCount" disabled style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="实际成交笔数：" >
                            <Input v-model="feeReviewProViewData.actualTurnoverCount" disabled style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="达成率：" >
                            <Input v-model="feeReviewProViewData.reachRate" disabled style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.dealerFlag">
                <p slot="title">
                    <Icon type="search"></Icon>
                    经销商信息
                </p>
                <Table :columns="dealerColumns" :data="feeReviewProViewData.activeDealeList"></Table>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.areaFlag">
                <p slot="title">
                    <Icon type="search"></Icon>
                    区域信息
                </p>
                <Row>
                    <Col span="9" offset="2">
                        <FormItem label="活动范围：" >
                            <Select v-model="feeReviewProViewMainData.inputArea"  style="width: 100%" placeholder = "全部" disabled>
                                <Option value="1" >区域</Option>
                                <Option value="0" >省市</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.areaRow">
                    <Col span="20" offset="2">
                        <FormItem label="活动区域：" >
                            <Select v-model="feeReviewProViewData.areasList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProViewAreaListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.cityRow">
                    <Row>
                        <Col span="20" offset="2">
                            <FormItem label="活动省份：" >
                                <Select v-model="feeReviewProViewData.provienceList" style="width:100%" disabled multiple >
                                    <Option v-for="item in feeReviewProViewProvinceListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="20" offset="2">
                            <FormItem label="活动城市：" >
                                <Select v-model="feeReviewProViewData.cityList" style="width:100%" disabled multiple>
                                    <Option v-for="item in feeReviewProViewCityListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="20" offset="2">
                        <FormItem label="活动品牌：" >
                            <Select v-model="feeReviewProViewCarData.brandsCode" style="width:100%" disabled >
                                <Option v-for="item in feeReviewProViewBrandsListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="活动子品牌：" >
                            <Select v-model="feeReviewProViewData.carSeriesList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProViewSeriesListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="活动车型：" >
                            <Select v-model="feeReviewProViewData.carModerList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProViewModerListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="20" offset="2">
                        <FormItem label="金融产品：" >
                            <Select v-model="feeReviewProViewData.financeProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProViewAllProductListData.financeCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="业务模式：" >
                            <Select v-model="feeReviewProViewData.businessCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProViewAllProductListData.businessCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="信贷产品：" >
                            <Select v-model="feeReviewProViewData.creditProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProViewAllProductListData.creditCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="2">
                        <FormItem label="营销活动：" >
                            <Select v-model="feeReviewProViewData.marketingCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProViewAllProductListData.marketingCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="6" offset="2" >
                        <FormItem label="附加贷：" >
                            <Select v-model="feeReviewProViewMainData.additionFlag"  style="width:100%" disabled>
                                <Option value="0">否</Option>
                                <Option value="1">是</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="13" offset="1" v-show="showFlag.additionFlag">
                        <FormItem label="附加贷金额：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="feeReviewProViewMainData.additionAmtBegin"  disabled ></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="feeReviewProViewMainData.additionAmtEnd"  disabled ></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.additionFlag">
                    <Col span="20" offset="2">
                        <FormItem label="附加贷子项：" >
                            <Select v-model="feeReviewProViewData.AdditionalList" style="width:100%" disabled multiple>
                                <Option v-for="item in feeReviewProViewAllProductListData.additionalCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="20" offset="2">
                        <FormItem label="备注：" >
                            <Input v-model="feeReviewProViewMainData.remark" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}" disabled></Input>
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
                            <Input v-model="feeReviewProViewData.maxBillFee" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="调整金额(元)：" prop="billFee">
                            <Input v-model="feeReviewProViewData.billFee"  disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="2">
                        <FormItem label="备注：" prop="remark2">
                            <Input v-model="feeReviewProViewData.remark2" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    审核进度
                </p>
                <Table :data="feeReviewProViewResult" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
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
    name: 'feeReviewProView',
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
                    align: 'center',
                    key: 'modifyTime',
                    render: (h, params) => {
                        const row = params.row;
                        return h('div', [
                            h('div', formatDate(row.modifyTime, 'yyyy-MM-dd hh:mm:ss'))
                        ]);
                    }
                }, {
                    title: '审核人',
                    key: 'modifierName'
                }, {
                    title: '审核意见',
                    align: 'center',
                    key: 'opinion',
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
            loading: ({feeReviewProView}) => feeReviewProView.loading,
            feeReviewProViewData: ({feeReviewProView}) => feeReviewProView.feeReviewProViewData,
            feeReviewProViewMainData: ({feeReviewProView}) => feeReviewProView.feeReviewProViewMainData,
            feeReviewProViewCarData: ({feeReviewProView}) => feeReviewProView.feeReviewProViewCarData,
            feeReviewProViewAreaListData: ({feeReviewProView}) => feeReviewProView.feeReviewProViewAreaListData,
            feeReviewProViewProvinceListData: ({feeReviewProView}) => feeReviewProView.feeReviewProViewProvinceListData,
            feeReviewProViewCityListData: ({feeReviewProView}) => feeReviewProView.feeReviewProViewCityListData,
            feeReviewProViewBrandsListData: ({feeReviewProView}) => feeReviewProView.feeReviewProViewBrandsListData,
            feeReviewProViewSeriesListData: ({feeReviewProView}) => feeReviewProView.feeReviewProViewSeriesListData,
            feeReviewProViewModerListData: ({feeReviewProView}) => feeReviewProView.feeReviewProViewModerListData,
            feeReviewProViewAllProductListData: ({feeReviewProView}) => feeReviewProView.feeReviewProViewAllProductListData,
            feeReviewProViewResult: ({feeReviewProView}) => feeReviewProView.feeReviewProViewResult
        })
    },
    methods: {
        ...mapActions([
            'handelQueryFeeReviewProByCode',
            'handelQueryFeeReviewProViewWork',
            'handelFeeReviewProProvinceList',
            'handelFeeReviewProCityList',
            'handelFeeReviewProAreaList',
            'handelFeeReviewProBrandsList',
            'handelFeeReviewProSeriesList',
            'handelFeeReviewProModerList',
            'handelFeeReviewProAllProductList'
        ]),
        init () {
            this.queryActiveAreaList();
            this.queryActiveProvinceList();
            this.queryActiveBrandsList();
            this.showActiveProductList();
            this.queryFeeReviewProListByCode(this.$route.query.businessCode);
            this.queryFeeReviewWork(this.$route.query.businessCode);
            // this.queryTeamReviewWork(this.$route.query.teamCode);
            resetWorkHeight();
        },
        queryFeeReviewProListByCode (data) {
            // console.log(data)
            this.handelQueryFeeReviewProByCode(data).then(res => {
                resetWorkHeight();
                const inputDeale = this.feeReviewProViewData.activeMain.inputDeale;
                // console.log(this.feeReviewProViewData)
                this.judgmentInputFlag(inputDeale);
                this.showCarBrandsList();
                this.showActiveProduct();
                this.judgmentAdditionFlag();
                resetWorkHeight();
            });
        },
        queryFeeReviewWork (code) {
            this.handelQueryFeeReviewProViewWork(code).then(res => {
                resetWorkHeight();
            });
        },
        /**
         * 判断是否附加贷
         */
        judgmentAdditionFlag () {
            const addFlag = this.feeReviewProViewData.activeMain.additionFlag;
            if (addFlag === '0') {
                this.showFlag.additionFlag = false;
            } else {
                this.showFlag.additionFlag = true;
                var Additionals = [];
                Additionals = this.feeReviewProViewData.activeAdditional.additionalCode.split(',');
                this.feeReviewProViewData.AdditionalList = Additionals;
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
                if (this.feeReviewProViewData.activeMain.inputArea === '1') { // 区域
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
            const brands = this.feeReviewProViewData.activeCar.brandsCode;
            this.handelFeeReviewProSeriesList(brands).then(res => {
                resetWorkHeight();
            });
            this.showCarBrands();
        },
        /**
         * 展示子品牌
         */
        showCarBrands () {
            var carSeries = [];
            carSeries = this.feeReviewProViewData.activeCar.seriesCode.split(',');
            // console.log(carSeries)
            this.feeReviewProViewData.carSeriesList = carSeries;
            this.showCarModer();
            resetWorkHeight();
        },
        /**
         * 展示车型
         */
        showCarModer () {
            this.handelFeeReviewProModerList(this.feeReviewProViewData.activeCar.moderCode).then(res => {
            });
            var carModers = [];
            carModers = this.feeReviewProViewData.activeCar.moderCode.split(',');
            this.feeReviewProViewData.carModerList = carModers;
            resetWorkHeight();
        },
        /**
         * 初始化查询区域
         * @param name
         */
        queryActiveAreaList () {
            this.handelFeeReviewProAreaList().then(res => {
                resetWorkHeight();
            });
        },
        /**
         * 回显区域
         */
        queryActiveArea () {
            var areas = [];
            areas = this.feeReviewProViewData.activeArea.areaCode.split(',');
            this.feeReviewProViewData.areasList = areas;
            resetWorkHeight();
        },
        /**
         * 展示省
         * @param name
         */
        queryActiveProvinceList () {
            this.handelFeeReviewProProvinceList().then(res => {
                resetWorkHeight();
            });
        },
        /**
         * 回显省份
         */
        queryActiveProvince () {
            var provienceArr = [];
            var provienceList = [];
            provienceArr = this.feeReviewProViewData.activeArea.provinceCode.split(',');
            this.feeReviewProViewData.provienceList = provienceArr;
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
                this.handelFeeReviewProCityList(data).then(res => {
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
            citys = this.feeReviewProViewData.activeArea.cityCode.split(',');
            this.feeReviewProViewData.cityList = citys;
            resetWorkHeight();
        },
        /**
         * 加载品牌
         */
        queryActiveBrandsList () {
            this.handelFeeReviewProBrandsList().then(res => {
            });
        },
        /**
         * 加载所有活动产品
         */
        showActiveProductList () {
            this.handelFeeReviewProAllProductList().then(res => {
            });
        },
        /**
         * 展示活动产品
         */
        showActiveProduct () {
            var businessCodes = [];
            var marketingCodes = [];
            businessCodes = this.feeReviewProViewData.activeBusiness.businessCode.split(',');
            this.feeReviewProViewData.businessCodeList = businessCodes;

            marketingCodes = this.feeReviewProViewData.activeMarketing.marketingCode.split(',');
            this.feeReviewProViewData.marketingCodeList = marketingCodes;
            this.showActiveProList();
            resetWorkHeight();
        },
        /**
         * 显示金融信贷产品
         */
        showActiveProList () {
            var financeProdCodes = [];
            var creditProdCodes = [];
            const length = this.feeReviewProViewData.activeProdList.length;
            if (length > 0) {
                for (var i = 0; i < length; i++) {
                    if (this.feeReviewProViewData.activeProdList[i].prodType === '01') { // 金融产品
                        financeProdCodes = this.feeReviewProViewData.activeProdList[i].prodCode.split(',');
                        this.feeReviewProViewData.financeProdCodeList = financeProdCodes;
                    } else { // 信贷产品
                        creditProdCodes = this.feeReviewProViewData.activeProdList[i].prodCode.split(',');
                        this.feeReviewProViewData.creditProdCodeList = creditProdCodes;
                    }
                }
            }
        },
        /**
         * 附件链接
         */
        btn_add_appendix () {
            window.open('http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>' + this.feeReviewProViewData.activeMain.additionalId + '</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >');
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