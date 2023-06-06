package fingerfire.com.overwatch.features.heroes.data.response

data class HeroesDataResponse(
    val _id: String,
    val displayName: String,
    val description: String,
    val developerName: String,
    val location: String,
    val bustPortrait: String,
    val fullPortrait: String,
    val fullPortraitV2: String,
    val fullPortraitV3: String,
    val role: RoleResponse,
    val abilities: List<AbilitiesResponse>,
    val history: String,
    val chapters: List<HistoryResponse>
)