package module.main

import com.soywiz.korge.scene.Module
import com.soywiz.korinject.AsyncInjector
import module.scene.GameScene


object AppModule : Module() {

    override val mainScene = GameScene::class

    override suspend fun AsyncInjector.configure() {
        mapPrototype { GameScene() }
    }
}