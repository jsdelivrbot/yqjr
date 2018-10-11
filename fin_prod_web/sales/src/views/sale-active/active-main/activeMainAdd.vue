<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="activeMainData" :rules="ruleValidate" :model="activeMainData" :label-width="140">
            <Card>
                <p slot="title">
                    <Icon type="edit"></Icon>
                    新增
                </p>
                <a href="#" slot="extra" @click.prevent="goBack">
                    <Icon type="arrow-return-left"></Icon>
                    返回
                </a>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="归属区域名称：">
                            <Input readonly v-model="activeMainData.ativeMain.areaName"/>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem required label="活动名称：" prop="activeName">
                            <Input v-model="activeMainData.ativeMain.activeName" :maxlength="32"/>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem required label="首付比例(%)：">
                            <Col span="11">
                                <FormItem prop="patmentBegin">
                                    <Input v-model="activeMainData.ativeMain.patmentBegin" :maxlength="10" style="width: 100%"></Input>
                                </FormItem>
                            </Col>
                            <Col span="2" style="text-align: center">-</Col>
                            <Col span="11">
                                <FormItem prop="patmentEnd">
                                    <Input v-model="activeMainData.ativeMain.patmentEnd" :maxlength="10" style="width: 100%"></Input>
                                </FormItem>
                            </Col>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem required label="贷款金额(元)：">
                            <Col span="11">
                                <FormItem prop="loanAmtBegin">
                                    <Input v-model="activeMainData.ativeMain.loanAmtBegin" :maxlength="14" style="width: 100%"></Input>
                                </FormItem>
                            </Col>
                            <Col span="2" style="text-align: center">-</Col>
                            <Col span="11">
                                <FormItem prop="loanAmtEnd">
                                    <Input v-model="activeMainData.ativeMain.loanAmtEnd" :maxlength="14" style="width: 100%"></Input>
                                </FormItem>
                            </Col>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem required label="贷款期限(月)：">
                            <Col span="11">
                                <FormItem prop="loanTermBegin">
                                    <Input v-model="activeMainData.ativeMain.loanTermBegin" :maxlength="10" style="width: 100%"></Input>
                                </FormItem>
                            </Col>
                            <Col span="2" style="text-align: center">-</Col>
                            <Col span="11">
                                <FormItem prop="loanTermEnd">
                                    <Input v-model="activeMainData.ativeMain.loanTermEnd" :maxlength="10" style="width: 100%"></Input>
                                </FormItem>
                            </Col>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem required label="受理开始日期：" prop="activeStartime">
                            <DatePicker type="date" v-model="activeMainData.ativeMain.activeStartime" placeholder="请输入受理开始日期" clearable style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem required label="受理截止日期:" prop="activeEndtime">
                            <DatePicker type="date" v-model="activeMainData.ativeMain.activeEndtime" placeholder="请输入受理截止日期" clearable style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem required label="放款开始日期：" prop="loanStartime">
                            <DatePicker type="date" v-model="activeMainData.ativeMain.loanStartime" placeholder="请输入受理开始日期" clearable style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem required label="放款截止日期：" prop="loanEndtime">
                            <DatePicker type="date" v-model="activeMainData.ativeMain.loanEndtime" placeholder="请输入受理截止日期" clearable style="width: 100%"></DatePicker>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="车籍：">
                            <Select v-model="activeMainData.ativeMain.carReg" style="width:100%">
                                <Option value="00">全部</Option>
                                <Option value="01">法人</Option>
                                <Option value="02">自然人</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem required label="促销活动激励标准：" prop="avtiveCriterion">
                            <Input v-model="activeMainData.ativeMain.avtiveCriterion" :maxlength="14" style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem required label="预计活动笔数：" prop="expectedCount">
                            <Input v-model="activeMainData.ativeMain.expectedCount" :maxlength="14" style="width: 100%"></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="经销商导入：">
                            <Select v-model="activeMainData.ativeMain.inputDeale" style="width:100%">
                                <Option value="1">是</Option>
                                <Option value="0">否</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-if="activeMainData.ativeMain.inputDeale == '1'">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    经销商信息
                </p>
                <Row style="margin-bottom: 10px;">
                    <Col span="9" offset="3">
                        <Upload
                                :before-upload="handleUpload"
                                :on-success="uploadSuccess"
                                :show-upload-list="false"
                                action="/mkmm/sales/activeDealerReviews/fileUpLoad">
                            <Button type="success" icon="ios-cloud-upload-outline">请选择文件</Button>
                        </Upload>
                    </Col>
                    <Col span="8">
                        <Button type="info" icon="ios-cloud-download-outline" @click="downloadTemplet" style="float:right;">下载模板</Button>
                    </Col>
                </Row>
                <Row>
                    <Col span="17" offset="3">
                        <Table style="width:100%;" :columns="dealerColumns" :data="activeMainData.ativeDealeList" size="small"></Table>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10" v-if="activeMainData.ativeMain.inputDeale == '0'">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    区域信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="活动范围：">
                            <Select v-model="activeMainData.ativeMain.inputArea" style="width:100%">
                                <Option value="1">区域</Option>
                                <Option value="0">省市</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-if="activeMainData.ativeMain.inputArea == '1'">
                    <Col span="18" offset="2">
                        <FormItem label="活动区域：">
                            <Select v-model="relateList.relateAreaCode" multiple @on-change="filterArea" style="width:100%">
                                <Option v-for="item in areaList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-if="activeMainData.ativeMain.inputArea == '0'">
                    <Col span="18" offset="2">
                        <FormItem label="活动省份：">
                            <Select v-model="relateList.relateProvinceCode" multiple @on-change="loadingCities" style="width:100%">
                                <Option v-for="item in provinceList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-if="activeMainData.ativeMain.inputArea == '0'">
                    <Col span="18" offset="2">
                        <FormItem label="活动城市：">
                            <Select v-model="relateList.relateCityCode" multiple @on-change="filterCity" style="width:100%">
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="edit"></Icon>
                    品牌信息
                </p>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem required label="活动品牌：">
                            <Select v-model="activeMainData.activeCar.brandsCode" label-in-value @on-change="loadingSubBrands" style="width:100%">
                                <Option v-for="item in brandList" :value="item.value" :key="item.value" :label="item.label">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="活动子品牌：">
                            <Select v-model="relateList.relateSeriesCode" multiple @on-change="loadingCarModels" style="width:100%">
                                <Option v-for="item in seriesList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="活动车型：">
                            <Select v-model="relateList.relateModerCode" multiple @on-change="filterCarModels" style="width:100%">
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
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="金融产品：">
                            <Select v-model="relateList.relateFinanceProdCode" multiple @on-change="filterFinanceProd" style="width:100%">
                                <Option v-for="item in financeCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="业务模式：">
                            <Select v-model="relateList.relateBusinessCode" multiple @on-change="filterBusinessProd" style="width:100%">
                                <Option v-for="item in businessCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="信贷产品：">
                            <Select v-model="relateList.relateCreditProdCode" multiple @on-change="filterCreditProd" style="width:100%">
                                <Option v-for="item in creditCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="营销活动：">
                            <Select v-model="relateList.relateMarketingCode" multiple @on-change="filterMarketingProd" style="width:100%">
                                <Option v-for="item in marketingCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="6" offset="2">
                        <FormItem label="附加贷：">
                            <Select v-model="activeMainData.ativeMain.additionFlag" style="width:100%">
                                <Option value="0">否</Option>
                                <Option value="1">是</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="10" offset="2" v-if="activeMainData.ativeMain.additionFlag == '1'">
                        <FormItem required label="附加贷金额：">
                            <Col span="11">
                                <FormItem prop="additionAmtBegin">
                                     <Input v-model="activeMainData.ativeMain.additionAmtBegin" :maxlength="14" style="width: 100%"></Input>
                                </FormItem>
                            </Col>
                            <Col span="2" style="text-align: center">-</Col>
                            <Col span="11">
                                <FormItem prop="additionAmtEnd">
                                    <Input v-model="activeMainData.ativeMain.additionAmtEnd" :maxlength="14" style="width: 100%"></Input>
                                 </FormItem>
                            </Col>
                        </FormItem>
                    </Col>
                </Row>
                <Row v-if="activeMainData.ativeMain.additionFlag == '1'">
                    <Col span="18" offset="2">
                        <FormItem label="附加贷子项：">
                            <Select v-model="relateList.relateAdditionalCode" multiple @on-change="filterAdditionalProd" style="width:100%">
                                <Option v-for="item in additionalCodes" :value="item.value" :key="item.value">{{ item.label }}</Option>
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
                    <Col span="10" offset="2">
                        <FormItem label="附件列表：">
                            <Button type="success" @click="addAppendix">添加附件</Button>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem required label="备注：" prop="remark">
                            <Input v-model="activeMainData.ativeMain.remark" :maxlength="265" type="textarea" :autosize="{minRows: 2,maxRows: 6}" placeholder="请输入备注信息"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" :loading="loading" icon="checkmark" @click="addActiveSubmit('activeMainData')">提交审核</Button>
                    </Col>
                    <Col span="4">
                        <Button type="primary" icon="reply" @click="goBack">返回</Button>
                    </Col>
                </Row>
            </Card>
        </Form>
    </div>
