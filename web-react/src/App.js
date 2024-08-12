import './App.css';
import React from "react";
import Root from "./features/Root";
import {BrowserRouter} from "react-router-dom";
import {URL_ROOT} from "./common/constants";

function App() {
    return (
        <div className="App">
            <BrowserRouter basename={URL_ROOT}>
                <Root/>
            </BrowserRouter>
        </div>
    );
}

export default App;
