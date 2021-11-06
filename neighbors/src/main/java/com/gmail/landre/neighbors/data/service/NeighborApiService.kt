package com.gmail.landre.neighbors.data.service

import com.gmail.landre.neighbors.models.Neighbor

interface NeighborApiService {
    /**
     * Get all my Neighbors
     * @return [List]
     */
    val neighbours: List<Neighbor>

    /**
     * Deletes a neighbor
     * @param neighbor : Neighbor
     */
    fun deleteNeighbour(neighbor: Neighbor)

    /**
     * Create a neighbour
     * @param neighbor: Neighbor
     */
    fun createNeighbour(neighbor: Neighbor)

    /**
     * Update "Favorite status" of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateFavoriteStatus(neighbor: Neighbor)

    /**
     * Update modified fields of an existing Neighbour"
     * @param neighbor: Neighbor
     */
    fun updateDataNeighbour(neighbor: Neighbor)
}
