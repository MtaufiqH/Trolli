package com.taufiq.core.di

import org.koin.core.module.Module

abstract class ModuleContainer {

    fun modules() : List<Module> {
        return this::class.java.declaredFields.map {
            it.isAccessible = true
            it.get(this) as Module
        }

    }
}