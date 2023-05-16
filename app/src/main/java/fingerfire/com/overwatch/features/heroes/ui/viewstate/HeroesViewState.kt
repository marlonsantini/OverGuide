package fingerfire.com.overwatch.features.heroes.ui.viewstate

import fingerfire.com.overwatch.features.heroes.data.response.HeroesResponse

data class HeroesViewState(val sucess: HeroesResponse? = null, val failure: Boolean = false)