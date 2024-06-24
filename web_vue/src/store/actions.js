import {requestLogin, requestServerStatus} from "@/api/index.js";

const actions = {
    async REQUEST_LOGIN(context, {id, password}) {
        try {
            const result = await requestLogin(id, password);
            console.log(result.data);
            context.commit('SET_ACCESS_TOKEN');
        } catch (e) {
            console.error(e);
        }
    }
}

export default actions;