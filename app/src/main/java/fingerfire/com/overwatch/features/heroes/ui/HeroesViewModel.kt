package fingerfire.com.overwatch.features.heroes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fingerfire.com.overwatch.features.heroes.data.repository.HeroesRepository
import fingerfire.com.overwatch.features.heroes.ui.viewstate.HeroesViewState
import kotlinx.coroutines.launch

class HeroesViewModel(private val heroesRepository: HeroesRepository) : ViewModel() {

    private val heroesMutableLiveData: MutableLiveData<HeroesViewState> =
        MutableLiveData<HeroesViewState>()
    val heroesLiveData: LiveData<HeroesViewState>
        get() = heroesMutableLiveData


    fun getHeroes() {
        viewModelScope.launch {
            val heroesResponse = heroesRepository.loadHeroes()
            if (heroesResponse.isSuccessful && heroesResponse.body() != null) {
                heroesMutableLiveData.postValue(HeroesViewState(sucess = heroesResponse.body()))
            } else if (heroesResponse.errorBody() != null) {
                heroesMutableLiveData.postValue(HeroesViewState(failure = true))
            }
        }
    }
}