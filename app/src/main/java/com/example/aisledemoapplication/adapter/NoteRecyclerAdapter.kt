package com.example.aisledemoapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aisledemoapplication.R
import com.example.aisledemoapplication.databinding.ItemRecyclerviewBinding
import com.example.aisledemoapplication.model.ProfilesItem

class NoteRecyclerAdapter(private val context: Context) :
    RecyclerView.Adapter<NoteRecyclerAdapter.DataViewHolder>() {

    private var notesList = emptyList<ProfilesItem>()

    class DataViewHolder(private val itemBinding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(notesList: ProfilesItem, context: Context) {
            itemBinding.txtName.text = notesList.firstName
            Glide.with(context)
                .load(notesList.avatar)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(itemBinding.ivMainImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemBinding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = notesList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(notesList[position], context)

    fun addData(profiles: List<ProfilesItem>) {
        this.notesList = profiles
    }

}