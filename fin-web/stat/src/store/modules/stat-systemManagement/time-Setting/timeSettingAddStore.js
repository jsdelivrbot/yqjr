import {apiAdd} from '../../../../api/stat-systemManagement/timeSettingApi';
import config from '@/config';

const timeSettingAdd = {
    state: {
        timeSettingAdd: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize:
        config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0, // 总页数
        isSuccess: true
    },
    actions: {
        InsertTimeSetting ({ commit }, formQueryData) {
            commit('sendin');//  formQueryData.startTime = formatDate(formQueryData.startTime, 'yyyy-MM-dd');
            return new Promise((resolve, reject) => {
                apiAdd(formQueryData).then(res => {
                    commit('setTeamAddData', res);
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
            state.timeSettingAdd = data.msg;
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
export default timeSettingAdd;
