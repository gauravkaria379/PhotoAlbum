package network

import models.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("photos")
    fun getPhotosListing() : Call<List<DataModel>>
}
