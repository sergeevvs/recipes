package com.github.sergeevvs.recipes.data.repositories

import androidx.annotation.WorkerThread
import com.github.sergeevvs.recipes.data.database.dao.RecipeDao
import com.github.sergeevvs.recipes.presentation.models.Recipe
import kotlinx.coroutines.flow.Flow

@WorkerThread
class RecipeRepository(private val recipeDao: RecipeDao) {

    val flowRecipeList: Flow<List<Recipe>> = recipeDao.getFlowRecipeList()

    suspend fun insert(recipe: Recipe) = recipeDao.insert(recipe)
    suspend fun update(recipe: Recipe) = recipeDao.updateRecipe(recipe)
    suspend fun deleteAll() = recipeDao.deleteAll()
    suspend fun insertMock() {
        val mockRecipe = Recipe(title = "Mock title", description = "Mock description")
        for (_recipe in listOf(
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe,
            mockRecipe
        ))
            recipeDao.insert(_recipe)
    }
}