package br.dev.s2w.ksensors.temperature.monitoring.api.converter

import br.dev.s2w.ksensors.temperature.monitoring.api.model.SensorAlertOutput
import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorAlert

fun SensorAlert.toSensorAlertOutput(): SensorAlertOutput =
    SensorAlertOutput(
        id = this.id.value,
        maxTemperature = this.maxTemperature,
        minTemperature = this.minTemperature
    )
