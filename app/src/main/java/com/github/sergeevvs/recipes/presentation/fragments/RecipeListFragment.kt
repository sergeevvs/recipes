package com.github.sergeevvs.recipes.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.sergeevvs.recipes.App
import com.github.sergeevvs.recipes.R
import com.github.sergeevvs.recipes.databinding.FragmentRecipeListBinding
import com.github.sergeevvs.recipes.presentation.adapters.RecipeListAdapter
import com.github.sergeevvs.recipes.presentation.models.Recipe
import com.github.sergeevvs.recipes.presentation.viewmodels.RecipeViewModel

class RecipeListFragment : Fragment() {

    private val viewModel: RecipeViewModel by activityViewModels {
        (context?.applicationContext as App).viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val binding = FragmentRecipeListBinding.inflate(layoutInflater)

        val recyclerView = binding.rvRecipeList
        val adapter = RecipeListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.activity)

        viewModel.recipeList.observe(viewLifecycleOwner) { recipeList ->
            recipeList?.let { adapter.submitList(it) }
        }

        binding.fabNewRecipe.setOnClickListener {
            findNavController().navigate(R.id.action_recipeListFragment_to_recipeFragment)
        }

        binding.fabDeleteAllRecipes.setOnClickListener {
            viewModel.deleteAll()
        }

        return binding.root
    }
}