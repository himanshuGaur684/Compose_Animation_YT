package gaur.himanshu.composeanimationyt

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimateContentSize() {

    val size = remember {
        mutableStateOf(1f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Slider(value = size.value, onValueChange = {
            size.value = it
        }, steps = 4, valueRange = 1f..10f)

        Text(
            text = "It's pretty likely that you exchange text messages with a relatively small group of people — friends, family and co-workers. Most people don't get a lot of \"cold call\" texts from people they don't know, so a message from someone you don't know, or a simple \"Hello\" directed to no one in particular, is a big red flag. A group message or a text that doesn't immediately seem directed to you isn't necessarily spam, but it probably is. Treat it with caution.  ",
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(animationSpec = spring(stiffness = Spring.StiffnessVeryLow)),
            maxLines = size.value.toInt()
        )


    }

}