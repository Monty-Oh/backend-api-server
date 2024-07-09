const mutations = {
    SET_TOKENS: (state, result) => {
        state.accessToken = result.data.accessToken;
        state.refreshToken = result.data.refreshToken;
    }
}

export default mutations;