import {requestLogin} from "@/api/index.js";

const actions = {
    async REQUEST_LOGIN(context, {id, password}) {
        try {
            const result = await requestLogin(id, password);
            context.commit('SET_TOKENS', result);
        } catch (e) {
            console.error(e);
        }
    }
}

export default actions;