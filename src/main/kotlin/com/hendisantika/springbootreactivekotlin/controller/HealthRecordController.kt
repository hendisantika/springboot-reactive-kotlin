package com.hendisantika.springbootreactivekotlin.controller

import com.hendisantika.springbootreactivekotlin.model.AverageHealthStatus
import com.hendisantika.springbootreactivekotlin.model.HealthRecord
import com.hendisantika.springbootreactivekotlin.repository.HealthRecordRepository
import org.springframework.web.bind.annotation.*
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

    @GetMapping("/health/{profileId}/avg")
    fun fetchHealthRecordAverage(@PathVariable("profileId") profileId: Long): Mono<AverageHealthStatus> =
            repository.findByProfileId(profileId)
                    .reduce(
                            AverageHealthStatus(0, 0.0, 0.0, 0.0)
                            , { s, r ->
                        AverageHealthStatus(s.cnt + 1
                                , s.temperature + r.temperature
                                , s.bloodPressure + r.bloodPressure
                                , s.heartRate + r.heartRate
                        )
                    }
                    ).map { s ->
                        AverageHealthStatus(s.cnt
                                , if (s.cnt != 0) s.temperature / s.cnt else 0.0
                                , if (s.cnt != 0) s.bloodPressure / s.cnt else 0.0
                                , if (s.cnt != 0) s.heartRate / s.cnt else 0.0)
                    }


}