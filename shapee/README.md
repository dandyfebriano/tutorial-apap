# Tutorial APAP
## Authors
* **<Dandy Febriano>** - *<1706074695>* - *<A>*
---
## Tutorial 6
### What I have learned today

1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode
yang telah anda buat) konsep tersebut diimplementasi?
Otentikasi = memvalidasi credentialnya seperti username dan password untuk memvalidasikan identitas.
Otorisasi = proses dalam menentukan apakah user yang sudah terotentikasi memiliki akses ke suatu fitur tertentu.
Otentikasi berada di dalam kodingan WebSecurityConfig method configAuthentication dan Otorisasi berada di dalam kodingan WebSecurityConfig method configure

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!
Implementasi dari PasswordEncoder yang menggunakan fungsi hashing BCrypt. Kita dapat menambahkan "strength" (log rounds di BCrypt) dan instansi SecureRandom. Semakin besar parameter "strength" , semakin banyak usaha yang harus dilakukan untuk meng-hash password tersebut. 

3. Jelaskan secara singkat apa itu UUID dan mengapa kita memakai UUID di UserModel.java? angka 128-bit yang digunakan untuk mengidentifikasi informasi di dalam sistem. Kita memakai uui di dalam UserModel.java untuk membuat id yang tidak identik di antara user-user.

4.  Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut
padahal kita sudah memiliki class UserRoleServiceImpl.java?  Untuk mengambil username dan password dari database. Karena pada class UserServiceImpl belum bisa mendapatkan username dan password tanpa melalui proses otentikasi,sehingga butuh class UserDetailsServiceImpl untuk mengambil atribut user dari database(username user dan password user) yang sudah terotentikasi

