package com.github.sergeevvs.recipes.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.sergeevvs.recipes.R
import com.github.sergeevvs.recipes.RecipeApplication
import com.github.sergeevvs.recipes.databinding.FragmentRecipeListBinding
import com.github.sergeevvs.recipes.presentation.adapters.RecipeListAdapter
import com.github.sergeevvs.recipes.presentation.viewmodels.RecipeListViewModel
import com.github.sergeevvs.recipes.presentation.viewmodels.factories.RecipeListViewModelFactory

class RecipeListFragment : Fragment() {

    private val model: RecipeListViewModel by viewModels {
        RecipeListViewModelFactory((activity?.application as RecipeApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentRecipeListBinding.inflate(layoutInflater)

        val recyclerView = binding.rvRecipeList
        val adapter = RecipeListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.activity)

        model.recipeList.observe(viewLifecycleOwner, { recipeList ->
            recipeList?.let { adapter.submitList(recipeList) }
        })

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_recipeListFragment_to_newRecipeFragment)
        }

        return binding.root
    }
}