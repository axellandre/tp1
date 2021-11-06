package com.gmail.landre.neighbors.data

import com.gmail.landre.neighbors.data.service.DummyNeighborApiService
import com.gmail.landre.neighbors.data.service.NeighborApiService
import com.gmail.landre.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours
    fun deleteNeighbour(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)
    fun insertNeighbour(neighbor: Neighbor) = apiService.createNeighbour(neighbor)
    fun getInstance(): NeighborRepository {
        if (instance == null) {
            instance = NeighborRepository()
        }
        return instance !!
    }

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance !!
        }
    }
}
