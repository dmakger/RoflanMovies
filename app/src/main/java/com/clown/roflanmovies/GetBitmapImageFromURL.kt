package com.clown.roflanmovies

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.lang.Exception
import java.net.URL

class GetBitmapImageFromURL : AsyncTask<String, Void, Bitmap?>() {
    override fun doInBackground(vararg urls: String?): Bitmap? {
        var bitmap: Bitmap? = null
        val url = URL(urls[0])
        val inputStream = url.openStream()
        bitmap = BitmapFactory.decodeStream(inputStream)
        return bitmap
    }
}