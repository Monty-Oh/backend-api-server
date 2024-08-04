import React, {useState} from "react";
import cat from '../../assets/cat.jpeg'
import './LoginPage.css';
import {useDispatch, useSelector} from "react-redux";
import {login} from "./authSlice";

export default function LoginPage() {
    const dispatch = useDispatch();
    const accessToken = useSelector(state => state.token.accessToken);

    const [loginId, setLoginId] = useState("");
    const [loginPassword, setLoginPassword] = useState("");

    //  input ID
    function onChangeLoginId(event) {
        setLoginId(event.target.value);
    }

    //  input PASSWORD
    function onChangeLoginPassword(event) {
        setLoginPassword(event.target.value);
    }

    //  request Login
    function onClickLoginButton() {
        dispatch(
            login({
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
                                        <input type="text" id="iaf3j" onChange={onChangeLoginId}/>
                                    </div>
                                    <div className="gjs-grid-column" id="imlg5">
                                        <div id="iir57">ID</div>
                                    </div>
                                </div>
                                <div className="gjs-grid-row" id="i9j0x">
                                    <div className="gjs-grid-column" id="ibuuh">
                                        <input type="text" id="inhym" onChange={onChangeLoginPassword}/>
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
                    {accessToken}
                </div>
            </div>
        </div>
    )
}
