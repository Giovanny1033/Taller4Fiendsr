package com.tinderequisde.tinderequisde.ui

import com.example.taller4fiendsr.interfaces.OnItemClick
import com.example.taller4fiendsr.models.ProfileInfor
import com.squareup.picasso.Picasso
import com.tinderequisde.tinderequisde.interfaces.OnItemClick
import com.tinderequisde.tinderequisde.models.ProfileInfo
import com.tinderequisde.tinderequisde.R
import com.tinderequisde.tinderequisde.databinding.ProfileItemBinding
import com.xwray.groupie.databinding.BindableItem

class ProfileItem(
    private val onItemClick: OnItemClick,
    private val profile: ProfileInfor
) :
    BindableItem<ProfileItemBinding>() {
    override fun bind(binding: ProfileItemBinding, position: Int) {
        binding.profileName.text = profile.name
        Picasso
            .get()
            .load(profile.photoUrl)
            .resize(250, 250)
            .centerCrop()
            .into(binding.profilePicture)

        binding.root.setOnClickListener {
            onItemClick.onItemClick(profile)
        }
    }

    override fun getLayout(): Int = R.layout.profile_item
}