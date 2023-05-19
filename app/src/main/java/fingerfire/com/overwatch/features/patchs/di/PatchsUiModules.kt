package fingerfire.com.overwatch.features.patchs.di

import fingerfire.com.overwatch.features.patchs.ui.PatchsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class PatchsUiModules {
    fun getViewModules() = module {
        viewModel {
            PatchsViewModel(get())
        }
//        viewModel {
//            MapsDetailViewModel(get())
//        }
    }
}