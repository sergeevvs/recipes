package com.github.sergeevvs.recipes

import android.app.Application
import com.github.sergeevvs.recipes.data.database.RecipeRoomDatabase
import com.github.sergeevvs.recipes.data.repositories.RecipeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class RecipeApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { RecipeRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { RecipeRepository(database.recipeDao()) }
}