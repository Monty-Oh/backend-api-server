import React, {useEffect, useState} from "react";
import MainSlider from "./MainSlider";

export default function Main() {
    const [contentData, setContentData] = useState([]);

    useEffect(() => {
        const fetchData = () => {
            const data = [
                { id: 1, tag: 'tag1', imageSrc: 'image1.jpg', order: 1 },
                { id: 2, tag: 'tag2', imageSrc: 'image2.jpg', order: 2 },
                { id: 3, tag: 'tag3', imageSrc: 'image3.jpg', order: 3 },
                { id: 4, tag: 'tag3', imageSrc: 'image3.jpg', order: 4 },
                { id: 5, tag: 'tag3', imageSrc: 'image3.jpg', order: 5 },
                // 더 많은 데이터...
            ];
            setContentData(data);
        };

        fetchData();
    }, []);

    const groupedContent = contentData.reduce((acc, content) => {
        const { tag } = content;
        if (!acc[tag]) acc[tag] = [];
        acc[tag].push(content);
        return acc;
    }, {});

    return (
        <div>
            {Object.entries(groupedContent).map(([tag, contents]) => (
                <MainSlider key={tag} tag={tag} contents={contents} />
            ))}
        </div>
    )
}