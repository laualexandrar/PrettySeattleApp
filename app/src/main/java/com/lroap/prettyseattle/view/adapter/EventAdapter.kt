package com.lroap.prettyseattle.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lroap.prettyseattle.R
import com.lroap.prettyseattle.model.Event
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EventAdapter(val eventListener:EventListener) : RecyclerView.Adapter<EventAdapter.ViewHolder>(){

    var listEvent = ArrayList<Event>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_future_events, parent, false))

    override fun getItemCount() = listEvent.size

    override fun onBindViewHolder(holder: EventAdapter.ViewHolder, position: Int) {
        val futureEvent = listEvent[position] as Event

        holder.tvFutureEventsName.text =  futureEvent.activityname
        holder.tvFutureEventsNeightborhood.text = futureEvent.placename
        holder.tvFutureEventsTag.text = futureEvent.tag

        val simpleDateFormat = SimpleDateFormat("HH:mm")
        val simpleDateFormatAMPM = SimpleDateFormat("a")

        val cal = Calendar.getInstance()
        cal.time = futureEvent.datetime
        val hourFormat = simpleDateFormat.format(futureEvent.datetime)

        holder.tvFutureEventsHour.text = hourFormat
        holder.tvFutureEventsAMPM.text = simpleDateFormatAMPM.format(futureEvent.datetime).toUpperCase()

        holder.itemView.setOnClickListener {
            eventListener.onEventClicked(futureEvent,position)
        }

    }

    fun updateData(data: List<Event>){
        listEvent.clear()
        listEvent.addAll(data)
        notifyDataSetChanged()

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val  tvFutureEventsName = itemView.findViewById<TextView>(R.id.tvItemFutureEventsName)
        val  tvFutureEventsNeightborhood = itemView.findViewById<TextView>(R.id.tvItemFutureEventsNeightborhood)
        val  tvFutureEventsTag = itemView.findViewById<TextView>(R.id.tvItemFutureEventsTag)
        val  tvFutureEventsHour = itemView.findViewById<TextView>(R.id.tvItemFutureEventsHour)
        val  tvFutureEventsAMPM = itemView.findViewById<TextView>(R.id.tvItemFutureEventsAMPM)
    }

}
