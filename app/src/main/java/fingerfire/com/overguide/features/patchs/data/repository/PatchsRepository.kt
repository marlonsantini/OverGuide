package fingerfire.com.overguide.features.patchs.data.repository

import fingerfire.com.overguide.api.OwApi
import fingerfire.com.overguide.features.patchs.data.response.PatchsDataResponse
import retrofit2.Response

class PatchsRepository(private val owApi: OwApi) {

    suspend fun loadPatchs(): Response<List<PatchsDataResponse>> {
        return owApi.getPatchs()
    }
}