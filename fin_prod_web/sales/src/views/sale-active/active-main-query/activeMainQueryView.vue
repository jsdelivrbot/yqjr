<style lang="less">
    @import '../../../styles/common.less';
    /*#active-query .ivu-select-input{width:20px!important;}*/
    /*#active-query .ivu-select-placeholder{display: none!important;}*/
</style>
<template>
    <div id="active-query">
        <Form :label-width="140">
            <Card style="margin-bottom: 10px;">
                <p slot="title">
                    <Icon type="search"></Icon>
                    活动明细查看
                </p>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="归属区域名称：" >
                            <Input v-model="activeMainQueryResult.activeMain.areaName" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="活动代码：" >
                            <Input v-model="activeMainQueryResult.activeMain.activeCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="活动名称：" >
                            <Input v-model="activeMainQueryResult.activeMain.activeName"  disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="首付比例(%)：" >
                            <Row>
                                <Col span="10"><Input v-model="activeMainQueryResult.activeMain.patmentBegin" disabled></Input></Col>
                                <Col span="4" style="text-align: center;">&nbsp;——&nbsp;</Col>
                                <Col span="10"><Input  v-model="activeMainQueryResult.activeMain.patmentEnd" disabled></Input></Col>
                            </Row>
                            <!--<Input style="width:48%;float:left;" v-model="activeMainQueryResult.activeMain.patmentBegin" disabled></Input>-->
                            <!--<Input style="width:48%;float:right;" v-model="activeMainQueryResult.activeMain.patmentEnd" disabled></Input>-->
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="贷款金额(元)：" >
                            <Row>
                                <Col span="10"><Input v-model="activeMainQueryResult.activeMain.loanAmtBegin" disabled></Input></Col>
                                <Col span="4" style="text-align: center;">&nbsp;——&nbsp;</Col>
                                <Col span="10"><Input  v-model="activeMainQueryResult.activeMain.loanAmtEnd" disabled></Input></Col>
                            </Row>
                            <!--<Input style="width:48%;float:left;" v-model="activeMainQueryResult.activeMain.loanAmtBegin" disabled></Input>-->
                            <!--<Input style="width:48%;float:right;" v-model="activeMainQueryResult.activeMain.loanAmtEnd" disabled></Input>-->
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="贷款期限(月)：" >
                            <Row>
                                <Col span="10"><Input v-model="activeMainQueryResult.activeMain.loanTermBegin" disabled></Input></Col>
                                <Col span="4" style="text-align: center;">&nbsp;——&nbsp;</Col>
                                <Col span="10"><Input  v-model="activeMainQueryResult.activeMain.loanTermEnd" disabled></Input></Col>
                            </Row>
                            <!--<Input style="width:48%;float:left;" v-model="activeMainQueryResult.activeMain.loanTermBegin" disabled></Input>-->
                            <!--<Input style="width:48%;float:right;" v-model="activeMainQueryResult.activeMain.loanTermEnd" disabled></Input>-->
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="受理开始日期：" >
                            <Input v-model="activeMainQueryResult.activeMain.activeStartime" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="受理截止日期：" >
                            <Input v-model="activeMainQueryResult.activeMain.activeEndtime" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="放款开始日期：" >
                            <Input v-model="activeMainQueryResult.activeMain.loanStartime" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="放款截止日期：" >
                            <Input v-model="activeMainQueryResult.activeMain.loanEndtime" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="车籍：" >
                            <Select v-model="activeMainQueryResult.activeMain.carReg" style="width:100%" disabled>
                                <Option v-for="item in activeCarRegList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="促销活动激励标准：" >
                            <Input v-model="activeMainQueryResult.activeMain.avtiveCriterion" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="预计活动笔数：" >
                            <Input v-model="activeMainQueryResult.activeMain.expectedCount" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="实际成交笔数：" >
                            <Input v-model="activeMainQueryResult.actualTurnoverCount" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="达成率：" >
                            <Input v-model="activeMainQueryResult.reachRate" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>


            <Card class="margin-top-10" v-if="activeMainQueryResult.activeMain.inputDeale == '1'">
                <p slot="title">
                    <Icon type="search"></Icon>
                    经销商信息
                </p>
                <Row>
                    <Table :columns="dealerColumns" :data="activeMainQueryResult.activeDealeList" size="small"></Table>
                </Row>
            </Card>
            <Card class="margin-top-10" v-if="activeMainQueryResult.activeMain.inputDeale == '0'">
                <p slot="title">
                    <Icon type="search"></Icon>
                    区域信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="活动范围：">
                            <Select placeholder="" v-model="activeMainQueryResult.activeMain.inputArea" style="width:100%" disabled>
                            <Option v-for="item in activeAreaArr" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-if="activeMainQueryResult.activeMain.inputArea == '1'">
                    <Col span="18" offset="2">
                        <FormItem label="活动区域：">
                            <!--<Input disabled v-model="activeMainViewData.areaName" style="width: 100%"></Input>-->
                            <Select placeholder="" v-model="vModel.activeAreaList" style="width:100%"  multiple :loading="loading" disabled>
                            <Option v-for="item in activeMainQueryArea" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-if="activeMainQueryResult.activeMain.inputArea == '0'">
                    <Col span="18" offset="2">
                        <FormItem label="活动省份：">
                            <!--<Input disabled v-model="activeMainViewData.provinceName" style="width: 100%"></Input>-->
                            <Select placeholder="" v-model="vModel.provinceList" style="width:100%"   multiple :loading="loading" disabled>
                            <Option v-for="item in activeMainQueryProvince" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-if="activeMainQueryResult.activeMain.inputArea == '0'">
                    <Col span="18" offset="2">
                        <FormItem label="活动城市：">
                            <!--<Input disabled v-model="activeMainViewData.cityName" style="width: 100%"></Input>-->
                            <Select placeholder="" v-model="vModel.cityList" style="width:100%"  multiple :loading="loading" disabled>
                            <Option v-for="item in activeMainQueryCity" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>

            <!--<Card style="margin-bottom: 10px;">-->
                <!--<p slot="title">-->
                    <!--<Icon type="search"></Icon>-->
                    <!--区域信息-->
                <!--</p>-->
                <!--<Row>-->
                    <!--<Col span="9" offset="1">-->
                        <!--<FormItem label="活动范围：" >-->
                            <!--<Select placeholder="" v-model="activeMainQueryResult.activeMain.inputArea" style="width:100%" disabled>-->
                                <!--<Option v-for="item in activeAreaArr" :value="item.value" :key="item.value">{{ item.label }}</Option>-->
                            <!--</Select>-->
                        <!--</FormItem>-->
                    <!--</Col>-->
                <!--</Row>-->
                <!--<Row v-show="ifShowArea">-->
                    <!--<Col span="20" offset="1">-->
                        <!--<FormItem label="活动区域：" >-->
                            <!--<Select placeholder="" v-model="vModel.activeAreaList" style="width:100%"  multiple :loading="loading" disabled>-->
                                <!--<Option v-for="item in activeMainQueryArea" :value="item.value" :key="item.value">{{ item.label }}</Option>-->
                            <!--</Select>-->
                        <!--</FormItem>-->
                    <!--</Col>-->
                <!--</Row>-->
                <!--<Row v-show="ifShowProvince">-->
                    <!--<Col span="20" offset="1">-->
                        <!--<FormItem label="活动省份：" >-->
                            <!--<Select placeholder="" v-model="vModel.provinceList" style="width:100%"   multiple :loading="loading" disabled>-->
                                <!--<Option v-for="item in activeMainQueryProvince" :value="item.value" :key="item.value">{{ item.label }}</Option>-->
                            <!--</Select>-->
                        <!--</FormItem>-->
                    <!--</Col>-->
                <!--</Row>-->
                <!--<Row v-show="ifShowProvince">-->
                    <!--<Col span="20" offset="1">-->
                        <!--<FormItem label="活动城市：" >-->
                            <!--<Select placeholder="" v-model="vModel.cityList" style="width:100%"  multiple :loading="loading" disabled>-->
                                <!--<Option v-for="item in activeMainQueryCity" :value="item.value" :key="item.value">{{ item.label }}</Option>-->
                            <!--</Select>-->
                        <!--</FormItem>-->
                    <!--</Col>-->
                <!--</Row>-->
            </Card>
            <Card style="margin-bottom: 10px;">
                <p slot="title">
                    <Icon type="search"></Icon>
                    品牌信息
                </p>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="活动品牌：" >
                            <Select placeholder=" " v-model="activeMainQueryResult.activeCar.brandsCode" style="width:100%" disabled>
                                <Option v-for="item in activeMainQueryBrand" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="活动子品牌：" >
                            <Select placeholder=" " v-model="vModel.secondBrandList" style="width:100%" :label-in-value="true" multiple :loading="loading" disabled>
                                <Option v-for="item in activeMainQuerySecondBrand" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="活动车型：" >
                            <Select placeholder=" " v-model="vModel.carTypeList" style="width:100%" :label-in-value="true" multiple :loading="loading" disabled>
                                <Option v-for="item in activeMainQueryCarType" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card style="margin-bottom: 10px;">
                <p slot="title">
                    <Icon type="search"></Icon>
                    产品信息
                </p>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="金融产品：" >
                            <Select placeholder=" " v-model="vModel.financeCodesList" style="width:100%" :label-in-value="true" multiple :loading="loading" disabled>
                                <Option v-for="item in financeCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="业务模式：" >
                            <Select placeholder=" " v-model="vModel.businessCodesList" style="width:100%" multiple :loading="loading" disabled>
                                <Option v-for="item in businessCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="信贷产品：" >
                            <Select placeholder=" " v-model="vModel.creditCodesList" style="width:100%" :label-in-value="true" multiple :loading="loading" disabled>
                                <Option v-for="item in creditCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="营销活动：" >
                            <Select placeholder=" " v-model="vModel.marketingCodesList" style="width:100%" :label-in-value="true" multiple :loading="loading" disabled>
                                <Option v-for="item in marketingCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="6" offset="1">
                        <FormItem label="附加贷：" >
                            <Select v-model="activeMainQueryResult.activeMain.additionFlag" disabled>
                                <Option v-for="item in activeAdditionalList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="12" offset="2" v-show="ifShowAdd">
                        <FormItem label="附加贷金额：" >
                            <Row>
                                <Col span="10"><Input v-model="activeMainQueryResult.activeMain.additionAmtBegin" disabled></Input></Col>
                                <Col span="4" style="text-align: center;">&nbsp;——&nbsp;</Col>
                                <Col span="10"><Input  v-model="activeMainQueryResult.activeMain.additionAmtEnd" disabled></Input></Col>
                            </Row>
                            <!--<Input style="width:48%;float:left;" v-model="activeMainQueryResult.activeMain.additionAmtBegin" disabled></Input>-->
                            <!--<Input style="width:48%;float:right;" v-model="activeMainQueryResult.activeMain.additionAmtEnd" disabled></Input>-->
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="ifShowAdd">
                    <Col span="20" offset="1">
                        <FormItem label="附加贷子项：" >
                            <Select placeholder=" " v-model="vModel.additionalCodesList" style="width:100%" :label-in-value="true" multiple :loading="loading" disabled>
                                <Option v-for="item in additionalCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card style="margin-bottom: 10px;">
                <p slot="title">
                    <Icon type="search"></Icon>
                    附件信息
                </p>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="附件列表：" >
                            <Button type="success" icon="search" @click="searchAccessory">查看附件</Button>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="备注：" >
                            <Input v-model="activeMainQueryResult.activeMain.remark" disabled type="textarea" placeholder="" :autosize="{minRows: 2,maxRows: 6}"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <!--返回按钮-->
                <Row class="margin-top-20">
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
import {resetWorkHeight} from '@/libs/util.js';
export default{
    name: 'activeMainQueryView',
    data () {
        return {
            activeCarRegList: [{
                value: '00',
                label: '全部'
            }, {
                value: '01',
                label: '法人'
            }, {
                value: '02',
                label: '自然人'
            }],
            activeAreaArr: [{
                value: '0',
                label: '省市'
            }, {
                value: '1',
                label: '区域'
            }],
            activeAdditionalList: [{
                value: '0',
                label: '否'
            }, {
                value: '1',
                label: '是'
            }],
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
            ]
        };
    },
    computed: {
        ...mapState({
            loading: ({activeMainQueryList}) => activeMainQueryList.loading,
            activeMainQueryResult: ({activeMainQueryList}) => activeMainQueryList.activeMainDetailsQueryData,
            activeMainQueryProvince: ({activeMainQueryList}) => activeMainQueryList.activeMainProvinceQueryList,
            activeMainQueryCity: ({activeMainQueryList}) => activeMainQueryList.activeMainCityQueryList,
            activeMainQueryBrand: ({activeMainQueryList}) => activeMainQueryList.activeMainBrandQueryList,
            activeMainQuerySecondBrand: ({activeMainQueryList}) => activeMainQueryList.activeMainSecondBrandQueryList,
            activeMainQueryCarType: ({activeMainQueryList}) => activeMainQueryList.activeMainCarTypeQueryList,
            activeMainQueryArea: ({activeMainQueryList}) => activeMainQueryList.activeMainAreaQueryList,
            provinceParams: ({activeMainQueryList}) => activeMainQueryList.provinceParams,
            cityParams: ({activeMainQueryList}) => activeMainQueryList.cityParams,
            brandParams: ({activeMainQueryList}) => activeMainQueryList.brandParams,
            secondBrandParams: ({activeMainQueryList}) => activeMainQueryList.secondBrandParams,
            carTypeParams: ({activeMainQueryList}) => activeMainQueryList.carTypeParams,
            activeAreaParams: ({activeMainQueryList}) => activeMainQueryList.activeAreaParams,
            ifShowArea: ({activeMainQueryList}) => activeMainQueryList.ifShowArea,
            ifShowProvince: ({activeMainQueryList}) => activeMainQueryList.ifShowProvince,
            ifShowAdd: ({activeMainQueryList}) => activeMainQueryList.ifShowAdd,
            isSuccess: ({activeMainQueryList}) => activeMainQueryList.isSuccess,
            msg: ({activeMainQueryList}) => activeMainQueryList.msg,
            additionalCodes: ({activeMainQueryList}) => activeMainQueryList.additionalCodes,
            marketingCodes: ({activeMainQueryList}) => activeMainQueryList.marketingCodes,
            businessCodes: ({activeMainQueryList}) => activeMainQueryList.businessCodes,
            creditCodes: ({activeMainQueryList}) => activeMainQueryList.creditCodes,
            financeCodes: ({activeMainQueryList}) => activeMainQueryList.financeCodes,
            vModel: ({activeMainQueryList}) => activeMainQueryList.vModel
        })
    },
    methods: {
        ...mapActions([
            'handleActiveMainQueryViewById',
            'handleActiveMainProvinceQuery',
            'handleActiveMainCityQuery',
            'handleActiveMainBrandQuery',
            'handleActiveMainSecondBrandQuery',
            'handleActiveMainCarTypeQuery',
            'handleActiveMainProductQuery',
            'handleActiveMainAreaQuery'
        ]),
        init () {
            this.queryActiveProduct(); // 先执行产品信息 再执行查询详情数据
            resetWorkHeight();
        },
        queryActiveById (id) {
            this.handleActiveMainQueryViewById(id).then(res => {
                if (!this.isSuccess) {
                    this.$Message.info(this.msg);
                }
                resetWorkHeight();
                if (this.ifShowProvince === true) {
                    this.queryActiveProvice(this.provinceParams); // 省会
                    this.queryActiveCity(this.cityParams); // 城市
                } else if (this.ifShowArea === true) {
                    this.queryActiveArea(this.activeAreaParams); // 活动区域
                }
                this.queryActiveBrand(this.brandParams); // 品牌
                this.queryActiveSecondBrand(this.secondBrandParams); // 子品牌
                this.queryActiveCarType(this.carTypeParams); // 车型
            });
        }, // 查询活动详情
        queryActiveProvice (data) {
            this.handleActiveMainProvinceQuery(data).then(res => {
                // if (this.isSuccess) {
                //     this.$Message.info(this.msg);
                // } else {
                //     this.$Message.info(this.msg);
                // }
                resetWorkHeight();
            });
        }, // 查询活动省份
        queryActiveCity (data) {
            this.handleActiveMainCityQuery(data).then(res => {
                // if (this.isSuccess) {
                //     this.$Message.info(this.msg);
                // } else {
                //     this.$Message.info(this.msg);
                // }
                resetWorkHeight();
            });
        }, // 查询活动城市
        queryActiveBrand (data) {
            this.handleActiveMainBrandQuery(data).then(res => {
                // if (this.isSuccess) {
                //     this.$Message.info(this.msg);
                // } else {
                //     this.$Message.info(this.msg);
                // }
                resetWorkHeight();
            });
        }, // 查询活动品牌
        queryActiveSecondBrand (data) {
            this.handleActiveMainSecondBrandQuery(data).then(res => {
                // if (this.isSuccess) {
                //     this.$Message.info(this.msg);
                // } else {
                //     this.$Message.info(this.msg);
                // }
                resetWorkHeight();
            });
        }, // 查询活动子品牌
        queryActiveCarType (data) {
            this.handleActiveMainCarTypeQuery(data).then(res => {
                // if (this.isSuccess) {
                //     this.$Message.info(this.msg);
                // } else {
                //     this.$Message.info(this.msg);
                // }
                resetWorkHeight();
            });
        }, // 查询活动车型
        queryActiveProduct () {
            this.handleActiveMainProductQuery().then(res => {
                this.queryActiveById(this.$route.query.activeCode);
                // if (this.isSuccess) {
                //     this.$Message.info(this.msg);
                // } else {
                //     this.$Message.info(this.msg);
                // }
                resetWorkHeight();
            });
        }, // 查询活动产品信息
        queryActiveArea (data) {
            this.handleActiveMainAreaQuery(data).then(res => {
                // if (this.isSuccess) {
                //     this.$Message.info(this.msg);
                // } else {
                //     this.$Message.info(this.msg);
                // }
                resetWorkHeight();
            });
        }, // 查询活动区域
        // 返回列表页面
        pageBack () {
            this.$router.push({name: 'activeMainQueryList', params: {h: true}});
        },
        // 附件查看
        searchAccessory () {
            window.open('http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>' + this.activeMainQueryResult.activeMain.additionalId + '</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >');
        }
    },
    mounted () {
        this.init();
    }
};
</script>