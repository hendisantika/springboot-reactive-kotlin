package com.hendisantika.springbootreactivekotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-reactive-kotlin
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/05/20
 * Time: 09.10
 */
@Table
data class HealthRecord(@Id var id: Long?, var profileId: Long?, var temperature: Double,
                        var bloodPressure: Double, var heartRate: Double, var date: LocalDate)