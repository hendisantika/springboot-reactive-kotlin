package com.hendisantika.springbootreactivekotlin.controller

import com.hendisantika.springbootreactivekotlin.model.HealthRecord
import com.hendisantika.springbootreactivekotlin.repository.HealthRecordRepository
import org.springframework.web.bind.annotation.PathVariable
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
 * Time: 09.16
 */
@RestController
class HealthRecordController(val repository: HealthRecordRepository) {
    @PostMapping("/health/{profileId}/record")
    fun storeHealthRecord(@PathVariable("profileId") profileId: Long, @RequestBody record: HealthRecord): Mono<HealthRecord> =
            repository.save(HealthRecord(null
                    , profileId
                    , record.temperature
                    , record.bloodPressure
                    , record.heartRate
                    , record.date))


}