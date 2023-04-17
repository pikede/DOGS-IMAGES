package com.example.dogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogs.databinding.FragmentDogBinding
import com.example.dogs.models.Dogs

class DogFragment : Fragment() {

    private var _binding: FragmentDogBinding? = null
    private val binding: FragmentDogBinding get() = _binding!!
    private val viewModel: DogViewModel by viewModels()
    private lateinit var dogAdapter: DogAdapter

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            DogFragment().apply {
                arguments = Bundle()
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dogRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            dogAdapter = DogAdapter()
            adapter = dogAdapter
        }

        with(viewModel) {
            dogs.observe(viewLifecycleOwner, dogsObserver)
            getDogList()
        }
    }

    private val dogsObserver = Observer<Dogs> {
        dogAdapter.updateDataset(it.message)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}