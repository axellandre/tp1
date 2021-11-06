package com.gmail.landre.neighbors.adapters

import com.gmail.landre.neighbors.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeighbor(neighbor: Neighbor)
    fun refresh()
}
