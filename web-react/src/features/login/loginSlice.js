import {createAsyncThunk, createSlice} from "@reduxjs/toolkit";
import {requestLogin} from "../../api/axiosClient";

//  RequestLogin
const fetchLogin = createAsyncThunk('data/fetchData', async ({id, password}) => {
    const response = await requestLogin(id, password);
    return response.data;
});

const loginSlice = createSlice({
    name: "token",
    initialState: {
        isLoggedIn: false,
        accessToken: "",
        refreshToken: ""
    },
    reducers: {
        setTokens: (state, action) => {
            state.accessToken = action.payload.accessToken;
            state.refreshToken = action.payload.refreshToken;
            state.isLoggedIn = state.accessToken && state.refreshToken;
        }
    },
    extraReducers: (builder) => {
        builder
            .addCase(fetchLogin.fulfilled, (state, action) => {
                state.accessToken = action.payload.accessToken;
                state.refreshToken = action.payload.refreshToken;
                state.isLoggedIn = true;
            });
    }
});

export default loginSlice.reducer;
export const {setTokens} = loginSlice.actions;
export {fetchLogin};
