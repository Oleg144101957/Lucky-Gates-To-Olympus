package app.gameplayer.egypt.ui.theme



sealed class Arrows(val destination: String) {

    object WaitingScreen : Arrows("waiting")
    object LaunchScreen : Arrows("launch")
    object PlayScreen : Arrows("play")
    object RulesScreen : Arrows("rules")
    object SettingsScreen : Arrows("settings")

}