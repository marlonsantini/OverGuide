package fingerfire.com.overwatch.data.repository

import fingerfire.com.overwatch.api.ValorantApi
import fingerfire.com.overwatch.data.model.AgentResponse

/**
 * Classe de repositorio faz parte da camada de dados
 * Nesse Exmeplo já esta com injeção de de dependencia implementado e coroutines
 * Nessa classe é realizada a gestão de dados */
class AgentsRepository(private val valorantApi: ValorantApi) {

    suspend fun loadAgents(): AgentResponse {
        return valorantApi.getAgents()
    }

}