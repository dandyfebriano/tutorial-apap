Nomer 1 tutorial

*** Menambahkan checkbox di bagian Item.js ***
<img src = https://user-images.githubusercontent.com/54923649/68777701-aa302680-0664-11ea-81ce-70ac6923111e.PNG>

*** Menambahkan checkbox di bagian List.js ***
<img src = https://user-images.githubusercontent.com/54923649/68777701-aa302680-0664-11ea-81ce-70ac6923111e.PNG>

*** Menambahkan checkbox di bagian App.js ***
<img src = https://user-images.githubusercontent.com/54923649/68778972-7d7d0e80-0666-11ea-88ac-5b8fca2e8378.PNG>
<img src = https://user-images.githubusercontent.com/54923649/68779371-2461aa80-0667-11ea-9f6c-ccc77b62916c.PNG>
<img src = https://user-images.githubusercontent.com/54923649/68779516-5d9a1a80-0667-11ea-9234-2419107f44d0.PNG>

Nomer 2 tutorial
Membuat fungsi baru ,yaitu handleItemClickLeft sebagai berikut:
<img src = https://user-images.githubusercontent.com/54923649/68779770-c84b5600-0667-11ea-84df-9b25357f9973.PNG>

Yaitu sama seperti handleItemClick, namun menghilangkan else untuk kondisi jika sudah ada favorite pada menu yang di klik,maka menu tersebut(yang sudah ada di favorit) tidak akan hilang dari favorit, karena fungsi dari kolom our menu hanya akan menambahkan menu menjadi favorit dan tidak akan menghapus menu tersebut dari favorit.Kemudian,menaruh fungsi baru tersebut di list yang ada di kolom our menu seperti berikut:
<img src = https://user-images.githubusercontent.com/54923649/68779969-1b250d80-0668-11ea-88f8-e23f0169d1f9.PNG>

Nomer 3 tutorial
Membuat constanta favContent untuk mengecek apakah toggle on atau off di my favorite sedang dinyalakan atau tidak. Jika dinyalakan, maka akan memanggil constanta content,yaitu kode untuk menampilkan daftar favorit.

- Constanta favContent tersebut sebagai berikut:
<img src = https://user-images.githubusercontent.com/54923649/68780378-c8982100-0668-11ea-8f55-d586a0a6b1ae.PNG>

- Constanta content tersebut sebagai berikut:
<img src = https://user-images.githubusercontent.com/54923649/68780546-0d23bc80-0669-11ea-9cc4-0632cfbfeebb.PNG>

Lalu memanggil constanta tersebut untuk di return dengan mengecek state dari checkbox favorite
{ favContent } >> di return () dalam App.js 

Membuat method bernama handleChange() yang berfungsi untuk mengatur state dari toggle checkbox di my favorite.
handleChange sebagai berikut:
<img src = https://user-images.githubusercontent.com/54923649/68780665-347a8980-0669-11ea-99a7-02128524a1f4.PNG>

Menambahkan kode untuk membuat checkbox my favorite,sebagai berikut di return() App.js
<img src = https://user-images.githubusercontent.com/54923649/68781257-14979580-066a-11ea-8835-382b3fb77583.PNG>

Nomer 4 tutorial
Membuat EmptyState.js di folder componenents sebagai daftar favorit yang kosong. 
EmptyState.js tersebut sebagai berikut:
<img src = https://user-images.githubusercontent.com/54923649/68781498-77892c80-066a-11ea-99d5-28700c35f211.PNG>

Membuat constanta favContent yang didalamnya berisi pengecekkan ukuran dari favItems. Jika Tidak berisi atau < 0 , maka akan menampilkan EmptyState yang sudah dibuat di Components. Jika favItems berisi atau > 0, maka akan menampilkan content yang ada di tutorial nomer 3.
Constanta favContent sebagai berikut:

<img src = https://user-images.githubusercontent.com/54923649/68781707-c33bd600-066a-11ea-9586-42b5d221286d.PNG>

Pengecekkan ukuran ada pada kode, favItems.length
