package fingerfire.com.overguide.features.patchs.data.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class PatchsDataResponse(
    @SerializedName("displayName") val displayName: String,
    @SerializedName("roleType") val roleType: String,
    @SerializedName("displayImage") val displayImage: String,
    @SerializedName("devComment") val devComment: String,
    @SerializedName("changes") val changes: List<PatchsChangeDataResponse>
)
