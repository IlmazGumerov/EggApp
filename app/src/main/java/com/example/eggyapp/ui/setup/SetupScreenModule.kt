package com.example.eggyapp.ui.setup

import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.eggyapp.di.ViewModelKey
import com.example.eggyapp.di.skope.PerFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [SetupScreenModule.BindsModule::class])
class SetupScreenModule {

    @Provides
    @PerFragment
    fun provideNavController( //Need delegate
        setupFragment: SetupFragment
    ) = setupFragment.findNavController()

    @Module
    interface BindsModule {
        @Binds
        @IntoMap
        @ViewModelKey(SetupViewModel::class)
        fun setupViewModel(viewModel: SetupViewModel): ViewModel
    }
}
