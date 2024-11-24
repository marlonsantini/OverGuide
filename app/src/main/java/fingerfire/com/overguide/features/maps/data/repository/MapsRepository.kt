package fingerfire.com.overguide.features.maps.data.repository

import fingerfire.com.overguide.api.OwApi
import fingerfire.com.overguide.features.maps.data.response.MapsDataResponse
import retrofit2.Response

class MapsRepository(private val owApi: OwApi) {

    suspend fun loadMaps(): Response<List<MapsDataResponse>> {
        return owApi.getMaps()
    }
}