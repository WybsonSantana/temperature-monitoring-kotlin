package br.dev.s2w.ksensors.temperature.monitoring.domain.repository

import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorId
import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorMonitoring
import org.springframework.data.jpa.repository.JpaRepository

interface SensorMonitoringRepository : JpaRepository<SensorMonitoring, SensorId>