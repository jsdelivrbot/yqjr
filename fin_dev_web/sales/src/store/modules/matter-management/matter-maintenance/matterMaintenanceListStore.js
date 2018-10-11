import {apiQueryMatterList, apiAddMatter, apiDeleteMatter} from '../../../../api/matter-management/matter-maintenance/matterMaintenanceApi';
import config from '@/config';
import {isEmpty, formatDate, compare} from '@/libs/util.js';
const matterMaintenanceList = {
    state: {
        matterMaintenanceList: [],
        loading: false,
        isSuccess: false,
        msg: '',
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleQueryMatterList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryMatterList(formQueryData).then(res => {
                    commit('setQueryMatterList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleAddMatter ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiAddMatter(formQueryData).then(res => {
                    commit('setAddMatter', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleDeleteMatter ({ commit }, id) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiDeleteMatter(id).then(res => {
                    commit('setDeleteMatter', res);
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
        setQueryMatterList (state, data) {
            console.log(data);
            if (data.isSuccess === true) {
                state.msg = '请求成功';
            } else {
                state.msg = '请求失败';
            }
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.matterMaintenanceList = data.rows;
            state.isSuccess = data.isSuccess;
        },
        setAddMatter (state, data) {
            state.isSuccess = data.isSuccess;
            state.msg = data.msg;
        },
        setDeleteMatter (state, data) {
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
export default matterMaintenanceList;
