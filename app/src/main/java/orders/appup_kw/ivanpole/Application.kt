package orders.appup_kw.ivanpole

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class Application : Application() {


    override fun onCreate() {
        super.onCreate()

    }

}