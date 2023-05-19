package fingerfire.com.overwatch.features.patchs.di

import fingerfire.com.overwatch.features.patchs.data.repository.PatchsRepository
import org.koin.dsl.module

class PatchsDataModules {
    fun getPatchsDataModules() = module {
        factory {
            PatchsRepository(get())
        }
    }
}