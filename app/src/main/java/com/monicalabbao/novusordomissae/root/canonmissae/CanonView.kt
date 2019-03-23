package com.monicalabbao.novusordomissae.root.canonmissae

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Top level view for {@link CanonBuilder.CanonScope}.
 */
class CanonView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : View(context, attrs, defStyle), CanonInteractor.CanonPresenter
