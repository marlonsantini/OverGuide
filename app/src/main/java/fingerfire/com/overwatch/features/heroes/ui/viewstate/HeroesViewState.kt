package fingerfire.com.overwatch.features.heroes.ui.viewstate

import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse

data class HeroesViewState(
    val sucess: List<HeroesDataResponse>? = null,
    val failure: Boolean = false
)