package gaur.himanshu.composeanimationyt

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentExampleBasic() {

    var count by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Button(onClick = { count-- }) {
            Text(text = "Decrease count")
        }

        Spacer(modifier = Modifier.height(20.dp))

        AnimatedContent(targetState = count, transitionSpec = {
            // final value pr animation likhna hi
            // old value pr animatino likhna hi
            if (targetState > initialState) {
                slideInVertically { fullHeight -> fullHeight } + fadeIn() with
                        slideOutVertically { fullHeight ->
                            -fullHeight
                        } + fadeOut()
            } else {
                slideInVertically { fullHeight -> -fullHeight } + fadeIn() with
                        slideOutVertically { fullHeight -> fullHeight } + fadeOut()
            }.using(
                SizeTransform(clip = false)
            )

        }
        ) {
            Box(modifier = Modifier.size(180.dp), contentAlignment = Alignment.Center) {
                Text(text = "$count", style = MaterialTheme.typography.h1)
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { count++ }) {
            Text(text = "Increase count")
        }


    }

}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentExampleAdvanced() {

    var expanded by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Card(modifier = Modifier
            .clickable { expanded = !expanded }
            .padding(12.dp), elevation = 12.dp) {

            AnimatedContent(
                modifier=Modifier.padding(12.dp).background(color=Color.Green),
                targetState = expanded,
                transitionSpec = {
                    // new value ka enter transition
                    // old value ka exit transition

                    fadeIn() with
                            fadeOut() using SizeTransform { initialSize, targetSize ->

                        if (expanded) {
                            keyframes {
                                IntSize(width = targetSize.width, height = initialSize.height) at 150
                                durationMillis = 1000
                            }

                        } else {
                            keyframes {
                                IntSize(width = initialSize.width, height = targetSize.height) at 150
                                durationMillis = 1000
                            }
                        }

                    }


                }) { targetState ->
                if (targetState) {
                    Expaned()
                } else {
                    Shrink()
                }
            }

        }
    }



}


@Composable
fun Expaned() {
    Text(
        modifier = Modifier.background(color=Color.Green).padding(12.dp),
        text =
        "Artificial intelligence was founded as an academic discipline in 1956, and in the years since has experienced several waves of optimism,[6][7] followed by disappointment and the loss of funding (known as an \"AI winter\"),[8][9] followed by new approaches, success and renewed funding.[7][10] AI research has tried and discarded many different approaches since its founding, including simulating the brain, modeling human problem solving, formal logic, large databases of knowledge and imitating animal behavior. In the first decades of the 21st century, highly mathematical-statistical machine learning has dominated the field, and this technique has proved highly successful, helping to solve many challenging problems throughout industry and academia.[10][11]",
    )
}

@Composable
fun Shrink() {

    Icon(
        imageVector = Icons.Default.Add,
        contentDescription = null,
        modifier = Modifier
            .padding(12.dp)
            .size(50.dp).background(color=Color.Green)
    )

}














