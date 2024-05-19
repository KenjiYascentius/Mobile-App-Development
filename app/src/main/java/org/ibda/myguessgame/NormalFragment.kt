package org.ibda.myguessgame

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.ibda.myguessgame.databinding.FragmentBottomNavBinding
import org.ibda.myguessgame.databinding.FragmentNormalBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NormalFragment : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var vm : NormalViewModel
    private lateinit var binding : FragmentNormalBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.binding = FragmentNormalBinding.inflate(inflater, container, false)
        val rootView = binding.root

        vm = ViewModelProvider(this).get(NormalViewModel::class.java)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        this.binding.normal = vm
        this.binding.lifecycleOwner = viewLifecycleOwner

        sharedViewModel.destination.observe(this.viewLifecycleOwner, Observer { destination ->
            Log.d("M2", destination)
            vm.setDestination(destination)
        })

        this.vm.tasks.observe(this.viewLifecycleOwner, Observer { tasks ->
            recyclerView.adapter = TaskAdapter(tasks)
        })

        return rootView
    }
}