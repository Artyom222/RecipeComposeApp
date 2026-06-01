package ru.example.recipecomposeapp.navigation

sealed class Destination(val route: String) {
    object Categories : Destination("categories")
    object Favorites : Destination("favorites")
    object Recipes : Destination("recipes/{categoryId}/{categoryTitle}"){
        fun createRoute(categoryId: Int, categoryTitle: String) = "recipes/$categoryId/$categoryTitle"
    }
    object Recipe : Destination("recipe/{recipeId}"){
        fun createRoute(recipeId: Int) = "recipe/$recipeId"
    }
}