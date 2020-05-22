package com.lroap.prettyseattle.view.ui.fragments


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment

import com.lroap.prettyseattle.R
import com.lroap.prettyseattle.model.Event
import kotlinx.android.synthetic.main.fragment_future_events_detail_dialog.*
import java.text.SimpleDateFormat

/**
 * A simple [Fragment] subclass.
 */
class FutureEventsDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_future_events_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarFurureEvents.navigationIcon =
            ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarFurureEvents.setTitleTextColor(Color.WHITE)
        toolbarFurureEvents.setNavigationOnClickListener {
            dismiss()
        }
        val event = arguments?.getSerializable("event") as Event

        toolbarFurureEvents.title = event.activityname

        tvNameEvent.text = event.activityname
        val pattern = "dd/MM/yyyy hh:mm a"
        val simpleDF = SimpleDateFormat(pattern)
        val date = simpleDF.format(event.datetime)
        tvFutureEventsHour.text = date
        tvFutureEventsPlaceName.text = event.placename
        tvFutureEventsTag.text = event.tag
        tvFutureEventsDescription.text = event.description

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }


}
