package fingerfire.com.overwatch.features.heroes.data.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class AbilitiesResponse(
    @SerializedName("description") val description: String,
    @SerializedName("displayIcon") val displayIcon: String,
    @SerializedName("displayName") val displayName: String,
    @SerializedName("displayImage") val displayImage: String,
    @SerializedName("displayVideo") val displayVideo: String,
    @SerializedName("slot") val slot: String
)
