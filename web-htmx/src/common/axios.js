import axios from "axios";

//  HTTP 요청 공통 설정
const userHttpConfig = {
    baseUrl: 'http://localhost:3000',
    urls: {
        userHealthCheck: '/user/monitor/healthcheck',
        userLogin: '/user/v1/users/login',
    }
}

//  로그인 요청
export function requestLogin(loginId, password) {
    return axios
        .post(
            userHttpConfig.baseUrl + userHttpConfig.urls.userLogin,
            {loginId, password}
        )
}