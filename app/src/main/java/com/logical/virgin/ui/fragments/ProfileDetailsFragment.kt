package com.logical.virgin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.logical.virgin.databinding.FragmentProfileDetailsBinding
import com.logical.virgin.models.people.PeopleModelItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileDetailsFragment : Fragment() {
    private var _binding: FragmentProfileDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileDetailsBinding.inflate(inflater, container, false)
        val person = arguments?.getParcelable<PeopleModelItem>("DATA")
        binding.person = person





        return binding.root
    }


}