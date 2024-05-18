package org.ibda.myguessgame

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import org.ibda.myguessgame.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var vm : HomeViewModel
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentHomeBinding.inflate(inflater, container, false)
        val rootView = binding.root

        vm = ViewModelProvider(this).get(HomeViewModel::class.java)

        this.binding.home = vm
        this.binding.lifecycleOwner = viewLifecycleOwner


        return rootView
    }
}