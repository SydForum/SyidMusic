/**
 * SyidMusic Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.sydforum.syidmusic.di

import com.sydforum.syidmusic.lyrics.LyricsHelper
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface LyricsHelperEntryPoint {
    fun lyricsHelper(): LyricsHelper
}
