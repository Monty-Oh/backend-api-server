import {requestLogin} from "@/api/index.js";

const actions = {
    async REQUEST_LOGIN(context, {id, password}) {
        try {
            const result = await requestLogin(id, password);
            context.commit('SET_TOKENS', result);
        } catch (error) {
            commonErrorHandler(error);
        }
    }
}

const commonErrorHandler = (error) => {
    let errorMessage = (error.response.headers["code"] && error.response.headers["message"])
        ? error.response.headers["message"]
        : "요청에 실패했습니다.";
    errorMessage = errorMessage.replace(/\+/g, ' ');
    alert(decodeURIComponent(errorMessage));
}

export default actions;