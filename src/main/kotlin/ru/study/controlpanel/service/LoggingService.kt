package ru.study.controlpanel.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.study.controlpanel.model.LogEntry
import ru.study.controlpanel.model.LogLevel

/**
 * Сервис для логирования действий пользователя.
 */
@Service
class LoggingService {

    private val log = LoggerFactory.getLogger(LoggingService::class.java)

    fun log(logEntry: LogEntry) {
        val logMessage = "${logEntry.title}: ${logEntry.action}"
        when (logEntry.level) {
            LogLevel.INFO -> log.info(logMessage)
            LogLevel.ERROR -> log.error(logMessage)
            LogLevel.WARN -> log.warn(logMessage)
        }
    }

}
