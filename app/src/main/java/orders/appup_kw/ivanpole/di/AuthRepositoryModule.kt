package orders.appup_kw.ivanpole.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import orders.appup_kw.ivanpole.network_servise.Api
import orders.appup_kw.ivanpole.repository.AuthRepository
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AuthRepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(
            network: Api
    ): AuthRepository {
        return AuthRepository(network)
    }

}