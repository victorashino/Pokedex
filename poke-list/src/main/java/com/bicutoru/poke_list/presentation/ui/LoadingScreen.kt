package com.bicutoru.poke_list.presentation.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PokeListSkeleton() {
    val itemCount = 10

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEFFF0)),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(itemCount) {
                SkeletonItem()
            }
        }
        ShimmerOverlay()
    }
}

@Composable
private fun SkeletonItem() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(190.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
        }
    }
}

@Composable
private fun ShimmerOverlay() {
    val shimmerBrush = customShimmerAnimation()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(shimmerBrush)
    )
}

@Composable
private fun customShimmerAnimation(): Brush {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val shimmerTranslate by infiniteTransition.animateFloat(
        initialValue = -400f,
        targetValue = 1600f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    return Brush.horizontalGradient(
        colors = listOf(
            Color.Gray.copy(alpha = 0.1f),
            Color.Gray.copy(alpha = 0.0f),
            Color.Gray.copy(alpha = 0.1f)
        ),
        startX = shimmerTranslate - 150f,
        endX = shimmerTranslate + 150f
    )
}