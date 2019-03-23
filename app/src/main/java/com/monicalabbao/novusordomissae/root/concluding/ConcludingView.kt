package com.monicalabbao.novusordomissae.root.concluding

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Top level view for {@link ConcludingBuilder.ConcludingScope}.
 */
class ConcludingView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : View(context, attrs, defStyle), ConcludingInteractor.ConcludingPresenter
