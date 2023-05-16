package fingerfire.com.overwatch.features.heroes.di

import fingerfire.com.overwatch.features.heroes.ui.HeroesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class HeroesUiModules {
    fun getViewModules() = module {
        viewModel {
            HeroesViewModel(get())
        }
    }
}