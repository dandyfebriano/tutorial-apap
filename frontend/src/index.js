import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import AppFunc from "./AppFunc";
import AppClass from "./App";
import * as serviceWorker from "./serviceWorker";
ReactDOM.render(
    <>
        <div className="mt-5" />
        <AppClass />
        <div className="mt-5 mb-5" />
        <AppFunc />
        <div className="mt-5 mb-5" />
    </>,
    // you should check public/index.html
    // there is a dom with id `root`
    document.getElementById("root")
);
// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();