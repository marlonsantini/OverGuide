package fingerfire.com.overguide.features.heroes.data.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class HistoryResponse(
    @SerializedName("session") val session: String,
    @SerializedName("description") val description: String,
    @SerializedName("displayIcon") val displayIcon: String
) {
    var isExpanded: Boolean = false
}