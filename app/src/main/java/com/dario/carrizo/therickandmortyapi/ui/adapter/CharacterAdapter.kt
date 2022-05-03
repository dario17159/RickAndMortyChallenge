package com.dario.carrizo.therickandmortyapi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dario.carrizo.therickandmortyapi.core.BaseViewHolder
import com.dario.carrizo.therickandmortyapi.databinding.CharacterItemBinding
import com.dario.carrizo.therickandmortyapi.domain.model.Character

/**
 * @author Dario Carrizo on 02/05/2022
 **/
class CharacterAdapter(private var characterList: List<Character>): RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is CharacterViewHolder -> {
                holder.bind(characterList[position])
            }
        }
    }

    fun setNewData(characterList: List<Character>){
        this.characterList = characterList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = characterList.size

    private inner class CharacterViewHolder(val binding: CharacterItemBinding, val context: Context): BaseViewHolder<Character>(binding.root){
        override fun bind(item: Character) {
            binding.nameCharacter.text = item.name
            binding.statusCharacter.text = item.status
            binding.speciesCharacter.text = item.species
            binding.genderCharacter.text = item.gender
            binding.originCharacter.text = item.origin
            binding.locationCharacter.text = item.location

            Glide.with(context)
                .load(item.image)
                .into(binding.characterImaage)
        }

    }

}