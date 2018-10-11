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
                        <Col span="6" offset="2">
                            <FormItem label="登录名:">
                                <Input  placeholder="请输入指标代码" v-model="searchFormDate.loginName" style="width:200px" ></Input>
                            </FormItem>
                        </Col>
                    </Row>
                    <Row>
                        <Col span="3" offset="9">
                            <Button type="primary" icon="search" @click="searchData">查询</Button>
                        </Col>
                        <Col span="3">
                            <Button icon="close" @click="cleanData">重置</Button>
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
                <Row type="flex" justify="end" :gutter="8" >
                    <Col>
                        <Button icon="android-add"  type="success" @click="addData">添加</Button>
                    </Col>
                    <Col>
                        <Button icon="android-close" type="error" @click="deletEventTeamData">删除</Button>
                    </Col>
                </Row>
                <Table :data="tableData" @on-selection-change='selectionClick' :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10"></Table>
                <div style="margin: 10px;overflow: hidden;height:135px">
                    <div style="float: right;">
                        <Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total show-sizer></Page>
                    </div>
                </div>
            </Card>
        </Row>
    </div>
</template>
<script>
    import {resetWorkHeight, getUserCookie, isEmpty} from '@/libs/util.js';
    import {mapActions, mapState} from 'vuex';
    export default {
        name: 'userSelect',
        data () {
            return {
                searchFormDate: {
                    pageInfo: {
                        pageSize: '10',
                        pageNo: '1'
                    }
                },
                idArr: [],
                tableColumns: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '登录名',
                        key: 'loginName',
                        align: 'center',
                        sortable: true
                    }, {
                        title: '用户名称',
                        align: 'center',
                        // key: 'userName',
                        render: (h, params) => {
                            const row = params.row;
                            return h('div', [
                                h('a', {
                                    // props: {
                                    //     type: 'primary',
                                    //     size: 'small'
                                    // },
                                    // style: {
                                    //     marginRight: '6px'
                                    // },
                                    on: {
                                        click: () => {
                                            let routerParam = {id: params.row.id};
                                            this.$router.push({
                                                name: 'userAuthority',
                                                query: routerParam
                                            });
                                        }
                                    }
                                }, row.userName)
                            ]);
                        }
                    }, {
                        title: '所属公司',
                        align: 'center',
                        key: 'comCode'
                    }, {
                        title: '所属机构',
                        align: 'center',
                        key: 'affiliation'
                    }, {
                        title: '状态',
                        align: 'center',
                        key: 'state'
                    }, {
                        title: '最后更新时间',
                        align: 'center',
                        key: 'endTime'
                    }, {
                        title: '操作',
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '6px'
                                    },
                                    on: {
                                        click: () => {
                                            let routerParam = {id: params.row.id};
                                            this.$router.push({
                                                name: 'teamEventView',
                                                query: routerParam
                                            });
                                        }
                                    }
                                }, '查看'),
                                h('Button', {
                                    props: {
                                        type: 'warning',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            let routerParam = {id: params.row.id};
                                            this.$router.push({
                                                name: 'teamEventEdit',
                                                query: routerParam
                                            });
                                        }
                                    }
                                }, '修改')
                            ]);
                        }
                    }
                ]
            };
        },
        computed: {
            ...mapState({
                loading: ({userList}) => userList.loading,
                tableData: ({userList}) => userList.userList,
                pageNo: ({userList}) => userList.pageNo,
                pageSize: ({userList}) => userList.pageSize,
                total: ({userList}) => userList.total,
                pages: ({userList}) => userList.pages
            })
        },
        methods: {
            ...mapActions([
                'handleUserList',
                'handleDelUser'
            ]),
            /**
             * 初始化
             */
            init () {
                const user = getUserCookie();
                const roleCode = user.roleCodeList;
                if (roleCode.indexOf('0000') >= 0 || roleCode.indexOf('0001') >= 0 || roleCode.indexOf('0002') >= 0) {
                    this.showFlag.areaFlag = true;
                } else {
                    this.showFlag.areaFlag = false;
                }
                this.searchData();
            },
            searchData () {
                this.handleUserList(this.searchFormDate).then(res => {
                    resetWorkHeight();
                    this.$Message.info('查询成功!');
                });
            },
            /**
             * 页面改变
             */
            changePage (index) {
                this.searchFormDate.pageInfo.pageNo = index;
                this.handleUserList(this.searchFormDate).then(res => {
                    resetWorkHeight();
                    this.$Message.info('查询成功!');
                    this.searchFormDate.pageInfo.pageNo = 1;
                });
            },
            /**
             * 切换每页条数
             */
            pageSizeChange (newPageSize) {
                this.searchFormDate.pageInfo.pageSize = newPageSize;
                this.handleUserList(this.searchFormDate).then(res => {
                    resetWorkHeight();
                    this.$Message.info('查询成功!');
                });
            },
            /**
             * 重置按钮
             */
            cleanData () {
                window.location.reload();
            },
            addData () {
                this.$router.push({name: 'userAdd'});
            },
            delData () {
                if (isEmpty(this.idArr)) {
                    this.$Message.info('请先选择一条数据再进行删除!');
                } else {
                    this.$Modal.confirm({
                        title: '删除',
                        content: '<p>您确定要删除这条数据吗?</p>',
                        onOk: () => {
                            this.handleDelUser(this.idArr).then(res => {
                                this.$Message.info('删除成功!');
                                this.searchData();
                            });
                        },
                        onCancel: () => {
                        }
                    });
                }
            },
            selectionClick: function (arr) {
                var idArr = [];
                if (!isEmpty(arr)) {
                    for (var i = 0; i < arr.length; i++) {
                        idArr.push(arr[i].id);
                    }
                }
                this.idArr = idArr;
                console.log(idArr);
            },
            /**
             * 修改数据
             */
            editData () {
                this.$router.push({name: 'userEdit'});
            }
        },
        mounted () {
            this.init();
        }
    }
    ;
</script>

