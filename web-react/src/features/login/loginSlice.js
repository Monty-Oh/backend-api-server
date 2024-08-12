import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import {requestLogin} from "../../api/axiosClient";
import {LOCAL_STORAGE_KEY_ACCESS_TOKEN, LOCAL_STORAGE_KEY_REFRESH_TOKEN} from "../../common/constants";

//  RequestLogin
export const fetchLogin = createAsyncThunk('data/fetchData', async ({id, password}) => {
    const response = await requestLogin(id, password);
    return response.data;
});

const fetchLoginReducers = (builder) => {
    builder
        .addCase(fetchLogin.fulfilled, (state, action) => {
            state.accessToken = action.payload.accessToken;
            state.refreshToken = action.payload.refreshToken;
            state.isLoggedIn = true;

            localStorage.setItem(LOCAL_STORAGE_KEY_ACCESS_TOKEN, action.payload.accessToken);
            localStorage.setItem(LOCAL_STORAGE_KEY_REFRESH_TOKEN, action.payload.refreshToken);
        });
}

const loginSlice = createSlice({
    name: "token",
    initialState: {
        isLoggedIn: false,
        accessToken: "",
        refreshToken: ""
    },
    reducers: {},
    extraReducers: (builder) => {
        fetchLoginReducers(builder);
    }
});

export default loginSlice.reducer;