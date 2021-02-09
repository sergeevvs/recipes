package com.github.sergeevvs.recipes.presentation.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.sergeevvs.recipes.databinding.RecipeBinding

class RecipeViewHolder(val binding: RecipeBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {

        fun create(parent: ViewGroup) =
            RecipeViewHolder(RecipeBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                    false))
    }
}