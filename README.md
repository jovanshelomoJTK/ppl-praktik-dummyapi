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


# Struture Project Test
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
