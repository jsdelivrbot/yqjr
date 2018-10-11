<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form :label-width="140">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    基本信息
                </p>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="人员代码：" >
                            <Input v-model="personMainQueryChangeResult.personCode" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="人员姓名：" >
                            <Input v-model="personMainQueryChangeResult.personName" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="身份证号：" >
                            <Input v-model="personMainQueryChangeResult.personIdcard"  disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="出生日期：" >
                            <Input v-model="personMainQueryChangeResult.personBirth" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="年龄：" >
                            <Input v-model="personMainQueryChangeResult.personAge" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="民族：" >
                            <Input v-model="personMainQueryChangeResult.personEthnic" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="婚姻状况：" >
                            <Input v-model="personMainQueryChangeResult.personMarr" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="毕业学校：" >
                            <Input v-model="personMainQueryChangeResult.personSchool" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="专业：" >
                            <Input v-model="personMainQueryChangeResult.personSubject" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="最高学历：" >
                            <Input v-model="personMainQueryChangeResult.personEdu" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="学位：" >
                            <Input v-model="personMainQueryChangeResult.personEdulevel" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="工龄：" >
                            <Input v-model="personMainQueryChangeResult.personWorktime" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="参加工作日期：" >
                            <Input v-model="personMainQueryChangeResult.personFirstworktime" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card style="margin-top:10px;">
                <p slot="title">
                    <Icon type="search"></Icon>
                    入职信息
                </p>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="团队名称：" >
                            <Input v-model="personMainQueryChangeResult.teamMain.teamName" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="团队代码：" >
                            <Input v-model="personMainQueryChangeResult.personTeam.teamCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="归属区域代码：" >
                            <Input v-model="personMainQueryChangeResult.personTeam.areaCode" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="归属区域名称：" >
                            <Input v-model="personMainQueryChangeResult.teamMain.areaName" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="人员性质：" >
                            <!--<Input v-model="personMainQueryChangeResult.personTeam.personNature" disabled ></Input>-->
                            <Select v-model="personMainQueryChangeResult.personTeam.personNature" style="width:100%" disabled>
                                <Option v-for="item in personNatureList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="人员级别：" >
                            <!--<Input v-model="personMainQueryChangeResult.personTeam.personLevel" disabled ></Input>-->
                            <Select v-model="personMainQueryChangeResult.personTeam.personLevel" style="width:100%" disabled>
                                <Option v-for="item in personLevelList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="人员状态：" >
                            <!--<Input v-model="personMainQueryChangeResult.personTeam.personStatus" disabled ></Input>-->
                            <Select v-model="personMainQueryChangeResult.personTeam.personStatus" style="width:100%" disabled>
                                <Option v-for="item in personStatusList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="考核开始日期：" >
                            <Input v-model="personMainQueryChangeResult.personTeam.personCheckStart" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="上岗日期：" >
                            <Input v-model="personMainQueryChangeResult.personTeam.personUptime" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="转正日期：" >
                            <Input v-model="personMainQueryChangeResult.personTeam.personCorrectime" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="试用期开始日期：" >
                            <Input v-model="personMainQueryChangeResult.personTeam.personTryStartime" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="试用期结束日期：" >
                            <Input v-model="personMainQueryChangeResult.personTeam.personTryEndtime" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="加入我司日期：" >
                            <Input v-model="personMainQueryChangeResult.personTeam.personJointime" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="生效日期：" >
                            <Input v-model="personMainQueryChangeResult.startTime" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="负责省份：" >
                            <Select style="width:100%" disabled  v-model="personMainQueryChangeResult.personCity.provinceCode" placeholder=""  filterable multiple  :loading="loading">
                                <Option v-for="province in searchProvinceList"  :value="province.value"  :key="province.value">{{ province.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="负责城市：" >
                            <Select  style="width:100%" disabled v-model="personMainQueryChangeResult.personCity.cityCode"  placeholder="" :label-in-value="true" filterable multiple   :loading="loading">
                                <Option v-for="city in searchCityList" :value="city.value" :key="city.value" >{{ city.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="负责品牌：" >
                            <Select style="width:100%" disabled v-model="personMainQueryChangeResult.personBrand.brandCode"  placeholder="" :label-in-value="true"  filterable multiple  :loading="loading" >
                                <Option v-for="brand in searchBrandList" :value="brand.value" :key="brand.value" >{{ brand.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Card>
            <Card style="margin-top:10px;">
                <p slot="title">
                    联系信息
                </p>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="家庭住址：" >
                            <Input v-model="personMainQueryChangeResult.personAddress" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="家庭电话：" >
                            <Input v-model="personMainQueryChangeResult.personHomephone" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="移动电话：" >
                            <Input v-model="personMainQueryChangeResult.personPhone" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="9" offset="2">
                        <FormItem label="工作电话：" >
                            <Input v-model="personMainQueryChangeResult.personWorkphone" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="9" offset="1">
                        <FormItem label="e-mail：" >
                            <Input v-model="personMainQueryChangeResult.perrsonEmail" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="20" offset="1">
                        <FormItem label="备注：" >
                            <Input disabled v-model="personMainQueryChangeResult.personTeam.remark"  type="textarea" :autosize="{minRows: 2,maxRows: 6}" style="width:100%"></Input>
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
import {resetWorkHeight, isEmpty} from '@/libs/util.js';
export default{
    name: 'teamView',
    data () {
        return {
            personLevelList: [{
                value: '1',
                label: '一级'
            }, {
                value: '2',
                label: '二级'
            }, {
                value: '3',
                label: '三级'
            }],
            personNatureList: [{
                value: '0',
                label: '团队负责人'
            }, {
                value: '1',
                label: '销售经理'
            }],
            personStatusList: [{
                value: '1',
                label: '有效'
            }, {
                value: '0',
                label: '无效'
            }, {
                value: '2',
                label: '注销'
            }]
        };
    },
    computed: {
        ...mapState({
            loading: ({personMainTabList}) => personMainTabList.loading,
            personMainQueryChangeResult: ({personMainTabList}) => personMainTabList.personMainQueryChangeResultData,
            searchProvinceList: ({personAdd}) => personAdd.searchProvinceList,
            searchCityList: ({personAdd}) => personAdd.searchCityList,
            searchBrandList: ({personAdd}) => personAdd.searchBrandList
        })
    },
    methods: {
        ...mapActions([
            'handleQueryProvinceList',
            'handleQueryCityList',
            'handleQueryBrandList',
            'handlePersonMainQueryChangeTrackById'
        ]),
        init () {
            this.getProvinceList();
            // this.queryPersonChangeById();
            // console.log(this.$route.query.id)
            resetWorkHeight();
        },
        // 获取省会列表
        getProvinceList () {
            this.handleQueryProvinceList().then(res => {
                this.handleQueryBrandList().then(res => {
                    this.queryPersonChangeById();
                });
            });
        },
        queryPersonChangeById () {
            this.handlePersonMainQueryChangeTrackById(this.$route.query.id).then(res => {
                if (!isEmpty(this.personMainQueryChangeResult.personCity.provinceCode)) {
                    this.handleQueryCityList(this.personMainQueryChangeResult.personCity.provinceCode).then(res => {
                        this.personMainQueryChangeResult.personCity.cityCode = this.personMainQueryChangeResult.personCity.cityCode;
                    });
                }
            });
        },
        pageBack () {
            let routerParam = {id: this.$route.query.ID, personCode: this.$route.query.personCode, tabName: 'name3'};
            this.$router.push({
                name: 'personMainQueryTabList',
                query: routerParam
            });
        }
    },
    mounted () {
        // alert(this.$route.query.ID + ' ' + this.$route.query.personCode);
        this.init();
    }
};
</script>