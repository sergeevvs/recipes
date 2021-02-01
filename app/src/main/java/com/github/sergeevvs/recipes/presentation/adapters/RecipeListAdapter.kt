package com.github.sergeevvs.recipes.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.sergeevvs.recipes.databinding.RecipeBinding
import com.github.sergeevvs.recipes.presentation.adapters.viewholders.RecipeViewHolder
import com.github.sergeevvs.recipes.presentation.models.Recipe

class RecipeListAdapter(
    private val items: List<Recipe>
) : UpdatableAdapter<Recipe, RecipeViewHolder>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder =
        RecipeViewHolder(RecipeBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = getItemByIndex(position)
        bindItem(holder, item)
    }

    private fun bindItem(holder: RecipeViewHolder, item: Recipe) {
        // todo add binding recipe item after refactoring recipe.xml
    }
}