package ru.example.recipecomposeapp.ui.favorites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import ru.example.recipecomposeapp.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ru.example.recipecomposeapp.core.ui.ScreenHeader

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier){
    ScreenHeader(
        imagePainter = painterResource(R.drawable.bcg_favorites),
        contentDescription = "Избранное",
        title = "Избранное"
    )
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Избранных рецептов нет",
            style = MaterialTheme.typography.displayLarge
        )
    }
}