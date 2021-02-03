package com.github.sergeevvs.recipes.presentation.viewmodels

import androidx.lifecycle.*
import com.github.sergeevvs.recipes.data.repositories.RecipeRepository
import com.github.sergeevvs.recipes.presentation.models.Recipe
import kotlinx.coroutines.launch

class RecipeListViewModel(private val repository: RecipeRepository) : ViewModel() {

    val recipeList: LiveData<List<Recipe>> = repository.allRecipes.asLiveData()

    fun insert(recipe: Recipe) = viewModelScope.launch {
        repository.insert(recipe)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun insertMock() = viewModelScope.launch {
        repository.insertMock()
    }
}
