import axios from "axios";

//  HTTP 요청 공통 설정
const userHttpConfig = {
    baseUrl: '',
    urls: {
        userHealthCheck: '/user/monitor/healthcheck',
        userLogin: '/user/v1/users/login',
    }
}

//  로그인 요청
function requestLogin(loginId, password) {
    return axios({
        url: userHttpConfig.baseUrl + userHttpConfig.urls.userLogin,
        method: 'post',
        data: {
            loginId, password
        }
    });
}

export {
    requestLogin,
}