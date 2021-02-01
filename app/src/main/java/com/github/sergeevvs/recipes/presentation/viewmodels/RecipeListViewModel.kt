package com.github.sergeevvs.recipes.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.sergeevvs.recipes.presentation.models.Recipe

class RecipeListViewModel : ViewModel() {

    private val _recipeList: MutableLiveData<List<Recipe>> by lazy {
        MutableLiveData<List<Recipe>>().also {
            loadRecipeList()
        }
    }

    val recipeList: LiveData<List<Recipe>>
        get() = _recipeList

    private fun loadRecipeList() {
//        TODO("Not yet implemented")
    }


}
