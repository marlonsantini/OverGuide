package fingerfire.com.overwatch.features.maps.di

import fingerfire.com.overwatch.features.maps.ui.MapsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class MapsUiModules {
    fun getViewModules() = module {
        viewModel {
            MapsViewModel(get())
        }
//        viewModel {
//            MapsDetailViewModel(get())
//        }
    }
}