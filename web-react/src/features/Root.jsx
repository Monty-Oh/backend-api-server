import {BrowserRouter, Route, Routes} from "react-router-dom";
import Main from "./main/Main";
import Login from "./login/Login";
import React from "react";

function Root() {
    return (
            <BrowserRouter basename="/">
                <Routes>
                    <Route path="/" element={<Main/>}/>
                    <Route path="/login" element={<Login/>}/>
                </Routes>
            </BrowserRouter>
    );
}

export default Root;