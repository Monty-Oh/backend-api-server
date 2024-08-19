import express from "express";
import {URL_USER_REQUEST_LOGIN, URL_WEB_LOGIN} from "../constants/api.js";
import axios from "axios";

//  userRouter
const router = express.Router();

/**
 * 로그인 요청
 */
router.post(
    URL_WEB_LOGIN,
    (req, res) => {
        const {loginId, password} = req.body;
        axios
            .post(URL_USER_REQUEST_LOGIN, {
                loginId,
                password
            })
            .then((response) => {
                const {accessToken, refreshToken} = response.data;
                res.send({
                    accessToken, refreshToken
                });
            })
            .catch((error) => {
                const {code, message} = error.response.headers;
                const decodedMessage = decodeURI(message).replace(/\+/g, ' ');
                res.send({
                    code,
                    message: decodedMessage
                });
            })
    }
)

export default router;