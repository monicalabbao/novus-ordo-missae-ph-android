package com.monicalabbao.novusordomissae.root.concluding

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ConcludingRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: ConcludingBuilder.Component
  @Mock internal lateinit var interactor: ConcludingInteractor
  @Mock internal lateinit var view: ConcludingView

  private var router: ConcludingRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = ConcludingRouter(view, interactor, component)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use RouterHelper to drive your router's lifecycle.
    RouterHelper.attach(router!!)
    RouterHelper.detach(router!!)

    throw RuntimeException("Remove this test and add real tests.")
  }

}

