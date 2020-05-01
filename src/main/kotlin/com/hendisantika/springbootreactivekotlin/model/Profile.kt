package com.hendisantika.springbootreactivekotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-reactive-kotlin
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/05/20
 * Time: 09.09
 */

@Table
data class Profile(@Id var id: Long?, var firstName: String, var lastName: String, var birthDate: LocalDateTime)