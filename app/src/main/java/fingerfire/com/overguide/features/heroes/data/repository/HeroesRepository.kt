package fingerfire.com.overguide.features.heroes.data.repository

import fingerfire.com.overguide.api.OwApi
import fingerfire.com.overguide.features.heroes.data.response.HeroesDataResponse
import retrofit2.Response

class HeroesRepository(private val owApi: OwApi) {
    suspend fun loadHeroes(): Response<List<HeroesDataResponse>> {
        return owApi.getHeroes()
    }

    suspend fun getHeroesDetail(id: String): HeroesDataResponse {
        return owApi.getHeroesId(id)
    }
}