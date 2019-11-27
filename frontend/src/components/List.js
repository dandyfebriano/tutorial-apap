import React from "react";

import Item from "./Item";

export default function List({title, items, onItemClick, checkbox}){
    return(
        <>
        <h3 style={StyleSheet.heading}>{title}</h3>
        <div className="list-group">
            {items.map(item =>(
                <Item key={item.id} item={item} onChange={onItemClick} checkbox={checkbox}/>
            ))}
        </div>
        </>
    );
}

const styles = {
    heading: {
        fontFamily: "courier new"
    }
};