package orders.appup_kw.ivanpole.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import orders.appup_kw.ivanpole.cache_bd.BasketDatabase
import orders.appup_kw.ivanpole.cache_bd.dao.BasketDao
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): BasketDatabase {
        return Room
            .databaseBuilder(
                context,
                BasketDatabase::class.java,
                BasketDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBlogDAO(blogDatabase: BasketDatabase): BasketDao {
        return blogDatabase.basketDao()
    }
}