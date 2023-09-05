package com.application.app.modules.registr.ui

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.isVisible
import com.application.app.R
import com.application.app.appcomponents.base.BaseActivity
import com.application.app.databinding.ActivityRegistrBinding
import com.application.app.modules.code.ui.CodeActivity
import com.application.app.modules.nb.ui.NbActivity
import com.application.app.modules.registr.`data`.viewmodel.RegistrVM
import kotlin.String
import kotlin.Unit

class RegistrActivity : BaseActivity<ActivityRegistrBinding>(R.layout.activity_registr) {

    private val viewModel: RegistrVM by viewModels<RegistrVM>()

    private lateinit var builder : NotificationCompat.Builder
    private lateinit var notificationManager: NotificationManagerCompat

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.registrVM = viewModel
    }

    override fun setUpClicks(): Unit {

        binding.imageSearch.setOnClickListener {
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buildNotificationChannel()
        setupButtons()
    }

    private fun setupButtons()
    {
        binding.btnCheckPhoneNumber.setOnClickListener {
            val answer = viewModel.checkPhoneNumber(binding.etField.text.toString())
            if(answer) {
                if(binding.errorMessage.isVisible)
                    binding.errorMessage.isVisible = false
                val userLoginResponseInfo = viewModel.getAnswerFromApi()
                if(userLoginResponseInfo.isUserInBD) {
                    setupNotificationMessage(
                        title = "Verification code",
                        message = "Your verification code: ${userLoginResponseInfo.verificationCode}",
                        context = this)
                    sendNotification(builder = builder, context = this)

                    val intent = Intent(this, NbActivity::class.java)
                    startActivity(intent)
                }
                else
                    showErrorMessage()
            }
            else {
                showErrorMessage()
            }
        }
    }

    private fun buildNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "loginChannel"
            val channelName = "Login Channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance)

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun setupNotificationMessage(title: String, message: String, context: Context) {
        builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    }

    private fun showErrorMessage() {
        binding.etField.setText("")
        binding.errorMessage.isVisible = true
    }

    @SuppressLint("MissingPermission")
    private fun sendNotification(builder : NotificationCompat.Builder, context: Context) {
        notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    companion object {
        const val TAG: String = "REGISTR_ACTIVITY"

        const val NOTIFICATION_ID = 101
        const val CHANNEL_ID = "loginChannel"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, RegistrActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}
