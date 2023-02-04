package fingerfire.com.overwatch.view.ui.allcharacters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fingerfire.com.overwatch.data.model.AgentResponse
import fingerfire.com.overwatch.data.repository.AgentsRepository
import fingerfire.com.overwatch.network.RetrofitBuilder.valorantApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    //JEITO QUE ALEX GOSTA!
    private val agentsRepository = AgentsRepository(valorantApi)
    private val agentsMutableLiveData: MutableLiveData<AgentResponse> = MutableLiveData<AgentResponse>()
    val agentsLiveData: LiveData<AgentResponse>
        get() {
           return agentsMutableLiveData
        }


    fun getAgents() {
        viewModelScope.launch {
            val agentResponse = agentsRepository.loadAgents()
            agentsMutableLiveData.postValue(agentResponse)
        }
    }

}