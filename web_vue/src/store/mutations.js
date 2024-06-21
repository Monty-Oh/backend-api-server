const mutations = {
    SET_STATE(state, {menu, data}) {
        state[menu] = data;
    }
}

export default mutations;