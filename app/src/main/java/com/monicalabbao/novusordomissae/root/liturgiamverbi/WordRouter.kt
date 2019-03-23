package com.monicalabbao.novusordomissae.root.liturgiamverbi

import android.view.View

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link WordBuilder.WordScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class WordRouter(
    view: WordView,
    interactor: WordInteractor,
    component: WordBuilder.Component) : ViewRouter<WordView, WordInteractor, WordBuilder.Component>(view, interactor, component)
