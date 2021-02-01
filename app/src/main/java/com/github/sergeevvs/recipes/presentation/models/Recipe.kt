package com.github.sergeevvs.recipes.presentation.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_table")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val description: String,
)