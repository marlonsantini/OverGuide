package fingerfire.com.overwatch

import android.app.Application
import fingerfire.com.overwatch.di.ApiModules
import fingerfire.com.overwatch.di.DataModules
import fingerfire.com.overwatch.di.NetworkModules
import fingerfire.com.overwatch.di.ViewModules
import org.koin.core.context.startKoin

class OverwatchApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    NetworkModules().getNetworkModules(),
                    ApiModules().getApiModules(),
                    DataModules().getDataModules(),
                    ViewModules().getViewModules()
                )
            )
        }
    }
}