package com.example.practice

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class Notifications : Fragment() {

    private val CHANNEL_ID = "channel_ID"
    private val NOTIFICATION_ID = 101

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val notification: Button? = view?.findViewById(R.id.btnNotification)
        val toast: Button? = view?.findViewById(R.id.btnToast)
        val snackbar: Button? = view?.findViewById(R.id.btnSnackbar)
        val dialog: Button? = view?.findViewById(R.id.btnDialog)

        notification?.setOnClickListener {
            // Создаём уведомление
            val builder = NotificationCompat.Builder(requireActivity(), CHANNEL_ID)
                .setSmallIcon(R.drawable.bilbo)
                .setContentTitle("Notification")
                .setContentText("Овсянка, сэр!")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            with(NotificationManagerCompat.from(requireActivity())) {
                notify(NOTIFICATION_ID, builder.build()) // посылаем уведомление
            }
        }
        toast?.setOnClickListener {

        }
        snackbar?.setOnClickListener {

        }
        dialog?.setOnClickListener {

        }


    }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {



            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_notifications, container, false)
        }



}