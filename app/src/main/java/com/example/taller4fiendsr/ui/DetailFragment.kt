package com.example.taller4fiendsr.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import com.taller4fiendsr.taller4fiendsr.databinding.FragmentDetailBinding

class DetailFragment {
    private lateinit var binding: FragmentDetailBinding

    private lateinit var id: String
    private var name: String = ""
    private var description: String = ""
    private var photo: String = ""
    private var rating: Float = 0f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arguments?.let {
            id = it.getString("id").toString()
            name = it.getString("name").toString()
            description = it.getString("description").toString()
            photo = it.getString("photo").toString()
            rating = it.getString("rating")?.toFloat()!!
        }
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.detailName.text = name
        Picasso
            .get()
            .load(photo)
            .into(binding.bigImage)
        binding.description.text = description

        binding.rating.setOnRatingBarChangeListener { ratingBar, _, _ ->
            rating = ratingBar.rating
            saveData()
        }

        loadRating()
    }

    private fun saveData() {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        with(sharedPref?.edit()) {
            this?.putString("id-$id", rating.toString())
            this?.apply()
        }
    }

    private fun loadRating() {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        rating = if (sharedPref?.getString("id-$id", "0f") != null) {
            sharedPref.getString("id-$id", "0f")?.toFloat()!!
        } else {
            0f
        }
        binding.rating.rating = rating
    }
}

}