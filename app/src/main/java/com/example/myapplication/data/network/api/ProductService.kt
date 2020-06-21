package com.example.myapplication.data.network.api

import com.example.myapplication.data.network.model.ProductsRespond
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {

    @GET("sites/{SITE_ID}/search")
    suspend fun searchProduct(@Path("SITE_ID") side_id: String, @Query("q") q: String): ProductsRespond
}

/*
* @GET("api.php")
    fun hitCountCheck(@Query("action") action: String,
                      @Query("format") format: String,
                      @Query("list") list: String,
                      @Query("srsearch") srsearch: String):
                  Observable<Model.Result>
* */

/*https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=Trump*/

/*https://api.mercadolibre.com/sites/MLA/search?category=MLA1055
https://api.mercadolibre.com/sites/$SITE_ID/search?category=$CATEGORY_ID*/



//https://api.mercadolibre.com/sites/MLA/search?search=MLA1055

//https://api.mercadolibre.com/sites/MLA/search?category=MLA1055

//https://api.mercadolibre.com/sites/MLA/search?q=Motorola%20G6