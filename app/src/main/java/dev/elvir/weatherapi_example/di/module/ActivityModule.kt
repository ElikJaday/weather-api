package dev.elvir.weatherapi_example.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

//    @Provides
//    fun providePresenter(): MainContract.Presenter {
//        return MainPresenter()
//    }

}