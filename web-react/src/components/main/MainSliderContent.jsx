import React from "react";
import "./MainSliderContent.css";

export default function MainSliderContent({item}) {
    return (
        <div key={item.id}>
            <div className="img-body">
                <img src={item.src} />
            </div>
            <div>
                <h2>{item.id}</h2>
                <p>test description</p>
            </div>
        </div>
    )
}