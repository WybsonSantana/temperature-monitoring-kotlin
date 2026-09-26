package br.dev.s2w.ksensors.temperature.monitoring.domain.model

import com.fasterxml.jackson.annotation.JsonValue
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.*

@Embeddable
data class TemperatureLogId(
    @JsonValue
    val value: UUID
) : Serializable {

    constructor(value: String) : this(UUID.fromString(value))

    override fun toString(): String = value.toString()

}
