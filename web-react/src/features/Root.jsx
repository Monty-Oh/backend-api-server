import Login from "./login/Login";
import React, {useEffect} from "react";
import {useDispatch, useSelector} from "react-redux";
import Main from "./main/Main";
import {LOCAL_STORAGE_KEY_ACCESS_TOKEN, LOCAL_STORAGE_KEY_REFRESH_TOKEN} from "../common/constants";
import {setTokens} from "./login/loginSlice";

function Root() {
    const dispatch = useDispatch();

    //  최초 페이지 로딩 시 localStorage 에서 토큰을 조회한 후 state 에 저장
    const isLoggedIn = useSelector(state => state.token.isLoggedIn);
    useEffect(() => {
        const accessToken = localStorage.getItem(LOCAL_STORAGE_KEY_ACCESS_TOKEN);
        const refreshToken = localStorage.getItem(LOCAL_STORAGE_KEY_REFRESH_TOKEN);
        if (accessToken && refreshToken) {
            const tokens = {accessToken, refreshToken};
            dispatch(setTokens(tokens));
        }
    }, [dispatch]);

    //  토큰 값 변화 시 localStorage 에 저장
    const accessToken = useSelector(state => state.token.accessToken);
    const refreshToken = useSelector(state => state.token.refreshToken);
    useEffect(() => {
        if (accessToken && refreshToken) {
            localStorage.setItem(LOCAL_STORAGE_KEY_ACCESS_TOKEN, accessToken);
            localStorage.setItem(LOCAL_STORAGE_KEY_REFRESH_TOKEN, refreshToken);
        }
    }, [accessToken, refreshToken])

    return (
        <div>
            {isLoggedIn ? <Main/> : <Login/>}
        </div>
    );
}

export default Root;