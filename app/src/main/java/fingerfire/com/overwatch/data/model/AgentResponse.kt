package fingerfire.com.overwatch.data.model

import com.squareup.moshi.Json

data class AgentResponse(
    @Json(name = "data")
    val data: List<AgentDataResponse>,
    @Json(name = "status")
    val statuss: Int
)