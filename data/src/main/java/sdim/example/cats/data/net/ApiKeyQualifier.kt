package sdim.example.cats.data.net

import javax.inject.Qualifier
import kotlin.annotation.AnnotationTarget.*

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
@Target(FIELD, VALUE_PARAMETER, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER)
annotation class ApiKeyQualifier