const getters = {
    getAccessToken: state => () => state.accessToken,
    getRefreshToken: state => () => state.refreshToken
}

export default getters;