package com.example.events.ui.details

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.events.R
import com.example.events.api.EventResponse
import com.example.events.api.EventsRepository
import com.example.events.databinding.EventDetailFragmentBinding
import com.example.events.models.CheckinModel
import com.example.events.models.EventModel

class DetailsFragment : Fragment(), EventResponse {

    private lateinit var mainContainer: ViewGroup

    companion object {
        private const val EVENT = "event"

        fun newInstance(eventModel: EventModel): DetailsFragment {
            val args = Bundle()
            args.putSerializable(EVENT, eventModel)
            val fragment = DetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mainContainer = container!!
        val eventDetailFragmentBinding = EventDetailFragmentBinding.inflate(inflater, container, false)

        eventDetailFragmentBinding.eventModel = arguments!!.getSerializable(EVENT) as EventModel
        eventDetailFragmentBinding.fragment = this
        return eventDetailFragmentBinding.root
    }

    fun openCheckinDialog() {
        val createdView = layoutInflater?.inflate(R.layout.checkin_dialog, mainContainer, false)
        AlertDialog.Builder(context!!)
            .setTitle(getString(R.string.dialog_title))
            .setView(createdView)
            .setPositiveButton(getText(R.string.dialog_confirm)
            ) { dialog, which ->
                val eventModel = arguments!!.getSerializable(EVENT) as EventModel
                val edtName = createdView?.findViewById<EditText>(R.id.edtName)
                val edtEmail = createdView?.findViewById<EditText>(R.id.edtEmail)
                EventsRepository().doCheckIn(
                    CheckinModel(
                        eventModel.id,
                        edtName?.text.toString(),
                        edtEmail?.text.toString()
                    ), this@DetailsFragment
                )
                dialog?.cancel()
            }
            .setNegativeButton(getString(R.string.dialog_cancel)
            ) { dialog, which -> dialog?.cancel() }
            .show()
    }

    override fun success(events: ArrayList<EventModel>) {
        //
    }

    override fun successPost() {
        Toast.makeText(context, getString(R.string.checkin_success), Toast.LENGTH_LONG).show()
    }

    override fun fail() {
        Toast.makeText(context, getString(R.string.checkin_error), Toast.LENGTH_LONG).show()
    }
}