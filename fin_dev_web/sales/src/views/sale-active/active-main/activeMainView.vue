<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form :label-width="140">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    新增
                </p>
                <a href="#" slot="extra" @click.prevent="goBack">
                    <Icon type="arrow-return-left"></Icon>
                    返回
                </a>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="归属区域名称：">
                            <Input disabled v-model="activeMainViewData.areaMainName"/>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="活动代码：">
                            <Input disabled v-model="activeMainViewData.activeCode"/>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="活动名称：">
                            <Input disabled v-model="activeMainViewData.activeName"/>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="首付比例(%)：">
                            <Col span="11">
                                <Input disabled v-model="activeMainViewData.patmentBegin" style="width: 100%"></Input>
                            </Col>
                            <Col span="2" style="text-align: center">-</Col>
                            <Col span="11">
                                <Input disabled v-model="activeMainViewData.patmentEnd" style="width: 100%"></Input>
                            </Col>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="贷款金额(元)：">
                            <Col span="11">
                                <Input disabled v-model="activeMainViewData.loanAmtBegin" style="width: 100%"></Input>
                            </Col>
                            <Col span="2" style="text-align: center">-</Col>
                            <Col span="11">
                                <Input disabled v-model="activeMainViewData.loanAmtEnd" style="width: 100%"></Input>
                            </Col>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="贷款期限(月)：">
                            <Col span="11">
                                <Input disabled v-model="activeMainViewData.loanTermBegin" style="width: 100%"></Input>
                            </Col>
                            <Col span="2" style="text-align: center">-</Col>
                            <Col span="11">
                                <Input disabled v-model="activeMainViewData.loanTermEnd" style="width: 100%"></Input>
                            </Col>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="受理开始日期：">
                            <DatePicker disabled type="date" v-model="activeMainViewData.activeStartime"
                                        style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="受理截止日期：">
                            <DatePicker disabled type="date" v-model="activeMainViewData.activeEndtime"
                                        style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="放款开始日期：">
                            <DatePicker disabled type="date" v-model="activeMainViewData.loanStartime"
                                        style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="放款截止日期：">
                            <DatePicker disabled type="date" v-model="activeMainViewData.loanEndtime"
                                        style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="车籍：">
                            <Input disabled v-model="activeMainViewData.carReg" style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="促销活动激励标准：">
                            <Input disabled v-model="activeMainViewData.avtiveCriterion" style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="预计活动笔数：">
                            <Input disabled v-model="activeMainViewData.expectedCount" style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="实际成交笔数：">
                            <Input disabled v-model="activeMainViewData.actualCount" style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="达成率：">
                            <Input disabled v-model="activeMainViewData.reachRate" style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-if="activeMainViewData.inputDeale == '1'">
                <p slot="title">
                    <Icon type="search"></Icon>
                    经销商信息
                </p>
                <Row>
                    <Table :columns="dealerColumns" :data="activeMainViewData.activeDealeList" size="small"></Table>
                </Row>
            </Card>
            <Card class="margin-top-10" v-if="activeMainViewData.inputDeale == '0'">
                <p slot="title">
                    <Icon type="search"></Icon>
                    区域信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="活动范围：">
                            <Select v-model="activeMainViewData.inputArea" disabled style="width:100%">
                                <Option value="1">区域</Option>
                                <Option value="0">省市</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-if="activeMainViewData.inputArea == '1'">
                    <Col span="18" offset="2">
                        <FormItem label="活动区域：">
                            <!--<Input disabled v-model="activeMainViewData.areaName" style="width: 100%"></Input>-->
                            <Select v-model="areaList.areaCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeViewAreaListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-if="activeMainViewData.inputArea == '0'">
                    <Col span="18" offset="2">
                        <FormItem label="活动省份：">
                            <!--<Input disabled v-model="activeMainViewData.provinceName" style="width: 100%"></Input>-->
                            <Select v-model="areaList.provinceCodesList" style="width:100%" disabled multiple >
                                <Option v-for="item in activeViewProvinceListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-if="activeMainViewData.inputArea == '0'">
                    <Col span="18" offset="2">
                        <FormItem label="活动城市：">
                            <!--<Input disabled v-model="activeMainViewData.cityName" style="width: 100%"></Input>-->
                            <Select v-model="areaList.cityCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeViewCityListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="18" offset="2">
                        <FormItem label="活动品牌：">
                            <!--<Input disabled v-model="activeMainViewData.brandsName" style="width: 100%"></Input>-->
                            <Select v-model="areaList.brandsNameList" style="width:100%" disabled >
                                <Option v-for="item in activeViewBrandsListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="活动子品牌：">
                            <!--<Input disabled v-model="activeMainViewData.seriesName" style="width: 100%"></Input>-->
                            <Select v-model="areaList.seriesCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeViewSeriesListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="活动车型：">
                            <!--<Input disabled v-model="activeMainViewData.moderName" style="width: 100%"></Input>-->
                            <Select v-model="areaList.moderCodeList" style="width:100%" disabled multiple>
                                <Option v-for="item in activeViewModerListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="金融产品：">
                            <Select v-model="activeMainViewData.financeProdCode" disabled multiple style="width:100%">
                                <Option v-for="item in financeCodes" :value="item.value" :key="item.value">
                                    {{ item.label }}
                                </Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="业务模式：">
                            <Select v-model="activeMainViewData.businessCode" disabled multiple style="width:100%">
                                <Option v-for="item in businessCodes" :value="item.value" :key="item.value">
                                    {{ item.label }}
                                </Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="信贷产品：">
                            <Select v-model="activeMainViewData.creditProdCode" disabled multiple style="width:100%">
                                <Option v-for="item in creditCodes" :value="item.value" :key="item.value">
                                    {{ item.label }}
                                </Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="营销活动：">
                            <Select v-model="activeMainViewData.marketingCode" disabled multiple style="width:100%">
                                <Option v-for="item in marketingCodes" :value="item.value" :key="item.value">
                                    {{ item.label }}
                                </Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="6" offset="2">
                        <FormItem label="附加贷：">
                            <Input disabled v-model="activeMainViewData.additionFlagName" style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                    <Col span="10" offset="2" v-if="activeMainViewData.additionFlag == '1'">
                        <FormItem label="附加贷金额：">
                            <Col span="11">
                                <Input disabled v-model="activeMainViewData.additionAmtBegin" style="width: 100%"></Input>
                            </Col>
                            <Col span="2" style="text-align: center">-</Col>
                            <Col span="11">
                                <Input disabled v-model="activeMainViewData.additionAmtEnd" style="width: 100%"></Input>
                            </Col>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-if="activeMainViewData.additionFlag == '1'">
                    <Col span="18" offset="2">
                        <FormItem label="附加贷子项：">
                            <Select v-model="activeMainViewData.additionalCode" disabled  multiple style="width:100%">
                                <Option v-for="item in additionalCodes" :value="item.value" :key="item.value">
                                    {{ item.label }}
                                </Option>
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
                        <FormItem label="附件列表：">
                            <Button type="success" @click="addAppendix">查看附件</Button>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="备注：">
                            <Input disabled v-model="activeMainViewData.remark" type="textarea" :rows="4"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="10">
                        <Button type="primary" icon="reply" @click="goBack">返回</Button>
                    </Col>
                </Row>
            </Card>
        </Form>
    </div>
