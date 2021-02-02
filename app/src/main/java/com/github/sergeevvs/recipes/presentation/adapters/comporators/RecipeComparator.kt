package com.github.sergeevvs.recipes.presentation.adapters.comporators

import androidx.recyclerview.widget.DiffUtil
import com.github.sergeevvs.recipes.presentation.models.Recipe

class RecipeComparator : DiffUtil.ItemCallback<Recipe>() {

    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.title == newItem.title && oldItem.description == newItem.description
    }
}