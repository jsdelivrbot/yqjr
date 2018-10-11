<style xmlns="http://www.w3.org/1999/html">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form :label-width="140">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    促销活动信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="归属区域名称：" >
                            <Input v-model="activeReviewCheckDate.areaName" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="活动代码：" >
                            <Input v-model="activeReviewCheckDate.activeCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="活动名称：" >
                            <Input v-model="activeReviewCheckDate.activeName" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="首付比例(%)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="activeReviewCheckDate.patmentBegin" :max="100" :min="1" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem >
                                        <Input v-model="activeReviewCheckDate.patmentEnd" :max="100" :min="1" disabled style="width: 100%"></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="贷款金额(元)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="activeReviewCheckDate.loanAmtBegin" :min="1" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="activeReviewCheckDate.loanAmtEnd" :min="1" disabled style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="贷款期限(月)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="activeReviewCheckDate.loanTermBegin" :min="1" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="activeReviewCheckDate.loanTermEnd" :min="1" disabled style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="受理开始日期：">
                            <DatePicker v-model="activeReviewCheckDate.activeStartime" disabled style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="受理截至日期：">
                            <DatePicker  v-model="activeReviewCheckDate.activeEndtime" disabled style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="放款开始日期：">
                            <DatePicker  v-model="activeReviewCheckDate.loanStartime" disabled style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                                <!--<Col span="2" style="text-align: center">-</Col>-->
                        <Col span="8" offset="2">
                            <FormItem label="放款截至日期：">
                                    <DatePicker  v-model="activeReviewCheckDate.loanEndtime" disabled style="width: 100%"></DatePicker>
                            </FormItem>
                        </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="车籍：" >
                            <Select v-model="activeReviewCheckDate.carReg"  style="width:100%" disabled>
                                <Option value="00">全部</Option>
                                <Option value="01">法人</Option>
                                <Option value="02">自然人</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="促销活动激励标准：" >
                            <Input v-model="activeReviewCheckDate.avtiveCriterion" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="预计活动笔数：" >
                            <Input v-model="activeReviewCheckDate.expectedCount" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="经销商导入：" >
                            <Select v-model="activeReviewCheckDate.inputDeale" disabled>
                                <Option value="1">是</Option>
                                <Option value="0">否</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.dealerFlag">
                <p slot="title">
                    <Icon type="search"></Icon>
                    经销商信息
                </p>
                <Row>
                    <Col span="17" offset="3">
                        <Table :columns="dealerColumns" :data="activeReviewViewDataResult.ativeDealeList"></Table>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.areaFlag">
                <p slot="title">
                    <Icon type="search"></Icon>
                    区域信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="活动范围：" >
                            <Select v-model="activeReviewCheckDate.inputArea" style="width:100%" placeholder = "全部" disabled>
                                <Option value="1" >区域</Option>
                                <Option value="0" >省市</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.areaRow">
                    <Col span="18" offset="2">
                        <FormItem label="活动区域：" >
                            <!--<Input v-model="activeReviewViewData.areaName" style="width:100%" disabled multiple></Input>-->
                            <Select v-model="activeReviewViewDataResult.areasList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewViewAreaListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.cityRow">
                    <Row>
                        <Col span="18" offset="2">
                            <FormItem label="活动省份：" >
                                <Select v-model="activeReviewViewDataResult.provincesList" style="width:100%" disabled multiple >
                                    <Option v-for="item in activeReviewViewProvinceListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="18" offset="2">
                            <FormItem label="活动城市：" >
                                <Select v-model="activeReviewViewDataResult.cityList" style="width:100%" disabled multiple>
                                    <Option v-for="item in activeReviewViewCityListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                            <Select v-model="activeReviewViewDataResult.brandsCodeList" style="width:100%" disabled >
                                <Option v-for="item in activeReviewViewBrandsListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="活动子品牌：" >
                            <Select v-model="activeReviewViewDataResult.seriesList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewViewSeriesListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="活动车型：" >
                            <Select v-model="activeReviewViewData.moderList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewViewModerListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                            <Select v-model="activeReviewViewDataResult.financeProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewViewAllProductListData.financeCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="业务模式：" >
                            <Select v-model="activeReviewViewDataResult.businessCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewViewAllProductListData.businessCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="信贷产品：" >
                            <Select v-model="activeReviewViewDataResult.creditProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewViewAllProductListData.creditCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="营销活动：" >
                            <Select v-model="activeReviewViewDataResult.marketingCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewViewAllProductListData.marketingCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="6" offset="2" >
                        <FormItem label="附加贷：" >
                            <Select v-model="activeReviewCheckDate.additionFlag"  style="width:100%" disabled>
                                <Option value="0">否</Option>
                                <Option value="1">是</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2" v-show="showFlag.additionFlag">
                        <FormItem label="附加贷金额：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="activeReviewCheckDate.additionAmtBegin"  disabled ></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="activeReviewCheckDate.additionAmtEnd"  disabled ></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.additionFlag">
                    <Col span="18" offset="2">
                        <FormItem label="附加贷子项：" >
                            <Select v-model="activeReviewViewDataResult.AdditionalList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewViewAllProductListData.additionalCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="8" offset="2">
                        <FormItem label="附件列表：" >
                            <Button type="success" @click="btn_add_appendix">查看附件</Button>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="备注：" >
                            <Input v-model="activeReviewCheckDate.remark" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    审核进度
                </p>
                <Table :data="activeReviewMessage" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                <Row class="margin-top-10">
                    <Col span="4" offset="11">
                        <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                    </Col>
                </Row>
            </Card>
        </Form>
    </div>
