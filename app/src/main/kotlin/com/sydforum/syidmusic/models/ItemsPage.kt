/**
 * SyidMusic Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.sydforum.syidmusic.models

import com.syidmusic.innertube.models.YTItem

data class ItemsPage(
    val items: List<YTItem>,
    val continuation: String?,
)
