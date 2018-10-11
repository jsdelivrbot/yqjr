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
                        <FormItem label="人员姓名：" >
                            <Input v-model="personEventViewData.personName"  disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="人员代码：" >
                            <Input v-model="personEventViewData.personCode" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="事项年度：" >
                            <Input v-model="personEventViewData.eventYear" disabled ></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="处理单位" >
                            <Input v-model="personEventViewData.eventApart" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="事项分类：" >
                            <Select v-model="personEventViewData.transcode1" style="width:100%" disabled>
                                <Option v-for="item in eventTypeList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="处理时间：" >
                            <Input v-model="personEventViewData.createTime" disabled ></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="18" offset="2">
                        <FormItem label="事项内容：">
                            <Input v-model="personEventViewData.brandsText" type="textarea" disabled style="width: 100%" :autosize="{minRows: 2,maxRows: 6}"></Input>
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
    name: 'personEventView',
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
            loading: ({personEventView}) => personEventView.loading,
            personEventViewData: ({personEventView}) => personEventView.personEventViewData
        })
    },
    methods: {
        ...mapActions([
            'handelQueryPersonEventById'
        ]),
        init () {
            console.log(this.$route.query.id);
            this.queryPersonEventById();
            resetWorkHeight();
        },
        queryPersonEventById () {
            this.handelQueryPersonEventById(this.$route.query.id);
        },
        pageBack () {
            this.$router.push({name: 'personEventList'});
        }
    },
    mounted () {
        this.init();
    }
};
</script>