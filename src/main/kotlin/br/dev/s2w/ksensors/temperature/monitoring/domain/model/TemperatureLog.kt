package br.dev.s2w.ksensors.temperature.monitoring.domain.model

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
data class TemperatureLog(
    @Id
    @AttributeOverride(name = "value", column = Column(name = "id", columnDefinition = "uuid"))
    val id: TemperatureLogId,

    @Column(name = "\"value\"")
    val value: Double,

    val registeredAt: OffsetDateTime,

    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "sensor_id", columnDefinition = "bigint"))
    val sensorId: SensorId
)