package com.github.sergeevvs.recipes.presentation.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.sergeevvs.recipes.data.repositories.RecipeRepository
import com.github.sergeevvs.recipes.presentation.viewmodels.RecipeListViewModel

class RecipeListViewModelFactory(private val repository: RecipeRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RecipeListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}