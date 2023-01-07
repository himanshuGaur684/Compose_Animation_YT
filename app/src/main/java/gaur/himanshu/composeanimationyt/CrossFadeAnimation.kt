package gaur.himanshu.composeanimationyt

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CrossFadeAnim() {

    val switch = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Switch(checked = switch.value, onCheckedChange = { switch.value = it })

        Crossfade(targetState = switch) {
            if (it.value) {
                ScreenA()
            } else {
                ScreenB()
            }
        }

    }

}

@Composable
fun ScreenA() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp).background(color= Color.Green), contentAlignment = Alignment.Center
    ) {
        Text(text = "This is Screen A")
    }

}

@Composable
fun ScreenB() {

    Box(
        modifier = Modifier
            .fillMaxWidth().background(color= Color.Yellow)
            .height(200.dp), contentAlignment = Alignment.Center
    ) {
        Text(text = "This is Screen B")
    }

}

