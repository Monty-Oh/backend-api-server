import axios from "axios";

//  HTTP 요청 공통 설정
const httpConfig = {
    baseUrl: 'http://localhost:3000',
    urls: {
        //  user
        userHealthCheck: '/user/monitor/healthcheck',
        userLogin: '/user/v1/users/login',

        //  auth
        authValidate: "/auth/v1/token/validate"
    }
}

//  로그인 요청
export function requestLogin(loginId, password) {
    return axios
        .post(
            httpConfig.baseUrl + httpConfig.urls.userLogin,
            {loginId, password}
        )
}

//  액세스 토큰 검증 요청
export function requestValidateToken(accessToken) {

}

//  Default Error Handler
export function requestErrorHandler(error) {
    const {code, message} = error.response
        ? error.response.headers
        : {code: "0000", message: "Server Connection Error"}
    ;
    const decodedMessage = decodeURI(message).replace(/\+/g, ' ');
    return {code, message: decodedMessage};
}