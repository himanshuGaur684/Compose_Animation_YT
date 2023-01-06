package gaur.himanshu.composeanimationyt

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BasicAnimations() {

    val toggle = remember {
        mutableStateOf(false)
    }

    val color = animateColorAsState(
        targetValue = if (toggle.value) Color.Yellow else Color.Red,
        animationSpec = spring(stiffness = Spring.StiffnessVeryLow),
        finishedListener = {

        }
    )



    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .size(100.dp)
                .padding(vertical = 24.dp)
                .background(color = color.value)
        )


        Button(onClick = { toggle.value = !toggle.value }) {
            Text(text = "Animate Me")
        }

    }

}



@Composable
fun BasicAnimationsTranstions() {

    val toggle = remember {
        mutableStateOf(false)
    }

   val transtion = updateTransition(targetState = toggle, label = "")

    val size by transtion.animateDp(label = "") {
        if(it.value) 300.dp else 100.dp
    }

    val color  by transtion.animateColor(label = "") {
        if(it.value) Color.Yellow else Color.Red
    }




    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .size(size)
                .padding(vertical = 24.dp)
                .background(color = color)
        )


        Button(onClick = { toggle.value = !toggle.value }) {
            Text(text = "Animate Me")
        }

    }

}