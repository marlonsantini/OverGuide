package fingerfire.com.overwatch.api

import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import fingerfire.com.overwatch.features.maps.data.response.MapsDataResponse
import fingerfire.com.overwatch.features.patchs.data.response.PatchsDataResponse
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

    @GET("/maps")
    suspend fun getMaps(
    ): Response<List<MapsDataResponse>>

    @GET("/patchs")
    suspend fun getPatchs(
    ): Response<List<PatchsDataResponse>>
}