package fingerfire.com.overwatch.api

import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OwApi {
    @GET("/heroes")
    suspend fun getHeroes(
    ): Response<List<HeroesDataResponse>>

    @GET("heroes/{heroesId}")
    suspend fun getHeroesId(
        @Path("id") id: String
    ): HeroesDetailResponse
}