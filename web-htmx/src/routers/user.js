import express from "express";
import {URL_USER_MONITOR_HEALTHCHECK} from "../constants/api.js";

//  userRouter
const router = express.Router();

/**
 * HealthCheck
 */
router.get(
    URL_USER_MONITOR_HEALTHCHECK,
    (req, res) => {
        res.send("test");
    }
)

export default router;