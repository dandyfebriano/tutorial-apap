# Tutorial APAP
## Authors
* **<Dandy Febriano>** - *<1706074695>* - *<A>*
---
## Tutorial 4
### What I have learned today
1. Jelaskan yang anda pelajari dari melakukan latihan nomor 2, dan jelaskan tahapan bagaimana
anda menyelesaikan latihan nomor 2?
Untuk menyelesaikan latihan nomor 2,saya mengubah kode di fragment.html dengan menambahkan parameter di tag navbar,sebagai berikut:
 <nav th:fragment="navbar(parameter)" class="navbar navbar-expand-lg navbar-light bg-light">
 <a class="navbar-brand" href="#" th:text="${parameter}"></a>
Parameter digunakan untuk mengganti nama fitur yang muncul di navigation bar header,yang sebelumnya hanya Navbar menjadi fitur yang kita akan akses,
Nantinya dinamisnya dapat dengan memanggil tag navbar(parameter) dengan parameter diisi sesuai dengan fitur yang ada di masing-masing html yang dikembalikkan
2. Jelaskan yang anda pelajari dari latihan nomor 3, dan jelaskan tahapan bagaimana anda
menyelesaikan latihan nomor 3? 
Untuk menyelesaikan nomor 3, saya menambah 2 controller untuk 1 page form yaitu untuk menambah form dan menghapus form. Selain itu di form page awal juga saya membuat sebuah list untuk menyimpan product yang diisi di dalam form. Setelah itu di control submit form, saya akan mengiterasi isi dari list yang sudah saya buat untuk disimpan di database. 
3. Jelaskan perbedaan th:include dan th:replace!
th:include = fragment akan ditempatkan di dalam div yang memakai th:include
th:replace = fragment akan mengganti div yang memakai th:replace
4. Jelaskan bagaimana penggunaan th:object beserta tujuannya!
digunakan untuk menyimpan data dari formulir sebagai suatu objek sehingga data tersebut dapat mudah dikelola dalam bentuk objek.

