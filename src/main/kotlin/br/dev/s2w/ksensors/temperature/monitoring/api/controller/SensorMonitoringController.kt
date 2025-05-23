package br.dev.s2w.ksensors.temperature.monitoring.api.controller

import br.dev.s2w.ksensors.temperature.monitoring.api.model.SensorMonitoringOutput
import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorId
import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorMonitoring
import br.dev.s2w.ksensors.temperature.monitoring.domain.repository.SensorMonitoringRepository
import io.hypersistence.tsid.TSID
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sensors/{sensorId}/monitoring")
class SensorMonitoringController(
    private val sensorMonitoringRepository: SensorMonitoringRepository
) {

    @GetMapping
    fun getDetail(@PathVariable sensorId: TSID): SensorMonitoringOutput =
        findByIdOrDefault(sensorId).run {
            SensorMonitoringOutput(
                id = id.value,
                lastTemperature = lastTemperature,
                updatedAt = updatedAt,
                enabled = enabled
            )
        }

    @PutMapping("/enable")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun enable(@PathVariable sensorId: TSID) =
        findByIdOrDefault(sensorId)
            .copy(enabled = true)
            .also(sensorMonitoringRepository::saveAndFlush)

    @DeleteMapping("/enable")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun disable(@PathVariable sensorId: TSID) =
        findByIdOrDefault(sensorId)
            .copy(enabled = false)
            .also(sensorMonitoringRepository::saveAndFlush)

    private fun findByIdOrDefault(sensorId: TSID): SensorMonitoring =
        sensorMonitoringRepository.findById(SensorId(sensorId))
            .orElse(getDefaultMonitoring(sensorId))

    private fun getDefaultMonitoring(sensorId: TSID): SensorMonitoring =
        SensorMonitoring(id = SensorId(sensorId))

}
