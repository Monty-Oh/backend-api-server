import {BrowserRouter, Route, Routes} from "react-router-dom";
import Main from "./main/Main";
import Login from "./login/Login";
import React from "react";
import {URL_LOGIN_PAGE, URL_MAIN_PAGE, URL_ROOT} from "../common/constants";

function Root() {
    return (
        <BrowserRouter basename={URL_ROOT}>
            <Routes>
                <Route path={URL_MAIN_PAGE} element={<Main/>}/>
                <Route path={URL_LOGIN_PAGE} element={<Login/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default Root;