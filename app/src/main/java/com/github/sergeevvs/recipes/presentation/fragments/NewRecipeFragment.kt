package com.github.sergeevvs.recipes.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.sergeevvs.recipes.App
import com.github.sergeevvs.recipes.R
import com.github.sergeevvs.recipes.databinding.FragmentNewRecipeBinding
import com.github.sergeevvs.recipes.presentation.viewmodels.RecipeViewModel

class NewRecipeFragment : Fragment() {

    private val viewModel: RecipeViewModel by activityViewModels {
        (context?.applicationContext as App).viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val binding = FragmentNewRecipeBinding.inflate(layoutInflater)

        /*viewModel.recipe.observe(viewLifecycleOwner) { recipe ->
            recipe?.let {
                binding.etRecipeTitle.editText?.setText(it.title)
                binding.etRecipeDescription.editText?.setText(it.description)
            }
        }*/

        binding.btnCreate.setOnClickListener {
            viewModel.createRecipe(
                title = binding.etRecipeTitle.editText.toString(),
                description = binding.etRecipeDescription.editText.toString()
            )
            findNavController().navigate(R.id.action_newRecipeFragment_to_recipeListFragment)
        }

        return binding.root
    }
}