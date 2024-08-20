import express from "express";
import {__dirname} from "../constants/system.js";

/**
 * WEB 페이지 라우터
 */
const router = express.Router();
router.get(
    "/",
    (req, res) => {
        res.sendFile(__dirname + "/src/web/index.html");
    }
)

export default router;