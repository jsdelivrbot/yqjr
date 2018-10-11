<style lang="less">
    @import '../../styles/common.less';
</style>
<template>
    <div>
        <Row>
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    查询
                </p>
                <Form ref="formValidate" :model="searchFormDate" :label-width="100">
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="活动名称:">
                                <Input placeholder="请输入活动名称" v-model="searchFormDate.activeName"></Input>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="活动代码:">
                                <Input placeholder="请输入活动代码" v-model="searchFormDate.activeCode"></Input>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="8" offset="2">
                            <FormItem label="受理开始日期:">
                                <DatePicker type="date" v-model="searchFormDate.activeStartime" placeholder="请输入受理开始日期"
                                            clearable style="width: 100%"></DatePicker>
                            </FormItem>
                        </Col>
                        <Col span="8" offset="2">
                            <FormItem label="受理结束日期:">
                                <DatePicker type="date" v-model="searchFormDate.activeEndtime" placeholder="请输入受理结束日期"
                                            clearable style="width: 100%"></DatePicker>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="4" offset="9">
                            <Button type="primary" icon="search" @click="searchData">查询</Button>
                        </Col>
                        <Col span="4">
                            <Button icon="close" @click="cleanData">取消</Button>
                        </Col>
                    </Row>
                </Form>
            </Card>
        </Row>
        <Row class="margin-top-10">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    表格数据
                </p>
                <a href="#" slot="extra" @click.prevent="exportExcel">
                    <Icon type="ios-cloud-download"></Icon>
                    导出数据
                </a>
                <Row type="flex" justify="end" :gutter="8">
                    <Col>
                        <Button icon="android-add" type="success" @click="addData">添加</Button>
                    </Col>
                    <Col>
                        <Button icon="edit" type="warning" @click="editData">修改</Button>
                    </Col>
                    <Col>
                        <Button icon="android-close" type="error" @click="delData">删除</Button>
                    </Col>
                </Row>
                <Table :data="tableData" :columns="tableColumns" :loading="loading" ref="tableExcel"
                       class="margin-top-10"></Table>
                <div style="margin: 10px;overflow: hidden">
                    <div style="float: right;">
                        <Page :total="total" :current="pageNum" :page-size="pageSize" size="small"
                              @on-change="changePage" @on-page-size-change="pageSizeChange" show-total
                              show-sizer></Page>
                    </div>
                </div>
            </Card>
        </Row>
        <a id="hrefToExportTable" style="postion: absolute;left: -10px;top: -10px;width: 0px;height: 0px;"></a>
    </div>
</template>

<script>
    import table2excel from '@/libs/table2excel.js';
    import {resetWorkHeight} from '@/libs/util.js';
    import {mapActions, mapState} from 'vuex';

    export default {
        name: 'demoList',
        data () {
            return {
                searchFormDate: {
                    activeName: '',
                    activeCode: '',
                    activeStartime: '',
                    activeEndtime: ''
                },
                tableColumns: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '姓名',
                        key: 'name',
                        sortable: true

                    }, {
                        title: '测试',
                        key: 'time'
                    }, {
                        title: '更新时间',
                        key: 'update'
                    }, {
                        title: '状态',
                        key: 'status',
                        render: (h, params) => {
                            const row = params.row;
                            const color = row.status === 1 ? 'blue' : row.status === 2 ? 'green' : 'red';
                            const text = row.status === 1 ? '修改中' : row.status === 2 ? '正常' : '停用';
                            return h('Tag', {
                                props: {
                                    type: 'dot',
                                    color: color
                                }
                            }, text);
                        }
                    }
                ],
                excelFileName: 'data'
            };
        },
        computed: {
            ...mapState({
                loading: ({demo}) => demo.loading,
                tableData: ({demo}) => demo.demoList,
                pageNum: ({demo}) => demo.pageNum,
                pageSize: ({demo}) => demo.pageSize,
                total: ({demo}) => demo.total,
                pages: ({demo}) => demo.pages

            })
        },
        methods: {
            ...mapActions([
                'handleDemoList'
            ]),
            /**
             * 初始化
             */
            init () {

            },
            /**
             * 点击查询按钮执行查询操作
             */
            searchData () {
                this.handleDemoList(this.searchFormDate, this.pageNum, this.pageSize).then(res => {
                    resetWorkHeight();
                    this.$Message.info('查询成功!');
                });
            },
            /**
             * 页面改变
             */
            changePage (newPageNum) {
                this.handleDemoList(this.searchFormDate, newPageNum, this.pageSize).then(res => {
                    this.$Message.info('查询成功!');
                });
            },
            /**
             * 切换每页条数
             */
            pageSizeChange (newPageSize) {
                this.handleDemoList(this.searchFormDate, this.pageNum, newPageSize).then(res => {
                    this.$Message.info('查询成功!');
                });
            },
            /**
             * 查询取消按钮
             */
            cleanData () {

            },
            /**
             * 导出execl
             */
            exportExcel () {
                table2excel.transform(this.$refs.tableExcel, 'hrefToExportTable', this.excelFileName);
            },
            /**
             * 添加数据
             */
            addData () {
                this.$router.push({name: 'demoAdd'});
            },
            /**
             * 修改数据
             */
            editData () {

            },
            /**
             * 删除数据
             */
            delData () {
                this.$Notice.success({
                    title: '通知',
                    desc: '提交成功!'
                });
            }
        },
        mounted () {
            this.init();
        }
    };
</script>
