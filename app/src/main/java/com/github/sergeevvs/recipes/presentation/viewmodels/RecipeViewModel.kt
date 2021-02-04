package com.github.sergeevvs.recipes.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.sergeevvs.recipes.domain.interactors.RecipeInteractor
import com.github.sergeevvs.recipes.presentation.models.Recipe
import kotlinx.coroutines.launch

class RecipeViewModel(private val interactor: RecipeInteractor) : ViewModel() {

    val recipeList: LiveData<List<Recipe>> = interactor.getLiveDataRecipeList()

    fun createRecipe(title: String, description: String) {
        viewModelScope.launch {
            if (title.isEmpty()) interactor.createMockRecipes()
            else interactor.createRecipe(Recipe(title = title, description = description))
        }
    }

    fun deleteAll() = viewModelScope.launch {
        interactor.deleteAllRecipes()
    }

}
