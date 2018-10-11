<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
            <div>
                <Form :label-width="120">
                    <Card>
                        <p slot="title">
                            <Icon type="search"></Icon>
                            人员基本信息
                        </p>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="人员代码：" >
                                <Input  disabled v-model="personData.personCode"></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="人员姓名：" >
                                <Input disabled v-model="personData.personName" ></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="身份证号：" >
                                <Input disabled  v-model="personData.personIdcard" ></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="出生日期：" >
                                <Input disabled  v-model="personData.personBirth" ></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="年龄：" >
                                <Input  disabled  v-model="personData.personAge"></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="民族：" >
                                <Input   disabled  v-model="personData.personEthnic"></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="婚姻状况：" >
                                <Input disabled   v-model="personData.personMarr"></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="毕业学校：" >
                                <Input disabled  v-model="personData.personSchool" ></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="专业：" >
                                <Input disabled  v-model="personData.personSubject"></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="最高学历：" >
                                <Input disabled  v-model="personData.personEdu"></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="学位：" >
                                <Input  disabled v-model="personData.personEdulevel" ></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="工龄：" >
                                <Input disabled v-model="personData.personWorktime"></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="参加工作日期：" >
                                <Input disabled  v-model="personData.personFirstworktime"></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <!--<Row>-->
                            <!--<Col span="4" offset="9">-->
                            <!--<Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>-->
                            <!--</Col>-->
                        <!--</Row>-->
                    </Card>
                </Form>
                <Form :label-width="120">
                    <Card class="margin-top-10">
                        <p slot="title">
                            <Icon type="search"></Icon>
                            入职信息
                        </p>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="团队名称：" >
                                <Input  disabled  v-model="personData.personTeam.teamName" ></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="团队代码：" >
                                <Input  disabled   v-model="personData.personTeam.teamCode" ></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="归属区域代码：" >
                                <Input  disabled  v-model="personData.personTeam.areaCode" ></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="归属区域名称：" >
                                <Input disabled  v-model="personData.teamMain.areaName"></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                                <FormItem label="人员性质：" >
                                    <Input  disabled  v-model="personNature" ></Input>
                                </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                                <FormItem label="人员级别：" >
                                    <Input disabled  v-model="personLevel"></Input>
                                </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                                <FormItem label="人员状态：" >
                                    <Input  disabled  v-model="personStatus"></Input>
                                </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                                <FormItem label="考核开始时间：" >
                                    <Input disabled  v-model="personCheckStart"></Input>
                                </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="上岗日期：" >
                                <Input disabled v-model="personUptime"></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="转正日期：" >
                                <Input disabled v-model="personCorrectime" ></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="试用期开始日期：" >
                                <Input disabled v-model="personTryStartime"  ></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="试用期结束日期：" >
                                <Input disabled  v-model="personTryEndtime" ></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="加入我司日期：" >
                                <Input  disabled v-model="personJointime" ></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="负责省份："  >
                                <Select  disabled  v-model="personData.personCity.provinceCode" placeholder=""  filterable multiple  :loading="loading" style="width: 650px">
                                    <Option v-for="province in searchProvinceList"  :value="province.value"  :key="province.value">{{ province.label }}</Option>
                                </Select>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="负责城市：" >
                                <Select   disabled v-model="personData.personCity.cityCode"  placeholder="" :label-in-value="true" filterable multiple   :loading="loading"  style="width: 650px">
                                    <Option v-for="city in searchCityList" :value="city.value" :key="city.value" >{{ city.label }}</Option>
                                </Select>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="负责品牌：" >
                                <Select  disabled v-model="personData.personBrand.brandCode"  placeholder="" :label-in-value="true"  filterable multiple  :loading="loading" style="width: 650px">
                                    <Option v-for="brand in searchBrandList" :value="brand.value" :key="brand.value" >{{ brand.label }}</Option>
                                </Select>
                            </FormItem>
                            </Col>
                        </Row>
                        <!--<Row>-->
                        <!--<Col span="4" offset="9">-->
                        <!--<Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>-->
                        <!--</Col>-->
                        <!--</Row>-->
                    </Card>
                </Form>
                <Form :label-width="120">
                    <Card class="margin-top-10">
                        <p slot="title">
                            <Icon type="search"></Icon>
                            联系信息
                        </p>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="家庭住址：" >
                                <Input disabled v-model="personData.personAddress" ></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="家庭电话：" >
                                <Input disabled  v-model="personData.personHomephone"></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="移动电话：" >
                                <Input disabled  v-model="personData.personPhone"></Input>
                            </FormItem>
                            </Col>
                            <Col span="8" offset="2">
                            <FormItem label="工作电话：" >
                                <Input disabled  v-model="personData.personWorkphone" ></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="e-mail：" >
                                <Input disabled v-model="personData.perrsonEmail"  ></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8" offset="2">
                            <FormItem label="备注：" >
                                <Input disabled v-model="personData.remark"  type="textarea" :autosize="{minRows: 2,maxRows: 2}" style="width:650px"></Input>
                            </FormItem>
                            </Col>
                        </Row>
                        <Row>
                        <Col span="8" offset="9">
                        <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                        </Col>
                        </Row>
                    </Card>
                </Form>
    </div>
