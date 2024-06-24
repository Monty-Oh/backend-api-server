import axios from "axios";

//  HTTP 요청 공통 설정
const userHttpConfig = {
    baseUrl: '/api',
    urls: {
        userHealthCheck: '/user/monitor/healthcheck',
        userLogin: '/user/v1/users/login',
    }
}

//  HTTP 요청 Functions
function requestServerStatus() {
    return axios.get(userHttpConfig.baseUrl + userHttpConfig.urls.userHealthCheck);
}

function requestLogin(loginId, password) {
    console.log(loginId, password);
    return axios.post(
        userHttpConfig.baseUrl + userHttpConfig.urls.userLogin,
        {loginId, password}
    )
}

export {
    requestServerStatus,
    requestLogin,
}