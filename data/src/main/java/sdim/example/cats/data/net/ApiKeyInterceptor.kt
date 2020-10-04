package sdim.example.cats.data.net

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

const val API_KEY_PARAM = "x-api-key"

@Singleton
class ApiKeyInterceptor @Inject constructor(@ApiKeyQualifier val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        request = request.newBuilder()
            .addHeader(API_KEY_PARAM, apiKey)
            .build();
        return chain.proceed(request);
    }
}