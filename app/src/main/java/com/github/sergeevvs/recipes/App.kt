package com.github.sergeevvs.recipes

import android.app.Application
import com.github.sergeevvs.recipes.data.database.RecipeRoomDatabase
import com.github.sergeevvs.recipes.data.repositories.RecipeRepository
import com.github.sergeevvs.recipes.presentation.viewmodels.factories.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class App : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { RecipeRoomDatabase.getDatabase(this, applicationScope) }
    private val repository by lazy { RecipeRepository(database.recipeDao()) }
    val viewModelFactory by lazy { ViewModelFactory(repository) }
}