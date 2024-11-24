package fingerfire.com.overguide.features.maps.di

import fingerfire.com.overguide.features.maps.data.repository.MapsRepository
import org.koin.dsl.module

class MapsDataModules {
    fun getMapsDataModules() = module {
        factory {
            MapsRepository(get())
        }
    }
}