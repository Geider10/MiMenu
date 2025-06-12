package com.example.mimenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mimenu.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.btnOne.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return binding.root
    }

}