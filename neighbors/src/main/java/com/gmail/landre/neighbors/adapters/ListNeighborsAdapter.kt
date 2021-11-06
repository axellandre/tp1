package com.gmail.landre.neighbors.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gmail.landre.neighbors.R
import com.gmail.landre.neighbors.models.Neighbor

class ListNeighborsAdapter(
    items: List<Neighbor>,
    private val listNeighborHandler: ListNeighborHandler
) : RecyclerView.Adapter<ListNeighborsAdapter.ViewHolder>() {
    private val mNeighbours: List<Neighbor> = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.neighbor_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val neighbour: Neighbor = mNeighbours[position]
        holder.mNeighbourName.text = neighbour.name
        val context = holder.mNeighbourAvatar.context
        Glide.with(context)
            .load(neighbour.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_baseline_person_outline_24)
            .error(R.drawable.ic_baseline_person_outline_24)
            .skipMemoryCache(false)
            .into(holder.mNeighbourAvatar)

        holder.mDeleteButton.setOnClickListener {
            listNeighborHandler.onDeleteNeighbor(neighbour)
        }
    }

    override fun getItemCount(): Int {
        return mNeighbours.size
    }

    inner class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var mNeighbourAvatar: ImageView = view.findViewById(R.id.item_list_avatar)
        var mNeighbourName: TextView = view.findViewById(R.id.item_list_name)
        var mDeleteButton: ImageButton = view.findViewById(R.id.item_list_delete_button)

        init {
            // Enable click on item
            mNeighbourAvatar = view.findViewById(R.id.item_list_avatar)
            mNeighbourName = view.findViewById(R.id.item_list_name)
            mDeleteButton = view.findViewById(R.id.item_list_delete_button)
        }
    }
}
