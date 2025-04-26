package br.dev.s2w.ksensors.temperature.monitoring.api.model

import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorAlert
import io.hypersistence.tsid.TSID

data class SensorAlertOutput(
    val id: TSID,

    val maxTemperature: Double?,

    val minTemperature: Double?
)

fun SensorAlert.toSensorAlertOutput(): SensorAlertOutput =
    SensorAlertOutput(
        id = this.id.value,
        maxTemperature = this.maxTemperature,
        minTemperature = this.minTemperature
    )