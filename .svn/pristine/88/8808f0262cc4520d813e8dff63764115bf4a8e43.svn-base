<style lang="less">
    @import '../../../styles/common.less';
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
                    <Col span="24">
                        <Form ref="searchFormDate" :rules="ruleValidate" :model="searchFormDate" :label-width="100">
                            <Row>
                                <Col span="8" offset="2">
                                    <FormItem label="素材类型：" prop="materialCode">
                                        <Select v-model="searchFormDate.materialCode">
                                            <Option value="00">素材1</Option>
                                            <Option value="01">素材2</Option>
                                            <Option value="02">素材3</Option>
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
                    </Col>
                </Row>
            </Card>
            <Card style="margin-top:10px;">
                <p slot="title">
                    <Icon type="search"></Icon>
                    查询数据
                </p>
                <Row>
                    <Col span="24">
                        <Row type="flex" justify="end" :gutter="8" >
                            <Col>
                                <Button icon="android-add"  type="success" @click="addData">新增</Button>
                            </Col>
                            <Col>
                                <Button icon="android-close"  type="error" @click="deleteData">删除</Button>
                            </Col>
                        </Row>
                        <Table ref="tableExcel" :data="tableData" @on-selection-change='selectionClick' :columns="tableColumns" :loading="loading" style="margin-top: 20px;"></Table>
                        <div style="margin: 10px;overflow: hidden">
                            <div style="float: right;">
                                <Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total  show-sizer placement="top" ></Page>
                            </div>
                        </div>
                        <Modal  id="material-modal"
                                v-model="modal"
                                title="素材新增">
                            <Form ref="FormAdd" :rules="ruleValidateAdd" :model="FormAdd" :label-width="100">
                                <Row>
                                    <Col span="24">
                                        <FormItem label="素材类型：" prop="materialCode">
                                            <Select v-model="FormAdd.materialCode">
                                                <Option value="00">素材1</Option>
                                                <Option value="01">素材2</Option>
                                                <Option value="02">素材3</Option>
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
        name: 'matterMaintenanceList',
        data () {
            const validateMaterialCodeCheck = (rule, value, callback) => {
                if (value === ' ' || value === null) {
                    callback(new Error('请输入物料类型!'));
                }
                callback();
            };
            return {
                name: '',
                ruleValidate: {},
                modal: false,
                searchFormDate: {
                    materialName: '',
                    materialCode: '',
                    pageInfo: {
                        pageSize: '10',
                        pageNo: '1'
                    }
                },
                rowData: [],
                tableColumns: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    }, {
                        title: '素材类型',
                        key: 'materialName',
                        align: 'center'
                    }, {
                        title: '备注',
                        key: 'remark',
                        align: 'center'
                    }
                ],
                FormAdd: {
                    materialName: '',
                    materialCode: '',
                    remark: ''
                },
                ruleValidateAdd: {
                    materialCode: [
                        { required: true, message: '请选择素材类型!', trigger: 'blur' },
                        {validator: validateMaterialCodeCheck}
                    ]
                },
                id: ''
            };
        },
        computed: {
            ...mapState({
                loading: ({matterMaintenanceList}) => matterMaintenanceList.loading,
                isSuccess: ({matterMaintenanceList}) => matterMaintenanceList.isSuccess,
                msg: ({matterMaintenanceList}) => matterMaintenanceList.msg,
                tableData: ({matterMaintenanceList}) => matterMaintenanceList.matterMaintenanceList,
                pageNo: ({matterMaintenanceList}) => matterMaintenanceList.pageNo,
                pageSize: ({matterMaintenanceList}) => matterMaintenanceList.pageSize,
                total: ({matterMaintenanceList}) => matterMaintenanceList.total,
                pages: ({matterMaintenanceList}) => matterMaintenanceList.pages
            })
        },
        methods: {
            ...mapActions([
                'handleQueryMatterList',
                'handleAddMatter',
                'handleDeleteMatter'
            ]),
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
                this.handleQueryMatterList(this.searchFormDate).then(res => {
                    this.$Message.info(this.msg);
                    this.searchFormDate.pageInfo.pageNo = 1;
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
             * 添加数据
             */
            addData () {
                this.modal = true;
                this.setBtnHidden();
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
                            this.handleDeleteMatter(this.id).then(res => {
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
            // 点击选择
            selectionClick: function (row) {
                this.rowData = row;
                this.id = row[0].id;
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
            // 保存按钮
            handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.handleAddMatter(this.FormAdd).then(res => {
                            this.$Message.success(this.msg);
                            this.searchData();
                            this.modal = false;
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
            setBtnHidden () {
                var materialModal = document.getElementById('material-modal');
                var child = materialModal.lastChild.lastChild.lastChild.lastChild;
                child.style.display = 'none';
            }
        },
        mounted () {
            this.init();
        }
    };
</script>
