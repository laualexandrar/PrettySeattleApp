package com.lroap.prettyseattle.view.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.lroap.prettyseattle.R
import com.lroap.prettyseattle.model.Event
import com.lroap.prettyseattle.view.adapter.EventAdapter
import com.lroap.prettyseattle.view.adapter.EventListener
import com.lroap.prettyseattle.viewmodel.EventViewModel
import kotlinx.android.synthetic.main.fragment_future_events.*


/**
 * A simple [Fragment] subclass.
 */
class FutureEventsFragment : Fragment(), EventListener {


    private lateinit var eventAdapter: EventAdapter
    lateinit var viewModel: EventViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_future_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(EventViewModel::class.java)
        viewModel.refresh()

        eventAdapter = EventAdapter(this)

        rvfutureEvents.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = eventAdapter
        }
        observeViewModel()

    }

    fun observeViewModel(){
        viewModel.listEvent.observe(this, Observer<List<Event>> { event ->
            eventAdapter.updateData(event)

        })

        viewModel.isLoading.observe(this, Observer<Boolean>{
            if(it != null)
                rlBaseEvent.visibility = View.INVISIBLE
        })
    }
    override fun onEventClicked(event: Event, position: Int) {
        val bundle = bundleOf("event" to event)
        findNavController().navigate(R.id.futureEventsDetailFragmentDialog,bundle)
    }
}
