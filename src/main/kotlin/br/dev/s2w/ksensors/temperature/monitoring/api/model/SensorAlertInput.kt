package br.dev.s2w.ksensors.temperature.monitoring.api.model

data class SensorAlertInput(
    val maxTemperature: Double,

    val minTemperature: Double
)