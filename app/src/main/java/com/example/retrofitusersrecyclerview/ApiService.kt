package com.example.retrofitusersrecyclerview

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    /*@GET(Constant.END_POINT)
    fun getRandomDogs() : Call<DogResponse>*/

    @GET(Constant.END_POINT)
    fun getUserList() : Call<List<UsersResponse>>
}