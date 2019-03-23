package com.monicalabbao.novusordomissae.root.concluding

import android.view.View

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link ConcludingBuilder.ConcludingScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class ConcludingRouter(
    view: ConcludingView,
    interactor: ConcludingInteractor,
    component: ConcludingBuilder.Component) : ViewRouter<ConcludingView, ConcludingInteractor, ConcludingBuilder.Component>(view, interactor, component)
