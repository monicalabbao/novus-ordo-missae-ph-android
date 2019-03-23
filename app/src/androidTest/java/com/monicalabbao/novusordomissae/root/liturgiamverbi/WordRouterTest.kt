package com.monicalabbao.novusordomissae.root.liturgiamverbi

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class WordRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: WordBuilder.Component
  @Mock internal lateinit var interactor: WordInteractor
  @Mock internal lateinit var view: WordView

  private var router: WordRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = WordRouter(view, interactor, component)
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

