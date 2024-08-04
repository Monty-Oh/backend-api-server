import {createSlice} from "@reduxjs/toolkit";
import {requestLogin} from '../../api';

//  API 개섡 참고: https://ko.redux.js.org/tutorials/essentials/part-5-async-logic
//  TODO: redux-thunk? redux-saga? 뭘 쓰지?
export const authSlice = createSlice({
    name: "token",
    initialState: {
        accessToken: "",
        refreshToken: ""
    },
    reducers: {
        setToken: (state, action) => {
            console.log(action);
            state.accessToken = action.payload.accessToken;
            state.refreshToken = action.payload.refreshToken;
        },
        login: async (state, action) => {
            const result = await requestLogin(action.payload.id, action.payload.password);
            console.log(result);
            state.accessToken = result.data.accessToken;
            state.refreshToken = result.data.refreshToken;
        }
    }
});

export const {setToken, login} = authSlice.actions;

export default authSlice.reducer;