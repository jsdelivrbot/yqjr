import { apiwarningAdd, apiyanZhengCode } from '../../../../api/stat-warning/warning-targettype/warningTargettypeApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const warningAdd = {
    state: {
        warningAddData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize:
        config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数
        isSuccess: true,
        msg: ''
    },
    actions: {
        WarningAddSto ({ commit }, formQueryData) {
            commit('sendin');
            formQueryData.startTime = formatDate(formQueryData.startTime, 'yyyy-MM-dd');
            console.log(formQueryData.startTime);
            return new Promise((resolve, reject) => {
                apiwarningAdd(formQueryData).then(res => {
                    commit('setTeamAddData', res);
                    commit('success');
                    resolve();
                }).catch(err => {
                    commit('success');
                    reject(err);
                });
            });
        },
        yanZhengCode ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiyanZhengCode(formQueryData).then(res => {
                    commit('setYanZhenData', res);
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
        setTeamAddData (state, data) {
            state.warningAddData = data.msg;
            state.isSuccess = data.isSuccess;
        },
        setYanZhenData (state, data) {
            state.msg = data.msg;
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
export default warningAdd;
