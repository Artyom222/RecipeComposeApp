package ru.example.recipecomposeapp.ui.recipes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.example.recipecomposeapp.R
import ru.example.recipecomposeapp.theme.Dimens
import ru.example.recipecomposeapp.ui.recipes.model.RecipeUiModel

@Composable
fun RecipeItem(
    recipe: RecipeUiModel,
    onRecipeClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(Dimens.PaddingMedium)
            .clickable { onRecipeClick(recipe.id) },
        shape = RoundedCornerShape(Dimens.PaddingMedium),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
    ) {
        Column {
            AsyncImage(
                model = recipe.imageUrl,
                contentDescription = "Рецепт: ${recipe.title}",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3.28f),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.img_placeholder),
                error = painterResource(R.drawable.img_error),
            )
            Text(
                text = recipe.title.uppercase(),
                modifier = Modifier
                    .padding(Dimens.PaddingMedium),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}