</template>

<script>
    import { mapActions, mapState } from 'vuex';
    import {resetWorkHeight, formatDate} from '@/libs/util.js';
    export default {
        name: 'activeReviewView',
        data () {
            return {
                DataMes: {
                    id: 0,
                    folowId: 0
                },
                showFlag: {
                    dealerFlag: false,
                    areaFlag: false,
                    areaRow: false,
                    cityRow: false,
                    additionFlag: false
                },
                dealerColumns: [
                    {
                        title: '经销商代码',
                        key: 'dealerCode'
                    }, {
                        title: '经销商名称',
                        key: 'dealerName'
                    }, {
                        title: '活动上限/辆',
                        key: 'activeNumber'
                    }
                ],
                tableColumns: [
                    // {
                    //     title: '审批意见',
                    //     key: 'opinion'
                    // }, {
                    //     title: '审批结果',
                    //     key: 'reviewStatus',
                    //     render: (h, params) => {
                    //         const row = params.row;
                    //         return h('div', [
                    //             h('div', row.reviewStatus === '04' ? '通过' : '驳回')
                    //         ]);
                    //     }
                    // }, {
                    //     title: '审核级别',
                    //     key: 'reviewLevel',
                    //     render: (h, params) => {
                    //         const row = params.row;
                    //         return h('div', [
                    //             h('div', row.reviewLevel === '1' ? '一级' : '二级')
                    //         ]);
                    //     }
                    // }, {
                    //     title: '审核时间',
                    //     key: 'modifyTime',
                    //     render: (h, params) => {
                    //         const row = params.row;
                    //         return h('div', [
                    //             h('div', formatDate(row.modifyTime, 'yyyy-MM-dd hh:mm:ss'))
                    //         ]);
                    //     }
                    // }
                    {
                        title: '审核类型',
                        key: 'type',
                        width: 100,
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.type === '01' ? '新增' : row.type === '02' ? '修改' : '')
                            ]);
                        }
                    }, {
                        title: '审核级别',
                        key: 'reviewLevel',
                        width: 100,
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.reviewLevel === '1' ? '一级审核' : row.reviewLevel === '2' ? '二级审核' : '')
                            ]);
                        }
                    }, {
                        title: '审核状态',
                        key: 'reviewStatus',
                        width: 100,
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.reviewStatus === '04' ? '审核通过' : row.reviewStatus === '00' ? '驳回' : row.reviewStatus === '03' ? '审核中' : '')
                            ]);
                        }
                    }, {
                        title: '审核时间',
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
                activeReviewViewDataResult: ({activeReviewView}) => activeReviewView.activeReviewViewDataResult,
                activeReviewCheckDate: ({activeReviewView}) => activeReviewView.activeReviewCheckDate,
                activeReviewViewProvinceListData: ({activeReviewView}) => activeReviewView.activeReviewViewProvinceListData, // 默认加载全部省份
                activeReviewViewCityListData: ({activeReviewView}) => activeReviewView.activeReviewViewCityListData, // 默认加载全部城市
                // activeReviewProViewMainData: ({activeReviewCheck}) => activeReviewCheck.activeReviewViewMainData,
                // activeReviewProViewCarData: ({activeReviewCheck}) => activeReviewCheck.activeReviewViewCarData,
                activeReviewViewBrandsListData: ({activeReviewView}) => activeReviewView.activeReviewViewBrandsListData, // 加载所有活动品牌
                activeReviewViewSeriesListData: ({activeReviewView}) => activeReviewView.activeReviewViewSeriesListData, // 加载所有子品牌
                activeReviewViewModerListData: ({activeReviewView}) => activeReviewView.activeReviewViewModerListData, // 根据子品牌加载车型
                activeReviewViewAllProductListData: ({activeReviewView}) => activeReviewView.activeReviewViewAllProductListData, // 加载所有产品模块信息
                // activeReviewProViewResult: ({activeReviewCheck}) => activeReviewCheck.activeReviewViewResult,
                activeReviewViewData: ({activeReviewView}) => activeReviewView.activeReviewViewData,
                activeReviewViewAreaListData: ({activeReviewView}) => activeReviewView.activeReviewViewAreaListData,
                isSuccess: ({activeReviewView}) => activeReviewView.isSuccess,
                loading: ({activeReviewView}) => activeReviewView.loading,
                msg: ({activeReviewView}) => activeReviewView.msg,
                activeReviewMessage: ({activeReviewView}) => activeReviewView.activeReviewMessage

            })
        },
        methods: {
            ...mapActions([
                'handleSearchDateById',
                'handleSearchProvinceList',
                'handelActiveReviewAreaList',
                'handleSearchCityList',
                'handleSearchBrandsList',
                'handleSearchSeriesList',
                'handleSearchModerCode',
                'handelActiveReviewAllProductList',
                'handelActiveReviewMessage'
            ]),
            init () {
                this.searchAreaList(); // 加载所有区域信息
                this.searchBrandsList(); // 加载并解析所有的活动品牌
                this.searchProvinceList(); // 加载所有省份信息
                this.searchActiveProductList(); // 加载所有产品信息
                this.queryActiveReviewWork(this.$route.query.code); // 查询审核进度信息
                console.log(11111111111111);
                console.log('编码： ' + this.$route.query.code);
                this.searchDateByIdForActiveReview(this.$route.query.id);
            },
            /**
             * 查询活动所有数据
             */
            searchDateByIdForActiveReview (data) {
                this.handleSearchDateById(data).then(res => {
                    this.activeReviewCheckDate.reviewStatus = '04';
                    if (this.activeReviewCheckDate.inputDeale === '0') { // 若不导入经销商
                        this.showFlag.dealerFlag = false;
                        this.showFlag.areaFlag = true;
                        if (this.activeReviewCheckDate.inputArea === '1') { // 若选择区域
                            this.complidAreaList();
                            this.showFlag.areaRow = true;
                            this.showFlag.cityRow = false;
                        } else { // 若选择省市
                            this.showFlag.areaRow = false;
                            this.showFlag.cityRow = true;
                            this.complidProvinceList();
                            this.SearchCityList();
                            this.complidCityList();
                        };
                    } else { // 有经销商导入
                        this.showFlag.dealerFlag = true;
                        this.showFlag.areaRow = false;
                        this.showFlag.cityRow = false;
                        this.showFlag.areaFlag = false;
                    };
                    if (this.activeReviewCheckDate.additionFlag === '1') {
                        this.showFlag.additionFlag = true;
                    } else {
                        this.activeReviewCheckDate.additionFlag = '0';
                    };
                    var type = this.$route.query.type;
                    var id = this.$route.query.id;
                    this.DataMes.id = id;
                    this.DataMes.folowId = this.activeReviewCheckDate.folowId;
                    this.complidBrandsList(); // 解析所有的活动品牌
                    this.searchSeriesList();
                    this.complidModerList();
                    this.complidAllProductList();
                    this.judgmentAdditionFlag();
                });
            },
            /**
             * 加载所有省份
             */
            searchProvinceList () {
                this.handleSearchProvinceList().then(res => {});
            },
            /**
             * 解析查询到的省份
             */
            complidProvinceList () {
                var provinceLists = [];
                provinceLists = this.activeReviewViewDataResult.activeArea.provinceCode.split(',');
                this.activeReviewViewDataResult.provincesList = provinceLists;
            },
            /**
             * 加载所有活动区域
             */
            searchAreaList () {
                this.handelActiveReviewAreaList().then(res => {});
                resetWorkHeight();
            },
            /**
             * 解析查询到的区域
             */
            complidAreaList () {
                var areasLists = [];
                areasLists = this.activeReviewViewDataResult.activeArea.areaCode.split(',');
                this.activeReviewViewDataResult.areasList = areasLists;
            },
            /**
             * 根据省份加载城市
             */
            SearchCityList () {
                this.handleSearchCityList(this.activeReviewViewDataResult.activeArea.provinceCode).then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 解析城市信息
             */
            complidCityList () {
                var cityLists = [];
                cityLists = this.activeReviewViewDataResult.activeArea.cityCode.split(',');
                this.activeReviewViewDataResult.cityList = cityLists;
            },
            /**
             * 加载所有品牌
             */
            searchBrandsList () {
                this.handleSearchBrandsList().then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 解析查询到的品牌信息
             */
            complidBrandsList () {
                var brandsCode = '';
                brandsCode = this.activeReviewViewDataResult.activeCar.brandsCode;
                this.activeReviewViewDataResult.brandsCodeList = brandsCode;
            },
            /**
             * 根据活动品牌加载子品牌
             */
            searchSeriesList () {
                this.handleSearchSeriesList(this.activeReviewViewDataResult.brandsCodeList).then(res => {
                    this.complidSeriesList();
                    resetWorkHeight();
                });
            },
            /**
             * 解析查询到的子品牌
             */
            complidSeriesList () {
                var seriesLists = [];
                seriesLists = this.activeReviewViewDataResult.activeCar.seriesCode.split(',');
                this.activeReviewViewDataResult.seriesList = seriesLists;
                this.searchModerCode();
            },
            /**
             * 根据子品牌加载车型
             */
            searchModerCode () {
                this.handleSearchModerCode(this.activeReviewViewDataResult.activeCar.moderCode).then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 解析查询到的车型
             */
            complidModerList () {
                var moderLists = [];
                moderLists = this.activeReviewViewDataResult.activeCar.moderCode.split(',');
                this.activeReviewViewData.moderList = moderLists;
            },
            /**
             * 加载所有产品信息
             */
            searchActiveProductList () {
                this.handelActiveReviewAllProductList().then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 解析所有产品信息
             */
            complidAllProductList () {
                var businessCodes = [];
                var marketingCodes = [];
                businessCodes = this.activeReviewViewDataResult.activeBusiness.businessCode.split(',');
                this.activeReviewViewDataResult.businessCodeList = businessCodes;
                marketingCodes = this.activeReviewViewDataResult.activeMarketing.marketingCode.split(',');
                this.activeReviewViewDataResult.marketingCodeList = marketingCodes;
                this.showActiveProList();
            },
            /**
             * 显示金融贷产品
             */
            showActiveProList () {
                var financeProdCodes = [];
                var creditProdCodes = [];
                const length = this.activeReviewViewDataResult.activeProdList.length;
                if (length > 0) {
                    for (var i = 0; i < length; i++) {
                        if (this.activeReviewViewDataResult.activeProdList[i].hasOwnProperty('prodType') && this.activeReviewViewDataResult.activeProdList[i].prodType === '01') { // 金融产品
                            financeProdCodes = this.activeReviewViewDataResult.activeProdList[i].prodCode.split(',');
                            this.activeReviewViewDataResult.financeProdCodeList = financeProdCodes;
                        } else if (this.activeReviewViewDataResult.activeProdList[i].hasOwnProperty('prodType') && this.activeReviewViewDataResult.activeProdList[i].prodType != '01') { // 信贷产品
                            creditProdCodes = this.activeReviewViewDataResult.activeProdList[i].prodCode.split(',');
                            this.activeReviewViewDataResult.creditProdCodeList = creditProdCodes;
                        }
                    }
                }
            },
            // 查看审核信息
            queryActiveReviewWork (code) {
                console.log('活动审核代码：' + code);
                this.handelActiveReviewMessage(code).then(res => {
                    resetWorkHeight();
                });
            },
            /**
             * 附件链接
             */
            btn_add_appendix () {
                window.open('http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>' + this.activeReviewCheckDate.additionalId + '</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >');
            },
            pageBack () {
                this.$router.push({name: 'activeReviewList'});
            },
            /**
             * 判断是否附加贷
             */
            judgmentAdditionFlag () {
                const addFlag = this.activeReviewCheckDate.additionFlag;
                if (addFlag === '0') {
                    this.showFlag.additionFlag = false;
                } else {
                    this.showFlag.additionFlag = true;
                    var Additionals = [];
                    Additionals = this.activeReviewViewDataResult.activeAdditional.additionalCode.split(',');
                    this.activeReviewViewDataResult.AdditionalList = Additionals;
                }
            }
        },
        mounted () {
            this.init();
            resetWorkHeight();
        }
    };
</script>

<style scoped>

</style>