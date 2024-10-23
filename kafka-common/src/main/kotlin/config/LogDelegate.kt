package ms2709.kafka.common.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class LogDelegate : ReadOnlyProperty<Any, Logger> {
    companion object {
        private fun <T>createLogger(clazz: Class<T>) : Logger {
            return LoggerFactory.getLogger(clazz)
        }
    }
    private var log:Logger? = null

    override fun getValue(thisRef: Any, property: KProperty<*>): Logger {
        if(log == null){
            log = createLogger(thisRef.javaClass)
        }
        return log!!
    }
}