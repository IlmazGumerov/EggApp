package com.example.eggyapp.di

import android.app.Application
import com.example.eggyapp.EggApp
import com.example.eggyapp.di.modules.ActivityBindsModule
import com.example.eggyapp.di.modules.SetupModule
import com.example.eggyapp.di.modules.ViewModelFactoryModule
import com.example.eggyapp.di.skope.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelFactoryModule::class,
        ActivityBindsModule::class,
        SetupModule::class
    ]
)
interface AppComponent {
    fun inject(eggApp: EggApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}