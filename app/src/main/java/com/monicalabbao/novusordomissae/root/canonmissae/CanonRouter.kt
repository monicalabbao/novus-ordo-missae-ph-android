package com.monicalabbao.novusordomissae.root.canonmissae

import android.view.View

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link CanonBuilder.CanonScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class CanonRouter(
    view: CanonView,
    interactor: CanonInteractor,
    component: CanonBuilder.Component) : ViewRouter<CanonView, CanonInteractor, CanonBuilder.Component>(view, interactor, component)
