package br.dev.s2w.ksensors.temperature.monitoring.domain.model

import io.hypersistence.tsid.TSID
import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.OffsetDateTime

@Entity
data class SensorMonitoring(
    @Id
    @AttributeOverride(name = "value", column = Column(name = "id", columnDefinition = "bigint"))
    val id: SensorId,

    val lastTemperature: Double?,

    val updatedAt: OffsetDateTime?,

    val enabled: Boolean = false
) {

    constructor(sensorId: TSID) : this(
        id = SensorId(sensorId),
        lastTemperature = null,
        updatedAt = null
    )

}
