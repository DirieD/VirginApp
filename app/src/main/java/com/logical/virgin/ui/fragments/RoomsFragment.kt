package com.logical.virgin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.logical.virgin.adapter.RoomsAdapter
import com.logical.virgin.databinding.FragmentRoomsBinding
import com.logical.virgin.viewModels.MainViewModel
import kotlinx.coroutines.launch

class RoomsFragment : Fragment() {
    private lateinit var mAdapter: RoomsAdapter
    private var _binding: FragmentRoomsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val recycleView = binding.recycleViewPeople
        mAdapter = RoomsAdapter()
        recycleView.adapter = mAdapter

        if (viewModel.hasInternetConnection()) {
            observeRoomsData()
        } else {
            observeDataFromDB()
        }
        binding.slPeople.setOnRefreshListener {
            observeRoomsData()
        }

        return binding.root
    }

    private fun observeRoomsData() {
        viewModel.getRooms()
        viewModel.getAllRooms.observe(viewLifecycleOwner) { rooms ->
            mAdapter.setData(rooms)
        }
    }

    private fun observeDataFromDB() {
        lifecycleScope.launch {
            viewModel.readRooms.observe(viewLifecycleOwner) {
                if (it.isNotEmpty()) {
                    Toast.makeText(context, "Data coming from local data base", Toast.LENGTH_SHORT)
                        .show()
                    mAdapter.setData(it[0].roomsModel)
                } else {
                    Toast.makeText(context, "No Internet & Database is empty", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}