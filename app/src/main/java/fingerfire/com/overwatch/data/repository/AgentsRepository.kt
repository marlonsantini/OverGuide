package fingerfire.com.overwatch.data.repository

import fingerfire.com.overwatch.api.OwApi
import fingerfire.com.overwatch.data.model.AgentResponse

/**
 * Classe de repositorio faz parte da camada de dados
 * Nesse Exmeplo já esta com injeção de de dependencia implementado e coroutines
 * Nessa classe é realizada a gestão de dados */
class AgentsRepository(private val valorantApi: OwApi) {

    suspend fun loadAgents(): AgentResponse {
        return valorantApi.getAgents()
    }

}