package com.isilsubasi.retrofithiltexample.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isilsubasi.retrofithiltexample.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

}