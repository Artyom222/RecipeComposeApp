package ru.example.recipecomposeapp.ui.recipes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ru.example.recipecomposeapp.R
import androidx.compose.ui.res.painterResource
import ru.example.recipecomposeapp.core.ui.ScreenHeader
import ru.example.recipecomposeapp.data.repository.getRecipesByCategoryId
import ru.example.recipecomposeapp.theme.Dimens
import ru.example.recipecomposeapp.ui.recipes.model.RecipeUiModel
import ru.example.recipecomposeapp.ui.recipes.model.toUiModel

@Composable
fun RecipesScreen(
    categoryId: Int,
    categoryTitle: String,
    modifier: Modifier = Modifier,
    onRecipeClick: (Int) -> Unit = {}
){
    var recipes by remember { mutableStateOf<List<RecipeUiModel>>(emptyList()) }
    LaunchedEffect(categoryId) {
        recipes = getRecipesByCategoryId(categoryId).map { dto -> dto.toUiModel() }
    }

     Column(modifier = modifier) {
        ScreenHeader(
            imagePainter = painterResource(R.drawable.bcg_recipes_list),
            contentDescription = "Рецепты: ${categoryTitle}",
            title = categoryTitle
        )
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(Dimens.PaddingMain),
            verticalArrangement = Arrangement.spacedBy(Dimens.PaddingMain)
        ) {
            items(
                items = recipes,
                key = { it.id }
            ) { recipe ->
                RecipeItem(
                    recipe = recipe,
                    onRecipeClick = onRecipeClick,
                )
            }
        }
    }
}