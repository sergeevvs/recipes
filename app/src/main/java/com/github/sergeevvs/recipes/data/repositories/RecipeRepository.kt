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

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAll() {
        recipeDao.deleteAll()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertMock() {
        for (_recipe in listOf(
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description"),
            Recipe(title = "Mock title", description = "Mock description")
        ))
            recipeDao.insert(_recipe)
    }
}