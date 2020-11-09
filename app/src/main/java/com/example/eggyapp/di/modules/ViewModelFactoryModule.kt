package com.example.eggyapp.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.eggyapp.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}