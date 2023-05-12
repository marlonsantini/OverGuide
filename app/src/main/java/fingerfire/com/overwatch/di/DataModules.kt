package fingerfire.com.overwatch.di

import fingerfire.com.overwatch.data.repository.AgentsRepository
import org.koin.dsl.module
class DataModules {
    fun getDataModules() = module {
        factory {
            AgentsRepository(get())
        }
    }
}