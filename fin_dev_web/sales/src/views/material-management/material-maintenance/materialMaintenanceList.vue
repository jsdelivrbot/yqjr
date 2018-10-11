<style lang="less">
    @import '../../../styles/common.less';
</style>
<style>
    .demo-tabs-style1 > .ivu-tabs-card > .ivu-tabs-content {
        height: 100%;
        margin-top: -16px;
    }

    .demo-tabs-style1 > .ivu-tabs-card > .ivu-tabs-content > .ivu-tabs-tabpane {
        background: #fff;
        padding: 16px;
    }

    .demo-tabs-style1 > .ivu-tabs.ivu-tabs-card > .ivu-tabs-bar .ivu-tabs-tab {
        border-color: transparent;
    }

    .demo-tabs-style1 > .ivu-tabs-card > .ivu-tabs-bar .ivu-tabs-tab-active {
        border-color: #fff;
    }
</style>
<template>
    <div>
        <Row :gutter="4">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    基本信息维护
                </p>
                <Row>
                    <Col span="12" class="demo-tabs-style1" style=" background: #e3e8ee;padding:16px; width: 100%">
                        <Tabs :value="name" type="card" :animated="false">
                            <TabPane name="name1" label="物料维护">
                                <Form ref="searchFormDate" :rules="ruleValidate" :model="searchFormDate" :label-width="100"  style="margin: 20px 0;">
                                    <Row>
                                        <Col span="8" offset="2">
                                            <FormItem label="物料分类：" prop="commodityCode">
                                                <Select v-model="searchFormDate.commodityCode">
                                                    <Option value="00">促销物料</Option>
                                                    <Option value="01">广宣物料</Option>
                                                    <Option value="02">品牌物料</Option>
                                                </Select>
                                            </FormItem>
                                        </Col>
                                        <Col span="8" offset="2">
                                            <FormItem label="物料名称：" prop="commodityTypeCode">
                                                <Select v-model="searchFormDate.commodityTypeCode">
                                                    <Option value="00">促销物料</Option>
                                                    <Option value="01">广宣物料</Option>
                                                    <Option value="02">品牌物料</Option>
                                                </Select>
                                            </FormItem>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col span="2" offset="9">
                                            <Button type="primary" icon="search" @click="searchData('searchFormDate')">查询</Button>
                                        </Col>
                                        <Col span="2" offset="2">
                                            <Button icon="refresh" @click="cleanData('searchFormDate')">重置</Button>
                                        </Col>
                                    </Row>
                                </Form>
                                <div style="height:1px;background:#eee;margin-bottom:20px;"></div>
                                <Row type="flex" justify="end" :gutter="8" >
                                    <Col>
                                        <Button icon="android-add"  type="success" @click="addData">新增</Button>
                                    </Col>
                                    <Col>
                                        <Button icon="android-close"  type="error" @click="deleteData">删除</Button>
                                    </Col>
                                </Row>
                                <Table ref="tableExcel" :data="tableData" @on-selection-change='selectionClick' :columns="tableColumns" :loading="loading" style="margin-top: 22px;"></Table>
                                <div style="margin: 10px;overflow: hidden">
                                    <div style="float: right;">
                                        <Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total  show-sizer placement="top" ></Page>
                                    </div>
                                </div>
                                <Modal  id="material-modal"
                                        v-model="modal"
                                        title="物料新增">
                                    <Form ref="FormAdd" :rules="ruleValidateAdd" :model="FormAdd" :label-width="100">
                                       <Row>
                                           <Col span="24">
                                               <FormItem label="物料名称：" prop="commodityCode">
                                                   <Select v-model="FormAdd.commodityCode">
                                                       <Option value="00">促销物料</Option>
                                                       <Option value="01">广宣物料</Option>
                                                       <Option value="02">品牌物料</Option>
                                                   </Select>
                                               </FormItem>
                                           </Col>
                                       </Row>
                                        <Row>
                                            <Col span="24">
                                                <FormItem label="物料分类：" prop="commodityTypeCode">
                                                    <Select v-model="FormAdd.commodityTypeCode">
                                                        <Option value="00">促销物料</Option>
                                                        <Option value="01">广宣物料</Option>
                                                        <Option value="02">品牌物料</Option>
                                                    </Select>
                                                </FormItem>
                                            </Col>
                                        </Row>
                                        <Row>
                                            <Col span="24">
                                                <FormItem label="备注：" >
                                                    <Input  v-model="FormAdd.remark" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入备注"></Input>
                                                </FormItem>
                                            </Col>
                                        </Row>
                                        <Row>
                                            <Col span="16" offset="4">
                                                <FormItem>
                                                    <Button type="primary" @click="handleSubmit('FormAdd')" style="margin-left: 8px">保存</Button>
                                                    <Button type="ghost" @click="handleReset('FormAdd')" style="margin-left: 12px">取消</Button>
                                                </FormItem>
                                            </Col>
                                        </Row>
                                    </Form>
                                </Modal>
                            </TabPane>
                            <TabPane name="name2" label="项目维护">
                                <Form ref="searchFormDate2" :rules="ruleValidate" :model="searchFormDate2" :label-width="100" style="margin: 20px 0;">
                                    <Row>
                                        <Col span="8" offset="2">
                                            <FormItem label="项目名称：" prop="projectCode">
                                                <Select v-model="searchFormDate2.projectCode">
                                                    <Option value="00">促销物料</Option>
                                                    <Option value="01">广宣物料</Option>
                                                    <Option value="02">品牌物料</Option>
                                                </Select>
                                            </FormItem>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col span="2" offset="9">
                                            <Button type="primary" icon="search" @click="searchData2('searchFormDate2')">查询</Button>
                                        </Col>
                                        <Col span="2" offset="2">
                                            <Button icon="refresh" @click="cleanData2('searchFormDate2')">重置</Button>
                                        </Col>
                                    </Row>
                                </Form>
                                <div style="height:1px;background:#eee;margin-bottom:20px;"></div>
                                <Row type="flex" justify="end" :gutter="8" >
                                    <Col>
                                        <Button icon="android-add"  type="success" @click="addData2">新增</Button>
                                    </Col>
                                    <Col>
                                        <Button icon="android-close"  type="error" @click="deleteData2">删除</Button>
                                    </Col>
                                </Row>
                                <Table ref="tableExcel" :data="tableData2" @on-selection-change='selectionClick2' :columns="tableColumns2" :loading="loading2" style="margin-top: 22px;"></Table>
                                <div style="margin: 10px;overflow: hidden">
                                    <div style="float: right;">
                                        <Page :total="total2" :current="pageNo2" :page-size="pageSize2" size="small" @on-change="changePage2" @on-page-size-change="pageSizeChange2" show-total  show-sizer placement="top" ></Page>
                                    </div>
                                </div>
                                <Modal  id="material-modal2"
                                        v-model="modal2"
                                        title="项目新增">
                                    <Form ref="FormAdd2" :rules="ruleValidateAdd2" :model="FormAdd2" :label-width="100">
                                        <Row>
                                            <Col span="24">
                                                <FormItem label="项目名称：" prop="projectCode">
                                                    <Select v-model="FormAdd2.projectCode">
                                                        <Option value="00">促销物料</Option>
                                                        <Option value="01">广宣物料</Option>
                                                        <Option value="02">品牌物料</Option>
                                                    </Select>
                                                </FormItem>
                                            </Col>
                                        </Row>
                                        <Row>
                                            <Col span="24">
                                                <FormItem label="备注：" >
                                                    <Input  v-model="FormAdd2.remark" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入备注"></Input>
                                                </FormItem>
                                            </Col>
                                        </Row>
                                        <Row>
                                            <Col span="16" offset="4">
                                                <FormItem>
                                                    <Button type="primary" @click="handleSubmit2('FormAdd2')" style="margin-left: 8px">保存</Button>
                                                    <Button type="ghost" @click="handleReset2('FormAdd2')" style="margin-left: 12px">取消</Button>
                                                </FormItem>
                                            </Col>
                                        </Row>
                                    </Form>
                                </Modal>
                            </TabPane>
                        </Tabs>
                    </Col>
                </Row>
            </Card>
        </Row>
    </div>
