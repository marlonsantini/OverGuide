package fingerfire.com.overwatch.api

import fingerfire.com.overwatch.features.heroes.data.response.HeroesDetailResponse
import fingerfire.com.overwatch.features.heroes.data.response.HeroesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OwApi {
    @GET("/heroes")
    suspend fun getHeroes(
    ): Response<HeroesResponse>

    @GET("heroes/{heroesId}")
    suspend fun getHeroesId(
        @Path("id") id: String
    ): HeroesDetailResponse
}