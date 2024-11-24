package fingerfire.com.overguide.features.heroes.data.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RoleResponse(
    @SerializedName("description") val description: String,
    @SerializedName("displayIcon") val displayIcon: String,
    @SerializedName("displayName") val displayName: String
)
