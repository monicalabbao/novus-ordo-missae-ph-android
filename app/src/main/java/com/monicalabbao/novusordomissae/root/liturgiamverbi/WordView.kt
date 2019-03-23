package com.monicalabbao.novusordomissae.root.liturgiamverbi

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Top level view for {@link WordBuilder.WordScope}.
 */
class WordView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : View(context, attrs, defStyle), WordInteractor.WordPresenter
