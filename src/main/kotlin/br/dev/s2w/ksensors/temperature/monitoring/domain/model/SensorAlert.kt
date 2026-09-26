package br.dev.s2w.ksensors.temperature.monitoring.domain.model

import io.hypersistence.tsid.TSID
import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class SensorAlert(
    @Id
    @AttributeOverride(name = "value", column = Column(name = "id", columnDefinition = "bigint"))
    val id: SensorId,
    val maxTemperature: Double?,
    val minTemperature: Double?
) {

    constructor(sensorId: TSID) : this(
        id = SensorId(sensorId),
        maxTemperature = null,
        minTemperature = null
    )

}
