# WS-Factory

## Prerequisites
1. Eclipse IDE for Enterprise Java Developers - 2020-09
2. Java version 7
3. Apache Tomcat 9.0

## Cara menjalankan
1. Lakukan git clone di folder yang Anda jadikan workspace untuk Eclipse
2. Buka Eclipse 
3. Ketika sudah terbuka, seharusnya "project" bernama ws-factory sudah ada di bagian Package Explorer

## Deskripsi web service
Web service WS-Factory adalah sebuah web service di atas java servlet menggunakan JAX-WS dengan protokol SOAP. Web service ini digunakan untuk Factory Management Pro dan Willy Wangky’s Web.

## Basis data yang digunakan web service
Basis data yang digunakan adalah sebagai berikut:
- add_stock (data mengenai request add stock) : 
    - id_add_stock : id request add stock
    - id_cokelat : id coklat yang direquest untuk add stock
    - jumlah : jumlah stock yang direquest ingin ditambah
    - status : status dari request add stock (pending, delivered, received)
- bahan (data mengenai bahan yang ada di factory):
    - id_bahan : id bahan
    - nama_bahan : nama bahan
    - jumlah : jumlah bahan yang ada di factory
    - tanggal_kadaluwarsa : tanggal kadaluwarsa bahan
- gudang (data mengenai cokelat yang ada di factory):
    - id_coklat : id cokelat
    - nama_coklat : nama cokelat
    - jumlah : jumlah cokelat yang ada di gudang
- resep (data mengenai bahan yang dibutuhkan untuk membuat coklat):
    - id_coklat : id coklat
    - nama_bahan : nama bahan yang dibutuhkan untuk membuat coklat
    - jumlah : jumlah bahan yang dibutuhkan untuk membuat coklat
- saldo (saldo yang dimiliki):
    - saldo : jumlah saldo yang dimiliki factory
- user (user yang dapat login ke willy-wangky-factory):
    - username : username
    - email : email
    - password : password
