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
                        <FormItem label="指标代码:" prop="indicatorcode">
                            <Input   v-model="teamViewData.indicatorcode" style="width:200px" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="指标名称:"  prop="indicatorname">
                            <Input  v-model="teamViewData.indicatorname" style="width:200px" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="上限:" prop="indicatorcaption">
                            <Input  v-model="teamViewData.indicatorcaption" style="width:200px" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="下限:" prop="indicatorgroup">
                            <Input   v-model="teamViewData.indicatorgroup" style="width:200px" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="区域范围:" prop="indicatorcaption">
                            <Input   v-model="teamViewData.indicatorcaption" style="width:200px" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="区域:" prop="alertflag">
                            <Input   v-model="teamViewData.alertflag" style="width:200px" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
                <Row>
                    <Col span="8" offset="2">
                        <FormItem label="维度类别:"  prop="enabledflag">
                            <Input   v-model="teamViewData.enabledflag" style="width:200px" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="8" offset="2">
                        <FormItem label="维度代码:" prop="displayorder">
                            <Input   v-model="teamViewData.displayorder" style="width:200px" disabled></Input>
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
