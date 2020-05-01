package com.hendisantika.springbootreactivekotlin.repository

import com.hendisantika.springbootreactivekotlin.model.HealthRecord
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

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
interface HealthRecordRepository : ReactiveCrudRepository<HealthRecord, Long> {
    @Query("select p.* from health_record p where p.profile_id = :profileId ")
    fun findByProfileId(profileId: Long): Flux<HealthRecord>
}