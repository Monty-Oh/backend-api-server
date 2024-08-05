import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import {requestLogin} from "../../api/axiosClient";

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
            console.log(state.accessToken, state.refreshToken);
        });
}

const loginSlice = createSlice({
    name: "token",
    initialState: {
        accessToken: "",
        refreshToken: ""
    },
    reducers: {},
    extraReducers: (builder) => {
        fetchLoginReducers(builder);
    }
});

export default loginSlice.reducer;