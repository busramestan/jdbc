# 📌 Java JDBC Bağlantı ve Kullanım Projesi

Bu proje, Java programlama dili ile JDBC (Java Database Connectivity) kullanılarak PostgreSQL veritabanına bağlantı kurulmasını ve temel veri işlemleri yapılmasını örnekleyen sade ve öğretici bir uygulamadır. Proje içerisinde bağlantı yapısı, tablo oluşturma ve veritabanı yönetimi için modern ve temiz bir yöntem uygulanmıştır.

## 📦 Kullanılan Teknolojiler

- Java 24
- JDBC (Java Database Connectivity)
- PostgreSQL 
- IntelliJ IDEA

## 📖 JDBC Nedir?

**JDBC (Java Database Connectivity)**, Java programlarının veri tabanlarıyla iletişim kurmasını sağlayan bir API'dir. JDBC sayesinde Java uygulamaları veri tabanı üzerinde **INSERT**, **SELECT**, **UPDATE**, **DELETE** gibi CRUD işlemlerini gerçekleştirebilir.


## 📌 Sınıflar ve Görevleri

### 📄 DatabaseConfig.java  
Veritabanı bağlantısı için gerekli URL, kullanıcı adı ve şifre gibi bilgileri sabit olarak saklar.

### 📄 DatabaseConnector.java  
Veritabanı bağlantısını `DriverManager.getConnection()` ile sağlar. Her çağrıda yeni bir bağlantı açar ve olası hataları `SQLException` ile yakalayarak yönetir.

### 📄 Main.java  
Projenin giriş noktasıdır. **try-with-resources** yapısı ile veritabanına bağlantı kurar ve SQL sorgusunu çalıştırır. Bağlantı ve statement, işlem bitince otomatik olarak kapanır.

## 📌 Çalıştırma Adımları

1. PostgreSQL veritabanınızda `jdbc` isminde bir database oluşturun.
2. `DatabaseConfig.java` içerisindeki kullanıcı adı, şifre ve bağlantı bilgilerini kendi veritabanınıza göre düzenleyin.
3. Projeyi IntelliJ IDEA veya tercih ettiğiniz IDE ile açın.
4. Main sınıfını çalıştırın.

## 📌 Konsol Çıktısı

Başarılı çalıştırmada aşağıdaki çıktıları görmeniz beklenir:

- Connected established successfully
- Table created successfully

## 📌 try-with-resources Neden Kullanılır?

**try-with-resources**, JDBC'de `Connection`, `Statement`, `ResultSet` gibi kaynakların iş bitince otomatik kapanmasını sağlar.  
Bu yöntem:
- Kodun daha temiz ve anlaşılır olmasını
- Bağlantı sızıntısı (connection leak) oluşmamasını
- Exception durumunda bile bağlantının güvenli şekilde kapanmasını sağlar.

