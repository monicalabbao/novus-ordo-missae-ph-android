package com.monicalabbao.novusordomissae.root.incipit

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class IntroductoryInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: IntroductoryInteractor.IntroductoryPresenter
  @Mock internal lateinit var router: IntroductoryRouter

  private var interactor: IntroductoryInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestIntroductoryInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<IntroductoryInteractor.IntroductoryPresenter, IntroductoryRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}