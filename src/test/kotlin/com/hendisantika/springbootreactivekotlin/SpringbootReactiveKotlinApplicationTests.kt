package com.hendisantika.springbootreactivekotlin

import com.fasterxml.jackson.databind.ObjectMapper
import com.hendisantika.springbootreactivekotlin.controller.ProfileController
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
class SpringbootReactiveKotlinApplicationTests {
    @Autowired
    lateinit var controller: ProfileController

    @Autowired
    lateinit var mapper: ObjectMapper

    lateinit var client: WebTestClient
    lateinit var profile: String

    @BeforeEach
    fun setup() {
        client = WebTestClient.bindToController(controller).build()
    }

    @Test
    fun whenRequestProfile_thenStatusShouldBeOk() {
        client.post()
                .uri("/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(profile)
                .exchange()
                .expectStatus().isOk
    }

    @Test
    fun whenRequestProfile_thenIdShouldBeNotNull() {
        client.post()
                .uri("/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(profile)
                .exchange()
                .expectBody()
                .jsonPath("$.id")
                .isNotEmpty
    }
}
