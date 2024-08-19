import express from "express";
import userRouter from "./routers/user.js";
import webRouter from "./routers/web.js";
import {__dirname, PORT} from "./constants/system.js";
import {URL_STATIC_ROOT} from "./constants/api.js";

const app = express();

app.use(express.json())
app.use(express.urlencoded({extended: true}));

//  routers
app.use(userRouter);
app.use(webRouter);

//  static
app.use(
    URL_STATIC_ROOT,
    express.static(__dirname + "/src/web")
);

app.listen(PORT);