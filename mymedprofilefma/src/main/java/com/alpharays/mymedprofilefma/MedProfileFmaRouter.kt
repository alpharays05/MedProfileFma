package com.alpharays.mymedprofilefma

import android.content.Context
import android.content.Intent
import com.alpharays.mymedprofilefma.dummywork.DummyActivity

object MedProfileFmaRouter {
    lateinit var context: Context

    fun startDummyActivity(context: Context) {
        // Start the DummyActivity
        val intent = Intent(context, DummyActivity::class.java)
        context.startActivity(intent)
    }


    fun initiateMedCommRouter(context: Context) {
        this.context = context
    }
}