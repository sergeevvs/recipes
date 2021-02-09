package com.github.sergeevvs.recipes.domain.interactors

import androidx.lifecycle.asLiveData
import com.github.sergeevvs.recipes.data.repositories.RecipeRepository
import com.github.sergeevvs.recipes.presentation.models.Recipe


class RecipeInteractor(private val recipeRepository: RecipeRepository) {

    fun getLiveDataRecipeList() = recipeRepository.flowRecipeList.asLiveData()
    suspend fun createRecipe(recipe: Recipe) = recipeRepository.insert(recipe)
    suspend fun updateRecipe(recipe: Recipe) = recipeRepository.update(recipe)
    suspend fun deleteAllRecipes() = recipeRepository.deleteAll()
    suspend fun createMockRecipes() = recipeRepository.insertMock()
}