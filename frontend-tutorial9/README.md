## Tutorial 9
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan
mengapa kalian melakukan langkah - langkah tersebut?
* Langkah - Langkah Solve 
> + Mencari di google dengan keyword : remove data after post react js
> + Mendapat potongan kode sebagai berikut sebagai contoh : this.setState({city: ""});
> + Mencoba mengaplikasikan potongan kode dengan bentuk seperti itu ke kode
> + Mengubah potongan kode menjadi this.setState({nama: "",followers: "", keterangan: ""});
sumber : https://stackoverflow.com/questions/46539480/react-clearing-an-input-value-after-form-submit

* Mengapa melakukan langkah tersebut 
>> Kode tersebut maksudnya adalah mengubah state/nilai dari atribut nama,followers, dan keterangan yang sebelumnya terisi dengan value store yang diinput menjadi kosong sehingga ketika akan add store lagi tidak akan ada history dari yang sebelumnya lagi/kosong. 

2. Jelaskan fungsi dari async dan await!
> * Operasi asynchronous adalah sebuah operasi yang akan dijalankan dengan tidak perlu menunggu operasi sebelumnya selesai untuk mengeksekusi operasi setelahnya. Async dan await mempermudah dalam menangani operasi asynchronous. 
> * async → mengubah function menjadi asynchronous
await → menunda eksekusi hingga proses asynchronous selesai
> * async dan await didesain untuk bekerjasama dengan operasi promise
async → Memastikan bahwa fungsi selalu mengembalikan promise dan membungkus non-promise didalamnya
await → Membuat JavaScripts menunggu hingga promise selesai dan menggunakan hasil dari promise tersebut 

3. Masukkan jawaban dari TODO pada Component Lifecycle pada pertanyaan ini.
https://user-images.githubusercontent.com/54923649/69871689-0bebc400-12e6-11ea-9f8d-75f609ead76b.PNG

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate,
componentDidUpdate, componentWillReceiveProps,
componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja
yang biasanya menggunakan lifecycle method tersebut”.
   - componentDidMount : componenDidMount merupakan mounting lifecycle terakhir yang akan dipanggil  ketika render selesai dipanggil untuk pertama kali. 
    - shouldComponentUpdate : shouldComponentUpdate merupakan updating lifecycle kedua yang akan dipanggil setelah componentWillReceiveProps dipanggil dan sebelum rendering html dilakukan.
    - componentDidUpdate : componentDidUpdate merupakan updating lifecycle terakhir yang dipanggil setelah component berhasil dilakukan dan render html telah selesai loading.
    - componentWillReceiveProps : componentWillReceiveProps merupakan updating lifecycle pertama yang akan dipanggil apabila Component memiliki props.
    - componentWillMount : componentWillMount merupakan mounting lifecycle pertama yang akan dipanggil sebelum render dipanggil untuk pertama kali.
