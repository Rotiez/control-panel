package ru.study.controlpanel.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Класс, представляющий настройки панели-управления, считываемые из конфигурационного файла.
 */
@ConfigurationProperties(prefix = "properties")
data class ControlProperties (
    val services: List<ServiceProperties>,
    val groups: List<GroupProperties>? = emptyList(),
)

data class GroupProperties (
    val name: String,
    val icon: String?,
    val services: List<ServiceProperties>,
)

data class ServiceProperties (
    val name: String,
    val address: String,
    val icon: String?,
    val version: String?,
)
