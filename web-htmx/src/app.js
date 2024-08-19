import express from "express";
import userRouter from "./routers/user.js";
import webRouter from "./routers/web.js";
import {__dirname, PORT} from "./constants/system.js";

const app = express();

//  routers
app.use(userRouter);
app.use(webRouter);

//  static
app.use(
    "/static",
    express.static(__dirname + "/src/web")
);

app.listen(PORT);