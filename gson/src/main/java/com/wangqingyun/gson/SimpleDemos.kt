package com.wangqingyun.gson

import android.annotation.SuppressLint
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * tutorial: http://tutorials.jenkov.com/java-json/gson.html
 * */

@SuppressLint("LogNotTimber")
fun demoSimpleGson() {
    demoParseJson()
//    Log.d("WQY", "--> ${demoParseObject()}")
}

internal fun demoCreateGson() {
    val gson = Gson()
}

internal fun demoGsonBuilder() {
    val builder = GsonBuilder()
    val gson = builder.create()
}

internal fun demoParseJson() {
    val json = "{\"gender\":\"MALE\",\"name\":\"Lao\"}"
    val person = Gson().fromJson(json, Person::class.java)
    Log.d("WQY", ": ${person.name}, ${person.gender}")
}

internal fun demoParseObject(): String {
    val person = Person("Lao", Gender.MALE)
    return Gson().toJson(person)
}

private data class Person(
        val name: String, val gender: Gender
)

private enum class Gender {
    MALE, FEMALE
}