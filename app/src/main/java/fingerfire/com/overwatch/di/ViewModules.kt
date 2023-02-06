package fingerfire.com.overwatch.di

import fingerfire.com.overwatch.view.ui.allcharacters.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
/** Classe de modulo feito para as injeção de dependencia da viewmodel onde no exemplo ela está
 * fazendo a verificação se está na lista de DI e usando factory
 * nesse caso sendo encerrado no momento em que parar de ter uso */
class ViewModules {

    fun getViewModules() = module {
        viewModel {
            HomeViewModel(get())
        }
    }
}