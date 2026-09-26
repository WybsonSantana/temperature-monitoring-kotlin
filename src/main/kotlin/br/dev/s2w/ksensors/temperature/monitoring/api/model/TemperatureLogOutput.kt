package br.dev.s2w.ksensors.temperature.monitoring.api.model

import io.hypersistence.tsid.TSID
import java.time.OffsetDateTime
import java.util.UUID

data class TemperatureLogOutput(
    val id: UUID,

    val sensorId: TSID,

    val registeredAt: OffsetDateTime,

    val value: Double
)
