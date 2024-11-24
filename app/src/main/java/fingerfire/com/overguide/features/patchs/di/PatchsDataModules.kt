package fingerfire.com.overguide.features.patchs.di

import fingerfire.com.overguide.features.patchs.data.repository.PatchsRepository
import org.koin.dsl.module

class PatchsDataModules {
    fun getPatchsDataModules() = module {
        factory {
            PatchsRepository(get())
        }
    }
}