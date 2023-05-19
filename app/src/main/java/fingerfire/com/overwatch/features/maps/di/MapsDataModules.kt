package fingerfire.com.overwatch.features.maps.di

import fingerfire.com.overwatch.features.heroes.data.repository.HeroesRepository
import org.koin.dsl.module

class MapsDataModules {
    fun getAgentsDataModules() = module {
        factory {
            HeroesRepository(get())
        }
    }
}