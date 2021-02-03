package com.github.sergeevvs.recipes.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.sergeevvs.recipes.RecipeApplication
import com.github.sergeevvs.recipes.databinding.FragmentNewRecipeBinding
import com.github.sergeevvs.recipes.presentation.models.Recipe
import com.github.sergeevvs.recipes.presentation.viewmodels.RecipeListViewModel
import com.github.sergeevvs.recipes.presentation.viewmodels.factories.RecipeListViewModelFactory

class NewRecipeFragment: Fragment() {

    private val model: RecipeListViewModel by viewModels {
        RecipeListViewModelFactory((activity?.application as RecipeApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentNewRecipeBinding.inflate(layoutInflater)

        binding.btnCreate.setOnClickListener {
            val recipe = Recipe(
                title = binding.etRecipeTitle.editText?.text.toString(),
                description = binding.etRecipeDescription.editText?.text.toString()
            )
            model.insert(recipe)
        }

        return binding.root
    }
}