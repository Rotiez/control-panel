package ru.study.controlpanel.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import ru.study.controlpanel.configuration.ControlProperties
import ru.study.controlpanel.model.LogEntry
import ru.study.controlpanel.model.LogLevel
import ru.study.controlpanel.service.LoggingService

/**
 * Контроллер для обработки запросов, связанных с представлениями Thymeleaf.
 */
@Controller
class PanelController(
    private val loggingService: LoggingService,
    private val properties: ControlProperties,

    @Value("\${logging.enabled}")
    private val loggingEnabled: Boolean
) {

    /**
     * Метод обработки GET-запроса на путь "/".
     * Добавляет атрибуты в модель и возвращает имя шаблона представления.
     * @param model объект модели для передачи атрибутов в представление.
     * @return имя шаблона представления (шаблон Thymeleaf), которое будет отображено пользователю.
     */
    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("props", properties)
        model.addAttribute("loggingEnabled", loggingEnabled)
        logIfLoggingEnabled(LogEntry(LogLevel.INFO, "Page Load", "main page was loaded"))
        return "index"
    }

    private fun logIfLoggingEnabled(logEntry: LogEntry) {
        if (loggingEnabled) {
            loggingService.log(logEntry)
        }
    }

}