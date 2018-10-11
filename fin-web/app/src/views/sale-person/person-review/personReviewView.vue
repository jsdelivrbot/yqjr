<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form ref="reviewPersonData"  :model="reviewPersonData" :label-width="120">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    人员基本信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员代码："   >
                        <Input v-model="reviewPersonData.personCode" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="人员姓名："   >
                        <Input v-model="reviewPersonData.personName" disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="身份证号：" >
                        <Input v-model="reviewPersonData.personIdcard" disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="出生日期：" >
                        <Input  v-model="reviewPersonData.personBirth" disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="年龄：" >
                        <Input v-model="reviewPersonData.personAge" disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="民族：" >
                        <Input v-model="reviewPersonData.personEthnic" disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="婚姻状况：" >
                        <Input  v-model="reviewPersonData.personMarr" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="毕业学校：" >
                        <Input  v-model="reviewPersonData.personSchool"  disabled ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="专业：" >
                        <Input   v-model="reviewPersonData.personSubject" disabled ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="最高学历：" >
                        <Input   v-model="reviewPersonData.personEdu" disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="学位：" >
                        <Input  v-model="reviewPersonData.personEdulevel" disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="工龄：" >
                        <Input  v-model="reviewPersonData.personWorktime"  disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="参加工作日期：" >
                        <Input disabled v-model="reviewPersonData.personFirstworktime" ></Input>
                    </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    入职信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="团队名称：" prop="tempTeamName">
                        <Input  v-model="reviewPersonData.teamName" disabled  ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="团队代码："   >
                        <Input  v-model="reviewPersonData.teamCode" disabled  ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="归属区域代码：" >
                        <Input   v-model="reviewPersonData.areaCode"  disabled></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="归属区域名称：" >
                        <Input  v-model="reviewPersonData.areaName"  disabled></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员性质：" prop="personNature">
                        <i-select v-model="reviewPersonData.personNature" disabled style="width:100%;">
                            <i-option v-for="nature in natureList" :value="nature.value" :key="nature.value" >{{ nature.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="人员级别："  prop="personNature">
                        <i-select v-model="reviewPersonData.personLevel"  disabled style="width:100%;">
                            <i-option v-for="level in levelList" :value="level.value" :key="level.value">{{ level.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="人员状态：" prop="personStatus">
                        <i-select v-model="reviewPersonData.personStatus"   disabled style="width:100%;">
                            <i-option v-for="status in statusList" :value="status.value"  :key="status.value">{{ status.label }}</i-option>
                        </i-select>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="考核开始时间：" prop="personCheckStart">
                        <DatePicker type="date"  disabled v-model="reviewPersonData.personCheckStart"  style="width:100%;"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="上岗日期："  prop="personUptime">
                        <DatePicker type="date"   disabled v-model="reviewPersonData.personUptime"  style="width:100%;"></DatePicker>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="转正日期：" prop="personCorrectime">
                        <DatePicker type="date"  disabled  v-model="reviewPersonData.personCorrectime"  style="width:100%;"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="试用期开始日期：" prop="personTryStartime">
                        <DatePicker type="date"  disabled  v-model="reviewPersonData.personTryStartime"  style="width:100%;"></DatePicker>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="试用期结束日期："  prop="personTryEndtime">
                        <DatePicker type="date"  disabled v-model="reviewPersonData.personTryEndtime"  style="width:100%;"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="加入我司日期：" prop="personJointime">
                        <DatePicker type="date"   disabled v-model="reviewPersonData.personJointime"  style="width:100%;"></DatePicker>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="负责省份：" >
                            <Select style="width:100%;" disabled v-model="reviewPersonData.tempProvinces" placeholder="" :label-in-value="true" filterable multiple  :loading="loading">
                                <Option v-for="item in searchProvinceList" :value="item.value" :key="item.value" >{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="负责城市：" >
                            <Select   disabled v-model="reviewPersonData.tempCities" placeholder="" :label-in-value="true" filterable multiple  :loading="loading"  style="width: 100%;">
                                <Option v-for="item in searchCityList" :value="item.value" :key="item.value" >{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="负责品牌：" >
                            <Select  disabled  v-model="reviewPersonData.tempBrands" placeholder="" :label-in-value="true" filterable multiple    :loading="loading" style="width: 100%;">
                                <Option v-for="item in searchBrandList" :value="item.value" :key="item.value" >{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    联系信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="家庭住址：" >
                        <Input  disabled v-model="reviewPersonData.personAddress" ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="家庭电话："   >
                        <Input   disabled type="text"  v-model="reviewPersonData.personHomephone" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="移动电话："  prop="personPhone">
                        <Input disabled  v-model="reviewPersonData.personPhone" ></Input>
                    </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                    <FormItem label="工作电话：" >
                        <Input  disabled type="text" v-model="reviewPersonData.personWorkphone" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                    <FormItem label="e-mail："  prop="personEmail">
                        <Input  disabled v-model="reviewPersonData.personEmail" ></Input>
                    </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                    <FormItem label="备注："  prop="remark">
                        <Input   disabled v-model="reviewPersonData.remark" type="textarea"  style="width:100%;"></Input>
                    </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card class="margin-top-10">
                <p slot="title">
                    <Icon type="search"></Icon>
                    审核进度
                </p>
                <Table :data="personReviewViewWork" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                <Row  class="margin-top-10">
                    <Col span="4" offset="11">
                    <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                    </Col>
                </Row>
            </Card>
        </Form>
    </div>
</template>

<script>
    /* eslint-disable no-console */

    import {resetWorkHeight, isEmpty, formatDate} from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';
    export default{
        name: 'personReviewView',
        data: function () {
            return {
                natureList: [
                    {
                        value: '0',
                        label: '团队负责人'
                    },
                    {
                        value: '1',
                        label: '销售经理'
                    }
                ],
                levelList: [
                    {
                        value: '1',
                        label: '一级'
                    }
                ],
                statusList: [
                    {
                        value: '1',
                        label: '有效'
                    },
                    {
                        value: '0',
                        label: '无效'
                    },
                    {
                        value: '2',
                        label: '注销'
                    }
                ],
                tableColumns: [
                    {
                        title: '审批结果',
                        align: 'center',
                        key: 'reviewStatus',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.reviewStatus === '04' ? '通过' : '驳回')
                            ]);
                        }
                    }, {
                        title: '审核级别',
                        align: 'center',
                        key: 'reviewLevel',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.reviewLevel === '1' ? '一级' : '二级')
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
                    },{
                        title: '审批意见',
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
                ],
                searchPerson: '',
                tempTeamName: ''
            };
        },
        computed: {
            ...mapState({
                reviewPersonData: ({personReviewView}) => personReviewView.reviewPersonData,
                personReviewViewWork: ({personReviewView}) => personReviewView.personReviewViewWork,
                searchProvinceList: ({personReviewView}) => personReviewView.searchProvinceList,
                searchCityList: ({personReviewView}) => personReviewView.searchCityList,
                searchBrandList: ({personReviewView}) => personReviewView.searchBrandList,
                loading: ({personReviewView}) => personReviewView.loading,
                msg: ({personReviewView}) => personReviewView.msg,
                isSuccess: ({personReviewView}) => personReviewView.isSuccess
            })
        },
        methods: {
            ...mapActions([
                'handlePersonReviewPersonData',
                'handlePersonReviewBrandList',
                'handlePersonReviewCityList',
                'handlePersonReviewProvinceList',
                'handelQueryPersonReviewWorkFlow'
            ]),
            /**
             * 初始化页面高度，省份数据，品牌数据
             */
            init () {
                this.queryActiveProvinceList();
            },
            /**
             * 展示省市
             * @param name
             */
            queryActiveProvinceList () {
                this.handlePersonReviewProvinceList().then(res => {
                    this.handlePersonReviewBrandList().then(res => {
                        this.getPersonData();
                        this.queryPersonReviewWork();
                    });
                    resetWorkHeight();
                });
            },
            queryPersonCityList () {
                if (!isEmpty(this.reviewPersonData.tempProvinces)) {
                    this.handlePersonReviewCityList(this.reviewPersonData.tempProvinces).then(res => {
                        this.reviewPersonData.tempCities = this.reviewPersonData.tempCities;
                    });
                }
            },
            pageBack () {
                if (this.$route.query.pageType === 'personReviewProgressList') {
                    this.$router.push({name: 'personReviewProgressList'});
                } else {
                    this.$router.push({name: 'personReviewList'});
                }
            },
            getPersonData () {
                console.log(this.$route.query)
                this.handlePersonReviewPersonData(this.$route.query.id).then(res => {
                    this.queryPersonCityList();
                    resetWorkHeight();
                });
            },
            /**
             * 查审核信息
             */
            queryPersonReviewWork () {
                this.handelQueryPersonReviewWorkFlow(this.$route.query.personCode).then(res => {
                    resetWorkHeight();
                });
            }
        },
        mounted () {
            this.init();
        }
    };
</script>