package br.dev.s2w.ksensors.temperature.monitoring.api.controller

import br.dev.s2w.ksensors.temperature.monitoring.api.model.SensorAlertInput
import br.dev.s2w.ksensors.temperature.monitoring.api.model.SensorAlertOutput
import br.dev.s2w.ksensors.temperature.monitoring.api.model.toSensorAlertOutput
import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorAlert
import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorId
import br.dev.s2w.ksensors.temperature.monitoring.domain.repository.SensorAlertRepository
import io.hypersistence.tsid.TSID
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/sensors/{sensorId}/alert")
class SensorAlertController(
    private val sensorAlertRepository: SensorAlertRepository
) {

    @GetMapping
    fun getDetail(@PathVariable sensorId: TSID): SensorAlertOutput =
        sensorAlertRepository.findById(SensorId(sensorId))
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
            .toSensorAlertOutput()

    @PutMapping
    fun createOrUpdate(@PathVariable sensorId: TSID, @RequestBody input: SensorAlertInput): SensorAlertOutput =
        findByIdOrDefault(sensorId)
            .copy(
                id = SensorId(sensorId),
                maxTemperature = input.maxTemperature,
                minTemperature = input.minTemperature
            ).let(sensorAlertRepository::saveAndFlush).toSensorAlertOutput()

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable sensorId: TSID) =
        sensorAlertRepository.findById(SensorId(sensorId))
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
            .let(sensorAlertRepository::delete)

    private fun findByIdOrDefault(sensorId: TSID): SensorAlert =
        sensorAlertRepository.findById(SensorId(sensorId))
            .orElse(SensorAlert(id = SensorId(sensorId)))

}
