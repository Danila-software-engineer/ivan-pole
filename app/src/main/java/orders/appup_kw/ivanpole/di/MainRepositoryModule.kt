package orders.appup_kw.ivanpole.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import orders.appup_kw.ivanpole.cache_bd.dao.BasketDao
import orders.appup_kw.ivanpole.network_servise.Api
import orders.appup_kw.ivanpole.repository.MainRepository
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object MainRepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        basketDao: BasketDao,
        network: Api
    ): MainRepository {
        return MainRepository(basketDao,network)
    }
}