import React from "react";

import Item from "./Item";

export default function EmptyState(){
    return(
        <div className="col-sm" style={style.align}>
            <h3>Belum ada item yang dipilih </h3><br/>
            <h6>Klik salah satu item di daftar Menu Produk</h6>
        </div>
    );
}

const style = {
    align : {
        textAlign:"center"
    }
}