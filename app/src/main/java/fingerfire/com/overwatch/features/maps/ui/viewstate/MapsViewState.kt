package fingerfire.com.overwatch.features.maps.ui.viewstate

import fingerfire.com.overwatch.features.maps.data.response.MapsDataResponse

data class MapsViewState (val sucess: List<MapsDataResponse>? = null, val failure: Boolean = false)