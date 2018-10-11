import {apiQueryMaterialAcceptanceList, apiRegisterMaterialAcceptance, apiExportMaterialAcceptance} from '../../../../api/material-management/material-acceptance/materialAcceptanceApi';
import config from '@/config';
import {isEmpty, formatDate, compare} from '@/libs/util.js';
const materialAcceptanceList = {
    state: {
        materialAcceptanceList: [],
        loading: false,
        isSuccess: false,
        msg: '',
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleQueryMaterialAcceptanceList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryMaterialAcceptanceList(formQueryData).then(res => {
                    commit('setQueryMaterialAcceptanceList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleRegisterMaterialAcceptance ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiRegisterMaterialAcceptance(formQueryData).then(res => {
                    commit('setRegisterMaterialAcceptance', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleExportMaterialAcceptance ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiExportMaterialAcceptance(formQueryData).then(res => {
                    commit('setExportMaterialAcceptance', res);
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
        setQueryMaterialAcceptanceList (state, data) {
            console.log(data);
            if (data.isSuccess === true) {
                state.msg = '请求成功';
            } else {
                state.msg = '请求失败';
            }
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.materialAcceptanceList = data.rows;
            state.isSuccess = data.isSuccess;
        },
        setRegisterMaterialAcceptance (state, data) {
            state.isSuccess = data.isSuccess;
            state.msg = data.msg;
        },
        setExportMaterialAcceptance (state, data) {
            state.isSuccess = data.isSuccess;
            state.msg = data.msg;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default materialAcceptanceList;
