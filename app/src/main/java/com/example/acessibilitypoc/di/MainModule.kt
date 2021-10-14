package com.example.mycookingrecipe.di

import com.example.acessibilitypoc.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainViewModelModule = module {
    viewModel {
        MainViewModel()
    }
}
//val repositoryModule = module {
//    single<RepositoryContract> {
//        RecipesRepository(get())
//    }
//}