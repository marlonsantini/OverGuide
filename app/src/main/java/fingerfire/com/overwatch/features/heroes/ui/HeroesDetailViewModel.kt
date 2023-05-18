package fingerfire.com.overwatch.features.heroes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fingerfire.com.overwatch.features.heroes.data.repository.HeroesRepository
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import kotlinx.coroutines.launch

class HeroesDetailViewModel(private val heroesRepository: HeroesRepository) : ViewModel() {

    private val heroesDetailMutableLiveData: MutableLiveData<HeroesDataResponse> =
        MutableLiveData<HeroesDataResponse>()
    val heroesDetailLiveData: LiveData<HeroesDataResponse>
        get() {
            return heroesDetailMutableLiveData
        }

    fun getHeroesDetail(id: String) {
        viewModelScope.launch {
            val heroesDataResponse = heroesRepository.getHeroesDetail(id)
            heroesDetailMutableLiveData.postValue(heroesDataResponse)
        }
    }
}