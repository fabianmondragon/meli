package com.mondev.network

import com.mondev.dto.respond.ProductsRespondDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {

    @GET("sites/{SITE_ID}/search")
    suspend fun searchProduct(@Path("SITE_ID") side_id: String, @Query("q") q: String): ProductsRespondDto
}