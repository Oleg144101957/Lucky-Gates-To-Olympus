package app.gameplayer.egypt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import app.gameplayer.egypt.ui.theme.LuckyGatesToOlympusTheme
import app.gameplayer.egypt.ui.theme.NavigationComponent

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuckyGatesToOlympusTheme {
                NavigationComponent()
            }
        }
    }
}
