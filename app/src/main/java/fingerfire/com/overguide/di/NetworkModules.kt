package fingerfire.com.overguide.di

import fingerfire.com.overguide.network.SetupRetrofit
import org.koin.dsl.module

class NetworkModules {

    fun getNetworkModules() = module {
        single {
            SetupRetrofit.getRetrofit()
        }
    }
}