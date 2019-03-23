package com.monicalabbao.novusordomissae.root.liturgiamverbi

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
 * Builder for the {@link WordScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class WordBuilder(dependency: ParentComponent) : ViewBuilder<WordView, WordRouter, WordBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [WordRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [WordRouter].
   */
  fun build(parentViewGroup: ViewGroup): WordRouter {
    val view = createView(parentViewGroup)
    val interactor = WordInteractor()
    val component = DaggerWordBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.wordRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): WordView? {
    // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
    // provided context from the parentViewGroup.
    return null
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @WordScope
    @Binds
    internal abstract fun presenter(view: WordView): WordInteractor.WordPresenter

    @dagger.Module
    companion object {

      @WordScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: WordView,
          interactor: WordInteractor): WordRouter {
        return WordRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @WordScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<WordInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: WordInteractor): Builder

      @BindsInstance
      fun view(view: WordView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun wordRouter(): WordRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class WordScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class WordInternal
}
