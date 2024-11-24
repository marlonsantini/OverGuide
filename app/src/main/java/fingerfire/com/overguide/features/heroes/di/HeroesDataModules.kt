package fingerfire.com.overguide.features.heroes.di

import fingerfire.com.overguide.features.heroes.data.repository.HeroesRepository
import org.koin.dsl.module

class HeroesDataModules {
    fun getAgentsDataModules() = module {
        factory {
            HeroesRepository(get())
        }
    }
}