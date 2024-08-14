import {Route, Routes, useNavigate} from "react-router-dom";
import Main from "./main/Main";
import Login from "./login/Login";
import React, {useEffect} from "react";
import {URL_LOGIN_PAGE, URL_MAIN_PAGE} from "../common/constants";
import {useSelector} from "react-redux";

function Root() {
    // const isLoggedIn = useSelector(state => state.token.isLoggedIn);
    // const navigate = useNavigate();
    // useEffect(() => {
    //     if (isLoggedIn) navigate(URL_MAIN_PAGE);
    // }, [isLoggedIn, navigate])

    return (
        <Routes>
            <Route path={URL_MAIN_PAGE} element={<Main/>}/>
            <Route path={URL_LOGIN_PAGE} element={<Login/>}/>
        </Routes>
    );
}

export default Root;