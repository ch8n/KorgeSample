package module.main

import com.soywiz.korge.scene.Module
import com.soywiz.korinject.AsyncInjector
import module.scene.GameScene
import module.scene.MainMenuScene
import module.scene.SplashScene


object AppModule : Module() {

    override val mainScene = SplashScene::class

    override suspend fun AsyncInjector.configure() {
        mapPrototype { SplashScene() } // create a scene, scene == screen
        mapPrototype { MainMenuScene() }
        mapPrototype { MainMenuScene() }
        mapPrototype { GameScene() }
    }
}