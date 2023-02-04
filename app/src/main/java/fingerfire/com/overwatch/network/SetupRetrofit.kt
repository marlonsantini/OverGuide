package fingerfire.com.overwatch.network

import fingerfire.com.overwatch.api.ValorantApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://valorant-api.com/v1/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val valorantApi: ValorantApi = getRetrofit().create(ValorantApi::class.java)

}