</template>

<script>
    import { isEmpty } from '@/libs/util.js';
    import { mapActions, mapState } from 'vuex';
    export default {
        name: 'materialMaintenanceList',
        data () {
            const validateCommodityCodeCheck = (rule, value, callback) => {
                if (value === ' ' || value === null) {
                    callback(new Error('请选择物料名称!'));
                }
                callback();
            };
            const validateCommodityTypeCodeCheck = (rule, value, callback) => {
                if (value === ' ' || value === null) {
                    callback(new Error('请选择物料类型!'));
                }
                callback();
            };
            const validateProjectCodeCheck = (rule, value, callback) => {
                if (value === ' ' || value === null) {
                    callback(new Error('请选择项目名称!'));
                }
                callback();
            };
            return {
                name: '',
                ruleValidate: {},
                modal: false,
                modal2: false,
                searchFormDate: {
                    commodityCode: '',
                    commodityName: '',
                    commodityTypeCode: '',
                    commodityTypeName: '',
                    pageInfo: {
                        pageSize: '10',
                        pageNo: '1'
                    }
                },
                rowData: [],
                searchFormDate2: {
                    projectCode: '',
                    projectName: '',
                    pageInfo: {
                        pageSize: '10',
                        pageNo: '1'
                    }
                },
                rowData2: [],
                tableColumns: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '物料名称',
                        key: 'commodityName',
                        align: 'center'
                    },
                    {
                        title: '物料分类',
                        key: 'commodityTypeName',
                        align: 'center'
                    }, {
                        title: '备注',
                        key: 'remark',
                        align: 'center'
                    }
                ],
                tableColumns2: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    }, {
                        title: '项目名称',
                        key: 'projectName',
                        align: 'center'
                    }, {
                        title: '备注',
                        key: 'remark',
                        align: 'center'
                    }
                ],
                FormAdd: {
                    commodityCode: '',
                    commodityTypeCode: '',
                    remark: ''
                },
                FormAdd2: {
                    projectCode: '',
                    remark: ''
                },
                ruleValidateAdd: {
                    commodityCode: [
                        { required: true, message: '请选择物料名称!', trigger: 'blur' },
                        {validator: validateCommodityCodeCheck}
                    ],
                    commodityTypeCode: [
                        { required: true, message: '请选择物料类型!', trigger: 'blur' },
                        {validator: validateCommodityTypeCodeCheck}
                    ]
                },
                ruleValidateAdd2: {
                    projectCode: [
                        { required: true, message: '请选择项目名称!', trigger: 'blur' },
                        {validator: validateProjectCodeCheck}
                    ]
                },
                id: '',
                id2: ''
            };
        },
        computed: {
            ...mapState({
                loading: ({materialMaintenanceList}) => materialMaintenanceList.loading,
                isSuccess: ({materialMaintenanceList}) => materialMaintenanceList.isSuccess,
                msg: ({materialMaintenanceList}) => materialMaintenanceList.msg,
                tableData: ({materialMaintenanceList}) => materialMaintenanceList.materialMaintenanceList,
                pageNo: ({materialMaintenanceList}) => materialMaintenanceList.pageNo,
                pageSize: ({materialMaintenanceList}) => materialMaintenanceList.pageSize,
                total: ({materialMaintenanceList}) => materialMaintenanceList.total,
                pages: ({materialMaintenanceList}) => materialMaintenanceList.pages,
                loading2: ({projectMaintenanceList}) => projectMaintenanceList.loading,
                isSuccess2: ({projectMaintenanceList}) => projectMaintenanceList.isSuccess,
                msg2: ({projectMaintenanceList}) => projectMaintenanceList.msg,
                tableData2: ({projectMaintenanceList}) => projectMaintenanceList.projectMaintenanceList,
                pageNo2: ({projectMaintenanceList}) => projectMaintenanceList.pageNo,
                pageSize2: ({projectMaintenanceList}) => projectMaintenanceList.pageSize,
                total2: ({projectMaintenanceList}) => projectMaintenanceList.total,
                pages2: ({projectMaintenanceList}) => projectMaintenanceList.pages
            })
        },
        methods: {
            ...mapActions([
                'handleQueryMaterialList',
                'handleAddMaterial',
                'handleDeleteMaterial',
                'handleQueryProjectList',
                'handleAddProject',
                'handleDeleteProject'
            ]),
            /**
             * 初始化
             */
            init () {
                this.searchData();
                this.searchData2();
            },
            /**
             * 点击查询按钮执行查询操作
             */
            searchData () {
                console.log(this.searchFormDate);
                this.handleQueryMaterialList(this.searchFormDate).then(res => {
                    this.$Message.info(this.msg);
                    this.searchFormDate.pageInfo.pageNo = 1;
                });
            },
            searchData2 () {
                console.log(this.searchFormDate2);
                this.handleQueryProjectList(this.searchFormDate2).then(res => {
                    this.$Message.info(this.msg2);
                    this.searchFormDate2.pageInfo.pageNo = 1;
                });
            },
            /**
             * 页面改变
             */
            changePage (index) {
                this.searchFormDate.pageInfo.pageNo = index;
                this.searchData();
            },
            changePage2 (index) {
                this.searchFormDate2.pageInfo.pageNo = index;
                this.searchData2();
            },
            /**
             * 切换每页条数
             */
            pageSizeChange (newPageSize) {
                this.searchFormDate.pageInfo.pageSize = newPageSize;
                this.searchData();
            },
            pageSizeChange2 (newPageSize) {
                this.searchFormDate2.pageInfo.pageSize = newPageSize;
                this.searchData2();
            },
            /**
             * 添加数据
             */
            addData () {
                this.modal = true;
                this.setBtnHidden();
            },
            addData2 () {
                this.modal2 = true;
                this.setBtnHidden2();
            },
            /**
             * 删除数据
             */
            deleteData: function () {
                if (this.rowData.length !== 1 || isEmpty(this.rowData)) {
                    this.$Modal.warning({
                        title: '提示',
                        content: '请选择一条记录!'
                    });
                } else {
                    this.$Modal.confirm({
                        title: '删除',
                        content: '<p>您确定要删除这条数据吗?</p>',
                        onOk: () => {
                            this.handleDeleteMaterial(this.id).then(res => {
                                this.$Message.info(this.msg);
                                this.rowData = [];
                                this.searchData();
                            });
                        },
                        onCancel: () => {
                        }
                    });
                }
            },
            deleteData2: function () {
                if (this.rowData2.length !== 1 || isEmpty(this.rowData2)) {
                    this.$Modal.warning({
                        title: '提示',
                        content: '请选择一条记录!'
                    });
                } else {
                    this.$Modal.confirm({
                        title: '删除',
                        content: '<p>您确定要删除这条数据吗?</p>',
                        onOk: () => {
                            this.handleDeleteProject(this.id2).then(res => {
                                this.$Message.info(this.msg2);
                                this.rowData2 = [];
                                this.searchData2();
                            });
                        },
                        onCancel: () => {
                        }
                    });
                }
            },
            // 点击选择
            selectionClick: function (row) {
                this.rowData = row;
                this.id = row[0].id;
                // alert(JSON.stringify(row[0].id));
            },
            selectionClick2: function (row) {
                this.rowData2 = row;
                this.id2 = row[0].id;
                // alert(JSON.stringify(row[0].id));
            },
            /**
             * 重置按钮
             */
            cleanData (name) {
                // window.location.reload();
                this.$refs[name].resetFields();
                this.searchData();
            },
            cleanData2 (name) {
                // window.location.reload();
                this.$refs[name].resetFields();
                this.searchData2();
            },
            // 保存按钮
            handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.handleAddMaterial(this.FormAdd).then(res => {
                            this.$Message.success(this.msg);
                            this.searchData();
                            this.modal = false;
                        });
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            },
            handleSubmit2 (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.handleAddProject(this.FormAdd2).then(res => {
                            this.$Message.success(this.msg2);
                            this.searchData2();
                            this.modal2 = false;
                        });
                    } else {
                        this.$Message.error('验证错误!');
                    }
                });
            },
            // 取消按钮
            handleReset (name) {
                this.$refs[name].resetFields();
                this.modal = false;
            },
            handleReset2 (name) {
                this.$refs[name].resetFields();
                this.modal2 = false;
            },
            setBtnHidden () {
                var materialModal = document.getElementById('material-modal');
                var child = materialModal.lastChild.lastChild.lastChild.lastChild;
                child.style.display = 'none';
            },
            setBtnHidden2 () {
                var materialModal2 = document.getElementById('material-modal2');
                var child = materialModal2.lastChild.lastChild.lastChild.lastChild;
                child.style.display = 'none';
            }
        },
        mounted () {
            this.init();
        }
    };
</script>
