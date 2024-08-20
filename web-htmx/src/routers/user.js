import express from "express";
import {requestErrorHandler, requestLogin} from "../common/axios.js";

/**
 * User 도메인으로 요청하는 Router
 */
const router = express.Router();

// 로그인 요청
router.post(
    "/login",
    async (req, res) => {
        const {loginId, password} = req.body;
        try {
            const response = await requestLogin(loginId, password)
            const {accessToken, refreshToken} = response.data;
            res.send({accessToken, refreshToken});
        } catch (error) {
            const {code, message} = requestErrorHandler(error);
            res.send({code, message});
        }
    }
)

export default router;