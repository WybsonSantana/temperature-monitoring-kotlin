package br.dev.s2w.ksensors.temperature.monitoring.api.controller

import br.dev.s2w.ksensors.temperature.monitoring.api.model.TemperatureLogOutput
import br.dev.s2w.ksensors.temperature.monitoring.api.model.toTemperatureLogOutput
import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorId
import br.dev.s2w.ksensors.temperature.monitoring.domain.repository.TemperatureLogRepository
import io.hypersistence.tsid.TSID
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures")
class TemperatureLogController(
    private val temperatureLogRepository: TemperatureLogRepository
) {

    @GetMapping
    fun search(@PathVariable sensorId: TSID, @PageableDefault pageable: Pageable): Page<TemperatureLogOutput> =
        temperatureLogRepository.findAllBySensorId(SensorId(sensorId), pageable)
            .map { it.toTemperatureLogOutput() }

}
