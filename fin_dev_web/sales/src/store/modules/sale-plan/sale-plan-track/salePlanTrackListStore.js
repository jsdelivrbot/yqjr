import {ApiSearchArea, ApiSearchData, ApiSearchCarBrands} from '../../../../api/sale-plan/sale-plan-track/salePlanTrackListApit';
import config from '@/config';
import {isEmpty, formatDate} from '@/libs/util.js';
const salePlanTrackList = {
    state: {
        areaCodeList: [],
        loading: false,
        planTrackVoList: [],
        isSuccess: false,
        pageNo: 1,
        total: 0, // 总页数
        records: 0, // 总记录数
        pageSize: config.pageSize,
        searchDataforCarBrands: []
    },
    actions: {
        /**
         * 加载区域信息
         * @param commit
         * @returns {Promise<any>}
         */
        handelInitArea ({commit}) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                ApiSearchArea().then(res => {
                    commit('setAreaMes', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handelSearchDataForMes ({commit}, data) {
            commit('sendin');
            data.year = formatDate(data.year, 'yyyy');
            console.log(data);
            return new Promise((resolve, reject) => {
                ApiSearchData(data).then(res => {
                    commit('setSearchData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        /**
         * 加载品牌数据
         */
        handelSearchDateForCarBrands ({commit}) {
            return new Promise((resolve, reject) => {
                ApiSearchCarBrands().then(res => {
                    commit('setSearchDataForCarBrands', res);
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
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        },
        setAreaMes (state, data) {
            data.unshift({
                'headLetter': '',
                'label': ' 全部',
                'value': ''
            });
            state.areaCodeList = data;
        },
        setSearchData (state, data) {
            state.planTrackVoList = data.rows;
            state.records = data.records;
            state.pageNo = data.page;
            state.total = data.total;
        },
        setSearchDataForCarBrands (state, data) {
            if (!isEmpty(data.result)) {
                data.result.unshift({
                    'headLetter': '',
                    'label': ' 全部',
                    'value': ''
                });
                state.searchDataforCarBrands = data.result;
            } else {
                state.searchDataforCarBrands = [];
            }
            state.isSuccess = data.isSuccess;
        }
    }
};
export default salePlanTrackList;
