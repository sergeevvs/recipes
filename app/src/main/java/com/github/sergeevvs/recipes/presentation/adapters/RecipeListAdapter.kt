package com.github.sergeevvs.recipes.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.github.sergeevvs.recipes.presentation.adapters.comporators.RecipeComparator
import com.github.sergeevvs.recipes.presentation.adapters.viewholders.RecipeViewHolder
import com.github.sergeevvs.recipes.presentation.models.Recipe

class RecipeListAdapter : ListAdapter<Recipe, RecipeViewHolder>(RecipeComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder =
        RecipeViewHolder.create(parent)

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}