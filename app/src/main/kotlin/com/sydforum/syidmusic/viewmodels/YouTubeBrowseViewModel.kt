/**
 * SyidMusic Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.sydforum.syidmusic.viewmodels

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syidmusic.innertube.YouTube
import com.syidmusic.innertube.models.filterYoutubeShorts
import com.syidmusic.innertube.pages.BrowseResult
import com.sydforum.syidmusic.constants.HideExplicitKey
import com.sydforum.syidmusic.constants.HideVideoSongsKey
import com.sydforum.syidmusic.constants.HideYoutubeShortsKey
import com.sydforum.syidmusic.utils.dataStore
import com.sydforum.syidmusic.utils.get
import com.sydforum.syidmusic.utils.reportException
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YouTubeBrowseViewModel
@Inject
constructor(
    @ApplicationContext val context: Context,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val browseId = savedStateHandle.get<String>("browseId")!!
    private val params = savedStateHandle.get<String>("params")

    val result = MutableStateFlow<BrowseResult?>(null)

    init {
        viewModelScope.launch {
            val hideExplicit = context.dataStore.get(HideExplicitKey, false)
            val hideVideoSongs = context.dataStore.get(HideVideoSongsKey, false)
            val hideYoutubeShorts = context.dataStore.get(HideYoutubeShortsKey, false)
            YouTube
                .browse(browseId, params)
                .onSuccess {
                    result.value = it
                        .filterExplicit(hideExplicit)
                        .filterVideoSongs(hideVideoSongs)
                        .filterYoutubeShorts(hideYoutubeShorts)
                }.onFailure {
                    reportException(it)
                }
        }
    }
}
