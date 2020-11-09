package com.example.eggyapp.di.modules

import com.example.eggyapp.di.skope.PerFragment
import com.example.eggyapp.ui.cook.CookFragment
import com.example.eggyapp.ui.cook.CookScreenModule
import com.example.eggyapp.ui.setup.SetupFragment
import com.example.eggyapp.ui.setup.SetupScreenModule
import com.example.eggyapp.ui.welcome.WelcomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBindsModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [CookScreenModule::class])
    fun contributeCookFragment(): CookFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [SetupScreenModule::class])
    fun contributeSetupFragment(): SetupFragment

    @PerFragment
    @ContributesAndroidInjector
    fun contributeWelcomeFragment(): WelcomeFragment
}
