<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Row :gutter="4">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    物料验收登记
                </p>
                <Row>
                    <Col span="24">
                        选择验收物料：
                        <Button type="success" icon="search" @click="openModal">选择</Button>
                    </Col>
                </Row>
                <Table ref="tableExcel" :data="tableData" :columns="tableColumns" :loading="loading" style="margin-top: 22px;"></Table>
                <div style="margin: 10px;overflow: hidden">
                    <div style="float: right;">
                        <Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total  show-sizer placement="top" ></Page>
                    </div>
                </div>
                <Modal  id="material-modal"
                        v-model="modal"
                        title="物料新增"
                        @on-ok="ok"
                        @on-cancel="cancel">
                    <Row>
                        <Col span="24">
                            <Select v-model="selectTree" multiple style="width:100%;" disabled>
                                <Option v-for="item in cityList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </Col>
                        <Col span="24">
                            <Tree :data="data2" multiple show-checkbox @on-check-change="getCheckedNodes"></Tree>
                        </Col>
                    </Row>
                </Modal>
            </Card>
        </Row>
    </div>
</template>

<script>
    import { isEmpty } from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';
    export default {
        name: 'materialAcceptanceRegister',
        data () {
            return {
                cityList: [
                    {
                        label: '雨伞',
                        value: '11'

                    },
                    {
                        label: '笔记本',
                        value: '21'
                    },
                    {
                        label: '签字笔',
                        value: '22'
                    },
                    {
                        label: '易拉宝',
                        value: '31'
                    },
                    {
                        label: '宣传册',
                        value: '32'
                    }
                ],
                selectTree: [],
                selectData: [],
                data2: [
                    {
                        title: '品牌物料',
                        expand: true,
                        children: [
                            {
                                title: '雨伞',
                                expand: true,
                                value: '11'
                            }
                        ]
                    },
                    {
                        title: '促销物料',
                        expand: true,
                        children: [
                            {
                                title: '笔记本',
                                expand: true,
                                value: '21'
                            },
                            {
                                title: '签字笔',
                                expand: true,
                                value: '22'
                            }
                        ]
                    },
                    {
                        title: '广宣物料',
                        expand: true,
                        children: [
                            {
                                title: '易拉宝',
                                expand: true,
                                value: '31'
                            },
                            {
                                title: '宣传册',
                                expand: true,
                                value: '32'
                            }
                        ]
                    }
                ],
                modal: false,
                ruleValidate: {},
                searchFormDate: {
                    commodityTypeCode: '',
                    commodityCode: '',
                    pageInfo: {
                        pageSize: '10',
                        pageNo: '1'
                    }
                },
                tableColumns: [
                    {
                        title: '物料分类',
                        key: 'commodityName',
                        align: 'center'
                    }, {
                        title: '物料名称',
                        key: 'acceptanceNumber',
                        align: 'center'
                    }, {
                        title: '供应单位',
                        key: 'provideOrganization',
                        align: 'center',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('div', row.provideOrganization === '1' ? '总部分发' : '自行采购')
                            ]);
                        }
                    }, {
                        title: '验收数量',
                        key: 'acceptanceOrganization',
                        align: 'center'
                    },
                    {
                        title: '操作',
                        key: 'action',
                        width: 150,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.remove(params.index)
                                        }
                                    }
                                }, '删除')
                            ]);
                        }
                    }
                ]
            };
        },
        watch: {
            selectData: function (newSelectData, oldSelectData) {
                this.answer = 'Waiting for you to stop typing...'
                this.debouncedGetAnswer()
            }
        },
        computed: {
            ...mapState({
                loading: ({materialAcceptanceList}) => materialAcceptanceList.loading,
                isSuccess: ({materialAcceptanceList}) => materialAcceptanceList.isSuccess,
                msg: ({materialAcceptanceList}) => materialAcceptanceList.msg,
                tableData: ({materialAcceptanceList}) => materialAcceptanceList.materialAcceptanceList,
                pageNo: ({materialAcceptanceList}) => materialAcceptanceList.pageNo,
                pageSize: ({materialAcceptanceList}) => materialAcceptanceList.pageSize,
                total: ({materialAcceptanceList}) => materialAcceptanceList.total,
                pages: ({materialAcceptanceList}) => materialAcceptanceList.pages
            })
        },
        methods: {
            ...mapActions([
                'handleRegisterMaterialAcceptance'
            ]),
            /**
             * 初始化
             */
            init () {
                this.searchData();
            },
            openModal () {
                this.modal = true;
            },
            // 点击树复选框
            getCheckedNodes (value) {
                this.selectTree = [];
                this.selectData = [];
                for (let i = 0; i < value.length; i++) {
                    if (value[i].children === undefined) {
                        this.selectTree.push(value[i].value);
                        this.selectData.push(value[i]);
                    }
                }
                console.log(this.selectData);
            },
            getSelectedNodes (value) {
                console.log(value);
            },
            /**
             * 点击查询按钮执行查询操作
             */
            searchData () {
                console.log(this.searchFormDate);
                this.handleRegisterMaterialAcceptance(this.searchFormDate).then(res => {
                    this.$Message.info(this.msg);
                    this.searchFormDate.pageInfo.pageNo = 1;
                });
            },
            remove (index) {
                this.tableData.splice(index, 1);
            },
            ok () {
                this.$Message.info('Clicked ok');
            },
            cancel () {
                this.$Message.info('Clicked cancel');
            },
            /**
             * 页面改变
             */
            changePage (index) {
                this.searchFormDate.pageInfo.pageNo = index;
                this.searchData();
            },
            /**
             * 切换每页条数
             */
            pageSizeChange (newPageSize) {
                this.searchFormDate.pageInfo.pageSize = newPageSize;
                this.searchData();
            }
        },
        mounted () {
            this.init();
        }
    };
</script>
