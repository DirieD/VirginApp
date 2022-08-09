package com.logical.virgin.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.logical.virgin.adapter.PeopleAdapter
import com.logical.virgin.databinding.FragmentPeopleBinding
import com.logical.virgin.models.people.PeopleModelItem
import com.logical.virgin.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment() {
    private var responsePeople = emptyList<PeopleModelItem>()
    private var mAdapter=PeopleAdapter()

    private var _binding: FragmentPeopleBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val recycleView = binding.recycleViewPeople
        recycleView.adapter=mAdapter
        viewModel.getPeople()

        viewModel.getAllPeople.observe(viewLifecycleOwner){
            mAdapter.setData(it)

        }

        return binding.root
    }


}