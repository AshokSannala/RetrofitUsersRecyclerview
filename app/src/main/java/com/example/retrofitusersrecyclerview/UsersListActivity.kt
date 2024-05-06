package com.example.retrofitusersrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitusersrecyclerview.databinding.ActivityUsersListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class UsersListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUsersListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var apiService: ApiService
    private lateinit var galleryAdapter: GalleryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetUsers()

    }
    private fun fetUsers() {
        retrofit = RetrofitBuilder.getRetrofit()
        apiService = retrofit.create(ApiService::class.java)
        apiService.getUserList().enqueue(object : Callback<List<UsersResponse>> {
            override fun onResponse(call: Call<List<UsersResponse>>, response: Response<List<UsersResponse>>) {
                if (response.isSuccessful) {
                    galleryAdapter = GalleryAdapter(response.body()!!)
                    with(binding) {
                        rv.layoutManager = LinearLayoutManager(this@UsersListActivity,LinearLayoutManager.VERTICAL,false)
                        rv.adapter = galleryAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<UsersResponse>>, t: Throwable) {
                Log.i("Tag", t.message.toString())
            }

        })
    }
}