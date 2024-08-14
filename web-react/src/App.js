import './App.css';
import React, {useEffect} from "react";
import Root from "./features/Root";
import {BrowserRouter} from "react-router-dom";
import {LOCAL_STORAGE_KEY_ACCESS_TOKEN, LOCAL_STORAGE_KEY_REFRESH_TOKEN, URL_ROOT} from "./common/constants";
import {useDispatch, useSelector} from "react-redux";
import {setTokens} from "./features/login/loginSlice";

function App() {
    const accessToken = useSelector(state => state.token.accessToken);
    const refreshToken = useSelector(state => state.token.refreshToken);
    const dispatch = useDispatch();

    //  컴포넌트 마운트 시 localStorage 에서 토큰 획득
    useEffect(() => {
        const accessToken = localStorage.getItem(LOCAL_STORAGE_KEY_ACCESS_TOKEN);
        const refreshToken = localStorage.getItem(LOCAL_STORAGE_KEY_REFRESH_TOKEN);
        if (accessToken && refreshToken) {
            const tokens = {accessToken, refreshToken};
            dispatch(setTokens(tokens));
        }
    }, []);

    //  토큰 값 변화 시 localStorage 에 저장
    useEffect(() => {
        localStorage.setItem(LOCAL_STORAGE_KEY_ACCESS_TOKEN, accessToken);
        localStorage.setItem(LOCAL_STORAGE_KEY_REFRESH_TOKEN, refreshToken);
    }, [accessToken, refreshToken])

    return (
        <div className="App">
            <BrowserRouter basename={URL_ROOT}>
                <Root/>
            </BrowserRouter>
        </div>
    );
}

export default App;
