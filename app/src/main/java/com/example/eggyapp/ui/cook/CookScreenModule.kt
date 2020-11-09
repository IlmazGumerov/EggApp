package com.example.eggyapp.ui.cook

import androidx.lifecycle.ViewModel
import com.example.eggyapp.data.SetupType
import com.example.eggyapp.di.ViewModelKey
import com.example.eggyapp.di.skope.PerFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [CookScreenModule.BindsModule::class])
class CookScreenModule {

    @Provides
    @PerFragment
    fun provideCookData(
        cookFragment: CookFragment
    ) = cookFragment.provideCookData()

    data class CookData(
        val calculatedTime: Int,
        val selectedType: SetupType
    )

    @Module
    interface BindsModule{
        @Binds
        @IntoMap
        @ViewModelKey(CookViewModel::class)
        fun cookViewModel(viewModel: CookViewModel): ViewModel
    }
}