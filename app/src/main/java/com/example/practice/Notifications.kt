package com.example.practice


import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.snackbar.Snackbar


class Notifications(context: Context) : Fragment() {

    private  var mConext: Context = context
    private lateinit  var mActivity: FragmentActivity


    companion object {
        private val CHANNEL_ID = "channel_ID"
        private val NOTIFICATION_ID = 101
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val notification: Button? = view?.findViewById(R.id.btnNotification)
        val toast: Button? = view?.findViewById(R.id.btnToast)
        val snackbar: Button? = view?.findViewById(R.id.btnSnackbar)
        val dialog: Button? = view?.findViewById(R.id.btnDialog)

        notification?.setOnClickListener {

            //Создаёмм канал для уведомления
            // TODO: узнать для чего нужны каналы и как они работают вместе с notification
            val channel = NotificationChannel(
                CHANNEL_ID, "My channel",
                NotificationManager.IMPORTANCE_HIGH
            )

            channel.setDescription("My channel description")
            channel.enableLights(true)
            channel.setLightColor(Color.RED)
            channel.enableVibration(false)
            val notificationManager:  NotificationManagerCompat =  NotificationManagerCompat.from(mConext.applicationContext)
            notificationManager.createNotificationChannel(channel)

            val builder: NotificationCompat.Builder = NotificationCompat.Builder(mConext.applicationContext, CHANNEL_ID)
                .setSmallIcon(R.drawable.bilbo)
                .setContentTitle("Notification")
                .setContentText("Овсянка, сэр!")
                .setPriority(NotificationCompat.PRIORITY_MAX)

            // Создаём уведомление
//            val builder = NotificationCompat.Builder(mConext.applicationContext, CHANNEL_ID)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("Notification")
//                .setContentText("Овсянка, сэр!")
//                .setPriority(NotificationCompat.PRIORITY_MAX)

            with(NotificationManagerCompat.from(mConext.applicationContext)) {
                notify(NOTIFICATION_ID, builder.build()) // посылаем уведомление
            }
        }
        toast?.setOnClickListener {
            val text = "Это Toast уведомление"
            val duration = Toast.LENGTH_SHORT

            Toast.makeText(context, text, duration).show()
        }
        snackbar?.setOnClickListener {
            Snackbar.make(requireView(), "Hello Android", Snackbar.LENGTH_LONG)
                .setTextColor(Color.WHITE)
                .setBackgroundTint(resources.getColor(R.color.brown))
                .show()

        }
        dialog?.setOnClickListener {
            val dialog: NofDialog = NofDialog()
            val manager: FragmentManager = mActivity.supportFragmentManager

            val transaction: FragmentTransaction= manager.beginTransaction()
            dialog.show(transaction,"dialog")
        }


    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mActivity = activity as FragmentActivity
    }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {



            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_notifications, container, false)
        }



}