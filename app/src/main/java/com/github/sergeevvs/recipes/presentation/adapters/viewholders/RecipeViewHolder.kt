package com.github.sergeevvs.recipes.presentation.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.sergeevvs.recipes.databinding.RecipeBinding
import com.github.sergeevvs.recipes.presentation.models.Recipe

class RecipeViewHolder(val binding: RecipeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(recipe: Recipe) {
        binding.itemTitle.text = recipe.title
        binding.itemDescription.text = recipe.description
    }

    companion object {

        fun create(parent: ViewGroup) =
            RecipeViewHolder(RecipeBinding.inflate(LayoutInflater.from(parent.context)))
    }
}