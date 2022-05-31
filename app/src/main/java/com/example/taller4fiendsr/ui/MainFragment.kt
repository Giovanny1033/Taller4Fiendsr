package com.tinderequisde.tinderequisde.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.taller4fiendsr.R
import com.example.taller4fiendsr.interfaces.OnItemClick
import com.example.taller4fiendsr.models.ProfileInfor
import com.example.taller4fiendsr.viewmodels.MainViewModel
import com.tinderequisde.tinderequisde.viewmodels.MainViewModel
import com.tinderequisde.tinderequisde.interfaces.OnItemClick
import com.tinderequisde.tinderequisde.models.ProfileInfo
import com.tinderequisde.tinderequisde.R
import com.tinderequisde.tinderequisde.databinding.MainFragmentBinding
import com.xwray.groupie.GroupieAdapter

class MainFragment : Fragment(), OnItemClick {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: MainFragmentBinding

    private val recyclerAdapter by lazy { GroupieAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        initObservers()
        initViews()
    }

    override fun onItemClick(profile: ProfileInfor) {
        openDetailFragment(profile)
    }

    private fun initViews() {
        viewModel.generateProfiles(requireContext())
    }

    private fun initObservers() {
        viewModel.profiles.observe(viewLifecycleOwner) {
            updateRecycler(it)
        }
    }

    private fun setupRecycler() {
        val manager = GridLayoutManager(requireContext(), 2)
        binding.mainRecycler.apply {
            layoutManager = manager
            adapter = recyclerAdapter
        }
    }

    private fun updateRecycler(profiles: List<ProfileInfor>) {
        recyclerAdapter.clear()
        profiles.map {
            recyclerAdapter.add(ProfileItem(this, it))
        }
    }

    private fun openDetailFragment(profile: ProfileInfor) {
        findNavController().navigate(R.id.profileDetailDestination, Bundle().apply {
            putString("id", profile.id)
            putString("name", profile.name)
            putString("description", profile.description)
            putString("photo", profile.photoUrl)
            putString("rating", profile.rating)
        })
    }
}