</template>

<script>
    /* eslint-disable no-console */

    import {resetWorkHeight, formatDate, isEmpty} from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';

    export default{
        name: 'personView',
        computed: {
            ...mapState({
                loading: ({personView}) => personView.loading,
                personData: ({personView}) => personView.personData,
                searchProvinceList: ({personAdd}) => personAdd.searchProvinceList,
                searchCityList: ({personAdd}) => personAdd.searchCityList,
                searchBrandList: ({personAdd}) => personAdd.searchBrandList
            }),
            personStatus: function () {
                var str = '';
                str = this.personData.personTeam.personStatus;
                if (str === '1') {
                    str = '有效';
                } else if (str === '0') {
                    str = '无效';
                } else {
                    str = '注销';
                }
                return str;
            },
            personNature: function () {
                var str = '';
                str = this.personData.personTeam.personNature;
                if (str === '0') {
                    str = '团队负责人';
                } else if (str === '1') {
                    str = '销售经理';
                }
                return str;
            },
            personLevel: function () {
                var str = '';
                str = this.personData.personTeam.personLevel;
                if (str === '1') {
                    str = '一级';
                }
                return str;
            },
            brands: function () {
                var str = '';
                if (!isEmpty(this.personData.brands)) {
                    for (var i = 0; i < this.personData.brands.length; i++) {
                        str += this.personData.brands[i].brandName + ',';
                    }
                    if (str.length > 0) {
                        str = str.substr(0, str.length - 1);
                    }
                    return str;
                }
            },
            cities: function () {
                var str = '';
                if (!isEmpty(this.personData.cities)) {
                    for (var i = 0; i < this.personData.cities.length; i++) {
                        str += this.personData.cities[i].cityName + ',';
                    }
                    if (str.length > 0) {
                        str = str.substr(0, str.length - 1);
                    }

                    return str;
                }
            },
            // personFirstworktime: function () {
            //     var str = '';
            //     str = formatDate(new Date(this.personData.personFirstworktime), 'yyyy-MM-dd');
            //     return str;
            // },
            // personBirth: function () {
            //     var str = '';
            //     str = formatDate(new Date(this.personData.personBirth), 'yyyy-MM-dd');
            //     return str;
            // },
            personCheckStart: function () {
                var str = '';
                str = formatDate(new Date(this.personData.personTeam.personCheckStart), 'yyyy-MM-dd');
                return str;
            },
            personUptime: function () {
                var str = '';
                str = formatDate(new Date(this.personData.personTeam.personUptime), 'yyyy-MM-dd');
                return str;
            },
            personCorrectime: function () {
                var str = '';
                str = formatDate(new Date(this.personData.personTeam.personCorrectime), 'yyyy-MM-dd');
                return str;
            },
            personTryStartime: function () {
                var str = '';
                str = formatDate(new Date(this.personData.personTeam.personTryStartime), 'yyyy-MM-dd');
                return str;
            },
            personTryEndtime: function () {
                var str = '';
                str = formatDate(new Date(this.personData.personTeam.personTryEndtime), 'yyyy-MM-dd');
                return str;
            },
            personJointime: function () {
                var str = '';
                str = formatDate(new Date(this.personData.personTeam.personJointime), 'yyyy-MM-dd');
                return str;
            }

        },
        methods: {
            ...mapActions([
                'handleQueryPersonById',
                'handleQueryProvinceList',
                'handleQueryCityList',
                'handleQueryBrandList'
            ]),
            /**
             * 初始化
             */
            init () {
                this.getProvinceList();
            },
            /**
             * 点击查询按钮执行查询操作
             */
            queryPersonById () {
                this.handleQueryPersonById(this.$route.query.id).then(res => {
                    if (!isEmpty(this.personData.personCity.provinceCode)) {
                        this.handleQueryCityList(this.personData.personCity.provinceCode).then(res => {
                            this.personData.personCity.cityCode = this.personData.personCity.cityCode;
                        });
                    }
                    // this.$Message.info('查询成功!');
                });
            },
            pageBack () {
                this.$router.push({name: 'personList'});
            },
            natureFilter (param) {
                alert(param);
            },
            getProvinceList () {
                this.handleQueryProvinceList().then(res => {
                    this.handleQueryBrandList().then(res => {
                        this.queryPersonById();
                    });
                });
            }

        },
        mounted () {
            this.init();
        }
    };
</script>