<style lang="less">
    @import '../../../styles/common.less';
    @import './components/table.less';
</style>
<template>
    <div>
        <Row :gutter="4">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    物料验收
                </p>
                <Row>
                    <Col span="24">
                        <Form ref="searchFormDate" :rules="ruleValidate" :model="searchFormDate" :label-width="100">
                            <Row>
                                <Col span="8" offset="2">
                                    <FormItem label="物料分类：" prop="commodityTypeCode">
                                        <Select v-model="searchFormDate.commodityTypeCode">
                                            <Option value="00">促销物料</Option>
                                            <Option value="01">广宣物料</Option>
                                            <Option value="02">品牌物料</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                                <Col span="8" offset="2">
                                    <FormItem label="物料名称：" prop="commodityCode">
                                        <Select v-model="searchFormDate.commodityCode">
                                            <Option value="00">签字笔</Option>
                                            <Option value="01">笔记本</Option>
                                            <Option value="02">雨伞</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                                <Col span="8" offset="2">
                                    <FormItem label="供应单位：" prop="provideOrganization">
                                        <Select v-model="searchFormDate.provideOrganization">
                                            <Option value="1">总部分发</Option>
                                            <Option value="2">自行采购</Option>
                                        </Select>
                                    </FormItem>
                                </Col>
                            </Row>
                            <Row>
                                <Col span="2" offset="9">
                                    <Button type="primary" icon="search" @click="searchData('searchFormDate')">查询</Button>
                                </Col>
                                <Col span="2" offset="2">
                                    <Button icon="refresh" @click="cleanData()">重置</Button>
                                </Col>
                            </Row>
                        </Form>
                    </Col>
                </Row>
            </Card>
            <Card style="margin-top: 10px;">
                <p slot="title">
                    <Icon type="search"></Icon>
                    数据
                </p>
                <Row type="flex" justify="end" :gutter="8" >
                    <Col>
                        <Button icon="android-add"  type="success" @click="registerData">验收登记</Button>
                    </Col>
                    <Col>
                        <Button icon="ios-cloud-download-outline" type="primary" @click.prevent="exportExcel('searchFormDate')">导出</Button>
                    </Col>
                </Row>
                <div class="edittable-table-height-con" style="margin-top: 20px;">
                    <can-edit-table
                            refs="table4"
                            v-model="tableData"
                            @on-cell-change="handleCellChange"
                            :editIncell="true"
                            :columns-list="tableColumns"
                    ></can-edit-table>
                </div>
                <div style="margin: 10px;overflow: hidden">
                    <div style="float: right;">
                        <Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total  show-sizer placement="top" ></Page>
                    </div>
                </div>
            </Card>
        </Row>
    </div>
</template>

<script>
    import { isEmpty } from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';
    import canEditTable from './components/canEditTable.vue';
    export default {
        name: 'materialAcceptanceList',
        components: {
            canEditTable
        },
        data () {
            return {
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
                        title: '物料名称',
                        key: 'commodityName',
                        align: 'center'
                    },
                    {
                        title: '验收数量',
                        key: 'acceptanceNumber',
                        align: 'center',
                        editable: true
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
                        title: '验收区域',
                        key: 'acceptanceOrganization',
                        align: 'center'
                    }, {
                        title: '验收人',
                        key: 'acceptancePerson',
                        align: 'center'
                    }, {
                        title: '验收时间',
                        key: 'createTime',
                        align: 'center'
                    }
                ]
            };
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
                'handleQueryMaterialAcceptanceList',
                'handleExportMaterialAcceptance'
            ]),
            handleCellChange (val, index, key) {
                this.$Message.success('修改了第 ' + (index + 1) + ' 行列名为 ' + key + ' 的数据');
            },
            /**
             * 初始化
             */
            init () {
                this.searchData();
            },
            /**
             * 点击查询按钮执行查询操作
             */
            searchData () {
                console.log(this.searchFormDate);
                this.handleQueryMaterialAcceptanceList(this.searchFormDate).then(res => {
                    this.$Message.info(this.msg);
                    this.searchFormDate.pageInfo.pageNo = 1;
                });
            },
            // 验收登记
            registerData () {
                this.$router.push({
                    name: 'materialAcceptanceRegister'
                });
            },
            /**
             * 导出execl
             */
            exportExcel (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.handleQueryMaterialAcceptanceList(this.searchFormDate).then(res => {
                            var commodityCode = this.searchFormDate.commodityCode;
                            var commodityTypeName = this.searchFormDate.commodityTypeName;
                            var commodityName = this.searchFormDate.commodityName;
                            var commodityTypeCode = this.searchFormDate.commodityTypeCode;
                            var provideOrganization = this.searchFormDate.provideOrganization;
                            window.location = '/mkmm/sales/commodityAcceptances/export?commodityCode=' + commodityCode + '&commodityTypeName=' + commodityTypeName + '&commodityName=' + commodityName + '&commodityTypeCode=' + commodityTypeCode + '&provideOrganization=' + provideOrganization;
                        });
                    }
                });
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
            },
            /**
             * 重置按钮
             */
            cleanData () {
                window.location.reload();
            }
        },
        mounted () {
            this.init();
        }
    };
</script>
