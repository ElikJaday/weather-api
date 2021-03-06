package dev.elvir.weatherapi_example.utils

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import java.io.IOException
import java.util.*


internal class NetWorkInfoUtility {

    var isWifiEnable = false
    var isMobileNetworkAvailable = false

    fun isNetWorkAvailableNow(context: Context): Boolean {
        var isNetworkAvailable = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        isWifiEnable =
            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected
        isMobileNetworkAvailable =
            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected
        if (isWifiEnable || isMobileNetworkAvailable) {

            if (isOnline) isNetworkAvailable = true
        }
        return isNetworkAvailable
    }

    val isOnline: Boolean
        get() {
            val t: Long = Calendar.getInstance().getTimeInMillis()
            val runtime = Runtime.getRuntime()
            try {
                val ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8")
                val exitValue = ipProcess.waitFor()
                return exitValue == 0
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                val t2: Long = Calendar.getInstance().getTimeInMillis()
                Log.i("NetWork check Time", (t2 - t).toString() + "")
            }
            return false
        }
}