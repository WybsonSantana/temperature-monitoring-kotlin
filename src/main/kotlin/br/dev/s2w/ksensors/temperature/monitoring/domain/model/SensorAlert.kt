package br.dev.s2w.ksensors.temperature.monitoring.domain.model

import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class SensorAlert(
    @Id
    @AttributeOverride(name = "value", column = Column(name = "id", columnDefinition = "bigint"))
    val id: SensorId,

    val maxTemperature: Double? = null,

    val minTemperature: Double? = null
)