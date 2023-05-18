package fingerfire.com.overwatch.api

import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OwApi {
    @GET("/heroes")
    suspend fun getHeroes(
    ): Response<List<HeroesDataResponse>>

    @GET("heroes/{id}")
    suspend fun getHeroesId(
        @Path("id") id: String
    ): HeroesDataResponse
}