import React from "react";

export default function MainSliderContent({imageSrc, contentId, order}) {
    return (
        <div>
            {/*<img src={imageSrc} alt={`Content ${contentId}`}/>*/}
            <p>Content ID: {contentId}</p>
            <p>Order: {order}</p>
        </div>
    )
}