/**
 * SyidMusic Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.sydforum.syidmusic.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.syidmusic.innertube.utils.parseCookieString
import com.sydforum.syidmusic.constants.InnerTubeCookieKey
import com.sydforum.syidmusic.constants.YtmSyncKey
import com.sydforum.syidmusic.utils.dataStore
import com.sydforum.syidmusic.utils.get
import kotlinx.coroutines.runBlocking

fun Context.isSyncEnabled(): Boolean {
    return runBlocking {
        dataStore.get(YtmSyncKey, true) && isUserLoggedIn()
    }
}

fun Context.isUserLoggedIn(): Boolean {
    return runBlocking {
        val cookie = dataStore[InnerTubeCookieKey] ?: ""
        "SAPISID" in parseCookieString(cookie) && isInternetConnected()
    }
}

fun Context.isInternetConnected(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
}
