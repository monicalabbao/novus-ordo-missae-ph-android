package com.monicalabbao.novusordomissae.root.incipit

import android.view.View

import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link IntroductoryBuilder.IntroductoryScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class IntroductoryRouter(
    view: IntroductoryView,
    interactor: IntroductoryInteractor,
    component: IntroductoryBuilder.Component) : ViewRouter<IntroductoryView, IntroductoryInteractor, IntroductoryBuilder.Component>(view, interactor, component)
