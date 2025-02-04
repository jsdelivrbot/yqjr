import { apiQueryTeamById } from '../../../../api/sale-team/team-maintenance/teamMainTenanceApi';
import config from '@/config';
import {formatDate} from '@/libs/util.js';

const teamView = {
    state: {
        teamViewData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize:
        config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryTeamViewById ({ commit }, formQueryData) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamById(formQueryData).then(res => {
                    commit('setTeamViewData', res);
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
        setTeamViewData (state, data) {
            console.log(data.rows)
            state.teamViewData = data.rows[0];
            state.teamViewData.startTime = formatDate(state.teamViewData.startTime, 'yyyy-MM-dd');
            state.teamViewData.createTime = formatDate(state.teamViewData.createTime, 'yyyy-MM-dd');
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default teamView;
