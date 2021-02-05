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
import com.github.sergeevvs.recipes.databinding.FragmentRecipeBinding
import com.github.sergeevvs.recipes.presentation.viewmodels.RecipeViewModel

class RecipeFragment : Fragment() {

    private val viewModel: RecipeViewModel by activityViewModels {
        (context?.applicationContext as App).viewModelFactory
    }
    private lateinit var binding: FragmentRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentRecipeBinding.inflate(layoutInflater)

        viewModel.getCurrentRecipe().observe(viewLifecycleOwner) { recipe ->
            recipe?.let {
                binding.etRecipeTitle.editText?.setText(it.title)
                binding.etRecipeDescription.editText?.setText(it.description)
            }
        }

        binding.btnCreate.setOnClickListener {
            viewModel.createRecipe(
                title = binding.etRecipeTitle.editText?.text.toString(),
                description = binding.etRecipeDescription.editText?.text.toString()
            )
            findNavController().navigate(R.id.action_recipeFragment_to_recipeListFragment)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.
    }
}