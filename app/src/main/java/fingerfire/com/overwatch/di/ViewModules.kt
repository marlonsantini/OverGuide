package fingerfire.com.overwatch.di

import fingerfire.com.overwatch.view.ui.allcharacters.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
class ViewModules {

    fun getViewModules() = module {
        viewModel {
            HomeViewModel(get())
        }
    }
}