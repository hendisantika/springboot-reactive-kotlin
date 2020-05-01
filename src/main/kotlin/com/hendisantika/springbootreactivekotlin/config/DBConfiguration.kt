package com.hendisantika.springbootreactivekotlin.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.core.DatabaseClient

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-reactive-kotlin
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/05/20
 * Time: 09.11
 */
@Configuration
class DBConfiguration(db: DatabaseClient) {
    init {
        val initDb = db.execute {
            """ CREATE TABLE IF NOT EXISTS profile (
                    id SERIAL PRIMARY KEY,
                    first_name VARCHAR(20) NOT NULL,
                    last_name VARCHAR(20) NOT NULL,
                    birth_date DATE NOT NULL
                );
                CREATE TABLE IF NOT EXISTS health_record(
                    id SERIAL PRIMARY KEY,
                    profile_id LONG NOT NULL,
                    temperature DECIMAL NOT NULL,
                    blood_pressure DECIMAL NOT NULL,
                    heart_rate DECIMAL,
                    date DATE NOT NULL
                );
            """
        }
        initDb.then().subscribe()
    }
}