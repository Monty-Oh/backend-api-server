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
    return axios
        .post(
            userHttpConfig.baseUrl + userHttpConfig.urls.userLogin,
            {loginId, password}
        )
        .catch(errorHandler);
}

const errorHandler = (error) => {
    let {code, message} = error.response.headers;
    if (!(code && message)) {
        code = "0000";
        message = "Server Connection Error";
    }
    const decodedMessage = decodeURI(message).replace(/\+/g, ' ');
    alert(`[${code}] ${decodedMessage}`);
}

export {
    requestLogin,
}