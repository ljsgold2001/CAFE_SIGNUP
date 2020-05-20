package cs.smu.ac.aaa.Api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CafeApiServiceImpl {
    private const val BASE_URL = "http://15.164.40.41:3000"


    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val service: CafeApiService = retrofit.create(CafeApiService::class.java)
}