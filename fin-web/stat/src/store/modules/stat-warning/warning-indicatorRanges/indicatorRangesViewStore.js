import { apiQueryTeamEventById2 } from '../../../../api/stat-warning/warning-indicatorRanges/indicatorRangesApi.js';
import config from '@/config';
import {formatDate} from '@/libs/util.js';
const indicatorRangesView = {
    state: {
        teamEventViewData: [],
        loading: false,
        pageNo: 1, // 当前页码
        pageSize:
        config.pageSize, // 每页记录数
        total: 0, // 总记录数
        pages: 0// 总页数
    },
    actions: {
        handelQueryTeamEventById2 ({ commit }, queryTeamEventView) {
            commit('sendin');
            return new Promise((resolve, reject) => {
                apiQueryTeamEventById2(queryTeamEventView).then(res => {
                    commit('setTeamEventView', res);
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
        setTeamEventView (state, data) {
            state.teamEventViewData = data.result;
            state.teamEventViewData.startTime = formatDate(state.teamEventViewData.startTime, 'yyyy-MM-dd');
            state.teamEventViewData.createTime = formatDate(state.teamEventViewData.createTime, 'yyyy-MM-dd');
        },
        sendin (state) {
            state.loading = true;
        },
        success (state) {
            state.loading = false;
        }
    }
};
export default indicatorRangesView;
