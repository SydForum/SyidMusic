/**
 * SyidMusic Project (C) 2026
 * Licensed under GPL-3.0 | See git history for contributors
 */

package com.sydforum.syidmusic.models

import com.syidmusic.innertube.models.YTItem
import com.sydforum.syidmusic.db.entities.LocalItem

data class SimilarRecommendation(
    val title: LocalItem,
    val items: List<YTItem>,
)
