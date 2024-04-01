package ru.study.controlpanel.model

/**
 * Класс, представляющий запись журнала для логирования действий пользователя.
 */
data class LogEntry (
    val level: LogLevel,
    val title: String,
    val action: String? = null,
)

/**
 * Enum-класс уровней логирования.
 */
enum class LogLevel {
    INFO, ERROR, WARN
}