package br.dev.s2w.ksensors.temperature.monitoring.domain.model

import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.*

@Embeddable
data class TemperatureLogId(
    val value: UUID
) : Serializable {

    constructor(value: String) : this(UUID.fromString(value))

}
