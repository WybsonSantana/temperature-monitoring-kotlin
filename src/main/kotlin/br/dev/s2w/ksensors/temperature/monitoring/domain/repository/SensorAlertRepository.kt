package br.dev.s2w.ksensors.temperature.monitoring.domain.repository

import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorAlert
import br.dev.s2w.ksensors.temperature.monitoring.domain.model.SensorId
import org.springframework.data.jpa.repository.JpaRepository

interface SensorAlertRepository : JpaRepository<SensorAlert, SensorId>