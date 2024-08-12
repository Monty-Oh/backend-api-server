import React, {useEffect, useState} from "react";
import './Login.css';
import {useDispatch, useSelector} from "react-redux";
import {fetchLogin} from "./loginSlice";
import cat from "../../assets/cat.jpeg";
import {useNavigate} from "react-router-dom";
import {URL_MAIN_PAGE} from "../../common/constants";

export default function Login() {

    const isLoggedIn = useSelector((state) => state.token.isLoggedIn);
    const navigate = useNavigate();
    useEffect(() => {
        if (isLoggedIn) navigate(URL_MAIN_PAGE);
    }, [isLoggedIn, navigate]);

    const [loginId, setLoginId] = useState("");
    const [loginPassword, setLoginPassword] = useState("");

    //  request Login
    const dispatch = useDispatch();
    function onClickLoginButton() {
        dispatch(
            fetchLogin({
                id: loginId,
                password: loginPassword
            })
        );
    }

    return (
        <div id="feature-section" className="gjs-grid-row">
            <div id="imymf" className="gjs-grid-column">
                <div id="ib541" className="gjs-grid-row">
                    <div id="iz8m8" className="gjs-grid-column">
                        <h4 id="ij2gh" className="gjs-heading gjs-text-blue">ADMIN</h4>
                        <h2 id="ism014" className="gjs-heading">로그인</h2>
                        <div className="gjs-grid-row" id="iyty1">
                            <div className="gjs-grid-column">
                                <div className="gjs-grid-row" id="i6ga5">
                                    <div className="gjs-grid-column" id="idq8y">
                                        <input type="text" id="iaf3j" onChange={(e) => setLoginId(e.target.value)}/>
                                    </div>
                                    <div className="gjs-grid-column" id="imlg5">
                                        <div id="iir57">ID</div>
                                    </div>
                                </div>
                                <div className="gjs-grid-row" id="i9j0x">
                                    <div className="gjs-grid-column" id="ibuuh">
                                        <input type="password" id="inhym" onChange={(e) => setLoginPassword(e.target.value)}/>
                                    </div>
                                    <div className="gjs-grid-column" id="iv3s6">
                                        <div id="itu1f">PASSWORD</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button id="iqx3z1" className="gjs-button" onClick={onClickLoginButton}>LOGIN</button>
                    </div>
                    <div id="iepks" className="gjs-grid-column">
                        <img src={cat} id="i466d" alt="고양이"/>
                    </div>
                </div>
            </div>
        </div>
    )
}
