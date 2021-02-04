package com.github.sergeevvs.recipes.presentation.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.sergeevvs.recipes.data.repositories.RecipeRepository
import com.github.sergeevvs.recipes.domain.interactors.RecipeInteractor
import com.github.sergeevvs.recipes.presentation.viewmodels.RecipeViewModel

class ViewModelFactory(private val repository: RecipeRepository) : ViewModelProvider.Factory {

    private val recipeInteractor = RecipeInteractor(repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RecipeViewModel(recipeInteractor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}