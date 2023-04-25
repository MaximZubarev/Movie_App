package com.mldz.module_injector


interface ComponentHolder<C: BaseApi, D: BaseDependencies> {

    fun init(dependencies: D)

    fun get(): C

    fun reset()
}


interface BaseApi


interface BaseDependencies
