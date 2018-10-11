<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form :label-width="100">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    团队基本信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="区域名称：" >
                            <Input v-model="teamViewData.areaName" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="区域代码：" >
                            <Input v-model="teamViewData.areaCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队名称：" >
                            <Input v-model="teamViewData.teamName"  disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="团队代码：" >
                            <Input v-model="teamViewData.teamCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队等级：" >
                            <Select v-model="teamViewData.teamLevel" style="width:100%" disabled>
                                <Option v-for="item in teamLevelList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="团队类别：" >
                            <Select v-model="teamViewData.teamType" style="width:100%" disabled>
                                <Option v-for="item in teamTypeList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="团队状态：" >
                            <Select v-model="teamViewData.teamStatus" style="width:100%" disabled>
                                <Option v-for="item in teamStatusList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="团队电话：" >
                            <Input v-model="teamViewData.teamPhone" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="邮编：" >
                            <Input v-model="teamViewData.teamZip" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="传真：" >
                            <Input v-model="teamViewData.teamFax" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="生效时间：" >
                            <Input v-model="teamViewData.startTime" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="创建时间：" >
                            <Input v-model="teamViewData.createTime" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="团队地址：" >
                            <Input v-model="teamViewData.teamAddress" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="备注：">
                            <Input v-model="teamViewData.remark" type="textarea" disabled style="width: 100%" :rows="4" :autosize="{minRows: 2,maxRows: 6}"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
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
import {resetWorkHeight} from '@/libs/util.js';
export default{
    name: 'teamView',
    data () {
        return {
            teamLevelList: [{
                value: '01',
                label: '一级'
            }, {
                value: '02',
                label: '二级'
            }, {
                value: '03',
                label: '三级'
            }],
            teamTypeList: [{
                value: '01',
                label: '普通'
            }],
            teamStatusList: [{
                value: '1',
                label: '有效'
            }, {
                value: '0',
                label: '无效'
            }]
        };
    },
    computed: {
        ...mapState({
            loading: ({teamView}) => teamView.loading,
            teamViewData: ({teamView}) => teamView.teamViewData
        })

    },
    methods: {
        ...mapActions([
            'handelQueryTeamViewById'
        ]),
        init () {
            this.queryTeamById(this.$route.query.id);
            resetWorkHeight();
        },
        queryTeamById (id) {
            this.handelQueryTeamViewById(id).then(res => {});
        },
        pageBack () {
            this.$router.push({name: 'teamMainTenanceList'});
        }
    },
    mounted () {
        this.init();
    }
};
</script>