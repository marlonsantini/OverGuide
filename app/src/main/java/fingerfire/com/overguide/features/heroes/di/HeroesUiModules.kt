package fingerfire.com.overguide.features.heroes.di

import fingerfire.com.overguide.features.heroes.ui.HeroesDetailViewModel
import fingerfire.com.overguide.features.heroes.ui.HeroesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class HeroesUiModules {
    fun getViewModules() = module {
        viewModel {
            HeroesViewModel(get())
        }
        viewModel {
            HeroesDetailViewModel(get())
        }
    }
}