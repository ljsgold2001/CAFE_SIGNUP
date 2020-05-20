package cs.smu.ac.aaa.data

import com.google.gson.annotations.SerializedName


data class UserData(
    @SerializedName("name")
    val name : String,
    @SerializedName("phone")
    val phone : String,
    @SerializedName("birth")
    val birth : String


)