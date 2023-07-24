package fingerfire.com.overwatch.features.heroes.data.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ComboResponse(
    @SerializedName("heroCombo") val heroCombo: String
)
