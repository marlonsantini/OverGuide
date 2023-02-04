package fingerfire.com.overwatch.data.repository

import fingerfire.com.overwatch.api.ValorantApi
import fingerfire.com.overwatch.data.model.AgentResponse

class AgentsRepository(private val valorantApi: ValorantApi) {

    suspend fun loadAgents(): AgentResponse {

        //COROUTINES
        return valorantApi.getAgents()
    }

}