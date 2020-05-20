package cs.smu.ac.aaa.Api

import com.google.gson.JsonObject
import cs.smu.ac.aaa.data.UserData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface CafeApiService {

    @POST("/user/signin")
    fun postUserData(
        @Body() body: JsonObject
    ):Call<UserData>


}