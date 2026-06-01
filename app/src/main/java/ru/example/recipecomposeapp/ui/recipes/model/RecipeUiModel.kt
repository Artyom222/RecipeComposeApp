package ru.example.recipecomposeapp.ui.recipes.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize
import ru.example.recipecomposeapp.data.model.ASSETS_URI_PREFIX
import ru.example.recipecomposeapp.data.model.RecipeDto

@Parcelize
@Immutable
data class RecipeUiModel(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val ingredients: List<IngredientUiModel>,
    val method: List<String>,
    val isFavorite: Boolean,
): Parcelable

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
        ingredients = ingredients.map { it.toUiModel() },
        method = method,
        isFavorite = false
    )
}