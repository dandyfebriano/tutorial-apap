# Tutorial APAP
## Authors
* **<Dandy Febriano>** - *<1706074695>* - *<A>*
---
## Tutorial 3
### What I have learned today
1.Pada class ProductDb, terdapat method findByStoreModelId, apakah kegunaan dari method
tersebut? me list produk produk yang ada di dalam suatu store

2.Pada class StoreController, jelaskan perbedaan method addStoreFormPage dan
addStoreSubmit? addStoreFormPage untuk  mengakses halaman form add store sedangkan addStoreSubmit untuk mensubmit form yang sudah diisi di dalam halaman addStoreFormPage

3.Jelaskan kegunaan dari JPA Repository? Memasukkan objek java masuk ke relational database.

4.Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara StoreModel dan
ProductModel dibuat? di line kode attribute-attribute yang ada di StoreModel dan Product Model yang relasi antara StoreModel dengan ProductModel adalah one to many, dan relasi antara ProductModel dan StoreModel adalah many to one.

5.Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
FetchType.LAZY = meload attribute objek tersebut saat dipakai method get().
FetchType.EAGER = meload attribute objek tersebut dengan semua field yang lain.
CascadeType.ALL =  Cara untuk mendapatkan kesamaan aksi untuk suatu entitas dan entitas yang terkait yang menyebarkan semua operasi(termasuk Hibernate sampai operasi yang spesifik) dari entitas pusat ke entitas cabang