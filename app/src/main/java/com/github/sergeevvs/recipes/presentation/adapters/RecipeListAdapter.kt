package com.github.sergeevvs.recipes.presentation.adapters

import com.github.sergeevvs.recipes.presentation.adapters.viewholders.RecipeViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.sergeevvs.recipes.databinding.FragmentRecipeBinding
import com.github.sergeevvs.recipes.presentation.models.Recipe


class RecipeListAdapter(
    private val values: List<Recipe>
) : RecyclerView.Adapter<RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder =
        RecipeViewHolder(FragmentRecipeBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = values.size
}