import express from "express";

/**
 * Auth 도메인으로 요청하는 Router
 */
const router = express.Router();

// 액세스 토큰 검증 요청
router.post(
    "/token/validate",
    async (req, res) => {
        const {token} = req.body;
        // res.send("test");
    }
)

export default router;