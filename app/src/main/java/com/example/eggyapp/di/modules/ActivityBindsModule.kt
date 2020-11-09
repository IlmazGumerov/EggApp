package com.example.eggyapp.di.modules

import com.example.eggyapp.di.skope.PerActivity
import com.example.eggyapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindsModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentBindsModule::class])
    fun contributeMainActivityInjector(): MainActivity
}
