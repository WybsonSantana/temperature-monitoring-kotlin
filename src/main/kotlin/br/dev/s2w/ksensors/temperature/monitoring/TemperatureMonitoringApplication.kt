package br.dev.s2w.ksensors.temperature.monitoring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TemperatureMonitoringApplication

fun main(args: Array<String>) {
	runApplication<TemperatureMonitoringApplication>(*args)
}
