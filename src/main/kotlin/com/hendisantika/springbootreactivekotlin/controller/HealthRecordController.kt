package com.hendisantika.springbootreactivekotlin.controller

import com.hendisantika.springbootreactivekotlin.repository.HealthRecordRepository
import org.springframework.web.bind.annotation.RestController

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-reactive-kotlin
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/05/20
 * Time: 09.16
 */
@RestController
class HealthRecordController(val repository: HealthRecordRepository)