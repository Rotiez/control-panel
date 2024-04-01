package ru.study.controlpanel.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.study.controlpanel.model.LogEntry
import ru.study.controlpanel.service.LoggingService

/**
 * Контроллер для обработки запросов на логирование пользовательских действий.
 */
@RestController
class LoggingController(
    private val service: LoggingService,
) {

    /**
     * Метод обработки POST-запроса на путь "/log".
     * Принимает объект LogEntry из тела запроса и передает его сервису для логирования.
     * @param logEntry объект, содержащий информацию о логируемом действии пользователя.
     */
    @PostMapping("/log")
    fun logUserAction(@RequestBody logEntry: LogEntry) {
        service.log(logEntry)
    }

}