package com.isilsubasi.retrofithiltexample.api

import com.isilsubasi.retrofithiltexample.response.MovieDetailsResponse
import com.isilsubasi.retrofithiltexample.response.MoviesListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopularMoviesList(@Query("page") page : Int) : Call<MoviesListResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId : Int) : Call<MovieDetailsResponse>

}