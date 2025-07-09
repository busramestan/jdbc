package com.busra.config;
/**
 * Veri tabanı bağlantı bilgilerini tutan config sınıfı.
 * Değişmeyen sabit değerler burada tanımlanır.
 */
public class DatabaseConfig {
    public static final String DATABASE_NAME = "jdbc";
    public static final String DATABASE_USERNAME = "postgres";
    public static final String DATABASE_PASSWORD = "1";
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/"+ DATABASE_NAME;
}
