package uz.tuit.disample.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.tuit.disample.impl.CryptoCurrencyRepositoryImpl
import uz.tuit.disample.repository.CryptoCurrencyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideCryptoCurrencyRepository():CryptoCurrencyRepository = CryptoCurrencyRepositoryImpl()


}