package com.logical.virgin.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.logical.virgin.databinding.FragmentProfileDetailsBinding
import com.logical.virgin.databinding.ProfileLayoutBinding
import com.logical.virgin.models.people.PeopleModelItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileDetailsFragment : Fragment() {
    private var _binding:ProfileLayoutBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ProfileLayoutBinding.inflate(inflater, container, false)
        val args = arguments

            val person: PeopleModelItem? = args?.getParcelable("information")
           Log.e("Crash", "$person")
            binding.person = person

            Log.e("Crash", "Arguments expected, but missing")







        return binding.root
    }


}