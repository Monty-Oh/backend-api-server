import express from "express";
import {URL_WEB_LOGIN} from "../constants/api.js";
import {requestLogin} from "../common/axios.js";

//  userRouter
const router = express.Router();

/**
 * 로그인 요청
 */
router.post(
    URL_WEB_LOGIN,
    async (req, res) => {
        const {loginId, password} = req.body;
        try {
            const response = await requestLogin(loginId, password)
            const {accessToken, refreshToken} = response.data;
            res.send({accessToken, refreshToken});
        } catch (error) {
            const {code, message} = error.response.headers;
            const decodedMessage = decodeURI(message).replace(/\+/g, ' ');
            res.send({code, message: decodedMessage});
        }
    }
)

export default router;