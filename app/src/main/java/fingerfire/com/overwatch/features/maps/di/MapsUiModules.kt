package fingerfire.com.overwatch.features.maps.di

import fingerfire.com.overwatch.features.heroes.ui.HeroesDetailViewModel
import fingerfire.com.overwatch.features.heroes.ui.HeroesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class MapsUiModules {
    fun getViewModules() = module {
        viewModel {
            HeroesViewModel(get())
        }
        viewModel {
            HeroesDetailViewModel(get())
        }
    }
}