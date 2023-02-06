package fingerfire.com.overwatch.data.model

import com.squareup.moshi.Json
/** Classe reponsável pelo gerenciamento do campos de recebimento do json
 * sendo usado DataClass e o converter Moshi */
data class AgentDataResponse(
    @Json(name = "displayName")
    val displayName: String
)