package com.example.mimenu.ui.more

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mimenu.MainActivity
import com.example.mimenu.R
import com.example.mimenu.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private lateinit var binding : FragmentMoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var main = requireActivity() as MainActivity
        main.disableToolBar()
    }

    override fun onDestroy() {
        super.onDestroy()
        var main = requireActivity() as MainActivity
        main.enableToolBar()
    }
}