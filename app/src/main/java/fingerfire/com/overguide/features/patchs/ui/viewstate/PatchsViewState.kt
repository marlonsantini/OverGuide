package fingerfire.com.overguide.features.patchs.ui.viewstate

import fingerfire.com.overguide.features.patchs.data.response.PatchsDataResponse

data class PatchsViewState(
    val sucess: List<PatchsDataResponse>? = null,
    val failure: Boolean = false
)