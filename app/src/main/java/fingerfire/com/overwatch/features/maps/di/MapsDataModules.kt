package fingerfire.com.overwatch.features.maps.di

import fingerfire.com.overwatch.features.heroes.data.repository.HeroesRepository
import fingerfire.com.overwatch.features.maps.data.repository.MapsRepository
import org.koin.dsl.module

class MapsDataModules {
    fun getMapsDataModules() = module {
        factory {
            MapsRepository(get())
        }
    }
}