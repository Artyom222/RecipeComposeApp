package ru.example.recipecomposeapp.ui.categories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun CategoriesScreen(modifier: Modifier = Modifier) {
    Column {
        ScreenHeader(
            imagePainter = painterResource(id = R.drawable.bcg_categories),
            contentDescription = "Категории",
            title = "Категории",
        )
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Категории",
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}