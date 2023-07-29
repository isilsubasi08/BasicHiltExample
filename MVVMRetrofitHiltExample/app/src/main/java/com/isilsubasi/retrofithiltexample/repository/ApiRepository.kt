package com.isilsubasi.retrofithiltexample.repository

import com.isilsubasi.retrofithiltexample.api.ApiService
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ApiRepository @Inject constructor(private val apiServices : ApiService){
    

    fun getPopularMoviesList(page : Int)=apiServices.getPopularMoviesList(page)

    fun getMovieDetails(id : Int) = apiServices.getMovieDetails(id)
}