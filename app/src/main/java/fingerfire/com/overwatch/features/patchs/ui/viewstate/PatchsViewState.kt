package fingerfire.com.overwatch.features.patchs.ui.viewstate

import fingerfire.com.overwatch.features.patchs.data.response.PatchsDataResponse

data class PatchsViewState(
    val sucess: List<PatchsDataResponse>? = null,
    val failure: Boolean = false
)