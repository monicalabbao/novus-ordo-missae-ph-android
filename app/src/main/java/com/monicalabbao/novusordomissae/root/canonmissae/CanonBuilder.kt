package com.monicalabbao.novusordomissae.root.canonmissae

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
 * Builder for the {@link CanonScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class CanonBuilder(dependency: ParentComponent) : ViewBuilder<CanonView, CanonRouter, CanonBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [CanonRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [CanonRouter].
   */
  fun build(parentViewGroup: ViewGroup): CanonRouter {
    val view = createView(parentViewGroup)
    val interactor = CanonInteractor()
    val component = DaggerCanonBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.canonRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): CanonView? {
    // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
    // provided context from the parentViewGroup.
    return null
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @CanonScope
    @Binds
    internal abstract fun presenter(view: CanonView): CanonInteractor.CanonPresenter

    @dagger.Module
    companion object {

      @CanonScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: CanonView,
          interactor: CanonInteractor): CanonRouter {
        return CanonRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @CanonScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<CanonInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: CanonInteractor): Builder

      @BindsInstance
      fun view(view: CanonView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun canonRouter(): CanonRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class CanonScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class CanonInternal
}
