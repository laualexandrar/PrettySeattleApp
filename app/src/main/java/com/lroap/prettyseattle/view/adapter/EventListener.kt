package com.lroap.prettyseattle.view.adapter

import com.lroap.prettyseattle.model.Event


interface EventListener {
    fun onEventClicked(event: Event, position: Int)
}