package orders.appup_kw.ivanpole.di

import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import orders.appup_kw.ivanpole.network_servise.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton
import kotlin.collections.ArrayList


@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    private object MyCookieJar : CookieJar {



        var cookies: ArrayList<Cookie> = ArrayList()

        override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
            //if (url.encodedPath().endsWith("auth/")) {
            this.cookies.clear()
            this.cookies.addAll(cookies)// = cookies[0]
            for (cookie in cookies) {
                Log.e("TAGG", cookie.value())
            }
            //}
        }

        override fun loadForRequest(url: HttpUrl): List<Cookie> {

            if (!url.encodedPath().endsWith("auth/") && cookies != null) {
                return cookies
            }
            return Collections.emptyList()

            /*
            if (cookies!= null) {
                for (cookie in cookies!!) {
                    Log.e("TAGG", cookie.value())
                }
            }

            return cookies ?: ArrayList()*/
        }
    }



    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
        return OkHttpClient.Builder()
                .cookieJar(MyCookieJar)
                .addInterceptor(interceptor)
    }


    @Provides
    @Singleton
    fun provideApi(client: OkHttpClient.Builder): Api {
        return Retrofit.Builder()
                .baseUrl("http://kukoba1.av.fvds.ru/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
                .build()
                .create(Api::class.java)
    }



    //@Singleton
    //@Provides
    //fun provideBlogService(): Api =
    //    Retrofit.Builder()
    //        .baseUrl("http://kukoba1.av.fvds.ru/api/")
    //        .addConverterFactory(GsonConverterFactory.create())
    //        .build()
    //        .create(Api::class.java)

}

