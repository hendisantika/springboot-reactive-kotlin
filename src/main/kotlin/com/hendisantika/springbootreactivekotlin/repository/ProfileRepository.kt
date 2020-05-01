package com.hendisantika.springbootreactivekotlin.repository

import com.hendisantika.springbootreactivekotlin.model.Profile
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-reactive-kotlin
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/05/20
 * Time: 09.12
 */
@Repository
interface ProfileRepository : ReactiveCrudRepository<Profile, Long>