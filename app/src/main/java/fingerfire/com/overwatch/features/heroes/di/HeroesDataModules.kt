package fingerfire.com.overwatch.features.heroes.di

import fingerfire.com.overwatch.features.heroes.data.repository.HeroesRepository
import org.koin.dsl.module

class HeroesDataModules {
    fun getAgentsDataModules() = module {
        factory {
            HeroesRepository(get())
        }
    }
}