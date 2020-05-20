package cs.smu.ac.aaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import cs.smu.ac.aaa.Api.CafeApiServiceImpl
import cs.smu.ac.aaa.data.UserData
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {



        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)




            button.setOnClickListener{

                var  Name  = editText2.text.toString()
                var  Phone  = editText5.text.toString()
                var  birth = editText6.text.toString()



                if (checkBox.isChecked()) {
                    if(Name.isEmpty() || Phone.isEmpty() || birth.isEmpty()){
                        var dialog = AlertDialog.Builder(this@MainActivity)
                        dialog.setTitle("알람")
                        dialog.setMessage(" 항목을 빠짐없이 작성해주세요!")
                        dialog.show()
                    }
                    else {
                        postUserData(Name, Phone, birth)
                    }
                }
                else{
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("알람")
                    dialog.setMessage(" 동의여부를 선택해주세요!")
                    dialog.show()
                }
            }

        }

        private fun postUserData(name : String ,phone : String, birth : String){

            var jsonObject = JSONObject()
            jsonObject.put("name",name)
            jsonObject.put("phone",phone)
            jsonObject.put("birth",birth)

            val body = JsonParser().parse(jsonObject.toString()) as JsonObject

            Log.d("지수의 고통", "너가만든 제이슨 : $body")

            val callSignUpResponse: Call<UserData> = CafeApiServiceImpl.service.postUserData(
                body

            )
            callSignUpResponse.enqueue(object : Callback<UserData> {
                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {

                    Log.d("지수의 고통", "onResponse Called / response : ${response.body()}")
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("알람")
                    dialog.setMessage(" 사용후 꼭 직원에게 반납해주세요!")
                    dialog.show()
                }

                override fun onFailure(call: Call<UserData>, t: Throwable) {

                    Log.d(
                        "지수의 고통",
                        "onResponse Called / response : ${TextUtils.join("\n", t.stackTrace)}"
                    )
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("알람")
                    dialog.setMessage("서버연동 실패")
                    dialog.show()


                }

            })









        }
    }


