package ru.example.recipecomposeapp.ui.recipes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ru.example.recipecomposeapp.R
import ru.example.recipecomposeapp.core.ui.ScreenHeader

@Composable
fun RecipesScreen(modifier: Modifier = Modifier){
    ScreenHeader(
        imagePainter = painterResource(R.drawable.bcg_favorites),
        contentDescription = "Рецепты",
        title = "Рецепты"
    )
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Скоро будут рецепты",
            style = MaterialTheme.typography.displayLarge
        )
    }
}