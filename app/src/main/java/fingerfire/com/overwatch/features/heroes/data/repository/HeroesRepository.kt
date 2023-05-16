package fingerfire.com.overwatch.features.heroes.data.repository

import fingerfire.com.overwatch.api.OwApi
import fingerfire.com.overwatch.features.heroes.data.response.HeroesResponse
import retrofit2.Response

class HeroesRepository(private val owApi: OwApi) {

    suspend fun loadHeroes(): Response<HeroesResponse> {
        return owApi.getHeroes()
    }
}