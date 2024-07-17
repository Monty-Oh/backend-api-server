import Vuex from 'vuex';
import actions from "@/store/actions.js";
import state from "@/store/state.js";
import getters from "@/store/getters.js";
import mutations from "@/store/mutations.js";

const store = new Vuex.createStore({
    state,
    actions,
    mutations,
    getters,
});

export default store
