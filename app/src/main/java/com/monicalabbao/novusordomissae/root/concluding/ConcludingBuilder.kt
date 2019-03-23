package com.monicalabbao.novusordomissae.root.concluding

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
 * Builder for the {@link ConcludingScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class ConcludingBuilder(dependency: ParentComponent) : ViewBuilder<ConcludingView, ConcludingRouter, ConcludingBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [ConcludingRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [ConcludingRouter].
   */
  fun build(parentViewGroup: ViewGroup): ConcludingRouter {
    val view = createView(parentViewGroup)
    val interactor = ConcludingInteractor()
    val component = DaggerConcludingBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.concludingRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): ConcludingView? {
    // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
    // provided context from the parentViewGroup.
    return null
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @ConcludingScope
    @Binds
    internal abstract fun presenter(view: ConcludingView): ConcludingInteractor.ConcludingPresenter

    @dagger.Module
    companion object {

      @ConcludingScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: ConcludingView,
          interactor: ConcludingInteractor): ConcludingRouter {
        return ConcludingRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @ConcludingScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<ConcludingInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: ConcludingInteractor): Builder

      @BindsInstance
      fun view(view: ConcludingView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun concludingRouter(): ConcludingRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class ConcludingScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class ConcludingInternal
}
