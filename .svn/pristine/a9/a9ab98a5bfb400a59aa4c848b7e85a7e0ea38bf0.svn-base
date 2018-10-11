import {apiQueryMaterialList, apiAddMaterial, apiDeleteMaterial} from '../../../../api/material-management/material-maintenance/materialMaintenanceApi';
import config from '@/config';
import {isEmpty, formatDate, compare} from '@/libs/util.js';
const materialMaintenanceList = {
    state: {
        materialMaintenanceList: [],
        loading: false,
        isSuccess: false,
        msg: '',
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleQueryMaterialList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryMaterialList(formQueryData).then(res => {
                    commit('setQueryMaterialList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleAddMaterial ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiAddMaterial(formQueryData).then(res => {
                    commit('setAddMaterial', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleDeleteMaterial ({ commit }, id) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiDeleteMaterial(id).then(res => {
                    commit('setDeleteMaterial', res);
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
        setQueryMaterialList (state, data) {
            console.log(data);
            if (data.isSuccess === true) {
                state.msg = '请求成功';
            } else {
                state.msg = '请求失败';
            }
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.materialMaintenanceList = data.rows;
            state.isSuccess = data.isSuccess;
        },
        setAddMaterial (state, data) {
            state.isSuccess = data.isSuccess;
            state.msg = data.msg;
        },
        setDeleteMaterial (state, data) {
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
export default materialMaintenanceList;
