package fingerfire.com.overwatch

import android.app.Application
import fingerfire.com.overwatch.di.ApiModules
import fingerfire.com.overwatch.di.NetworkModules
import fingerfire.com.overwatch.features.heroes.di.HeroesDataModules
import fingerfire.com.overwatch.features.heroes.di.HeroesUiModules
import org.koin.core.context.startKoin

class OverwatchApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    NetworkModules().getNetworkModules(),
                    ApiModules().getApiModules(),
                    HeroesDataModules().getAgentsDataModules(),
                    HeroesUiModules().getViewModules()
                )
            )
        }
    }
}