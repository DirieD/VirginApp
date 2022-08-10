package com.logical.virgin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.logical.virgin.databinding.ProfileLayoutBinding
import com.logical.virgin.models.people.PeopleModelItem
import com.logical.virgin.util.Constants.Companion.ARGS_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileDetailsFragment : Fragment() {
    private var _binding: ProfileLayoutBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = ProfileLayoutBinding.inflate(inflater, container, false)
        val args = arguments
        val person: PeopleModelItem? = args?.getParcelable(ARGS_KEY)
        binding.person = person
        return binding.root
    }

    override fun onDestroy() {
        _binding=null
        super.onDestroy()
    }

}