<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form :label-width="100">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    个人基本信息
                </p>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="事项年度：" >
                            <Input v-model="personMainQueryEventResult.eventYear" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="处理单位" >
                            <Input v-model="personMainQueryEventResult.eventApart" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="事项分类：" >
                            <Select v-model="personMainQueryEventResult.transcode1" style="width:100%" disabled>
                                <Option v-for="item in eventTypeList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="处理时间：" >
                            <Input v-model="personMainQueryEventResult.createTime" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="事项内容：">
                            <Input v-model="personMainQueryEventResult.brandsText" type="textarea" disabled style="width: 100%" :autosize="{minRows: 2,maxRows: 6}"></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
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
    name: 'personMainTabList',
    data () {
        return {
            eventTypeList: [{
                value: '0',
                label: '奖励'
            }, {
                value: '1',
                label: '处罚'
            }, {
                value: '2',
                label: '其他'
            }]
        };
    },
    computed: {
        ...mapState({
            loading: ({personMainTabList}) => personMainTabList.loading,
            personMainQueryEventResult: ({personMainTabList}) => personMainTabList.personMainQueryEventResultData
        })
    },
    methods: {
        ...mapActions([
            'handlePersonMainQueryEventById'
        ]),
        init () {
            this.queryPersonEventDataById(this.$route.query.id);
            resetWorkHeight();
        },
        queryPersonEventDataById (id) {
            this.handlePersonMainQueryEventById(id);
        },
        pageBack () {
            let routerParam = {id: this.$route.query.ID, personCode: this.$route.query.personCode, tabName: 'name4'};
            this.$router.push({
                name: 'personMainQueryTabList',
                query: routerParam
            });
        }
    },
    mounted () {
        this.init();
    }
};
</script>