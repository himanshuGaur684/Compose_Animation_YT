package gaur.himanshu.composeanimationyt

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate

@Composable
fun KeyFrameAnim() {


    val infiniteTrans = rememberInfiniteTransition()
    val degree by infiniteTrans.animateFloat(initialValue = 0f, targetValue = 359f, animationSpec =
    infiniteRepeatable(animation = keyframes {
        durationMillis = 2000
        0f at 0
        359f at 2000
    })
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Rotate Me", modifier = Modifier.rotate(degree))
    }

}