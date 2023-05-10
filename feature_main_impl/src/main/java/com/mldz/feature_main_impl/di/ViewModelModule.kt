package com.mldz.feature_main_impl.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mldz.core_utils.di.general.PerFeature
import com.mldz.core_utils.viewmodel.ViewModelFactory
import com.mldz.core_utils.viewmodel.ViewModelKey
import com.mldz.feature_main_impl.domain.MovieRepository
import com.mldz.feature_main_impl.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

//    @PerFeature
//    @Provides
//    fun provideMainViewModel(movieRepository: MovieRepository): MainViewModel = MainViewModel(movieRepository)

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMyViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}