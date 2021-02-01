package com.github.sergeevvs.recipes.data.repositories

import androidx.annotation.WorkerThread
import com.github.sergeevvs.recipes.data.database.dao.RecipeDao
import com.github.sergeevvs.recipes.presentation.models.Recipe
import kotlinx.coroutines.flow.Flow

class RecipeRepository(private val recipeDao: RecipeDao) {

    val allRecipes: Flow<List<Recipe>> = recipeDao.getRecipeList()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(recipe: Recipe) {
        recipeDao.insert(recipe)
    }
}