import React from "react";
import {useSelector} from "react-redux";
import {selectGroupedData} from "../../store/content";
import MainSlider from "./MainSlider";

export default function Main() {
    const groupedData = useSelector(state => selectGroupedData(state));
    console.log(groupedData);

    return (
        <div className="main-container">
            {Object.entries(groupedData).map(([tag, contents]) => (
                <MainSlider key={tag} tag={tag} contents={contents}/>
            ))}
        </div>
    )
}