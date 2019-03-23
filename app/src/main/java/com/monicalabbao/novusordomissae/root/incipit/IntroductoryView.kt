package com.monicalabbao.novusordomissae.root.incipit

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Top level view for {@link IntroductoryBuilder.IntroductoryScope}.
 */
class IntroductoryView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : View(context, attrs, defStyle), IntroductoryInteractor.IntroductoryPresenter
