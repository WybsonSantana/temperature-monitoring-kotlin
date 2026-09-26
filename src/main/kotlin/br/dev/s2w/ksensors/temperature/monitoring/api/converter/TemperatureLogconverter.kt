package br.dev.s2w.ksensors.temperature.monitoring.api.converter

import br.dev.s2w.ksensors.temperature.monitoring.api.model.TemperatureLogOutput
import br.dev.s2w.ksensors.temperature.monitoring.domain.model.TemperatureLog

fun TemperatureLog.toTemperatureLogOutput(): TemperatureLogOutput =
    TemperatureLogOutput(
        id = this.id.value,
        value = this.value,
        registeredAt = this.registeredAt,
        sensorId = this.sensorId.value
    )
