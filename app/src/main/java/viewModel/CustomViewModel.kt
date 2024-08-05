package viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import models.DataModel
import network.RetrofitAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CustomViewModel : ViewModel() {
    private var photoLiveData = MutableLiveData<List<DataModel>>()
    fun getPhotosListing() {
        RetrofitAPI.api.getPhotosListing().enqueue(object : Callback<List<DataModel>> {

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }

            override fun onResponse(call: Call<List<DataModel>>, response: Response<List<DataModel>>) {
                if (response.body()!=null){
                    photoLiveData.value = response.body()!!
                }
                else{
                    return
                }
            }
        })
    }
    fun observePhotoLiveData() : LiveData<List<DataModel>> {
        return photoLiveData
    }
}
