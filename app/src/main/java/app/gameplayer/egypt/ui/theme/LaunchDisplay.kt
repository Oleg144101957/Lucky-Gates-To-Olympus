package app.gameplayer.egypt.ui.theme

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import app.gameplayer.egypt.R


@Composable
fun LaunchDisplay(navControl: NavHostController){

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.back1),
            contentDescription = "back",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center)
            .padding(bottom = 64.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth()){
                Image(
                    painter = painterResource(id = R.drawable.textback),
                    contentDescription = "btn",
                    modifier = Modifier
                        .align(Alignment.Center)
                )

                Text(
                    text = "Play",
                    color = LuckyWhite,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            navControl.navigate(Arrows.PlayScreen.destination)
                        }
                )
            }

            Box(modifier = Modifier.fillMaxWidth()){
                Image(
                    painter = painterResource(id = R.drawable.textback),
                    contentDescription = "btn",
                    modifier = Modifier
                        .align(Alignment.Center)
                )

                Text(
                    text = "Settings",
                    color = LuckyWhite,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            navControl.navigate(Arrows.SettingsScreen.destination)
                        }
                )
            }

            Box(modifier = Modifier.fillMaxWidth()){
                Image(
                    painter = painterResource(id = R.drawable.textback),
                    contentDescription = "btn",
                    modifier = Modifier
                        .align(Alignment.Center)
                )

                Text(
                    text = "Help",
                    color = LuckyWhite,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            navControl.navigate(Arrows.RulesScreen.destination)
                        }
                )
            }

        }
    }

}