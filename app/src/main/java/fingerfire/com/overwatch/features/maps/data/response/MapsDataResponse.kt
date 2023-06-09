package fingerfire.com.overwatch.features.maps.data.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MapsDataResponse(
    @SerializedName("displayName") val displayName: String,
    @SerializedName("location") val location: String,
    @SerializedName("locationImage") val locationImage: String,
    @SerializedName("displayImage") val displayImage: String,
    @SerializedName("layoutImage") val layoutImage: String
)