</template>
<script>
    import {mapActions, mapState} from 'vuex';
    import {resetWorkHeight} from '@/libs/util.js';

    export default {
        name: 'activeMainView',
        data: function () {
            return {
                dealerColumns: [
                    {
                        title: '经销商代码',
                        align: 'center',
                        key: 'dealerCode'
                    },
                    {
                        title: '经销商名称',
                        align: 'center',
                        key: 'dealerName'
                    },
                    {
                        title: '活动上限/辆',
                        align: 'center',
                        key: 'activeNumber'
                    }
                ],
                excelFileName: '促销活动查看'
            };
        },
        computed: {
            ...mapState({
                activeMainViewData: ({activeMainView}) => activeMainView.activeMainViewData,
                financeCodes: ({activeMainView}) => activeMainView.financeCodes,
                businessCodes: ({activeMainView}) => activeMainView.businessCodes,
                creditCodes: ({activeMainView}) => activeMainView.creditCodes,
                marketingCodes: ({activeMainView}) => activeMainView.marketingCodes,
                additionalCodes: ({activeMainView}) => activeMainView.additionalCodes,
                areaList: ({activeMainView}) => activeMainView.areaList,
                activeViewAreaListData: ({activeMainView}) => activeMainView.activeViewAreaListData,
                activeViewProvinceListData: ({activeMainView}) => activeMainView.activeViewProvinceListData,
                activeViewCityListData: ({activeMainView}) => activeMainView.activeViewCityListData,
                activeViewBrandsListData: ({activeMainView}) => activeMainView.activeViewBrandsListData,
                activeViewSeriesListData: ({activeMainView}) => activeMainView.activeViewSeriesListData,
                activeViewModerListData: ({activeMainView}) => activeMainView.activeViewModerListData
            })
        },
        methods: {
            ...mapActions([
                'getProductList',
                'getActiveMainViewData',
                'handelActiveAreaList',
                'handleSearchBrandList',
                'handleSearchProvinList',
                'handleSearchSerieList',
                'handleSearchModerCod',
                'handleSearchCitList'
            ]),
            init () {
                this.searchAreaList(); // 加载所有区域信息
                this.searchProvinceList(); // 加载所有省份信息
                this.searchBrandList(); // 加载并解析所有的活动品牌
                this.loadingProductAll();
                this.getActiveMainView(this.$route.query.activeCode);
                setTimeout(function () {
                    resetWorkHeight();
                }, 1000);
            },
            goBack () {
                this.$router.push({name: 'activeMainList'});
            },
            /**
             * 加载所有省份
             */
            searchProvinceList () {
                this.handleSearchProvinList();
            },
            /**
             * 加载所有活动区域
             */
            searchAreaList () {
                this.handelActiveAreaList();
                resetWorkHeight();
            },
            /**
             * 根据活动品牌加载子品牌
             */
            searchSeriesList () {
                this.handleSearchSerieList(this.activeMainViewData.brandsCode).then(res => {
                    resetWorkHeight();
                    this.searchModerCode();
                });
            },
            /**
             * 根据子品牌加载车型
             */
            searchModerCode () {
                this.handleSearchModerCod(this.areaList.moderCodeList).then(res => {
                    resetWorkHeight();
                });
            },
            getActiveMainView (data) {
                this.getActiveMainViewData(data).then(res => {
                    this.searchCityList();
                    this.searchSeriesList();
                });
            },
            /**
             * 加载所有品牌
             */
            searchBrandList () {
                this.handleSearchBrandList();
            },
            loadingProductAll () {
                this.getProductList();
            },
            addAppendix () {
                const appendixId = this.activeMainViewData.additionalId;
                window.open('http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>' + appendixId + '</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >');
            },
            /**
             * 根据省份加载城市
             */
            searchCityList () {
                this.handleSearchCitList(this.areaList.provinceCodesList).then(res => {
                    resetWorkHeight();
                });
            }
        },
        mounted () {
            this.init();
        }
    };
</script>