package ru.study.controlpanel.configuration

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean
import org.springframework.core.env.PropertiesPropertySource
import org.springframework.core.env.PropertySource
import org.springframework.core.io.support.EncodedResource
import org.springframework.core.io.support.PropertySourceFactory
import java.io.FileNotFoundException
import java.util.*


/**
 * Фабрика для загрузки свойств из yaml.
 */
object YamlPropertySourceFactory: PropertySourceFactory {

    override fun createPropertySource(name: String?, encodedResource: EncodedResource): PropertySource<*> {
        val props = loadYamlIntoProperties(encodedResource)
        return PropertiesPropertySource(encodedResource.resource.filename.orEmpty(), props)
    }

    private fun loadYamlIntoProperties(encodedResource: EncodedResource): Properties {
        try {
            return YamlPropertiesFactoryBean().apply { setResources(encodedResource.resource) }.`object` ?: Properties()
        } catch (e: IllegalArgumentException) {
            val cause = e.cause
            if (cause is FileNotFoundException) {
                throw cause.apply {
                    addSuppressed(e)
                }
            }
            throw e
        }
    }
}
