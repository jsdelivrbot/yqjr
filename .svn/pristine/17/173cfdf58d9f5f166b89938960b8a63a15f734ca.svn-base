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
                    <Col span="9" offset="1">
                        <FormItem label="区域名称：" >
                            <Input v-model="activeReviewProViewMainData.areaName" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="活动代码：" >
                            <Input v-model="activeReviewProViewMainData.activeCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="活动名称：" >
                            <Input v-model="activeReviewProViewMainData.activeName" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="首付比例(%)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="activeReviewProViewMainData.patmentBegin" :max="100" :min="1" disabled placeholder="首付比例" style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem >
                                        <Input v-model="activeReviewProViewMainData.patmentEnd" :max="100" :min="1" disabled placeholder="首付比例" style="width: 100%"></Input>
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
                                    <Input v-model="activeReviewProViewMainData.loanAmtBegin" :min="1" placeholder="贷款金额" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="activeReviewProViewMainData.loanAmtEnd" :min="1" placeholder="贷款金额" disabled style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="贷款期限(月)：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="activeReviewProViewMainData.loanTermBegin" :min="1" placeholder="贷款期限" disabled style="width: 100%"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="activeReviewProViewMainData.loanTermEnd" :min="1" placeholder="贷款期限" disabled style="width: 100%"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="受理日期：">
                            <Row>
                                <Col span="11">
                                    <FormItem >
                                        <DatePicker v-model="activeReviewProViewMainData.activeStartime"  placeholder="受理开始日期" disabled style="width: 100%"></DatePicker>
                                    </FormItem>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem >
                                        <DatePicker  v-model="activeReviewProViewMainData.activeEndtime" placeholder="受理结束日期" disabled style="width: 100%"></DatePicker>
                                    </FormItem>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="放款日期：">
                            <Row>
                                <Col span="11">
                                    <DatePicker  v-model="activeReviewProViewMainData.loanStartime" placeholder="放款开始日期" disabled style="width: 100%"></DatePicker>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <DatePicker  v-model="activeReviewProViewMainData.loanEndtime" placeholder="放款结束日期" disabled style="width: 100%"></DatePicker>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="车籍：" >
                            <Select v-model="activeReviewProViewMainData.carReg"  style="width:100%" disabled>
                                <Option value="00">全部</Option>
                                <Option value="01">法人</Option>
                                <Option value="02">自然人</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="促销活动激励标准：" >
                            <Input v-model="activeReviewProViewMainData.avtiveCriterion" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="预计活动笔数：" >
                            <Input v-model="activeReviewProViewMainData.expectedCount" disabled></Input>
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
                    <Col span="19" offset="2">
                        <Table :columns="dealerColumns" :data="activeReviewProViewData.ativeDealeList"></Table>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.areaFlag">
                <p slot="title">
                    <Icon type="search"></Icon>
                    区域信息
                </p>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="活动范围：" >
                            <Select v-model="activeReviewProViewMainData.inputArea" style="width:100%" placeholder = "全部" disabled>
                                <Option value="1" >区域</Option>
                                <Option value="0" >省市</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.areaRow">
                    <Col span="20" offset="1">
                        <FormItem label="活动区域：" >
                            <Select v-model="activeReviewProViewData.areasList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewProViewAreaListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.cityRow">
                    <Row>
                        <Col span="20" offset="1">
                            <FormItem label="活动省份：" >
                                <Select v-model="activeReviewProViewData.provienceList" style="width:100%" disabled multiple >
                                    <Option v-for="item in activeReviewProViewProvinceListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="20" offset="1">
                            <FormItem label="活动城市：" >
                                <Select v-model="activeReviewProViewData.cityList" style="width:100%" disabled multiple>
                                    <Option v-for="item in activeReviewProViewCityListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                            <Select v-model="activeReviewProViewCarData.brandsCode" style="width:100%" disabled >
                                <Option v-for="item in activeReviewProViewBrandsListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="活动子品牌：" >
                            <Select v-model="activeReviewProViewData.carSeriesList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewProViewSeriesListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="活动车型：" >
                            <Select v-model="activeReviewProViewData.carModerList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewProViewModerListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                            <Select v-model="activeReviewProViewData.financeProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewProViewAllProductListData.financeCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="业务模式：" >
                            <Select v-model="activeReviewProViewData.businessCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewProViewAllProductListData.businessCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="信贷产品：" >
                            <Select v-model="activeReviewProViewData.creditProdCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewProViewAllProductListData.creditCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="20" offset="1">
                        <FormItem label="营销活动：" >
                            <Select v-model="activeReviewProViewData.marketingCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewProViewAllProductListData.marketingCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="9" offset="1" >
                        <FormItem label="附加贷：" >
                            <Select v-model="activeReviewProViewMainData.additionFlag"  style="width:100%" disabled>
                                <Option value="0">否</Option>
                                <Option value="1">是</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="12" offset="2" v-show="showFlag.additionFlag">
                        <FormItem label="附加贷金额：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="activeReviewProViewMainData.additionAmtBegin"  disabled ></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="activeReviewProViewMainData.additionAmtEnd"  disabled ></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.additionFlag">
                    <Col span="20" offset="1">
                        <FormItem label="附加贷子项：" >
                            <Select v-model="activeReviewProViewData.AdditionalList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeReviewProViewAllProductListData.additionalCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="8" offset="1">
                        <FormItem label="备注：" >
                            <Button type="success" @click="btn_add_appendix">添加附件</Button>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="备注：" >
                            <Input v-model="activeReviewProViewMainData.remark" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    审核进度
                </p>
                <Table :data="activeReviewProViewResult" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                <Row style="margin-top: 15px;">
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
import {resetWorkHeight, isEmpty, formatDate} from '@/libs/util.js';
export default{
    name: 'activeReviewProView',
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
            loading: ({activeReviewProView}) => activeReviewProView.loading,
            activeReviewProViewData: ({activeReviewProView}) => activeReviewProView.activeReviewProViewData,
            activeReviewProViewMainData: ({activeReviewProView}) => activeReviewProView.activeReviewProViewMainData,
            activeReviewProViewCarData: ({activeReviewProView}) => activeReviewProView.activeReviewProViewCarData,
            activeReviewProViewAreaListData: ({activeReviewProView}) => activeReviewProView.activeReviewProViewAreaListData,
            activeReviewProViewProvinceListData: ({activeReviewProView}) => activeReviewProView.activeReviewProViewProvinceListData,
            activeReviewProViewCityListData: ({activeReviewProView}) => activeReviewProView.activeReviewProViewCityListData,
            activeReviewProViewBrandsListData: ({activeReviewProView}) => activeReviewProView.activeReviewProViewBrandsListData,
            activeReviewProViewSeriesListData: ({activeReviewProView}) => activeReviewProView.activeReviewProViewSeriesListData,
            activeReviewProViewModerListData: ({activeReviewProView}) => activeReviewProView.activeReviewProViewModerListData,
            activeReviewProViewAllProductListData: ({activeReviewProView}) => activeReviewProView.activeReviewProViewAllProductListData,
            activeReviewProViewResult: ({activeReviewProView}) => activeReviewProView.activeReviewProViewResult
        })
    },
    methods: {
        ...mapActions([
            'handelQueryActiveReviewProById',
            'handelQueryActiveReviewProViewWork',
            'handelActiveReviewProProvinceList',
            'handelActiveReviewProCityList',
            'handelActiveReviewProAreaList',
            'handelActiveReviewProBrandsList',
            'handelActiveReviewProSeriesList',
            'handelActiveReviewProModerList',
            'handelActiveReviewProAllProductList'
        ]),
        init () {
            this.queryActiveAreaList();
            this.queryActiveProvinceList();
            this.queryActiveBrandsList();
            this.showActiveProductList();
            this.queryActiveReviewProListByCode(this.$route.query.id);
            this.queryActiveReviewWork(this.$route.query.code);
            resetWorkHeight();
        },
        queryActiveReviewProListByCode (data) {
            // console.log(data)
            this.handelQueryActiveReviewProById(data).then(res => {
                resetWorkHeight();
                const inputDeale = this.activeReviewProViewData.ativeMain.inputDeale;
                this.judgmentInputFlag(inputDeale);
                this.showCarBrandsList();
                this.showActiveProduct();
                this.judgmentAdditionFlag();
                resetWorkHeight();
            });
        },
        queryActiveReviewWork (code) {
            this.handelQueryActiveReviewProViewWork(code).then(res => {
                resetWorkHeight();
            });
        },
        /**
         * 判断是否附加贷
         */
        judgmentAdditionFlag () {
            const addFlag = this.activeReviewProViewData.ativeMain.additionFlag;
            if (addFlag === '0') {
                this.showFlag.additionFlag = false;
            } else {
                this.showFlag.additionFlag = true;
                var Additionals = [];
                Additionals = this.activeReviewProViewData.activeAdditional.additionalCode.split(',');
                this.activeReviewProViewData.AdditionalList = Additionals;
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
                if (this.activeReviewProViewData.ativeMain.inputArea === '1') { // 区域
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
            const brands = this.activeReviewProViewData.activeCar.seriesCode;
            // console.log(brands)
            this.handelActiveReviewProSeriesList(brands).then(res => {
                resetWorkHeight();
            });
            this.showCarBrands();
        },
        /**
         * 展示子品牌
         */
        showCarBrands () {
            var carSeries = [];
            carSeries = this.activeReviewProViewData.activeCar.seriesCode.split(',');
            // console.log(carSeries)
            this.activeReviewProViewData.carSeriesList = carSeries;
            this.showCarModer();
            resetWorkHeight();
        },
        /**
         * 展示车型
         */
        showCarModer () {
            this.handelActiveReviewProModerList(this.activeReviewProViewData.activeCar.moderCode).then(res => {
            });
            var carModers = [];
            carModers = this.activeReviewProViewData.activeCar.moderCode.split(',');
            this.activeReviewProViewData.carModerList = carModers;
            resetWorkHeight();
        },
        /**
         * 初始化查询区域
         * @param name
         */
        queryActiveAreaList () {
            this.handelActiveReviewProAreaList().then(res => {
                resetWorkHeight();
            });
        },
        /**
         * 回显区域
         */
        queryActiveArea () {
            var areas = [];
            areas = this.activeReviewProViewData.activeArea.areaCode.split(',');
            this.activeReviewProViewData.areasList = areas;
            resetWorkHeight();
        },
        /**
         * 展示省
         * @param name
         */
        queryActiveProvinceList () {
            this.handelActiveReviewProProvinceList().then(res => {
                resetWorkHeight();
            });
        },
        /**
         * 回显省份
         */
        queryActiveProvince () {
            var provienceArr = [];
            var provienceList = [];
            provienceArr = this.activeReviewProViewData.activeArea.provinceCode.split(',');
            this.activeReviewProViewData.provienceList = provienceArr;
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
                this.handelActiveReviewProCityList(data).then(res => {
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
            citys = this.activeReviewProViewData.activeArea.cityCode.split(',');
            this.activeReviewProViewData.cityList = citys;
            resetWorkHeight();
        },
        /**
         * 加载品牌
         */
        queryActiveBrandsList () {
            this.handelActiveReviewProBrandsList().then(res => {
            });
        },
        /**
         * 加载所有活动产品
         */
        showActiveProductList () {
            this.handelActiveReviewProAllProductList().then(res => {
            });
        },
        /**
         * 展示活动产品
         */
        showActiveProduct () {
            var businessCodes = [];
            var marketingCodes = [];
            businessCodes = this.activeReviewProViewData.activeBusiness.businessCode.split(',');
            this.activeReviewProViewData.businessCodeList = businessCodes;

            marketingCodes = this.activeReviewProViewData.activeMarketing.marketingCode.split(',');
            this.activeReviewProViewData.marketingCodeList = marketingCodes;
            this.showActiveProList();
            resetWorkHeight();
        },
        /**
         * 显示金融信贷产品
         */
        showActiveProList () {
            var financeProdCodes = [];
            var creditProdCodes = [];
            const length = this.activeReviewProViewData.activeProdList.length;
            if (length > 0) {
                for (var i = 0; i < length; i++) {
                    if (this.activeReviewProViewData.activeProdList[i].prodType === '01') { // 金融产品
                        financeProdCodes = this.activeReviewProViewData.activeProdList[i].prodCode.split(',');
                        this.activeReviewProViewData.financeProdCodeList = financeProdCodes;
                    } else { // 信贷产品
                        creditProdCodes = this.activeReviewProViewData.activeProdList[i].prodCode.split(',');
                        this.activeReviewProViewData.creditProdCodeList = creditProdCodes;
                    }
                }
            }
        },
        /**
         * 附件链接
         */
        btn_add_appendix () {
            window.open('http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>' + this.activeReviewProViewData.ativeMain.additionalId + '</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >');
        },
        pageBack () {
            this.$router.push({name: 'activeReviewProgressList'});
        }
    },
    mounted () {
        this.init();
    }
};
</script>