package fingerfire.com.overguide.features.heroes.data.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class HeroesDataResponse(
    @SerializedName("_id") val _id: String?,
    @SerializedName("displayName") val displayName: String,
    @SerializedName("description") val description: String,
    @SerializedName("developerName") val developerName: String,
    @SerializedName("location") val location: String,
    @SerializedName("life") val life: String,
    @SerializedName("shield") val shield: String,
    @SerializedName("bustPortrait") val bustPortrait: String,
    @SerializedName("fullPortrait") val fullPortrait: String,
    @SerializedName("fullPortraitV2") val fullPortraitV2: String,
    @SerializedName("fullPortraitV3") val fullPortraitV3: String,
    @SerializedName("bustMini") val bustMini: String,
    @SerializedName("fullHero") val fullHero: String,
    @SerializedName("role") val role: RoleResponse,
    @SerializedName("combo") val combo: List<ComboResponse>,
    @SerializedName("weak") val weak: List<WeakResponse>,
    @SerializedName("abilities") val abilities: List<AbilitiesResponse>,
    @SerializedName("history") val history: String,
    @SerializedName("chapters") val chapters: List<HistoryResponse>
)
