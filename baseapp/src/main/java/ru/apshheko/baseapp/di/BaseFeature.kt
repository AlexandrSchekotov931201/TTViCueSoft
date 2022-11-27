package ru.apshheko.baseapp.di

import javax.inject.Provider

/**
 * Абстракция является базовым представлением функциональной единицы проекта
 * Фичи должны разделяться по разным гредл модулям, и у каждого гредл модуля должна быть реализация абстрактного класса BaseFeature
 * Этот класс декларирует о том какие зависимости используются в данной фиче/модуле и какое api фича может предоставлять во внешние модули
 */
abstract class BaseFeature<A : BaseFeatureApi, D : BaseDependencies>(protected val dependencies: Provider<D>) {
    abstract fun getApi(): A
}