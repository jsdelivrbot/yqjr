<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="activeReviewProEditData" :rules="ruleValidate" :model="activeReviewProEditData" :label-width="140">
            <Card>
                <p slot="title">
                    <Icon type="edit"></Icon>
                    审核查看
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="区域名称：" >
                            <Input v-model="activeReviewProEditMainData.areaName" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="活动代码：" >
                            <Input v-model="activeReviewProEditMainData.activeCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="活动名称：" prop="activeName">
                            <Input v-model="activeReviewProEditMainData.activeName"></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="首付比例(%)：" >
                            <Row>
                                <Col span="11">
                                    <FormItem prop="patmentBegin">
                                        <Input v-model="activeReviewProEditMainData.patmentBegin" :max="100" :min="1"  placeholder="Select date" style="width: 100%"></Input>
                                    </FormItem>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem prop="patmentEnd">
                                        <Input v-model="activeReviewProEditMainData.patmentEnd" :max="100" :min="1"  placeholder="Select time" style="width: 100%"></Input>
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
                                <Col span="11" >
                                    <FormItem prop="loanAmtBegin">
                                        <Input v-model="activeReviewProEditMainData.loanAmtBegin" :min="1" placeholder="Select date"  style="width: 100%"></Input>
                                    </FormItem>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11" >
                                    <FormItem prop="loanAmtEnd">
                                        <Input v-model="activeReviewProEditMainData.loanAmtEnd" :min="1" placeholder="Select time"  style="width: 100%"></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="贷款期限(月)：" >
                            <Row>
                                <Col span="11">
                                    <FormItem prop="loanTermBegin">
                                        <Input v-model="activeReviewProEditMainData.loanTermBegin" :min="1" placeholder="Select date" style="width: 100%"></Input>
                                    </FormItem>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <FormItem prop="loanTermEnd">
                                        <Input v-model="activeReviewProEditMainData.loanTermEnd" :min="1" placeholder="Select time" style="width: 100%"></Input>
                                    </FormItem>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="受理开始日期：" prop="activeStartime">
                            <DatePicker v-model="activeReviewProEditMainData.activeStartime"  placeholder="受理开始日期" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="受理结束日期：" prop="activeEndtime">
                            <DatePicker  v-model="activeReviewProEditMainData.activeEndtime" placeholder="受理结束日期" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="放款开始日期：" prop="loanStartime">
                            <DatePicker  v-model="activeReviewProEditMainData.loanStartime" placeholder="放款开始日期" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="放款结束日期：" prop="loanEndtime">
                            <DatePicker  v-model="activeReviewProEditMainData.loanEndtime" placeholder="放款结束日期" style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="车籍：" >
                            <Select v-model="activeReviewProEditMainData.carReg"  style="width:100%">
                                <Option value="00">全部</Option>
                                <Option value="01">法人</Option>
                                <Option value="02">自然人</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="促销活动激励标准：" prop="avtiveCriterion">
                            <Input v-model="activeReviewProEditMainData.avtiveCriterion" ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="预计活动笔数：" prop="expectedCount">
                            <Input v-model="activeReviewProEditMainData.expectedCount"></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="经销商导入：" >
                            <Select v-model="activeReviewProEditMainData.inputDeale"  style="width:100%" @on-change="judgmentInputFlag">
                                <Option value="0">否</Option>
                                <Option value="1">是</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.dealerFlag">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    经销商信息
                </p>
                <Row>
                    <Col span="6" offset="3">
                        <Upload
                                :before-upload="handleUpload"
                                :on-success="uploadSuccess"
                                :show-upload-list="false"
                                action="/mkmm/sales/activeDealerReviews/fileUpLoad">
                            <Button type="ghost" icon="ios-cloud-upload-outline">请选择文件</Button>
                        </Upload>
                    </Col>
                    <Col span="4" offset="9" style="margin-top:5px;">
                        <Button type="info" size="small" @click="downloadTemplet">下载模板</Button>
                    </Col>
                </Row>
                <Row style="margin-top:10px;">
                    <Col span="17" offset="3">
                        <Table :columns="dealerColumns" :data="ativeDealersList"></Table>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-show="showFlag.areaFlag">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    区域信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="活动范围：" >
                            <Select v-model="activeReviewProEditMainData.inputArea" style="width:100%" placeholder = "全部" @on-change="judgmentInputAreaFlag">
                                <Option value="1" >区域</Option>
                                <Option value="0" >省市</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.areaRow">
                    <Col span="18" offset="2">
                        <FormItem label="活动区域：" prop="areaCode">
                            <Select v-model="areasList" style="width:100%" multiple @on-change="filterArea">
                                <Option v-for="item in activeReviewProEditAreaListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.cityRow">
                    <Row>
                        <Col span="18" offset="2">
                            <FormItem label="活动省份：" prop="provienceCode">
                                <Select v-model="proviencesList" style="width:100%" multiple @on-change="loadingCities">
                                    <Option v-for="item in activeReviewProEditProvinceListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                                </Select>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="18" offset="2">
                            <FormItem label="活动城市：" >
                                <Select v-model="citysList" style="width:100%" multiple @on-change="filterCity">
                                    <Option v-for="item in activeReviewProEditCityListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="18" offset="2">
                        <FormItem label="活动品牌：">
                            <Select  v-model="brandsCodeList" style="width:100%"  @on-change="loadingSubBrands">
                                <Option v-for="item in activeReviewProEditBrandsListData" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="活动子品牌：">
                            <Select v-model="subBrandCodeList" style="width:100%" multiple @on-change="loadingCarModels">
                                <Option v-for="item in seriesList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="活动车型：">
                            <Select v-model="carModelsCodeList" style="width:100%" multiple @on-change="filterCarModels">
                                <Option v-for="item in modelList" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="18" offset="2">
                        <FormItem label="金融产品：" >
                            <Select v-model="financeProdCodeList" style="width:100%" multiple @on-change="changeFinanceProd">
                                <Option v-for="item in activeReviewProEditAllProductListData.financeCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="业务模式：" >
                            <Select v-model="businessCodeList" style="width:100%" multiple @on-change="changeBusiness">
                                <Option v-for="item in activeReviewProEditAllProductListData.businessCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="信贷产品：" >
                            <Select v-model="creditProdCodeList" style="width:100%" multiple @on-change="changeCreditProd">
                                <Option v-for="item in activeReviewProEditAllProductListData.creditCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="18" offset="2">
                        <FormItem label="营销活动：" >
                            <Select v-model="marketingCodeList" style="width:100%" multiple @on-change="changeMarketing">
                                <Option v-for="item in activeReviewProEditAllProductListData.marketingCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row >
                    <Col span="6" offset="2" >
                        <FormItem label="附加贷：" >
                            <Select v-model="activeReviewProEditMainData.additionFlag"  style="width:100%" @on-change="judgmentAdditionFlag">
                                <Option value="0">否</Option>
                                <Option value="1">是</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="10" offset="2" v-show="showFlag.additionFlag">
                        <FormItem label="附加贷金额：" >
                            <Row>
                                <Col span="11">
                                    <Input v-model="activeReviewProEditMainData.additionAmtBegin"></Input>
                                </Col>
                                <Col span="2" style="text-align: center">-</Col>
                                <Col span="11">
                                    <Input v-model="activeReviewProEditMainData.additionAmtEnd"></Input>
                                </Col>
                            </Row>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-show="showFlag.additionFlag">
                    <Col span="18" offset="2">
                        <FormItem label="附加贷子项：" >
                            <Select v-model="additionalList" style="width:100%" multiple @on-change="filterAdditionalProd">
                                <Option v-for="item in activeReviewProEditAllProductListData.additionalCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="8" offset="2">
                        <FormItem label="附件：" >
                            <Button type="success" @click="btn_add_appendix">添加附件</Button>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="备注：" prop="remark">
                            <Input v-model="activeReviewProEditMainData.remark" type="textarea" style="width: 100%" :autosize="{minRows: 2,maxRows: 6}"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="checkmark" @click="activeReviewSub('activeReviewProEditData')" :loading="loading">提交审核</Button>
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
    import {resetWorkHeight, isEmpty, formatDate} from '@/libs/util.js';

    export default{
        name: 'activeReviewProEdit',
        data () {
            const validateActiveName = (rule, value, callback) => {
                if (isEmpty(this.activeReviewProEditMainData.activeName)) {
                    callback(new Error('请输入活动名称'));
                }
                callback();
            };
            const validatePatmentBegin = (rule, value, callback) => {
                var reg = /^\d+(\.\d+)?$/;
                if (isEmpty(this.activeReviewProEditMainData.patmentBegin)) {
                    callback(new Error('起始比例不能为空'));
                } else if (!reg.test(this.activeReviewProEditMainData.patmentBegin)) {
                    callback(new Error('起始比例必须为数字'));
                } else if (this.activeReviewProEditMainData.patmentBegin > 100) {
                    callback(new Error('起始比例不能大于100'));
                }
                if (!isEmpty(this.activeReviewProEditMainData.patmentBegin) && !isEmpty(this.activeReviewProEditMainData.patmentEnd)) {
                    if (parseInt(this.activeReviewProEditMainData.patmentBegin) > parseInt(this.activeReviewProEditMainData.patmentEnd)) {
                        callback(new Error('起始不能大于结束'));
                    }
                }
                callback();
            };
            const validatePatmentEnd = (rule, value, callback) => {
                var reg = /^\d+(\.\d+)?$/;
                if (isEmpty(this.activeReviewProEditMainData.patmentEnd)) {
                    callback(new Error('结束比例不能为空'));
                } else if (!reg.test(this.activeReviewProEditMainData.patmentEnd)) {
                    callback(new Error('结束比例必须为数字'));
                } else if (this.activeReviewProEditMainData.patmentEnd > 100) {
                    callback(new Error('结束比例不能大于100'));
                }
                if (!isEmpty(this.activeReviewProEditMainData.patmentBegin) && !isEmpty(this.activeReviewProEditMainData.patmentEnd)) {
                    if (parseInt(this.activeReviewProEditMainData.patmentBegin) > parseInt(this.activeReviewProEditMainData.patmentEnd)) {
                        callback(new Error('起始不能大于结束'));
                    }
                }
                callback();
            };
            const validateLoanAmtBegin = (rule, value, callback) => {
                var reg = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
                if (isEmpty(this.activeReviewProEditMainData.loanAmtBegin)) {
                    callback(new Error('起始不能为空'));
                } else if (!reg.test(this.activeReviewProEditMainData.loanAmtBegin)) {
                    callback(new Error('应为数字且最多两位小数'));
                }
                if (!isEmpty(this.activeReviewProEditMainData.loanAmtBegin) && !isEmpty(this.activeReviewProEditMainData.loanAmtEnd)) {
                    if (parseInt(this.activeReviewProEditMainData.loanAmtBegin) > parseInt(this.activeReviewProEditMainData.loanAmtEnd)) {
                        callback(new Error('起始不能大于结束'));
                    }
                }
                callback();
            };
            const validateLoanAmtEnd = (rule, value, callback) => {
                var reg = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
                if (isEmpty(this.activeReviewProEditMainData.loanAmtEnd)) {
                    callback(new Error('结束不能为空'));
                } else if (!reg.test(this.activeReviewProEditMainData.loanAmtEnd)) {
                    callback(new Error('应为数字且最多两位小数'));
                }
                if (!isEmpty(this.activeReviewProEditMainData.loanAmtBegin) && !isEmpty(this.activeReviewProEditMainData.loanAmtEnd)) {
                    if (parseInt(this.activeReviewProEditMainData.loanAmtBegin) > parseInt(this.activeReviewProEditMainData.loanAmtEnd)) {
                        callback(new Error('起始不能大于结束'));
                    }
                }
                callback();
            };
            const validateLoanTermBegin = (rule, value, callback) => {
                var reg = /^[0-9]*[1-9][0-9]*$/;
                if (isEmpty(this.activeReviewProEditMainData.loanTermBegin)) {
                    callback(new Error('起始不能为空'));
                } else if (!reg.test(this.activeReviewProEditMainData.loanTermBegin)) {
                    callback(new Error('应为正整数'));
                }
                if (!isEmpty(this.activeReviewProEditMainData.loanTermBegin) && !isEmpty(this.activeReviewProEditMainData.loanTermEnd)) {
                    if (parseInt(this.activeReviewProEditMainData.loanTermBegin) > parseInt(this.activeReviewProEditMainData.loanTermEnd)) {
                        callback(new Error('起始不能大于终止'));
                    }
                }
                callback();
            };
            const validateLoanTermEnd = (rule, value, callback) => {
                var reg = /^[0-9]*[1-9][0-9]*$/;
                if (isEmpty(this.activeReviewProEditMainData.loanTermEnd)) {
                    callback(new Error('结束不能为空'));
                } else if (!reg.test(this.activeReviewProEditMainData.loanTermEnd)) {
                    callback(new Error('应为正整数'));
                }
                if (!isEmpty(this.activeReviewProEditMainData.loanTermBegin) && !isEmpty(this.activeReviewProEditMainData.loanTermEnd)) {
                    if (parseInt(this.activeReviewProEditMainData.loanTermBegin) > parseInt(this.activeReviewProEditMainData.loanTermEnd)) {
                        callback(new Error('起始不能大于结束'));
                    }
                }
                callback();
            };
            const validateActiveStartime = (rule, value, callback) => {
                if (isEmpty(this.activeReviewProEditMainData.activeStartime)) {
                    callback(new Error('受理开始日期不能为空'));
                } else if (formatDate(this.activeReviewProEditMainData.activeStartime, 'yyyy-MM-dd') < formatDate(new Date(), 'yyyy-MM-dd')) {
                    callback(new Error('受理开始日期不能小于今天'));
                } else if (!isEmpty(this.activeReviewProEditMainData.activeEndtime) && formatDate(this.activeReviewProEditMainData.activeEndtime, 'yyyy-MM-dd') <= formatDate(this.activeReviewProEditMainData.activeStartime, 'yyyy-MM-dd')) {
                    callback(new Error('受理截止日期必须大于受理开始时间'));
                } else if (!isEmpty(this.activeReviewProEditMainData.loanStartime) && formatDate(this.activeReviewProEditMainData.loanStartime, 'yyyy-MM-dd') <= formatDate(this.activeReviewProEditMainData.activeStartime, 'yyyy-MM-dd')) {
                    callback(new Error('受理开始日期必须小于放款开始日期'));
                }
                callback();
            };
            const validateActiveEndtime = (rule, value, callback) => {
                if (isEmpty(this.activeReviewProEditMainData.activeStartime)) {
                    callback(new Error('请先选择受理开始日期'));
                }
                if (isEmpty(this.activeReviewProEditMainData.activeEndtime)) {
                    callback(new Error('受理截止日期不能为空'));
                } else if (formatDate(this.activeReviewProEditMainData.activeEndtime, 'yyyy-MM-dd') <= formatDate(this.activeReviewProEditMainData.activeStartime, 'yyyy-MM-dd')) {
                    callback(new Error('受理截止日期必须大于受理开始时间'));
                }
                callback();
            };
            const validateLoanStartime = (rule, value, callback) => {
                if (isEmpty(this.activeReviewProEditMainData.activeStartime)) {
                    callback(new Error('请先选择受理开始日期'));
                }
                if (isEmpty(this.activeReviewProEditMainData.loanStartime)) {
                    callback(new Error('放款开始日期不能为空'));
                } else if (formatDate(this.activeReviewProEditMainData.loanStartime, 'yyyy-MM-dd') <= formatDate(this.activeReviewProEditMainData.activeStartime, 'yyyy-MM-dd')) {
                    callback(new Error('放款开始日期不能小于受理开始日期'));
                } else if (!isEmpty(this.activeReviewProEditMainData.loanEndtime) && formatDate(this.activeReviewProEditMainData.loanEndtime, 'yyyy-MM-dd') <= formatDate(this.activeReviewProEditMainData.loanStartime, 'yyyy-MM-dd')) {
                    callback(new Error('放款截止日期必须大于放款开始日期'));
                }
                callback();
            };
            const validateLoanEndtime = (rule, value, callback) => {
                if (isEmpty(this.activeReviewProEditMainData.loanStartime)) {
                    callback(new Error('请先选择放款开始日期'));
                }
                if (isEmpty(this.activeReviewProEditMainData.loanEndtime)) {
                    callback(new Error('放款截止日期不能为空'));
                } else if (formatDate(this.activeReviewProEditMainData.loanEndtime, 'yyyy-MM-dd') <= formatDate(this.activeReviewProEditMainData.loanStartime, 'yyyy-MM-dd')) {
                    callback(new Error('放款截止日期必须大于放款开始日期'));
                }
                callback();
            };
            const validateAvtiveCriterion = (rule, value, callback) => {
                var reg = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
                if (isEmpty(this.activeReviewProEditMainData.avtiveCriterion)) {
                    callback(new Error('激励标准不能为空'));
                } else if (!reg.test(this.activeReviewProEditMainData.avtiveCriterion)) {
                    callback(new Error('激励标准须为数字,最多保留两位小数'));
                }
                callback();
            };
            const validateExpectedCount = (rule, value, callback) => {
                var reg = /^[0-9]*[1-9][0-9]*$/;
                if (isEmpty(this.activeReviewProEditMainData.expectedCount)) {
                    callback(new Error('预计活动笔数不能为空'));
                } else if (!reg.test(this.activeReviewProEditMainData.expectedCount)) {
                    callback(new Error('预计活动笔数应为正整数'));
                }
                callback();
            };
            const validateAdditionAmtBegin = (rule, value, callback) => {
                var reg = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
                if (isEmpty(this.activeReviewProEditMainData.additionAmtBegin)) {
                    callback(new Error('请输入附加贷起始金额'));
                } else if (!reg.test(this.activeReviewProEditMainData.additionAmtBegin)) {
                    callback(new Error('应为数字,最多两位小数'));
                }
                if (parseInt(this.activeReviewProEditMainData.additionAmtBegin) > parseInt(this.activeReviewProEditMainData.additionAmtEnd)) {
                    callback(new Error('附加贷起始不能大于终止'));
                }
                callback();
            };
            const validateAdditionAmtEnd = (rule, value, callback) => {
                var reg = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
                if (isEmpty(this.activeReviewProEditMainData.additionAmtEnd)) {
                    callback(new Error('请录入附加贷结束金额'));
                } else if (!reg.test(this.activeReviewProEditMainData.additionAmtEnd)) {
                    callback(new Error('应为数字,最多两位小数'));
                }
                if (parseInt(this.activeReviewProEditMainData.additionAmtBegin) > parseInt(this.activeReviewProEditMainData.additionAmtEnd)) {
                    callback(new Error('附加贷起始不能大于结束'));
                }
                callback();
            };
            const validateRemark = (rule, value, callback) => {
                const remarkVal = this.activeReviewProEditMainData.remark;
                if (isEmpty(remarkVal)) {
                    callback(new Error('请输入备注信息'));
                } else if (remarkVal.length > 265) {
                    callback(new Error('备注信息最大长度265'));
                }
                callback();
            };
            return {
                additionalList: [],
                areasList: [],
                proviencesList: [],
                citysList: [],
                brandsList: [],
                brandsCodeList: [],
                subBrandCodeList: [],
                carModelsCodeList: [],
                financeProdCodeList: [],
                businessCodeList: [],
                creditProdCodeList: [],
                marketingCodeList: [],
                ativeDealersList: [],
                ruleValidate: {
                    activeName: [
                        { validator: validateActiveName }
                    ],
                    patmentBegin: [
                        { validator: validatePatmentBegin }
                    ],
                    patmentEnd: [
                        { validator: validatePatmentEnd }
                    ],
                    loanAmtBegin: [
                        { validator: validateLoanAmtBegin }
                    ],
                    loanAmtEnd: [
                        { validator: validateLoanAmtEnd }
                    ],
                    loanTermBegin: [
                        { validator: validateLoanTermBegin }
                    ],
                    loanTermEnd: [
                        { validator: validateLoanTermEnd }
                    ],
                    activeStartime: [
                        { validator: validateActiveStartime }
                    ],
                    activeEndtime: [
                        { validator: validateActiveEndtime }
                    ],
                    loanStartime: [
                        { validator: validateLoanStartime }
                    ],
                    loanEndtime: [
                        { validator: validateLoanEndtime }
                    ],
                    avtiveCriterion: [
                        { validator: validateAvtiveCriterion }
                    ],
                    expectedCount: [
                        { validator: validateExpectedCount }
                    ],
                    additionAmtBegin: [
                        { validator: validateAdditionAmtBegin }
                    ],
                    additionAmtEnd: [
                        { validator: validateAdditionAmtEnd }
                    ],
                    remark: [
                        { validator: validateRemark }
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
                loading: ({activeReviewProEdit}) => activeReviewProEdit.loading,
                activeReviewProEditData: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditData,
                activeReviewProEditMainData: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditMainData,
                activeReviewProEditCarData: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditCarData,
                activeReviewProEditAreaListData: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditAreaListData,
                activeReviewProEditProvinceListData: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditProvinceListData,
                activeReviewProEditCityListData: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditCityListData,
                activeReviewProEditBrandsListData: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditBrandsListData,
                activeReviewProEditSeriesListData: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditSeriesListData,
                activeReviewProEditModerListData: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditModerListData,
                activeReviewProEditAllProductListData: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditAllProductListData,
                activeReviewProEditAddData: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditAddData,
                activeReviewProEditMsg: ({activeReviewProEdit}) => activeReviewProEdit.activeReviewProEditMsg,
                modelList: ({activeReviewProEdit}) => activeReviewProEdit.modelList,
                seriesList: ({activeReviewProEdit}) => activeReviewProEdit.seriesList,
                isSuccess: ({activeReviewProEdit}) => activeReviewProEdit.isSuccess
            })
        },
        methods: {
            ...mapActions([
                'handelQueryActiveReviewProEditById',
                'handelActiveReviewProEditProvinceList',
                'handelActiveReviewProEditCityList',
                'handelActiveReviewProEditAreaList',
                'handelActiveReviewProEditBrandsList',
                'handelActiveReviewProEditSeriesList',
                'handelActiveReviewProEditModerList',
                'handelQuerySubBrands',
                'handelQueryCarModel',
                'handelActiveReviewToSubmit',
                'handelActiveReviewProEditAllProductList'
            ]),
            init () {
                this.queryActiveAreaList();
                this.queryActiveProvinceList();
                this.queryActiveBrandsList();
                this.showActiveProductList();
                this.queryActiveReviewProEditById(this.$route.query.id);
                resetWorkHeight();
            },
            queryActiveReviewProEditById (data) {
                // console.log(data)
                this.handelQueryActiveReviewProEditById(data).then(res => {
                    // console.log(this.activeReviewProEditMainData);
                    this.judgmentInputFlag();
                    this.showActiveProduct();
                    this.judgmentAdditionFlag();
                    this.showBrandsCode();
                    resetWorkHeight();
                });
            },
            /**
             * 判断是否附加贷
             */
            judgmentAdditionFlag () {
                const addFlag = this.activeReviewProEditData.ativeMain.additionFlag;
                var additionals = [];
                if (addFlag === '0') {
                    this.showFlag.additionFlag = false;
                } else {
                    this.showFlag.additionFlag = true;
                    // console.log(this.activeReviewProEditAddData)
                    if (!isEmpty(this.activeReviewProEditAddData.additionalCode)) {
                        additionals = this.activeReviewProEditAddData.additionalCode.split(',');
                        this.additionalList = additionals;
                    }
                }
            },
            /**
             * 判断是显示区域或经销商
             * @param inputDeale
             */
            judgmentInputFlag () {
                const inputDeale = this.activeReviewProEditMainData.inputDeale;
                if (inputDeale === '1') {
                    this.showFlag.dealerFlag = true;
                    this.showFlag.areaFlag = false;
                    this.showDealers();
                } else if (inputDeale === '0') {
                    this.showFlag.dealerFlag = false;
                    this.showFlag.areaFlag = true;
                    this.judgmentInputAreaFlag();
                }
            },
            showDealers () {
                this.ativeDealersList = this.activeReviewProEditData.ativeDealeList;
            },
            judgmentInputAreaFlag () {
                if (this.activeReviewProEditData.ativeMain.inputArea === '1') { // 区域
                    this.showFlag.areaRow = true;
                    this.showFlag.cityRow = false;
                    this.queryActiveArea();
                } else { // 省市
                    this.showFlag.areaRow = false;
                    this.showFlag.cityRow = true;
                    this.queryActiveProvince();
                }
            },
            loadingSubBrands (data) {
                this.handelQuerySubBrands(data).then(res => {
                });
            },
            loadingCarModels (data) {
                var subBrandSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        subBrandSelected.push('00');
                        this.subBrandCodeList = subBrandSelected;
                        break;
                    }
                }
                resetWorkHeight();
                this.handelQueryCarModel(data).then(res => {
                });
            },
            filterCarModels (data) {
                var carModelsSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        carModelsSelected.push('00');
                        this.carModelsCodeList = carModelsSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            showBrandsCode () {
                this.brandsCodeList = this.activeReviewProEditData.activeCar.brandsCode;
                var subBrandsArr = [];
                if (!isEmpty(this.activeReviewProEditData.activeCar.seriesCode)) {
                    subBrandsArr = this.activeReviewProEditData.activeCar.seriesCode.split(',');
                    // console.log(carSeries)
                    this.subBrandCodeList = subBrandsArr;
                };
                var carModelsArr = [];
                if (!isEmpty(this.activeReviewProEditData.activeCar.moderCode)) {
                    carModelsArr = this.activeReviewProEditData.activeCar.moderCode.split(',');
                    // console.log(carSeries)
                    this.carModelsCodeList = carModelsArr;
                }
            },
            /**
             * 初始化查询区域
             * @param name
             */
            queryActiveAreaList () {
                this.handelActiveReviewProEditAreaList().then(res => {
                });
            },
            /**
             * 回显区域
             */
            queryActiveArea () {
                if (!isEmpty(this.activeReviewProEditData.activeArea)) {
                    console.log(this.activeReviewProEditData.activeArea.areaCode)
                    const areaData = this.activeReviewProEditData.activeArea.areaCode;
                    if (!isEmpty(areaData)) {
                        var areas = [];
                        areas = areaData.split(',');
                        this.areasList = areas;
                    }
                }
            },
            /**
             * 展示省
             * @param name
             */
            queryActiveProvinceList () {
                this.handelActiveReviewProEditProvinceList().then(res => {
                });
            },
            /**
             * 回显省份
             */
            queryActiveProvince () {
                var provienceArr = [];
                var provienceList = [];
                console.log(this.activeReviewProEditData.activeArea)
                if (!isEmpty(this.activeReviewProEditData.activeArea.provinceCode)) {
                    provienceArr = this.activeReviewProEditData.activeArea.provinceCode.split(',');
                    this.proviencesList = provienceArr;
                    // console.log(provienceArr)
                    for (var i = 0; i < provienceArr.length; i++) {
                        provienceList.push(provienceArr);
                    }
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
                    this.handelActiveReviewProEditCityList(data).then(res => {
                    });
                }
            },
            /**
             * 展示市
             * @param name
             */
            queryActiveCity () {
                var citys = [];
                if (!isEmpty(this.activeReviewProEditData.activeArea.cityCode)) {
                    citys = this.activeReviewProEditData.activeArea.cityCode.split(',');
                    this.citysList = citys;
                }
            },
            /**
             * 加载品牌
             */
            queryActiveBrandsList () {
                this.handelActiveReviewProEditBrandsList().then(res => {
                });
            },
            /**
             * 加载所有活动产品
             */
            showActiveProductList () {
                this.handelActiveReviewProEditAllProductList().then(res => {
                });
            },
            /**
             * 展示活动产品
             */
            showActiveProduct () {
                var businessCodes = [];
                var marketingCodes = [];
                businessCodes = this.activeReviewProEditData.activeBusiness.businessCode.split(',');
                this.businessCodeList = businessCodes;

                marketingCodes = this.activeReviewProEditData.activeMarketing.marketingCode.split(',');
                this.marketingCodeList = marketingCodes;
                this.showActiveProList();
            },
            /**
             * 金融产品修改
             */
            changeFinanceProd (data) {
                // this.financeProdCodeList = data;
                var financeSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        financeSelected.push('00');
                        this.financeProdCodeList = financeSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            /**
             * 信贷产品修改
             */
            changeCreditProd (data) {
                var creditSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        creditSelected.push('00');
                        this.creditProdCodeList = creditSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            /**
             * 业务模式修改
             */
            changeBusiness (data) {
                var businessSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        businessSelected.push('00');
                        this.businessCodeList = businessSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            /**
             * 营销活动修改
             */
            changeMarketing (data) {
                var marketingSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        marketingSelected.push('00');
                        this.marketingCodeList = marketingSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            /**
             * 附加贷修改
             */
            filterAdditionalProd (data) {
                var additionalSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        additionalSelected.push('00');
                        this.additionalList = additionalSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            /**
             * 显示金融信贷产品
             */
            showActiveProList () {
                var financeProdCodes = [];
                var creditProdCodes = [];
                const length = this.activeReviewProEditData.activeProdList.length;
                if (length > 0) {
                    for (var i = 0; i < length; i++) {
                        if (this.activeReviewProEditData.activeProdList[i].prodType === '01') { // 金融产品
                            financeProdCodes = this.activeReviewProEditData.activeProdList[i].prodCode.split(',');
                            this.financeProdCodeList = financeProdCodes;
                        } else { // 信贷产品
                            creditProdCodes = this.activeReviewProEditData.activeProdList[i].prodCode.split(',');
                            this.creditProdCodeList = creditProdCodes;
                        }
                    }
                }
            },
            /**
             * 附件链接
             */
            btn_add_appendix () {
                window.open('http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>' + this.activeReviewProEditData.ativeMain.additionalId + '</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >');
            },
            /**
             * 经销商导入
             */
            handleUpload (file) {
                this.file = file;
                return true;
            },
            uploadSuccess (res, file) {
                this.ativeDealersList = res.result;
                this.file = null;
                setTimeout(function () {
                    resetWorkHeight();
                }, 1500);
            },
            downloadTemplet () {
                window.location = '/mkmm/sales/activeDealerReviews/downloadTemplate';
            },
            /**
             * 加载城市
             */
            loadingCities (data) {
                var provinceSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        provinceSelected.push('00');
                        this.proviencesList = provinceSelected;
                        break;
                    }
                }
                resetWorkHeight();
                this.handelActiveReviewProEditCityList(data).then(res => {
                });
            },
            /**
             * 显示区域
             */
            filterArea (data) {
                var areaSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        areaSelected.push('00');
                        this.areasList = areaSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            /**
             * 显示城市
             */
            filterCity (data) {
                var citySelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        citySelected.push('00');
                        this.citysList = citySelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            /**
             * 提交审核
             */
            activeReviewSub (name) { // 提交审核
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.activeReviewProEditData.activeAdditional.additionalCode = this.additionalList.join(',');
                        this.activeReviewProEditData.activeCar.brandsCode = this.brandsCodeList;
                        this.activeReviewProEditData.activeCar.seriesCode = this.subBrandCodeList.join(',');
                        this.activeReviewProEditData.activeCar.moderCode = this.carModelsCodeList.join(',');
                        for (var i = 0; i < this.activeReviewProEditData.activeProdList.length; i++) {
                            if (this.activeReviewProEditData.activeProdList[i].prodType === '01') { // 金融产品
                                this.activeReviewProEditData.activeProdList[i].prodCode = this.financeProdCodeList.join(',');
                            } else if (this.activeReviewProEditData.activeProdList[i].prodType === '02') {
                                this.activeReviewProEditData.activeProdList[i].prodCode = this.creditProdCodeList.join(',');
                            }
                        }
                        this.activeReviewProEditData.activeMarketing.businessCode = this.businessCodeList.join(',');
                        this.activeReviewProEditData.activeMarketing.marketingCode = this.marketingCodeList.join(',');
                        this.activeReviewProEditData.activeArea.areaCode = this.areasList.join(',');
                        this.activeReviewProEditData.activeArea.cityCode = this.citysList.join(',');
                        this.activeReviewProEditData.activeArea.provinceCode = this.proviencesList.join(',');
                        console.log(this.activeReviewProEditData);// 此数据提交
                        console.log('join shenhe');
                        this.handelActiveReviewToSubmit(this.activeReviewProEditData).then(res => {
                            if (this.isSuccess) {
                                this.$Modal.success({
                                    title: '提交审核',
                                    content: this.activeReviewProEditMsg,
                                    onOk: () => {
                                        this.$router.push({name: 'activeReviewProgressList'});
                                    }
                                });
                            } else {
                                this.$Modal.error({
                                    title: '提交审核',
                                    content: this.activeReviewProEditMsg,
                                    onOk: () => {
                                        this.$router.push({name: 'activeReviewProgressList'});
                                    }
                                });
                            }
                        });
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            },
            changeOpin () {
                if (this.activeReviewProEditData.reviewStatus === '04') {
                    this.activeReviewProEditData.opinion = '同意';
                } else {
                    this.activeReviewProEditData.opinion = '';
                }
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