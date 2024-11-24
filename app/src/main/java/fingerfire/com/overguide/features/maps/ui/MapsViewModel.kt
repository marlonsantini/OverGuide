package fingerfire.com.overguide.features.maps.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fingerfire.com.overguide.features.maps.data.repository.MapsRepository
import fingerfire.com.overguide.features.maps.ui.viewstate.MapsViewState
import kotlinx.coroutines.launch

class MapsViewModel(private val mapsRepository: MapsRepository) : ViewModel() {

    private val mapsMutableLiveData: MutableLiveData<MapsViewState> =
        MutableLiveData<MapsViewState>()
    val mapsLiveData: LiveData<MapsViewState>
        get() {
            return mapsMutableLiveData
        }

    fun getMaps() {
        viewModelScope.launch {
            val mapsResponse = mapsRepository.loadMaps()
            if (mapsResponse.isSuccessful && mapsResponse.body() != null) {
                mapsMutableLiveData.postValue(MapsViewState(sucess = mapsResponse.body()))
            } else if (mapsResponse.errorBody() != null) {
                mapsMutableLiveData.postValue(MapsViewState(failure = true))
            }
        }
    }
}