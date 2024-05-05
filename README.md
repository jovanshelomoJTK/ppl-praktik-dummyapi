# Project Automation API Testing

Proyek automation testing untuk menguji api management user pada tautan https://dummyapi.io/. Proyek ini dikembangkan menggunakan bahasa java (pembuatan script test) dan Maven (build tools).

# Build With

Proyek pengujian otomatis melibatkan 4 buah library dan 1 buah plugin yang dibutuhkan.

## Library:

- rest assured
- JUnit
- dotenv (tambahan)
- hamcrest (tambahan)

## Plugin:

- surefire

# Getting Started

## Prerequisite

Sebelum menjalankan proyek ini, diperlukan persyaratan environment yang harus disiapkan pada device eksekusi proyek

1. JDK diatas versi 8
2. Maven

## Installation

Proses instalasi proyek ini pada local environment

1. Clone repository github ini
2. Buka IDE pemrograman. Misalnya Visual Studio Code
3. Buka folder hasil clone pada Visual Studio Code
4. Buka terminal
5. Ketikan perintah di bawah ini untuk eksekusi test script dan generate test report

```
mvn surefire-report:report
```

6. Buka hasil test report pada file yang berada pada path target/site/surefire-report.html

## File Configuration

Proses konfigurasi project menggunakan build automation pada file pom.xml

1. Semua dependency yang dibutuhkan harus ditambahkan di dalam dependencies pada pom.xml. Berikut dependency yang dibutuhkan:

    a. rest assured, library untuk melakukan pengujian API otomatis untuk membuat request HTTP dan melakukan validasi pada respons yang diterima

   ```xml
    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>rest-assured</artifactId>
      <version>${rest-assured.version}</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>io.rest-assured</groupId>
      <artifactId>json-schema-validator</artifactId>
      <version>${json-schema-validator.version}</version>
      <scope>test</scope>
    </dependency>
   ```

   b. JUnit, framework unit testing untuk menjalankan pengujian

   ```xml
        <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter-api</artifactId>
          <version>${junit.version}</version>
          <scope>test</scope>
        </dependency>
        <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter-engine</artifactId>
          <version>${junit.version}</version>
          <scope>test</scope>
        </dependency>
   ```

    c. dotenv, library untuk memuat variabel dari file .env ke dalam proyek

     ```xml
          <dependency>
            <groupId>io.github.cdimascio</groupId>
            <artifactId>dotenv-java</artifactId>
            <version>3.0.0</version>
          </dependency>
     ```

    d. hamcrest, library yang menyediakan matcher untuk membuat validasi pengujian

     ```xml
        <dependency>
          <groupId>org.hamcrest</groupId>
          <artifactId>hamcrest</artifactId>
          <version>${hamcrest.version}</version>
        </dependency>
     ```

2. Tambahkan plugin yang dibutuhkan dalam plugins pada pom.xml. Berikut plugin yang dibutuhkan:

```xml
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>${maven-surefire-plugin.version}</version>
  </plugin>
```


# Structure Project Test
Tujuan project adalah proses pengujian automation API user controller, sehingga kode program tersimpan dalam folder test. Berikut struktur proyek:
```
ppl-praktik-dummyapi
  src
    main/java/com/ppl
    test
      java/com/ppl
        CreateTest.java
        DeleteTest.java
        GetTest.java
        UpdateTest.java
      resources
        user-schema.json
  target
    classes/com/ppl
    javadoc-bundle-options
    maven-status/maven-compiler-plugin
    site
      css
      images
      jacoco
      surefire-report.html
    surefire-reports
    test-classes
    jacoco.exec
  .editorconfig
  .env
  README.md
  pom.xml
```


- package main berisi main program walau dalam program ini tidak digunakan karena berfokus pada testing
- package test berisi test class untuk 4 API yaitu get user by id, create user, update user, dan delete user. Selain itu, berisi juga schema JSON dari data user sesuai pada models di dummyapi.io
- package target berisi hasil generate test report

# Workflow
Langkah pembuatan test script
1. Buat test class untuk tiap API(get,create,update, dan delete) pada src/test.
2. Import library-library yang dibutuhkan, yaitu: dotenv, restassured, DisplayName dari JUnit, Test dari JUnit, BeforeEach dari JUnit, Matchers dari hamcrest
3. Buat test case dalam bentuk method pada masing-masing test class berisi method HTTP Rest API, header, response status code, dan response body


# How to Run Execution Testing
Berikut proses untuk menjalankan eksekusi tes pada program melalui terminal
```
mvn surefire-report:report
```
## Persiapan Data
Sebelum menjalankan test case, diperlukan persiapan data test:
1. Gunakan app-id yang didapatkan pada https://dummyapi.io/ dan masukkan app-id tersebut pada file .env


# Software Under test
Pengujian dilakukan untuk API program user controller pada https://dummyapi.io/docs/user
* hit api get profile user by id
* hit api post new user
* hit api update user by id
* hit api delete user by id


# Test Case
Pembuatan test case meliputi test positif dan test negatif, yaitu


## Test Case API User
    1. Pemeriksaan berhasil melakukan get profile user by id
    2. Pemeriksaan gagal get profile user, karena user id tidak ditemukan
    3. Pemeriksaan berhasil membuat user baru
    4. Pemeriksaan gagal membuat user baru karena email sudah digunakan
    5. Pemeriksaan gagal membuat user baru karena tipe data suatu field tidak sesuai model/schema
    6. Pemeriksaan gagal membuat user baru karena format isi suatu field tidak sesuai model
    7. Pemeriksaan gagal membuat user baru karena panjang isi suatu field tidak sesuai model
    8. Pemeriksaan berhasil ubah profile user by id
    9. Pemeriksaan gagal ubah profile user by id karena tipe data suatu field tidak sesuai model/schema
    10. Pemeriksaan gagal membuat user baru karena format isi suatu field tidak sesuai model
    11. Pemeriksaan gagal membuat user baru karena panjang isi suatu field tidak sesuai model
    12. Pemeriksaan berhasil hapus profile user by id
    13. Pemeriksaan gagal hapus profile user by id karena id user tidak ada di sistem
	


Note. Pendekatan pengujian menggunakan black box testing dengan metode ECP dan BVA.
Satuan unit adalah fitur atau fungsi software


# Author
<span style="font-size:0.7em;">
Jovan Shelomo</br>
Mey Meizia Galtiady</br>
Rahma Alia Latifa</br>
Kelompok B6 PPL</br>
Jurusan Teknik Komputer dan Informatika</br>
Politeknik Negeri Bandung</br>




</span>


# Reference
Daftar resource yang dapat dipelajari
- <a href="https://github.com/rest-assured/rest-assured/wiki/GettingStarted">REST Assured documentation</a>
- <a href="https://junit.org/junit5/">JUnit documentation</a>
- <a href="https://www.dotenv.org/docs/">Dotenv documentation</a>
- <a href="https://hamcrest.org/">Hamcrest documentation</a>
- <a href="https://maven.apache.org/surefire/maven-surefire-plugin/">Surefire Introduction</a>
