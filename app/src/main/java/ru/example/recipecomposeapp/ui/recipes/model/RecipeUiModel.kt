package ru.example.recipecomposeapp.ui.recipes.model

import androidx.compose.runtime.Immutable
import ru.example.recipecomposeapp.data.model.ASSETS_URI_PREFIX
import ru.example.recipecomposeapp.data.model.IngredientDto
import ru.example.recipecomposeapp.data.model.RecipeDto

@Immutable
data class RecipeUiModel(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val ingredients: List<IngredientDto>,
    val method: List<String>,
    val isFavorite: Boolean,
)

fun RecipeDto.toUiModel(): RecipeUiModel {
    val currentImageUrl = if (imageUrl.startsWith("http",false)) {
        imageUrl
    } else {
        ASSETS_URI_PREFIX + imageUrl
    }
    return RecipeUiModel(
        id = id,
        title = name,
        imageUrl = currentImageUrl,
        ingredients = ingredients,
        method = method,
        isFavorite = false
    )
}