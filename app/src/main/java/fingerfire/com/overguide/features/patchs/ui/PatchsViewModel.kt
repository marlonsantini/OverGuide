package fingerfire.com.overguide.features.patchs.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fingerfire.com.overguide.features.patchs.data.repository.PatchsRepository
import fingerfire.com.overguide.features.patchs.ui.viewstate.PatchsViewState
import kotlinx.coroutines.launch

class PatchsViewModel(private val patchsRepository: PatchsRepository) : ViewModel() {

    private val patchsMutableLiveData: MutableLiveData<PatchsViewState> =
        MutableLiveData<PatchsViewState>()
    val patchsLiveData: LiveData<PatchsViewState>
        get() {
            return patchsMutableLiveData
        }

    fun getPatchs() {
        viewModelScope.launch {
            val patchsResponse = patchsRepository.loadPatchs()
            if (patchsResponse.isSuccessful && patchsResponse.body() != null) {
                patchsMutableLiveData.postValue(PatchsViewState(sucess = patchsResponse.body()))
            } else if (patchsResponse.errorBody() != null) {
                patchsMutableLiveData.postValue(PatchsViewState(failure = true))
            }
        }
    }
}