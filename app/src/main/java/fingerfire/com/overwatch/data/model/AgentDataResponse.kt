package fingerfire.com.overwatch.data.model

import com.squareup.moshi.Json

data class AgentDataResponse(
    @Json(name = "displayName")
    val displayName: String
)