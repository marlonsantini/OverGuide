package fingerfire.com.overguide.features.heroes.ui.viewstate

import fingerfire.com.overguide.features.heroes.data.response.HeroesDataResponse

data class HeroesViewState(
    val sucess: List<HeroesDataResponse>? = null,
    val failure: Boolean = false
)