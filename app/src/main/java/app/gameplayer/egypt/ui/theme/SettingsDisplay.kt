package app.gameplayer.egypt.ui.theme

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.gameplayer.egypt.Constants
import app.gameplayer.egypt.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsDisplay(){
    //Settings

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    val text = remember {
        mutableStateOf("")
    }


    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(Constants.PREF, Context.MODE_PRIVATE)

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.back1),
            contentDescription = "back",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        BasicTextField(
            value = text.value,
            textStyle = TextStyle(color = LuckyWhite),
            modifier = Modifier
                .width(256.dp)
                .height(32.dp)
                .background(LuckyBlack)
                .align(Alignment.Center),
            onValueChange = {
                text.value = it
                sharedPreferences.edit().putString(Constants.PREF_USER_NAME, it).apply()
            }
        )

        Text(
            text = "Enter your name",
            color = LuckyBlack,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-38).dp)
        )
    }
}