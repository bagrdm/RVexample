package com.example.rvexample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.rvexample.databinding.FragmentExampleBinding

class ExampleFragment : Fragment(R.layout.fragment_example) {

    private val viewModel: FragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentExampleBinding.bind(view)

        binding.addItemButton.setOnClickListener {
            viewModel.addRoom()
        }

        val listener = object : ButtonClickListener {

            override fun removeRoom(position: Int) {
                viewModel.removeRoom(position)
            }

            override fun addParent(position: Int) {
                viewModel.addParent(position)
            }

            override fun addChild(position: Int) {
                viewModel.addChild(position)
            }

            override fun removeParent(position: Int) {
                viewModel.removeParent(position)
            }

            override fun removeChild(position: Int) {
                viewModel.removeChild(position)
            }
        }

        val exampleAdapter = createAdapter(listener)
        binding.recycler.adapter = exampleAdapter

        viewModel.data.observe(viewLifecycleOwner) {
            exampleAdapter.submitList(it)
        }
    }

    private fun createAdapter(listener: ButtonClickListener): ExampleAdapter {

        return ExampleAdapter(listener)
    }
}
