package com.example.myapplication

import android.annotation.SuppressLint
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.gson.Gson
import java.io.FileWriter
import java.io.PrintWriter


class MainActivity : AppCompatActivity() {

    var login = arrayListOf<String>()
    var password = arrayListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val l_login = findViewById<EditText>(R.id.label_login)
        val l_password = findViewById<EditText>(R.id.label_password)
        val button_signin = findViewById<Button>(R.id.button_signin)
        val l_reg = findViewById<TextView>(R.id.label_reg)
        val l_test = findViewById<TextView>(R.id.test_label)
        val l_socket = findViewById<TextView>(R.id.test_socket)

        val text = l_login.text.toString().trim()

        button_signin.setOnClickListener {
            l_login.setVisibility(View.INVISIBLE)
        }

        l_reg.setOnClickListener {
            l_password.setVisibility(View.INVISIBLE)
            setContentView(R.layout.second_layout)
            //rsrp
            //lat
            //lon
            //YT: StartAndroid
        }

        l_test.setOnClickListener {
            read_json(l_test)
        }

        l_socket.setOnClickListener {
            setContentView(R.layout.socket_layout)

        }

    }

    fun read_json(l_test: TextView)
    {
        val mapper = jacksonObjectMapper()

        //val jsonString : UserAdapter = UserAdapter("bl", "123")
        //val login_tmp : String = user.login

        //l_test.text = jsonString.login + " " +  jsonString.password

        val jsonString = """{
            "login": "sosio",
            "password": "123"
        }"""

        val userFromJsonWithType: User = mapper.readValue(jsonString)

        //l_test.text = userFromJsonWithType.login + " " + userFromJsonWithType.password

        val user = User("test", "pass12")
        val userJson = mapper.writeValueAsString(user)

        val userList = mutableListOf<User>()
        userList.add(User("1337", "52"))
        userList.add(User("5252", "53"))

        val jsonArray = mapper.writeValueAsString(userList)

        val userListFromJson: List<User> = mapper.readValue(jsonArray)

        l_test.text = jsonArray


        val path = "/assets/baza_log.json"
        try {
            PrintWriter(FileWriter(path)).use {
                val gson = Gson()
                val jsonString = gson.toJson(companies)
                it.write(jsonString)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        println(userListFromJson)
    }

}
