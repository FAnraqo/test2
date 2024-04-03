package com.example.myapplication

import android.annotation.SuppressLint
// import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.net.ServerSocket
import java.net.Socket
// import androidx.core.content.ContentProviderCompat.requireContext
// import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
//import com.fasterxml.jackson.module.kotlin.readValue
//import com.google.gson.Gson
//import java.io.File
import java.io.PrintWriter
import java.io.BufferedReader
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

//    var login = arrayListOf<String>()
//    var password = arrayListOf<String>()



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val labelLogin = findViewById<EditText>(R.id.label_login)
        val labelPassword = findViewById<EditText>(R.id.label_password)
        val buttonSignin = findViewById<Button>(R.id.button_signin)
        val labelReg = findViewById<TextView>(R.id.label_reg)
        val labelTest = findViewById<TextView>(R.id.test_label)
        val labelSocket = findViewById<TextView>(R.id.test_socket)
        val buttonSocket = findViewById<Button>(R.id.back_socket)
        val sendHello = findViewById<Button>(R.id.sendHello)

//        val text = l_login.text.toString().trim()
//
        val userList = mutableListOf<User>()
        userList.add(User("admin", "123"))
        userList.add(User("52", "52"))

        buttonSignin.setOnClickListener {
            // labelLogin.setVisibility(View.INVISIBLE)
            if (labelLogin.toString() == userList[0].login)
                labelReg.text = "Вы ввошли в аккаунт"
            else
                labelReg.text = "Неверно введён пароль"
        }
//
//        labelReg.setOnClickListener {
//            //labelPassword.setVisibility(View.INVISIBLE)
//            setContentView(R.layout.second_layout)
//            //rsrp
//            //lat
//            //lon
//            //YT: StartAndroid
//        }
//
//        labelTest.setOnClickListener {
//            readJson(labelTest)
//        }
//
        labelSocket.setOnClickListener {
            setContentView(R.layout.socket_layout)
        }

//        buttonSocket.setOnClickListener {
//            setContentView(R.layout.second_layout)
//        }

//        sendHello.setOnClickListener{
//            client()
//        }

    }
//
//    fun readJson(labelTest: TextView)
//    {
////        val mapper = jacksonObjectMapper()
////
////        //val jsonString : UserAdapter = UserAdapter("bl", "123")
////        //val login_tmp : String = user.login
////
////        //l_test.text = jsonString.login + " " +  jsonString.password
////
////        val jsonString = """{
////            "login": "sosio",
////            "password": "123"
////        }"""
////
////        val userFromJsonWithType: User = mapper.readValue(jsonString)
////
////        //l_test.text = userFromJsonWithType.login + " " + userFromJsonWithType.password
////
////        val user = User("test", "pass12")
////        val userJson = mapper.writeValueAsString(user)
////
////
////
////        val jsonArray = mapper.writeValueAsString(userList)
////
////        val userListFromJson: List<User> = mapper.readValue(jsonArray)
////
////        l_test.text = jsonArray
//
//
////        val path = "/assets/baza_log.json"
////        try {
////            PrintWriter(FileWriter(path)).use {
////                val gson = Gson()
////                val jsonString = gson.toJson(companies)
////                it.write(jsonString)
////            }
////        } catch (e: Exception) {
////            e.printStackTrace()
////        }
////
////        println(userListFromJson)
//
////        val filePath = "baza_log.json" // Replace with your JSON file path
////        val file = File(filePath)
////        labelTest.text = "good"
//
//        //val jsonString_test = file.readText()
//        //val user_test = Gson().fromJson(jsonString_test, User::class.java)
//
//        //l_test.text = user_test.toString()
//        //println(user_test)
//    }

}
fun client() {
    val client = Socket("127.0.0.1", 9999)
    val output = PrintWriter(client.getOutputStream(), true)
    val input = BufferedReader(InputStreamReader(client.inputStream))

    println("Client sending [Hello]")
    output.println("Hello")
    println("Client receiving [${input.readLine()}]")
    client.close()
}