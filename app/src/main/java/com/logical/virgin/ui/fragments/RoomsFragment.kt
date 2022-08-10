package com.logical.virgin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.logical.virgin.R
import com.logical.virgin.adapter.ItemClicked
import com.logical.virgin.adapter.RoomsAdapter
import com.logical.virgin.databinding.FragmentPeopleBinding
import com.logical.virgin.databinding.FragmentRoomsBinding
import com.logical.virgin.models.people.PeopleModelItem
import com.logical.virgin.viewModels.MainViewModel



class RoomsFragment : Fragment() {
    private lateinit var mAdapter: RoomsAdapter
    private var _binding: FragmentRoomsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val recycleView = binding.recycleViewPeople
        mAdapter = RoomsAdapter()
        recycleView.adapter = mAdapter
        viewModel.getRooms()
        viewModel.getAllRooms.observe(viewLifecycleOwner) {rooms->
            mAdapter.setData(rooms)
        }

        return binding.root
    }


}