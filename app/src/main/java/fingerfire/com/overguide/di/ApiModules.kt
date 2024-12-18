package fingerfire.com.overguide.di

import fingerfire.com.overguide.api.OwApi
import org.koin.dsl.module
import retrofit2.Retrofit

class ApiModules {
    fun getApiModules() = module {
        factory<OwApi> {
            get<Retrofit>().create(OwApi::class.java)
        }
    }
}