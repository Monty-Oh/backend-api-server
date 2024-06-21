import {requestServerStatus} from "@/api/index.js";

const actions = {
    async FETCH_STATE() {
        try {
            const response = await requestServerStatus();
            console.log(response);
        } catch (e) {
            console.error(e);
        }
    }
}

export default actions;