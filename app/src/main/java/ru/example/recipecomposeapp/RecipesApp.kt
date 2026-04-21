package ru.example.recipecomposeapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.example.recipecomposeapp.theme.RecipesAppTheme

@Composable
fun RecipesApp() {
    RecipesAppTheme {
        Scaffold { paddingValues ->
            Text(
                text = "Recipes App",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(paddingValues),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipesAppPreview() {
    RecipesApp()
}