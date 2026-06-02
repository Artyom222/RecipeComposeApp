package ru.example.recipecomposeapp

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.example.recipecomposeapp.data.model.KEY_RECIPE_OBJECT
import ru.example.recipecomposeapp.navigation.BottomNavigation
import ru.example.recipecomposeapp.navigation.Destination
import ru.example.recipecomposeapp.theme.RecipesAppTheme
import ru.example.recipecomposeapp.ui.categories.CategoriesScreen
import ru.example.recipecomposeapp.ui.details.RecipeDetailsScreen
import ru.example.recipecomposeapp.ui.favorites.FavoritesScreen
import ru.example.recipecomposeapp.ui.recipes.RecipesScreen
import ru.example.recipecomposeapp.ui.recipes.model.RecipeUiModel

@Composable
fun RecipesApp() {
    val navController = rememberNavController()
    RecipesAppTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    onFavoriteClick = {
                        navController.navigate(Destination.Favorites.route)
                    },
                    onCategoriesClick = {
                        navController.navigate(Destination.Categories.route)
                    },
                )
            }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Destination.Categories.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(route = Destination.Categories.route) {
                    CategoriesScreen(
                        onCategoryClick = { categoryId, categoryTitle ->
                            navController.navigate(
                                Destination
                                    .Recipes
                                    .createRoute(categoryId, categoryTitle)
                            )
                        }
                    )
                }
                composable(route = Destination.Favorites.route) {
                    FavoritesScreen()
                }
                composable(
                    route = Destination.Recipes.route,
                    arguments = listOf(
                        navArgument("categoryId") { type = NavType.IntType },
                        navArgument("categoryTitle") { type = NavType.StringType },
                    )
                ) { backStackEntry ->
                    val categoryId = backStackEntry.arguments?.getInt("categoryId")
                        ?: error("Category ID is required")
                    val categoryTitle = backStackEntry.arguments?.getString("categoryTitle")
                        ?: error("Category title is required")

                    RecipesScreen(
                        categoryId = categoryId,
                        categoryTitle = categoryTitle,
                        onRecipeClick = {recipeId, recipe ->
                            navController.currentBackStackEntry?.savedStateHandle?.set(KEY_RECIPE_OBJECT, recipe)
                            navController.navigate(Destination.Recipe.createRoute(recipeId))
                        }
                    )
                }
                composable(
                    route = Destination.Recipe.route
                ) {
                    val recipe = navController.previousBackStackEntry
                        ?.savedStateHandle?.get<RecipeUiModel>(KEY_RECIPE_OBJECT)
                    RecipeDetailsScreen(
                        recipe ?: error("RecipeUiModel is required")
                    )
                }
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