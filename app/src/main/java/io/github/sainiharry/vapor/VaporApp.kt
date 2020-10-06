package io.github.sainiharry.vapor

import android.app.Application
import io.github.sainiharry.vapor.repository.games.gamesRepositoryModule
import org.koin.core.context.startKoin

class VaporApp : Application() {

    override fun onCreate() {
        super.onCreate()

        //Setup Koin
        startKoin {
            modules(gamesRepositoryModule)
        }
    }
}