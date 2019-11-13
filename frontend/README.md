Nomer 1 tutorial
*** Menambahkan checkbox di bagian Item.js ***
>> const { item, onChange,checkbox } = props;
>> {checkbox && <input type="checkbox" checked={checked} onChange={handleChange} />}
*** Menambahkan checkbox di bagian List.js ***
>> export default function List({ title, items, onItemClick, checkbox }) {
>> <Item key={item.id} item={item} onChange={onItemClick} checkbox = {checkbox} />
*** Menambahkan checkbox di bagian App.js ***
>> <List
    checkbox={false}
    title="Our Menu"
    items={dummyItems}
    onItemClick={this.handleItemClickLeft}
    />
>> <List
    checkbox={true}
    title="My Favorite"
    items={favItems}
    onItemClick={this.handleItemClick}
    />
Nomer 2 tutorial
Membuat fungsi baru ,yaitu handleItemClickLeft sebagai berikut:
handleItemClickLeft = item => {
 const newItems = [...this.state.favItems];
 const newItem = {...item };

 const targetInd = newItems.findIndex(it => it.id === newItem.id);
 if(targetInd < 0) newItems.push(newItem);
 this.setState({ favItems: newItems });
}; 
Yaitu sama seperti handleItemClick, namun menghilangkan else untuk kondisi jika sudah ada favorite pada menu yang di klik,maka menu tersebut(yang sudah ada di favorit) tidak akan hilang dari favorit, karena fungsi dari kolom our menu hanya akan menambahkan menu menjadi favorit dan tidak akan menghapus menu tersebut dari favorit.Kemudian,menaruh fungsi baru tersebut di list yang ada di kolom our menu seperti berikut:
<List
 checkbox={false}
 title="Our Menu" 
 items={dummyItems}
 onItemClick={this.handleItemClickLeft}
 /> 

Nomer 3 tutorial
Membuat constanta favContent untuk mengecek apakah toggle on atau off di my favorite sedang dinyalakan atau tidak. Jika dinyalakan, maka akan memanggil constanta content,yaitu kode untuk menampilkan daftar favorit.
- Constanta favContent tersebut sebagai berikut:
const favContent = this.state.checked ? favItems.length > 0 ?  content : <EmptyState/> :null

- Constanta content tersebut sebagai berikut:
const content = 
      <div className="col-sm">
        <List
          checkbox={true}
          title="My Favorite"
          items={favItems}
          onItemClick={this.handleItemClick}
        />
      </div>

Lalu memanggil constanta tersebut untuk di return dengan mengecek state dari checkbox favorite
{ favContent } >> di return () dalam App.js 

Membuat method bernama handleChange() yang berfungsi untuk mengatur state dari toggle checkbox di my favorite.
handleChange sebagai berikut:
handleChange() {
  this.setState({
    checked: !this.state.checked
 })
}

Menambahkan kode untuk membuat checkbox my favorite,sebagai berikut di return() App.js
 <div>
            <label>Show Favorit</label>
            <input 
              type="checkbox" 
              checked={ this.state.checked } 
              onChange={ this.handleChange } />
          </div>

Nomer 4 tutorial
Membuat EmptyState.js di folder componenents sebagai daftar favorit yang kosong. 
EmptyState.js tersebut sebagai berikut:
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

Membuat constanta favContent yang didalamnya berisi pengecekkan ukuran dari favItems. Jika Tidak berisi atau < 0 , maka akan menampilkan EmptyState yang sudah dibuat di Components. Jika favItems berisi atau > 0, maka akan menampilkan content yang ada di tutorial nomer 3.
Constanta favContent sebagai berikut:
const contentFav = this.state.checked ? favItems.length > 0 ? content : <EmptyState/> : null
Pengecekkan ukuran ada pada kode, favItems.length
