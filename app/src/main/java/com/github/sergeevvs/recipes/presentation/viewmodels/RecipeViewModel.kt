package com.github.sergeevvs.recipes.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.sergeevvs.recipes.domain.interactors.RecipeInteractor
import com.github.sergeevvs.recipes.presentation.models.Recipe
import kotlinx.coroutines.launch

class RecipeViewModel(private val interactor: RecipeInteractor) : ViewModel() {

    val recipeList: LiveData<List<Recipe>> = interactor.getLiveDataRecipeList()
    private val currentRecipe = MutableLiveData<Recipe>()
    var isNewRecipe: Boolean = false

    fun getCurrentRecipe(): LiveData<Recipe> = currentRecipe

    fun updateRecipeState(title: String, description: String) {
        currentRecipe.value?.let {
            it.title = title
            it.description = description
        }
    }

    fun setCurrentRecipe(recipe: Recipe? = null) {
        if (recipe == null) {
            isNewRecipe = true
            currentRecipe.value = Recipe()
        } else {
            isNewRecipe = false
            currentRecipe.value = recipe.copy()
        }
    }

    fun createRecipe() {
        viewModelScope.launch {
            if (currentRecipe.value?.title == "") interactor.createMockRecipes()
            else currentRecipe.value?.let { interactor.createRecipe(it) }
        }
    }

    fun updateRecipe() {
        viewModelScope.launch {
            currentRecipe.value?.let { interactor.updateRecipe(it) }
        }
    }

    fun deleteAll() = viewModelScope.launch {
        interactor.deleteAllRecipes()
    }

}
