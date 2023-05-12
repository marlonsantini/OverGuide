package fingerfire.com.overwatch.di

import fingerfire.com.overwatch.network.SetupRetrofit
import org.koin.dsl.module
class NetworkModules {

    fun getNetworkModules() = module {
        single {
            SetupRetrofit.getRetrofit()
        }
    }
}