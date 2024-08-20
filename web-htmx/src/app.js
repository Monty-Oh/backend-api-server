import express from "express";
import authRouter from "./routers/auth.js";
import userRouter from "./routers/user.js";
import webRouter from "./routers/web.js";
import {__dirname, PORT} from "./constants/system.js";

const app = express();

app.use(express.json())
app.use(express.urlencoded({extended: true}));

//  routers
app.use(authRouter);
app.use(userRouter);
app.use(webRouter);

//  static
app.use(
    "/static",
    express.static(__dirname + "/src/web")
);

app.listen(PORT);