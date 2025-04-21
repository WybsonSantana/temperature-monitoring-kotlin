package br.dev.s2w.ksensors.temperature.monitoring.api.model

import br.dev.s2w.ksensors.temperature.monitoring.domain.model.TemperatureLog
import io.hypersistence.tsid.TSID
import java.time.OffsetDateTime
import java.util.*

data class TemperatureLogOutput(
    val id: UUID,

    val sensorId: TSID,

    val registeredAt: OffsetDateTime,

    val value: Double
)

fun TemperatureLog.toTemperatureLogOutput(): TemperatureLogOutput =
    TemperatureLogOutput(
        id = this.id.value,
        value = this.value,
        registeredAt = this.registeredAt,
        sensorId = this.sensorId.value
    )