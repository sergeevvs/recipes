package com.github.sergeevvs.recipes.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.github.sergeevvs.recipes.databinding.FragmentRecipeListBinding
import com.github.sergeevvs.recipes.presentation.viewmodels.RecipeListViewModel

class RecipeListFragment : Fragment() {

    private val model: RecipeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentRecipeListBinding.inflate(layoutInflater)

//        model.recipeList.observe(viewLifecycleOwner,  })

        return binding.root
    }
}