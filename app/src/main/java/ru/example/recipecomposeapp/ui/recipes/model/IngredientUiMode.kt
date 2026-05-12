package ru.example.recipecomposeapp.ui.recipes.model

import androidx.compose.runtime.Immutable
import ru.example.recipecomposeapp.data.model.IngredientDto

@Immutable
data class IngredientUiMode(
    val name: String,
    val quantity: String,
    val unitOfMeasure: String,
)

fun IngredientDto.toUiModel(): IngredientUiMode {
    return IngredientUiMode(
        name = description,
        quantity = quantity,
        unitOfMeasure = unitOfMeasure,
    )
}