package br.dev.s2w.ksensors.temperature.monitoring.api.model

import io.hypersistence.tsid.TSID

data class SensorAlertOutput(
    val id: TSID,
    val maxTemperature: Double?,
    val minTemperature: Double?
)
