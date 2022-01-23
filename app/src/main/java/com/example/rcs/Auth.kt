package com.example.rcs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import androidx.viewpager2.adapter.FragmentViewHolder
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.create
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.coroutines.CoroutineContext
import okhttp3.RequestBody.Companion.toRequestBody
import java.nio.charset.StandardCharsets.UTF_8

fun md5(input: String): String {
    val md = MessageDigest.getInstance("MD5")
    return md.digest(input.toByteArray(UTF_8)).toHex()
}

private fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }


class Auth : AppCompatActivity() {
    val frament_manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        findViewById<Button>(R.id.button4).setOnClickListener{_ -> changeFragmentToReg(null)}
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val retrofit = Retrofit.Builder().baseUrl("http://game.phhask.space/").build()

        if (intent.getStringExtra("fragment") == "reg"){
            changeFragmentToReg(null)
        }
        findViewById<Button>(R.id.button3).setOnClickListener { _ ->
            val now_fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
            val jsonObject = JSONObject()
            if (now_fragment is LoginFragment) {
                jsonObject.put("login|mail", findViewById<TextInputLayout>(R.id.textInputLayout).editText?.text)
                jsonObject.put("password", md5(findViewById<TextInputLayout>(R.id.textInputLayout2).editText?.text.toString()))
                CoroutineScope(Dispatchers.IO).launch{
                    val response = retrofit.create(AuthAPI::class.java).Login(jsonObject.toString().toRequestBody("application/json".toMediaType()))
                    println(JSONObject(response.body()?.string()))
                    println(jsonObject["password"])
                }
            } else if (now_fragment is RegFragment){
                jsonObject.put("login", findViewById<TextInputLayout>(R.id.login).editText?.text.toString())
                jsonObject.put("email", " ")
                jsonObject.put("password", findViewById<TextInputLayout>(R.id.password_second).editText?.text.toString())
                CoroutineScope(Dispatchers.IO).launch{
                    val response = retrofit.create(AuthAPI::class.java).Reg(jsonObject.toString().toRequestBody("application/json".toMediaType()))
                    println(JSONObject(response.body()?.string()))
                }
            }
        }
    }

    fun changeFragmentToReg(v: View?){
        frament_manager.beginTransaction().replace(R.id.fragmentContainerView, RegFragment()).addToBackStack(null).commit()
        findViewById<Button>(R.id.button3).text = "Sign up"
        findViewById<Button>(R.id.button4).text = "Sign in"
        findViewById<Button>(R.id.button4).setOnClickListener{_ -> changeFragmentToLogin(null)}
    }

    fun changeFragmentToLogin(v: View?){
        frament_manager.beginTransaction().replace(R.id.fragmentContainerView, LoginFragment()).addToBackStack(null).commit()
        findViewById<Button>(R.id.button3).text = "Sign in"
        findViewById<Button>(R.id.button4).text = "Sign up"
        findViewById<Button>(R.id.button4).setOnClickListener{_ -> changeFragmentToReg(null)}
    }
}