</template>
<script>
    import {mapActions, mapState} from 'vuex';
    import {resetWorkHeight, isEmpty, formatDate, getUserCookie} from '@/libs/util.js';
    export default {
        name: 'activeMainAdd',
        data: function () {
            const validateActiveName = (rule, value, callback) => {
                if (isEmpty(this.activeMainData.ativeMain.activeName)) {
                    callback(new Error('请输入活动名称'));
                }
                callback();
            };
            const validatePatmentBegin = (rule, value, callback) => {
                var reg = /^\d+(\.\d+)?$/;
                if (isEmpty(this.activeMainData.ativeMain.patmentBegin)) {
                    callback(new Error('起始比例不能为空'));
                } else if (!reg.test(this.activeMainData.ativeMain.patmentBegin)) {
                    callback(new Error('起始比例必须为数字'));
                } else if (this.activeMainData.ativeMain.patmentBegin > 100) {
                    callback(new Error('起始比例不能大于100'));
                }
                if (!isEmpty(this.activeMainData.ativeMain.patmentBegin) && !isEmpty(this.activeMainData.ativeMain.patmentEnd)) {
                    if (parseInt(this.activeMainData.ativeMain.patmentBegin) > parseInt(this.activeMainData.ativeMain.patmentEnd)) {
                        callback(new Error('起始不能大于结束'));
                    }
                }
                callback();
            };
            const validatePatmentEnd = (rule, value, callback) => {
                var reg = /^\d+(\.\d+)?$/;
                if (isEmpty(this.activeMainData.ativeMain.patmentEnd)) {
                    callback(new Error('结束比例不能为空'));
                } else if (!reg.test(this.activeMainData.ativeMain.patmentEnd)) {
                    callback(new Error('结束比例必须为数字'));
                } else if (this.activeMainData.ativeMain.patmentEnd > 100) {
                    callback(new Error('结束比例不能大于100'));
                }
                if (!isEmpty(this.activeMainData.ativeMain.patmentBegin) && !isEmpty(this.activeMainData.ativeMain.patmentEnd)) {
                    if (parseInt(this.activeMainData.ativeMain.patmentBegin) > parseInt(this.activeMainData.ativeMain.patmentEnd)) {
                        callback(new Error('起始不能大于结束'));
                    }
                }
                callback();
            };
            const validateLoanAmtBegin = (rule, value, callback) => {
                var reg = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
                if (isEmpty(this.activeMainData.ativeMain.loanAmtBegin)) {
                    callback(new Error('起始不能为空'));
                } else if (!reg.test(this.activeMainData.ativeMain.loanAmtBegin)) {
                    callback(new Error('应为数字且最多两位小数'));
                }
                if (!isEmpty(this.activeMainData.ativeMain.loanAmtBegin) && !isEmpty(this.activeMainData.ativeMain.loanAmtEnd)) {
                    if (parseInt(this.activeMainData.ativeMain.loanAmtBegin) > parseInt(this.activeMainData.ativeMain.loanAmtEnd)) {
                        callback(new Error('起始不能大于结束'));
                    }
                }
                callback();
            };
            const validateLoanAmtEnd = (rule, value, callback) => {
                var reg = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
                if (isEmpty(this.activeMainData.ativeMain.loanAmtEnd)) {
                    callback(new Error('结束不能为空'));
                } else if (!reg.test(this.activeMainData.ativeMain.loanAmtEnd)) {
                    callback(new Error('应为数字且最多两位小数'));
                }
                if (!isEmpty(this.activeMainData.ativeMain.loanAmtBegin) && !isEmpty(this.activeMainData.ativeMain.loanAmtEnd)) {
                    if (parseInt(this.activeMainData.ativeMain.loanAmtBegin) > parseInt(this.activeMainData.ativeMain.loanAmtEnd)) {
                        callback(new Error('起始不能大于结束'));
                    }
                }
                callback();
            };
            const validateLoanTermBegin = (rule, value, callback) => {
                var reg = /^[0-9]*[1-9][0-9]*$/;
                if (isEmpty(this.activeMainData.ativeMain.loanTermBegin)) {
                    callback(new Error('起始不能为空'));
                } else if (!reg.test(this.activeMainData.ativeMain.loanTermBegin)) {
                    callback(new Error('应为正整数'));
                }
                if (!isEmpty(this.activeMainData.ativeMain.loanTermBegin) && !isEmpty(this.activeMainData.ativeMain.loanTermEnd)) {
                    if (parseInt(this.activeMainData.ativeMain.loanTermBegin) > parseInt(this.activeMainData.ativeMain.loanTermEnd)) {
                        callback(new Error('起始不能大于终止'));
                    }
                }
                callback();
            };
            const validateLoanTermEnd = (rule, value, callback) => {
                var reg = /^[0-9]*[1-9][0-9]*$/;
                if (isEmpty(this.activeMainData.ativeMain.loanTermEnd)) {
                    callback(new Error('结束不能为空'));
                } else if (!reg.test(this.activeMainData.ativeMain.loanTermEnd)) {
                    callback(new Error('应为正整数'));
                }
                if (!isEmpty(this.activeMainData.ativeMain.loanTermBegin) && !isEmpty(this.activeMainData.ativeMain.loanTermEnd)) {
                    if (parseInt(this.activeMainData.ativeMain.loanTermBegin) > parseInt(this.activeMainData.ativeMain.loanTermEnd)) {
                        callback(new Error('起始不能大于结束'));
                    }
                }
                callback();
            };
            const validateActiveStartime = (rule, value, callback) => {
                if (isEmpty(this.activeMainData.ativeMain.activeStartime)) {
                    callback(new Error('受理开始日期不能为空'));
                } else if (formatDate(this.activeMainData.ativeMain.activeStartime, 'yyyy-MM-dd') < formatDate(new Date(), 'yyyy-MM-dd')) {
                    callback(new Error('受理开始日期不能小于今天'));
                } else if (!isEmpty(this.activeMainData.ativeMain.activeEndtime) && formatDate(this.activeMainData.ativeMain.activeEndtime, 'yyyy-MM-dd') <= formatDate(this.activeMainData.ativeMain.activeStartime, 'yyyy-MM-dd')) {
                    callback(new Error('受理截止日期必须大于受理开始时间'));
                } else if (!isEmpty(this.activeMainData.ativeMain.loanStartime) && formatDate(this.activeMainData.ativeMain.loanStartime, 'yyyy-MM-dd') <= formatDate(this.activeMainData.ativeMain.activeStartime, 'yyyy-MM-dd')) {
                    callback(new Error('受理开始日期必须小于放款开始日期'));
                }
                callback();
            };
            const validateActiveEndtime = (rule, value, callback) => {
                if (isEmpty(this.activeMainData.ativeMain.activeStartime)) {
                    callback(new Error('请先选择受理开始日期'));
                }
                if (isEmpty(this.activeMainData.ativeMain.activeEndtime)) {
                    callback(new Error('受理截止日期不能为空'));
                } else if (formatDate(this.activeMainData.ativeMain.activeEndtime, 'yyyy-MM-dd') <= formatDate(this.activeMainData.ativeMain.activeStartime, 'yyyy-MM-dd')) {
                    callback(new Error('受理截止日期必须大于受理开始时间'));
                }
                callback();
            };
            const validateLoanStartime = (rule, value, callback) => {
                if (isEmpty(this.activeMainData.ativeMain.activeStartime)) {
                    callback(new Error('请先选择受理开始日期'));
                }
                if (isEmpty(this.activeMainData.ativeMain.loanStartime)) {
                    callback(new Error('放款开始日期不能为空'));
                } else if (formatDate(this.activeMainData.ativeMain.loanStartime, 'yyyy-MM-dd') <= formatDate(this.activeMainData.ativeMain.activeStartime, 'yyyy-MM-dd')) {
                    callback(new Error('放款开始日期不能小于受理开始日期'));
                } else if (!isEmpty(this.activeMainData.ativeMain.loanEndtime) && formatDate(this.activeMainData.ativeMain.loanEndtime, 'yyyy-MM-dd') <= formatDate(this.activeMainData.ativeMain.loanStartime, 'yyyy-MM-dd')) {
                    callback(new Error('放款截止日期必须大于放款开始日期'));
                }
                callback();
            };
            const validateLoanEndtime = (rule, value, callback) => {
                if (isEmpty(this.activeMainData.ativeMain.loanStartime)) {
                    callback(new Error('请先选择放款开始日期'));
                }
                if (isEmpty(this.activeMainData.ativeMain.loanEndtime)) {
                    callback(new Error('放款截止日期不能为空'));
                } else if (formatDate(this.activeMainData.ativeMain.loanEndtime, 'yyyy-MM-dd') <= formatDate(this.activeMainData.ativeMain.loanStartime, 'yyyy-MM-dd')) {
                    callback(new Error('放款截止日期必须大于放款开始日期'));
                }
                callback();
            };
            const validateAvtiveCriterion = (rule, value, callback) => {
                var reg = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
                if (isEmpty(this.activeMainData.ativeMain.avtiveCriterion)) {
                    callback(new Error('激励标准不能为空'));
                } else if (!reg.test(this.activeMainData.ativeMain.avtiveCriterion)) {
                    callback(new Error('激励标准须为数字,最多保留两位小数'));
                }
                callback();
            };
            const validateExpectedCount = (rule, value, callback) => {
                var reg = /^[0-9]*[1-9][0-9]*$/;
                if (isEmpty(this.activeMainData.ativeMain.expectedCount)) {
                    callback(new Error('预计活动笔数不能为空'));
                } else if (!reg.test(this.activeMainData.ativeMain.expectedCount)) {
                    callback(new Error('预计活动笔数应为正整数'));
                }
                callback();
            };
            const validateAdditionAmtBegin = (rule, value, callback) => {
                var reg = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
                if (isEmpty(this.activeMainData.ativeMain.additionAmtBegin)) {
                    callback(new Error('请输入附加贷起始金额'));
                } else if (!reg.test(this.activeMainData.ativeMain.additionAmtBegin)) {
                    callback(new Error('应为数字,最多两位小数'));
                }
                if (parseInt(this.activeMainData.ativeMain.additionAmtBegin) > parseInt(this.activeMainData.ativeMain.additionAmtEnd)) {
                    callback(new Error('附加贷起始不能大于终止'));
                }
                callback();
            };
            const validateAdditionAmtEnd = (rule, value, callback) => {
                var reg = /^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/;
                if (isEmpty(this.activeMainData.ativeMain.additionAmtEnd)) {
                    callback(new Error('请录入附加贷结束金额'));
                } else if (!reg.test(this.activeMainData.ativeMain.additionAmtEnd)) {
                    callback(new Error('应为数字,最多两位小数'));
                }
                if (parseInt(this.activeMainData.ativeMain.additionAmtBegin) > parseInt(this.activeMainData.ativeMain.additionAmtEnd)) {
                    callback(new Error('附加贷起始不能大于结束'));
                }
                callback();
            };
            const validateRemark = (rule, value, callback) => {
                if (isEmpty(this.activeMainData.ativeMain.remark)) {
                    callback(new Error('请输入备注信息'));
                }
                callback();
            };
            return {
                loadingStatus: false,
                file: null,
                resultModal: false,
                activeModelStyle: {
                    top: 500 + 'px'
                },
                dealerColumns: [
                    {
                        title: '经销商代码',
                        key: 'dealerCode',
                        align: 'center'
                    },
                    {
                        title: '经销商名称',
                        key: 'dealerName',
                        align: 'center'
                    },
                    {
                        title: '活动上限/辆',
                        align: 'center',
                        key: 'activeNumber'
                    }
                ],
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
                excelFileName: '促销活动新增'
            };
        },
        computed: {
            ...mapState({
                loading: ({activeMainAdd}) => activeMainAdd.loading,
                activeMainData: ({activeMainAdd}) => activeMainAdd.activeMainData,
                areaList: ({activeMainAdd}) => activeMainAdd.areaList,
                provinceList: ({activeMainAdd}) => activeMainAdd.provinceList,
                cityList: ({activeMainAdd}) => activeMainAdd.cityList,
                brandList: ({activeMainAdd}) => activeMainAdd.brandList,
                seriesList: ({activeMainAdd}) => activeMainAdd.seriesList,
                modelList: ({activeMainAdd}) => activeMainAdd.modelList,
                additionalCodes: ({activeMainAdd}) => activeMainAdd.additionalCodes,
                businessCodes: ({activeMainAdd}) => activeMainAdd.businessCodes,
                creditCodes: ({activeMainAdd}) => activeMainAdd.creditCodes,
                financeCodes: ({activeMainAdd}) => activeMainAdd.financeCodes,
                marketingCodes: ({activeMainAdd}) => activeMainAdd.marketingCodes,
                relateList: ({activeMainAdd}) => activeMainAdd.relateList,
                submitResult: ({activeMainAdd}) => activeMainAdd.submitResult
            })
        },
        methods: {
            ...mapActions([
                'getProductAll',
                'getOptionArea',
                'getOptionProvince',
                'getOptionCity',
                'getOptionBrand',
                'getOptionSubBrand',
                'getOptionCarModel',
                'handleActiveMainCheck',
                'handleActiveMainAdd',
                'handleResetActiveMainData'
            ]),
            init () {
                resetWorkHeight();
                this.loadingProductAll();
                this.loadingAreas();
                this.loadingProvinces();
                this.loadingBrands();
                this.generateRandomId();
                this.getCookieInfo();
            },
            goBack () {
                this.$router.push({name: 'activeMainList'});
            },
            handleUpload (file) {
                this.file = file;
                return true;
            },
            uploadSuccess (res, file) {
                this.activeMainData.ativeDealeList = res.result;
                this.file = null;
                setTimeout(function () {
                    resetWorkHeight();
                }, 1500);
            },
            addAppendix () {
                const appendixId = this.activeMainData.ativeMain.additionalId;
                window.open('http://gfimg.faf.com.cn:9080/afImg/imageBasic/ImageBasicAction.do?method=showMainFrame&paraInfo=<USER_CODE>1</USER_CODE><APP_CODE>sett_counter</APP_CODE><BUSI_NO>' + appendixId + '</BUSI_NO><is_scan>1</is_scan><is_import>1</is_import><is_delete>1</is_delete><is_modifyname>0</is_modifyname >');
            },
            downloadTemplet () {
                window.location = '/mkmm/sales/activeDealerReviews/downloadTemplate';
            },
            loadingProductAll () {
                this.getProductAll().then(res => {
                });
            },
            loadingProvinces () {
                this.getOptionProvince().then(res => {
                });
            },
            loadingCities (data) {
                var provinceSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        provinceSelected.push('00');
                        this.relateList.relateProvinceCode = provinceSelected;
                        break;
                    }
                }
                resetWorkHeight();
                this.getOptionCity(data).then(res => {
                });
            },
            filterArea (data) {
                var areaSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        areaSelected.push('00');
                        this.relateList.relateAreaCode = areaSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            filterCity (data) {
                var citySelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        citySelected.push('00');
                        this.relateList.relateCityCode = citySelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            loadingAreas () {
                this.getOptionArea().then(res => {
                });
            },
            loadingBrands () {
                this.getOptionBrand().then(res => {
                });
            },
            loadingSubBrands (data) {
                this.activeMainData.activeCar.brandsName = data.label;
                this.getOptionSubBrand(data).then(res => {
                });
            },
            loadingCarModels (data) {
                var subBrandSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        subBrandSelected.push('00');
                        this.relateList.relateSeriesCode = subBrandSelected;
                        break;
                    }
                }
                resetWorkHeight();
                this.getOptionCarModel(data).then(res => {
                });
            },
            filterCarModels (data) {
                var carModelsSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        carModelsSelected.push('00');
                        this.relateList.relateModerCode = carModelsSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            filterFinanceProd (data) {
                var financeSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        financeSelected.push('00');
                        this.relateList.relateFinanceProdCode = financeSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            filterBusinessProd (data) {
                var businessSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        businessSelected.push('00');
                        this.relateList.relateBusinessCode = businessSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            filterCreditProd (data) {
                var creditSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        creditSelected.push('00');
                        this.relateList.relateCreditProdCode = creditSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            filterMarketingProd (data) {
                var marketingSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        marketingSelected.push('00');
                        this.relateList.relateMarketingCode = marketingSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            filterAdditionalProd (data) {
                var additionalSelected = [];
                for (var i = 0; i < data.length; i++) {
                    if (data[i] === '00' && data.length > 1) {
                        additionalSelected.push('00');
                        this.relateList.relateAdditionalCode = additionalSelected;
                        break;
                    }
                }
                resetWorkHeight();
            },
            generateRandomId () {
                this.activeMainData.ativeMain.additionalId = (Math.random() * 10000000).toString(16).substr(0, 4) + '-' + (new Date()).getTime() + '-' + Math.random().toString().substr(2, 5);
            },
            addActiveSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        if (this.activeMainData.ativeMain.inputDeale === '1') {
                            const dealerResult = this.validateDealer();
                            if (dealerResult !== '') {
                                this.$Message.error(dealerResult);
                                return null;
                            }
                        } else if (this.activeMainData.ativeMain.inputDeale === '0') {
                            const areaResult = this.validateArea();
                            if (areaResult !== '') {
                                this.$Message.error(areaResult);
                                return null;
                            }
                        };
                        if (this.activeMainData.activeCar.brandsCode === '') {
                            this.$Message.error('活动品牌不能为空！');
                            return null;
                        } else {
                            this.activeMainData.ativeMain.activeStartime = formatDate(this.activeMainData.ativeMain.activeStartime, 'yyyy-MM-dd');
                            this.activeMainData.ativeMain.activeEndtime = formatDate(this.activeMainData.ativeMain.activeEndtime, 'yyyy-MM-dd');
                            this.activeMainData.ativeMain.loanStartime = formatDate(this.activeMainData.ativeMain.loanStartime, 'yyyy-MM-dd');
                            this.activeMainData.ativeMain.loanEndtime = formatDate(this.activeMainData.ativeMain.loanEndtime, 'yyyy-MM-dd');
                            if (this.activeMainData.ativeMain.additionFlag === '1') {
                                if (this.relateList.relateAdditionalCode.length < 1) {
                                    this.activeMainData.activeAdditional.additionalCode = '00';
                                } else {
                                    this.activeMainData.activeAdditional.additionalCode = this.relateList.relateAdditionalCode.join(',');
                                }
                            }
                            if (this.relateList.relateFinanceProdCode.length < 1) {
                                this.activeMainData.activeProdList[0].prodCode = '00';
                            } else {
                                this.activeMainData.activeProdList[0].prodCode = this.relateList.relateFinanceProdCode.join(',');
                            }
                            if (this.relateList.relateCreditProdCode.length < 1) {
                                this.activeMainData.activeProdList[1].prodCode = '00';
                            } else {
                                this.activeMainData.activeProdList[1].prodCode = this.relateList.relateCreditProdCode.join(',');
                            }
                            if (this.relateList.relateBusinessCode.length < 1) {
                                this.activeMainData.activeBusiness.businessCode = '00';
                            } else {
                                this.activeMainData.activeBusiness.businessCode = this.relateList.relateBusinessCode.join(',');
                            }
                            if (this.relateList.relateMarketingCode.length < 1) {
                                this.activeMainData.activeMarketing.marketingCode = '00';
                            } else {
                                this.activeMainData.activeMarketing.marketingCode = this.relateList.relateMarketingCode.join(',');
                            }
                            if (this.relateList.relateSeriesCode.length < 1) {
                                this.activeMainData.activeCar.seriesCode = '00';
                            } else {
                                this.activeMainData.activeCar.seriesCode = this.relateList.relateSeriesCode.join(',');
                            }
                            if (this.relateList.relateModerCode.length < 1) {
                                this.activeMainData.activeCar.moderCode = '00';
                            } else {
                                this.activeMainData.activeCar.moderCode = this.relateList.relateModerCode.join(',');
                            }
                            if (this.activeMainData.ativeMain.inputArea === '1') {
                                if (this.relateList.relateAreaCode.length < 1) {
                                    this.activeMainData.activeArea.areaCode = '00';
                                } else {
                                    this.activeMainData.activeArea.areaCode = this.relateList.relateAreaCode.join(',');
                                }
                            } else {
                                if (this.relateList.relateProvinceCode.length < 1) {
                                    this.activeMainData.activeArea.provinceCode = '00';
                                } else {
                                    this.activeMainData.activeArea.provinceCode = this.relateList.relateProvinceCode.join(',');
                                }
                                if (this.relateList.relateCityCode.length < 1) {
                                    this.activeMainData.activeArea.cityCode = '00';
                                } else {
                                    this.activeMainData.activeArea.cityCode = this.relateList.relateCityCode.join(',');
                                }
                            }
                            this.validateSuccess();
                        }
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            },
            validateSuccess () {
                this.handleActiveMainAdd(this.activeMainData).then(() => {
                    if (this.submitResult.isSuccess) {
                        this.$Modal.success({
                            title: '提交成功',
                            content: this.submitResult.msg,
                            onOk: () => {
                                this.ok();
                            },
                            onCancel: () => {
                                this.ok();
                            }
                        });
                    } else {
                        this.$Modal.error({
                            title: '提交失败',
                            content: '请联系管理员'
                        });
                    }
                });
            },
            validateDealer () {
                if (this.activeMainData.ativeDealeList.length < 1) {
                    //this.$Message.error('经销商信息不能为空!');
                    return '经销商信息不能为空!';
                }
                var reg = /^[0-9]*$/;
                for (var i = 0; i < this.activeMainData.ativeDealeList.length; i++) {
                    var activeDealerObj = this.activeMainData.ativeDealeList[i];
                    if (activeDealerObj.dealerCode === '') {
                        return '经销商导入的第' + (i + 1) + '条数据，供应商代码不能为空!';
                    }
                    if (activeDealerObj.dealerName === '') {
                        return '经销商导入的第' + (i + 1) + '条数据，供应商名称不能为空!';
                    }
                    if (activeDealerObj.activeNumber) {
                        if (activeDealerObj.activeNumber !== '' && !reg.test(activeDealerObj.activeNumber)) {
                            return '经销商导入的第' + (i + 1) + '条数据，活动上限必须为数字!';
                        }
                    }
                }
                return '';
            },
            validateArea () {
                if (this.activeMainData.ativeMain.inputArea === '1') {
                    if (this.relateList.relateAreaCode.length < 1) {
                        return '活动区域不能为空!';
                    }
                } else {
                    if (this.relateList.relateProvinceCode.length < 1) {
                        return '活动省份不能为空!';
                    }
                }
                return '';
            },
            getCookieInfo () {
                const user = getUserCookie();
                this.activeMainData.ativeMain.areaName = user.areaName;
                this.activeMainData.ativeMain.areaCode = user.areaCode;
                this.activeMainData.ativeMain.company = user.comCode;
            },
            ok () {
                this.handleResetActiveMainData().then(res => {
                    this.$router.push({name: 'activeMainList'});
                });
            }
        },
        mounted () {
            this.init();
        }
    };
</script>