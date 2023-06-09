package fingerfire.com.overwatch.features.patchs.data.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class PatchsChangeDataResponse(
    @SerializedName("displayName") val displayName: String,
    @SerializedName("displayIcon") val displayIcon: String,
    @SerializedName("changeOne") val changeOne: String,
    @SerializedName("changeTwo") val changeTwo: String
)
