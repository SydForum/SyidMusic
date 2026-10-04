package com.syidmusic.innertube.pages

import com.syidmusic.innertube.models.YTItem

data class LibraryContinuationPage(
    val items: List<YTItem>,
    val continuation: String?,
)
