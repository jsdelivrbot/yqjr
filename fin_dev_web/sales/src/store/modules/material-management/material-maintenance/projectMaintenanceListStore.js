import {apiQueryProjectList, apiAddProject, apiDeleteProject} from '../../../../api/material-management/project-maintenance/projectMaintenanceApi';
import config from '@/config';
import {isEmpty, formatDate, compare} from '@/libs/util.js';
const projectMaintenanceList = {
    state: {
        projectMaintenanceList: [],
        loading: false,
        isSuccess: false,
        msg: '',
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handleQueryProjectList ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryProjectList(formQueryData).then(res => {
                    commit('setQueryProjectList', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleAddProject ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiAddProject(formQueryData).then(res => {
                    commit('setAddProject', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        handleDeleteProject ({ commit }, id) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiDeleteProject(id).then(res => {
                    commit('setDeleteProject', res);
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
        setQueryProjectList (state, data) {
            console.log(data);
            if (data.isSuccess === true) {
                state.msg = '请求成功';
            } else {
                state.msg = '请求失败';
            }
            state.pageNo = data.page;
            state.total = data.records;
            state.pages = data.total;
            state.projectMaintenanceList = data.rows;
            state.isSuccess = data.isSuccess;
        },
        setAddProject (state, data) {
            state.isSuccess = data.isSuccess;
            state.msg = data.msg;
        },
        setDeleteProject (state, data) {
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
export default projectMaintenanceList;
