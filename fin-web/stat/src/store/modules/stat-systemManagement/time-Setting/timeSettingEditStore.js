/* eslint-disable no-console */
import {apiFindById, apiUpdate} from '../../../../api/stat-systemManagement/timeSettingApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const timeSettingEdit = {
    state: {
        timeSettingEdit: {},
        timeSettingMsg: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        isSuccess: true,
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        FindById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiFindById(formQueryData).then(res => {
                    commit('setTeamData1', res.result);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        Update ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiUpdate(formQueryData).then(res => {
                    commit('setTeamMsg', res);
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
        setTeamData1 (state, data) {
            state.timeSettingEdit = data;
        },
        setTeamMsg (state, data) {
            state.timeSettingMsg = data.msg;
            state.isSuccess = data.isSuccess;
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default timeSettingEdit;
