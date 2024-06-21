import axios from "axios";

//  HTTP 요청 공통 설정
const httpConfig = {
    baseUrl: 'http://localhost:3000',
    urls: {
        userHealthCheck: '/user/monitor/healthcheck',
    }
}

//  HTTP 요청 Functions
function requestServerStatus() {
    return axios.post(httpConfig.baseUrl + httpConfig.urls.userHealthCheck);
}

export {
    requestServerStatus,
}