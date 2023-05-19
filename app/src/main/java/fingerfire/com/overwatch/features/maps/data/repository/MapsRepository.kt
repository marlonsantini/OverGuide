package fingerfire.com.overwatch.features.maps.data.repository

import fingerfire.com.overwatch.api.OwApi
import fingerfire.com.overwatch.features.maps.data.response.MapsDataResponse
import retrofit2.Response

class MapsRepository(private val owApi: OwApi) {

    suspend fun loadMaps(): Response<List<MapsDataResponse>> {
        return owApi.getMaps()
    }
}