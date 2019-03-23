package com.monicalabbao.novusordomissae.root.incipit

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Builder for the {@link IntroductoryScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class IntroductoryBuilder(dependency: ParentComponent) : ViewBuilder<IntroductoryView, IntroductoryRouter, IntroductoryBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [IntroductoryRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [IntroductoryRouter].
   */
  fun build(parentViewGroup: ViewGroup): IntroductoryRouter {
    val view = createView(parentViewGroup)
    val interactor = IntroductoryInteractor()
    val component = DaggerIntroductoryBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.introductoryRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): IntroductoryView? {
    // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
    // provided context from the parentViewGroup.
    return null
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @IntroductoryScope
    @Binds
    internal abstract fun presenter(view: IntroductoryView): IntroductoryInteractor.IntroductoryPresenter

    @dagger.Module
    companion object {

      @IntroductoryScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: IntroductoryView,
          interactor: IntroductoryInteractor): IntroductoryRouter {
        return IntroductoryRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @IntroductoryScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<IntroductoryInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: IntroductoryInteractor): Builder

      @BindsInstance
      fun view(view: IntroductoryView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun introductoryRouter(): IntroductoryRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class IntroductoryScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class IntroductoryInternal
}
