package ru.example.recipecomposeapp.ui.categories.model

import androidx.compose.runtime.Immutable
import ru.example.recipecomposeapp.data.model.ASSETS_URI_PREFIX
import ru.example.recipecomposeapp.data.model.CategoryDto

@Immutable
data class CategoryUiModel(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String
)

fun CategoryDto.toUiModel(): CategoryUiModel {
    val currentImageUrl = if (imageUrl.startsWith("http",false)) {
        imageUrl
    } else {
        ASSETS_URI_PREFIX + imageUrl
    }
    return CategoryUiModel(
        id = id,
        title = name,
        description = description,
        imageUrl = currentImageUrl,
    )
}