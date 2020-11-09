package com.example.eggyapp.di.modules

import com.example.eggyapp.data.SetupEggRepository
import com.example.eggyapp.data.SetupEggRepositoryImpl
import com.example.eggyapp.di.skope.PerApplication
import dagger.Module
import dagger.Provides

@Module
class SetupModule {
    @PerApplication
    @Provides
    fun provideSetupRepository(): SetupEggRepository = SetupEggRepositoryImpl()
}