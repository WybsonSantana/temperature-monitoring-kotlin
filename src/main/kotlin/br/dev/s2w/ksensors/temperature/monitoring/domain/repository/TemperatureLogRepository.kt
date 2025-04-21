package br.dev.s2w.ksensors.temperature.monitoring.domain.repository

import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorId
import br.dev.s2w.ksensors.temperature.monitoring.domain.model.TemperatureLog
import br.dev.s2w.ksensors.temperature.monitoring.domain.model.TemperatureLogId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TemperatureLogRepository : JpaRepository<TemperatureLog, TemperatureLogId> {

    fun findAllBySensorId(sensorId: SensorId, pageable: Pageable): Page<TemperatureLog>

}
