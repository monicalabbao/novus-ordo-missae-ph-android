package com.monicalabbao.novusordomissae.root.concluding

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.InteractorHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ConcludingInteractorTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var presenter: ConcludingInteractor.ConcludingPresenter
  @Mock internal lateinit var router: ConcludingRouter

  private var interactor: ConcludingInteractor? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    interactor = TestConcludingInteractor.create(presenter)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use InteractorHelper to drive your interactor's lifecycle.
    InteractorHelper.attach<ConcludingInteractor.ConcludingPresenter, ConcludingRouter>(interactor!!, presenter, router, null)
    InteractorHelper.detach(interactor!!)

    throw RuntimeException("Remove this test and add real tests.")
  }
}