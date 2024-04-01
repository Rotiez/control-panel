package ru.study.controlpanel.configuration

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

/**
 * Конфигурационный класс, определяющий настройки панели-управления и подключающий их к Spring контексту.
 */
@Configuration
@EnableConfigurationProperties(ControlProperties::class)
class ControlConfiguration