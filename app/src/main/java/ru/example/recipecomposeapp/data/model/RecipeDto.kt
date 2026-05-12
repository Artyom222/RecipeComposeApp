package ru.example.recipecomposeapp.data.model

data class RecipeDto(
    val id: Int,
    val name: String,
    val ingredients: List<IngredientDto>,
    val method: List<String>,
    val imageUrl: String,
)