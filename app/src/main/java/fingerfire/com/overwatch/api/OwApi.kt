package fingerfire.com.overwatch.api

import fingerfire.com.overwatch.features.heroes.data.response.HeroesResponse
import retrofit2.Response
import retrofit2.http.GET

interface OwApi {

    @GET("/heroes")
    suspend fun getHeroes(
    ): Response<HeroesResponse>
}