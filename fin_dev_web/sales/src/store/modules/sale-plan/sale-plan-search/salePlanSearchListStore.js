import {apiQueryPersonPlanList} from '../../../../api/sale-plan/sale-plan-search/salePlanSearchListApi';
import {apiOptionBrand} from '../../../../api/sale-option/option-brand/optionBrandApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const salePlanSearchList = {
    state: {
        personPlanListData: [],
        brandsList: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleQueryPersonPlanList ({ commit }, formQueryData) {
            formQueryData.year = formatDate(formQueryData.year, 'yyyy');
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryPersonPlanList(formQueryData).then(res => {
                    commit('setQueryPersonPlanList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleSearchCarBrands ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiOptionBrand(formQueryData).then(res => {
                    commit('setQueryBrandsList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        }
    },
    mutations: {
        setQueryPersonPlanList (state, data) {
            state.personPlanListData = data.rows;
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
        },
        setQueryBrandsList (state, data) {
            state.brandsList = data.result;
            console.log(state.brandsList)
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default salePlanSearchList;
