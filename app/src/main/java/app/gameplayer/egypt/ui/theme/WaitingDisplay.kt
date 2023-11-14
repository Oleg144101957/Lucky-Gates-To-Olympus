package app.gameplayer.egypt.ui.theme

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import app.gameplayer.egypt.R
import kotlinx.coroutines.delay


@Composable
fun WaitingDisplay(navControl: NavHostController){

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    val infiniteTransition = rememberInfiniteTransition()
    val rotation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    LaunchedEffect(key1 = "next screen"){
        delay(1550)
        navControl.navigate(Arrows.LaunchScreen.destination)
    }

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.back1),
            contentDescription = "back",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.el5),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .graphicsLayer {
                    rotationZ = rotation.value
                }
        )

        Text(
            text = "Loading...",
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 64.dp)
        )
    }
}