package br.dev.s2w.ksensors.temperature.monitoring.api.model

import io.hypersistence.tsid.TSID
import java.time.OffsetDateTime

data class SensorMonitoringOutput(
    val id: TSID,

    val lastTemperature: Double?,

    val updatedAt: OffsetDateTime?,

    val enabled: Boolean
)