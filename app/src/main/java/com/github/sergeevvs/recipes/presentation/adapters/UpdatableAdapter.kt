package com.github.sergeevvs.recipes.presentation.adapters

import androidx.recyclerview.widget.RecyclerView

abstract class UpdatableAdapter<ItemType, ViewHolderType : RecyclerView.ViewHolder>(initialItems: List<ItemType>) :
    RecyclerView.Adapter<ViewHolderType>() {

    private val items: ArrayList<ItemType> = ArrayList(initialItems)

    protected fun getItemByIndex(position: Int) = items[position]

    @Synchronized
    fun setItems(items: List<ItemType>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun getItemCount() = items.size
}