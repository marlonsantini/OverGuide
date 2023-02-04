package fingerfire.com.overwatch.api

import fingerfire.com.overwatch.data.model.AgentResponse
import retrofit2.http.GET
import retrofit2.http.Query

//End-point
interface ValorantApi {
    @GET("agents")
    suspend fun getAgents(
    ): AgentResponse

}