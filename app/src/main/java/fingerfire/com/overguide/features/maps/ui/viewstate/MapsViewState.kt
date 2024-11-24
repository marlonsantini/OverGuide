package fingerfire.com.overguide.features.maps.ui.viewstate

import fingerfire.com.overguide.features.maps.data.response.MapsDataResponse

data class MapsViewState(val sucess: List<MapsDataResponse>? = null, val failure: Boolean = false)