package com.project.itsme.presentation

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Message
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.AppCard
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material.scrollAway
import com.project.itsme.R
import com.project.itsme.presentation.theme.WearAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "Message") {
                composable(route = "Message") {
                    Message(navController)
                }
                composable(route = "WearApp") {
                    WearApp()
                }
            }
        }
    }
}

@Composable
fun Message(navController: NavHostController) {
    val listState = rememberScalingLazyListState()
    val contentModifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp)
    val iconModifier = Modifier
        .size(24.dp)
        .wrapContentSize(align = Alignment.Center)
    ScalingLazyColumn(
        modifier = Modifier.fillMaxSize(),
        autoCentering = AutoCenteringParams(itemIndex = 0),
        state = listState
    ) {
        item {
            CardExample(
                contentModifier,
                iconModifier,
                onClick = {
                    // 카드 클릭 시 WearApp 화면으로 이동
                    navController.navigate("WearApp")
                }
            )
        }
    }
}
@Composable
fun WearApp() {
    WearAppTheme {
        val listState = rememberScalingLazyListState()
        LaunchedEffect(Unit) {
            // Scroll to the top after the contents have loaded
            listState.scrollToItem(0)
        }

        Scaffold(
            timeText = {
                TimeText(modifier = Modifier.scrollAway(listState))
            },
            vignette = {
                // Only show a Vignette for scrollable screens. This code lab only has one screen,
                // which is scrollable, so we show it all the time.
                Vignette(vignettePosition = VignettePosition.TopAndBottom)
            },
            positionIndicator = {
                PositionIndicator(
                    scalingLazyListState = listState
                )
            }
        ) {
            val contentModifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
            val iconModifier = Modifier
                .size(24.dp)
                .wrapContentSize(align = Alignment.Center)
            val chipTextList2 = listOf("곧 전화할게", "나중에 전화할게", "문자 보내줘", "알바중 이따가 전화할게", "회의중 나중에 전화할게", "운전중이야 나중에 전화할게", "밥먹고 이따 전화할게", "무슨일 있어??")

            ScalingLazyColumn(
                modifier = Modifier.fillMaxSize(),
                autoCentering = AutoCenteringParams(itemIndex = 0),
                state = listState
            ) {
                for (chip_text in chipTextList2) {
                    item { ChipExample(contentModifier, chip_text) }
                }
            }
        }
    }
}



//@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
//@Composable
//fun DefaultPreview() {
//    WearApp()
//}