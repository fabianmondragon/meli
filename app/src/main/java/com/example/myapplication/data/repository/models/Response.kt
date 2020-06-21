package com.example.myapplication.data.repository.models

import com.google.gson.annotations.SerializedName

data class Response <T> (
    @SerializedName("results")
    val results: T
){
}