package module.scene

import com.soywiz.klock.timesPerSecond
import com.soywiz.korev.Key
import com.soywiz.korge.input.onClick
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.scene.sceneContainer
import com.soywiz.korge.ui.uiButton
import com.soywiz.korge.ui.uiTextButton
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korio.async.launchImmediately


class SplashScene : Scene() {
    override suspend fun Container.sceneInit(): Unit {
        sceneContainer(name = "splash", views = views) {
            val mainText = text(text = "This is $name scene container").centerOnStage()
            val menuBtn = uiTextButton(text = "change scene") {
                alignTopToBottomOf(mainText)
                alignLeftToLeftOf(mainText)
                onClick {
                    launchImmediately { sceneContainer.changeTo<MainMenuScene>() }
                }
            }

            uiTextButton(text = "go to game scene") {
                alignTopToBottomOf(menuBtn)
                alignLeftToLeftOf(menuBtn)
                onClick {
                    launchImmediately { sceneContainer.changeTo<GameScene>() }
                }
            }
        }
    }
}


class MainMenuScene : Scene() {
    override suspend fun Container.sceneInit(): Unit {
        sceneContainer(name = "main_menu", views = views) {
            val mainText = text(text = "This is $name scene container").centerOnStage()
            uiTextButton(text = "go to game scene") {
                alignTopToBottomOf(mainText)
                alignLeftToLeftOf(mainText)
                onClick {
                    launchImmediately { sceneContainer.changeTo<GameScene>() }
                }
            }
        }
    }
}

class GameScene : Scene() {
    override suspend fun Container.sceneInit(): Unit {
        sceneContainer(name = "game", views = views) {
            val mainText = text(text = "This is $name scene container").centerOnStage()
            val player = circle(radius = 25.0, fill = Colors.PINK) {
                alignTopToBottomOf(mainText)
                alignLeftToLeftOf(mainText)
                alignRightToRightOf(mainText)
            }


            addFixedUpdater(60.timesPerSecond) {

                when {

                    views.input.keys[Key.UP] && views.input.keys[Key.LEFT] -> {
                        player.color = Colors.BLUEVIOLET
                        player.xy(player.x - 1, player.y - 1)
                    }

                    views.input.keys[Key.UP] && views.input.keys[Key.RIGHT] -> {
                        player.color = Colors.GREENYELLOW
                        player.xy(player.x + 1, player.y - 1)
                    }

                    views.input.keys[Key.DOWN] && views.input.keys[Key.RIGHT] -> {
                        player.color = Colors.HOTPINK
                        player.xy(player.x + 1, player.y + 1)
                    }

                    views.input.keys[Key.DOWN] && views.input.keys[Key.LEFT] -> {
                        player.color = Colors.TAN
                        player.xy(player.x - 1, player.y + 1)
                    }

                    views.input.keys[Key.UP] -> {
                        player.color = Colors.DARKCYAN
                        player.y -= 1
                    }
                    views.input.keys[Key.DOWN] -> {
                        player.color = Colors.DARKCYAN
                        player.y += 1
                    }
                    views.input.keys[Key.LEFT] -> {
                        player.color = Colors.DARKCYAN
                        player.x -= 1
                    }
                    views.input.keys[Key.RIGHT] -> {
                        player.color = Colors.DARKCYAN
                        player.x += 1
                    }
                }
            }
        }
    }
}