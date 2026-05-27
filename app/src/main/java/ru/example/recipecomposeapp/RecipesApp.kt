package ru.example.recipecomposeapp

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.example.recipecomposeapp.navigation.BottomNavigation
import ru.example.recipecomposeapp.theme.RecipesAppTheme
import ru.example.recipecomposeapp.ui.categories.CategoriesScreen
import ru.example.recipecomposeapp.ui.favorites.FavoritesScreen
import ru.example.recipecomposeapp.ui.recipes.RecipesScreen


@Composable
fun RecipesApp() {
    var currentScreen by remember { mutableStateOf(ScreenId.CATEGORIES) }
    var selectedCategoryId by remember { mutableStateOf<Int?>(null) }
    var selectedCategoryTitle by remember { mutableStateOf("") }
    RecipesAppTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    onFavoriteClick = {
                        currentScreen = ScreenId.FAVORITES
                    },
                    onCategoriesClick = {
                        currentScreen = ScreenId.CATEGORIES
                        selectedCategoryId = null
                        selectedCategoryTitle = ""
                    },
                )
            }
        ) { paddingValues ->
            when (currentScreen) {
                ScreenId.CATEGORIES -> CategoriesScreen(
                    modifier = Modifier.padding(paddingValues),
                    onCategoryClick = { categoryId, categoryTitle ->
                        selectedCategoryId = categoryId
                        selectedCategoryTitle = categoryTitle
                        currentScreen = ScreenId.RECIPES
                    }
                )

                ScreenId.RECIPES -> RecipesScreen(
                    categoryId = selectedCategoryId ?: error("Category ID is required"),
                    categoryTitle = selectedCategoryTitle,
                    modifier = Modifier.padding(paddingValues),
                )

                ScreenId.FAVORITES -> FavoritesScreen(
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun RecipesAppPreviewLight() {
    RecipesApp()
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RecipesAppPreviewDark() {
    RecipesApp()
}