package fingerfire.com.overwatch.features.patchs.data.repository

import fingerfire.com.overwatch.api.OwApi
import fingerfire.com.overwatch.features.patchs.data.response.PatchsDataResponse
import retrofit2.Response

class PatchsRepository(private val owApi: OwApi) {

    suspend fun loadPatchs(): Response<List<PatchsDataResponse>> {
        return owApi.getPatchs()
    }
}