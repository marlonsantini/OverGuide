package fingerfire.com.overguide.features.heroes.data.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class WeakResponse(
    @SerializedName("heroWeak") val heroWeak: String
)
