package fingerfire.com.overwatch

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.ads.MobileAds
import com.google.firebase.FirebaseApp
import fingerfire.com.overwatch.di.ApiModules
import fingerfire.com.overwatch.di.NetworkModules
import fingerfire.com.overwatch.features.heroes.di.HeroesDataModules
import fingerfire.com.overwatch.features.heroes.di.HeroesUiModules
import fingerfire.com.overwatch.features.maps.di.MapsDataModules
import fingerfire.com.overwatch.features.maps.di.MapsUiModules
import fingerfire.com.overwatch.features.patchs.di.PatchsDataModules
import fingerfire.com.overwatch.features.patchs.di.PatchsUiModules
import org.koin.core.context.startKoin

class OverwatchApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        MobileAds.initialize(this)
        FirebaseApp.initializeApp(this)

        startKoin {
            modules(
                listOf(
                    NetworkModules().getNetworkModules(),
                    ApiModules().getApiModules(),
                    HeroesDataModules().getAgentsDataModules(),
                    HeroesUiModules().getViewModules(),
                    MapsDataModules().getMapsDataModules(),
                    MapsUiModules().getViewModules(),
                    PatchsDataModules().getPatchsDataModules(),
                    PatchsUiModules().getViewModules()
                )
            )
        }
    }
}