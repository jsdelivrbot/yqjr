import { apiQueryWarningById, apiUpdate } from '../../../../api/stat-warning/warning-targettype/warningTargettypeApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const warningEdit = {
    state: {
        warningEditData: {},
        warningEditMsg: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize: config.pageSize, // 每页记录数
        isSuccess: true,
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        QueryWarningById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryWarningById(formQueryData).then(res => {
                    commit('setTeamData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        WarningEditSubToSto ({ commit }, formQueryData) {
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
        setTeamData (state, data) {
            state.warningEditData = data.rows[0];
            state.warningEditData.createTime = formatDate(state.warningEditData.createTime, 'yyyy-MM-dd');
        },
        setTeamMsg (state, data) {
            state.warningEditMsg = data.msg;
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
export default warningEdit;
