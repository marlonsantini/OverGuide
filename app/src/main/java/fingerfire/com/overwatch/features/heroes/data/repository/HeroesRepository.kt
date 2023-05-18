package fingerfire.com.overwatch.features.heroes.data.repository

import fingerfire.com.overwatch.api.OwApi
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDetailResponse
import retrofit2.Response

class HeroesRepository(private val owApi: OwApi) {
    suspend fun loadHeroes(): Response<List<HeroesDataResponse>> {
        return owApi.getHeroes()
    }

    suspend fun getHeroesDetail(id: String): HeroesDetailResponse {
        return owApi.getHeroesId(id)
    }
}