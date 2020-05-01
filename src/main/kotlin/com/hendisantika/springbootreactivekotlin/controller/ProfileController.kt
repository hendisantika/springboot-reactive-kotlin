package com.hendisantika.springbootreactivekotlin.controller

import com.hendisantika.springbootreactivekotlin.model.Profile
import com.hendisantika.springbootreactivekotlin.repository.ProfileRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-reactive-kotlin
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/05/20
 * Time: 09.13
 */
@RestController
class ProfileController(val repository: ProfileRepository) {
    @PostMapping("/profile")
    fun save(@RequestBody profile: Profile): Mono<Profile> = repository.save(profile)
}
