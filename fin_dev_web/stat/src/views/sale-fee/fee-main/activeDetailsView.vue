<style lang="less">
    @import '../../../styles/common.less';
</style>
<template>
    <div>
        <Form :label-width="100">
            <Card>
                <p slot="title">
                    <Icon type="search"></Icon>
                    业务明细查看
                </p>
                <a href="#" slot="extra" @click.prevent="exportExcel">
                    <Icon type="ios-cloud-download"></Icon>
                    导出数据
                </a>
                <Table :data="activeDetailsListData" :columns="tableColumns"  :loading="loading" ref="tableExcel" class="margin-top-10" ></Table>
                <div style="margin: 10px;overflow: hidden">
                    <div style="float: right;">
                        <Page :total="total" :current="pageNo" :page-size="pageSize" size="small" @on-change="changePage" @on-page-size-change="pageSizeChange" show-total show-sizer></Page>
                    </div>
                </div>
                <Row>
                    <Col span="4" offset="9">
                        <Button type="primary" icon="reply" @click.prevent="pageBack">返回</Button>
                    </Col>
                </Row>
            </Card>
        </Form>
        <a id="hrefToExportTable" style="postion: absolute;left: -10px;top: -10px;width: 0px;height: 0px;"></a>
    </div>
</template>
<script>
import { mapActions, mapState } from 'vuex';
import {resetWorkHeight} from '@/libs/util.js';
import table2excel from '@/libs/table2excel.js';
export default{
    name: 'activeDetailsList',
    data () {
        return {
            searchFormDate: {
                businessCode: '',
                pageInfo: {
                    pageSize: '10',
                    pageNo: '1'
                }
            },
            tableColumns: [
                {
                    title: '活动名称',
                    align: 'center',
                    key: 'businessName'
                }, {
                    title: '活动代码',
                    align: 'center',
                    key: 'businessCode'
                }, {
                    title: '区域名称',
                    align: 'center',
                    key: 'largeAreaName'
                }, {
                    title: '活动经销商',
                    align: 'center',
                    key: 'distributorName'
                }, {
                    title: '活动品牌',
                    align: 'center',
                    key: 'brandsName'
                }, {
                    title: '活动子品牌',
                    align: 'center',
                    key: 'seriesName'
                }, {
                    title: '活动车型',
                    align: 'center',
                    key: 'carBrandTypeName'
                }, {
                    title: '贷款金额',
                    align: 'center',
                    key: 'nloanMoney'
                }, {
                    title: '贷款期限',
                    align: 'center',
                    key: 'timeLimit'
                }, {
                    title: '放款截止日期',
                    align: 'center',
                    key: 'dfactstartDate'
                }, {
                    title: '营销活动',
                    align: 'center',
                    key: 'nactivitiesName'
                }, {
                    title: '金融产品',
                    align: 'center',
                    key: 'ndlrbizTypeName'
                }, {
                    title: '业务模式',
                    align: 'center',
                    key: 'nbizTypeName'
                }, {
                    title: '信贷产品',
                    align: 'center',
                    key: 'ngetinterestTypeName'
                }
            ],
            excelFileName: '活动明细'
        };
    },
    computed: {
        ...mapState({
            loading: ({activeDetailsList}) => activeDetailsList.loading,
            activeDetailsListData: ({activeDetailsList}) => activeDetailsList.activeDetailsListData,
            pageNo: ({activeDetailsList}) => activeDetailsList.pageNo,
            pageSize: ({activeDetailsList}) => activeDetailsList.pageSize,
            total: ({activeDetailsList}) => activeDetailsList.total,
            pages: ({activeDetailsList}) => activeDetailsList.pages
        })
    },
    methods: {
        ...mapActions([
            'handleQueryActiveDetailsByCode'
        ]),
        init () {
            const businessCode = this.$route.params.businessCode;
            this.searchFormDate.businessCode = businessCode;
            this.queryActiveDetailsByCode(this.searchFormDate);
            resetWorkHeight();
        },
        queryActiveDetailsByCode (data) {
            this.handleQueryActiveDetailsByCode(data).then(res => {});
        },
        pageBack () {
            this.$router.push({name: 'teamMainTenanceList'});
        },
        /**
         * 导出execl
         */
        exportExcel () {
            // table2excel.transform(this.$refs.tableExcel, 'hrefToExportTable', this.excelFileName);
            const businessCode = this.$route.params.businessCode;
            window.location = '/mkmm/sales/activeMatchDetails/activeMatchDetail?businessCode=' + businessCode;
        },
        /**
         * 页面改变
         */
        changePage (index) {
            this.searchFormDate.pageInfo.pageNo = index;
            this.handleQueryActiveDetailsByCode(this.searchFormDate).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
                this.searchFormDate.pageInfo.pageNo = 1;
            });
        },
        /**
         * 切换每页条数
         */
        pageSizeChange (newPageSize) {
            this.searchFormDate.pageInfo.pageSize = newPageSize;
            this.handleQueryActiveDetailsByCode(this.searchFormDate).then(res => {
                resetWorkHeight();
                // this.$Message.info('查询成功!');
            });
        },
        pageBack () {
            this.$router.push({name: 'feeDoPayList'});
        }
    },
    mounted () {
        this.init();
    }
};
</script>