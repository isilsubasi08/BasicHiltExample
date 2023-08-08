package com.isilsubasi.retrofithiltexample.ui.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import coil.load
import coil.size.Scale
import com.isilsubasi.retrofithiltexample.R
import com.isilsubasi.retrofithiltexample.databinding.FragmentMoviesDetailsBinding
import com.isilsubasi.retrofithiltexample.repository.ApiRepository
import com.isilsubasi.retrofithiltexample.response.MovieDetailsResponse
import com.isilsubasi.retrofithiltexample.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MoviesDetailsFragment : Fragment() {

    private lateinit var binding : FragmentMoviesDetailsBinding

    @Inject
    lateinit var apiRepository: ApiRepository

    private val args : MoviesDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentMoviesDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = args.movieId
        binding.apply {
            prgBarMovies.visibility=View.INVISIBLE
            apiRepository.getMovieDetails(id).enqueue(object : Callback<MovieDetailsResponse>{
                override fun onResponse(
                    call: Call<MovieDetailsResponse>,
                    response: Response<MovieDetailsResponse>
                ) {
                    prgBarMovies.visibility=View.GONE
                    when(response.code()){
                        200 ->{
                            response.body().let {
                                val moviePoster= Constants.POSTER_BASE_URL +it!!.poster_path
                                tvMovieBudget.text=it.budget.toString()
                                tvMovieOverview.text=it.overview
                                tvMovieDateRelease.text=it.release_date
                                tvMovieRating.text=it.vote_average.toString()
                                tvMovieRevenue.text=it.revenue.toString()
                                tvMovieRuntime.text=it.runtime.toString()
                                tvMovieTagLine.text=it.tagline
                                tvMovieTitle.text=it.title

                                imgMovie.load(moviePoster){
                                    crossfade(true)
                                    placeholder(R.drawable.poster_placeholder)
                                    scale(Scale.FILL)
                                }
                                imgMovieBack.load(moviePoster){
                                    crossfade(true)
                                    placeholder(R.drawable.poster_placeholder)
                                    scale(Scale.FILL)
                                }
                            }
                        }
                        400 ->{Toast.makeText(requireContext(), "400", Toast.LENGTH_SHORT).show()}
                        401 ->{Toast.makeText(requireContext(), "401", Toast.LENGTH_SHORT).show()}

                    }

                }

                override fun onFailure(call: Call<MovieDetailsResponse>, t: Throwable) {
                    prgBarMovies.visibility=View.GONE
                    Toast.makeText(requireContext(), "onFailure", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

}