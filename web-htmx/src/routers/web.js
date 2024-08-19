import express from "express";
import {URL_WEB_ROOT} from "../constants/api.js";
import {__dirname} from "../constants/system.js";

const router = express.Router();

router.get(
    URL_WEB_ROOT,
    (req, res) => {
        res.sendFile(__dirname + "/src/web/index.html");
    }
)

export default router;