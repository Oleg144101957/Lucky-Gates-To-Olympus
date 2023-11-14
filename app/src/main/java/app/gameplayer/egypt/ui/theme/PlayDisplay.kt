package app.gameplayer.egypt.ui.theme

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import app.gameplayer.egypt.Constants
import app.gameplayer.egypt.R
import kotlinx.coroutines.delay


@Composable
fun PlayDisplay(navControl: NavHostController){

    val animationPlay = remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    val pref = context.getSharedPreferences(Constants.PREF, Context.MODE_PRIVATE)
    val name = pref.getString(Constants.PREF_USER_NAME, "")

    val targetAlpha = if (animationPlay.value) 0f else 1f

    val currentAlpha = animateFloatAsState(
        targetValue = targetAlpha,
        animationSpec = tween(durationMillis = 3000)
    )


    if (!animationPlay.value){
        LaunchedEffect(Unit){
            animationPlay.value = true
            delay(3000)
            animationPlay.value = false
        }
    }


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.back1),
            contentDescription = "back",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = rememberVectorPainter(image = Icons.Default.Close),
            contentDescription = "close",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
                .clickable {
                    navControl.navigate(Arrows.LaunchScreen.destination)
                }
        )
        
        PlaySurface()

        Text(
            text = "Hello $name",
            color = LuckyYellow,
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .align(Alignment.Center)
                .alpha(currentAlpha.value)
        )
    }
}

@Composable
fun BoxScope.ScoresPart(scores: Int){
    
    Box(modifier = Modifier
        .align(Alignment.TopCenter)
        .padding(top = 32.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.scoreback),
            contentDescription = "score back",
            modifier = Modifier.align(Alignment.Center)
        )
        
        Text(
            text = "$scores scores",
            color = LuckyWhite,
            modifier = Modifier.align(Alignment.Center)
        )
        
    }
}


@Composable
fun BoxScope.PlaySurface(){

    val screenHeight = LocalConfiguration.current.screenHeightDp
    val score = remember {
        mutableStateOf(0)
    }

    val fallingSpeed = remember {
        mutableStateOf(3500)
    }

    val ani1 = remember {
        Animatable(initialValue = 0f)
    }

    val ani2 = remember {
        Animatable(initialValue = 0f)
    }

    val ani3 = remember {
        Animatable(initialValue = 0f)
    }

    val ani4 = remember {
        Animatable(initialValue = 0f)
    }

    val ani5 = remember {
        Animatable(initialValue = 0f)
    }

    val ani6 = remember {
        Animatable(initialValue = 0f)
    }


    val isVisible1 = remember {
        mutableStateOf(true)
    }

    val isVisible2 = remember {
        mutableStateOf(true)
    }

    val isVisible3 = remember {
        mutableStateOf(true)
    }

    val isVisible4 = remember {
        mutableStateOf(true)
    }

    val isVisible5 = remember {
        mutableStateOf(true)
    }

    val isVisible6 = remember {
        mutableStateOf(true)
    }



    LaunchedEffect(key1 = "anim1"){
        ani1.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 150, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(key1 = "anim2"){
        ani2.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 300, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(key1 = "anim3"){
        ani3.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 500, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(key1 = "anim4"){
        ani4.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 50, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(key1 = "anim5"){
        ani5.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 150, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(key1 = "anim6"){
        ani6.animateTo(
            targetValue = screenHeight.toFloat(),
            animationSpec = infiniteRepeatable(
                tween(fallingSpeed.value, delayMillis = 500, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    LaunchedEffect(Unit){
        repeat(32){
            delay(3500)
            isVisible1.value = true
            isVisible2.value = true
            isVisible3.value = true
            isVisible4.value = true
            isVisible5.value = true
            isVisible6.value = true
        }
    }


    Image(
        painter = painterResource(id = R.drawable.lightsection),
        contentDescription = "light section",
        modifier = Modifier
            .size(640.dp)
            .align(Alignment.BottomCenter)
    )

    if (isVisible1.value){
        Image(
            painter = painterResource(id = R.drawable.el2),
            contentDescription = "art1",
            modifier = Modifier
                .offset(y = ani1.value.dp, x = 33.dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 1
                    isVisible1.value = false
                    fallingSpeed.value -= 250
                }
        )
    }

    if (isVisible2.value){
        Image(
            painter = painterResource(id = R.drawable.el3),
            contentDescription = "art2",
            modifier = Modifier
                .offset(y = ani2.value.dp, x = (-33).dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 1
                    isVisible2.value = false
                    fallingSpeed.value -= 250
                }
        )
    }

    if (isVisible3.value){
        Image(
            painter = painterResource(id = R.drawable.el4),
            contentDescription = "art3",
            modifier = Modifier
                .offset(y = ani3.value.dp, x = 48.dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 1
                    isVisible3.value = false
                    fallingSpeed.value -= 250
                }
        )
    }

    if (isVisible4.value){
        Image(
            painter = painterResource(id = R.drawable.el6),
            contentDescription = "art4",
            modifier = Modifier
                .offset(y = ani4.value.dp, x = (-48).dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 4
                    isVisible4.value = false
                    fallingSpeed.value -= 250
                }
        )
    }

    if (isVisible5.value){
        Image(
            painter = painterResource(id = R.drawable.el7),
            contentDescription = "art5",
            modifier = Modifier
                .offset(y = ani5.value.dp, x = 10.dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 2
                    isVisible5.value = false
                    fallingSpeed.value -= 250
                }
        )
    }

    if (isVisible6.value){
        Image(
            painter = painterResource(id = R.drawable.el8),
            contentDescription = "art6",
            modifier = Modifier
                .offset(y = ani6.value.dp)
                .align(Alignment.TopCenter)
                .clickable {
                    score.value += 3
                    isVisible6.value = false
                    fallingSpeed.value -= 250
                }
        )
    }

    //Game surface

    Image(
        painter = painterResource(id = R.drawable.frontelement),
        contentDescription = "light section",
        modifier = Modifier

            .align(Alignment.BottomCenter)
    )
    
    ScoresPart(scores = score.value)

}