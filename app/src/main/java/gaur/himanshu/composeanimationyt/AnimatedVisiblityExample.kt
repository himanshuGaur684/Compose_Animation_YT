package gaur.himanshu.composeanimationyt

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp


@Composable
fun AnimatedVisibilityExample() {

    val isVisible = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedVisibility(visible = isVisible.value) {
            Text(text = "Animate")
        }



        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { isVisible.value = !isVisible.value }) {
            Text(text = "Click")
        }


    }


}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilityExampleSecond() {

    val isVisible = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedVisibility(
            visible = isVisible.value,
            enter = fadeIn(animationSpec = tween(durationMillis = 1000)) + slideIn(initialOffset = { IntOffset(x = 100, y = 100) })
            , exit = fadeOut()+slideOut(targetOffset = { IntOffset(x = -100, y = -100) })

        ) {
            Image(
                painter = painterResource(id = R.drawable.king), contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clip(CircleShape), contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { isVisible.value = !isVisible.value }) {
            Text(text = "Click")
        }


    }


}
