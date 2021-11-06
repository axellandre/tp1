package com.gmail.landre.neighbors.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.landre.neighbors.NavigationListener
import com.gmail.landre.neighbors.R
import com.gmail.landre.neighbors.adapters.ListNeighborHandler
import com.gmail.landre.neighbors.adapters.ListNeighborsAdapter
import com.gmail.landre.neighbors.data.NeighborRepository
import com.gmail.landre.neighbors.models.Neighbor
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListNeighborsFragment : Fragment(), ListNeighborHandler {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNeighbor: FloatingActionButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        (activity as? NavigationListener)
        (activity as? NavigationListener)?.updateTitle(R.string.list_neighbours_toolbar_name)

        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        addNeighbor = view.findViewById(R.id.addNeighbor)
        addNeighbor.setOnClickListener {
            (activity as? NavigationListener)?.showFragment(AddNeighbourFragment())
        }
        return view
    }

    override fun onDeleteNeighbor(neighbor: Neighbor) {

        activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.Confirmation_Message)
                .setPositiveButton(
                    R.string.oui
                ) { _, _ ->
                    NeighborRepository.getInstance().deleteNeighbour(neighbor)
                    refresh()
                }
                .setNegativeButton(
                    R.string.non
                ) { _, _ ->
                    // User cancelled the dialog
                }

            builder.create().show()
        }
    }

    override fun refresh() {
        val neighbor = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbor, this)
        recyclerView.adapter = adapter
    }
}
