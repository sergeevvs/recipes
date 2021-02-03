package com.github.sergeevvs.recipes.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.sergeevvs.recipes.R
import com.github.sergeevvs.recipes.RecipeApplication
import com.github.sergeevvs.recipes.databinding.FragmentNewRecipeBinding
import com.github.sergeevvs.recipes.presentation.models.Recipe
import com.github.sergeevvs.recipes.presentation.viewmodels.RecipeListViewModel
import com.github.sergeevvs.recipes.presentation.viewmodels.factories.RecipeListViewModelFactory

class NewRecipeFragment : Fragment() {

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
            if (recipe.title == "") model.insertMock()
            else model.insert(recipe)
            findNavController().navigate(R.id.action_newRecipeFragment_to_recipeListFragment)
        }

        return binding.root
    }
}