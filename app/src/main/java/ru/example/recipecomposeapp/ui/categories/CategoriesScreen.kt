package ru.example.recipecomposeapp.ui.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.example.recipecomposeapp.R
import ru.example.recipecomposeapp.core.ui.ScreenHeader
import ru.example.recipecomposeapp.data.repository.getCategories
import ru.example.recipecomposeapp.theme.Dimens
import ru.example.recipecomposeapp.ui.categories.model.toUiModel

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    onCategoryClick: (Int, String) -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        ScreenHeader(
            imagePainter = painterResource(id = R.drawable.bcg_categories),
            contentDescription = "Категории",
            title = "Категории"
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues( Dimens.PaddingMain),
            verticalArrangement = Arrangement.spacedBy(Dimens.PaddingMain),
            horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingMain),
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(
                items = getCategories(),
                key = { it.id }
            ) { category ->
                val uiModelCategory = category.toUiModel()
                CategoryItem(
                    category = uiModelCategory,
                    onClick = { onCategoryClick(uiModelCategory.id, uiModelCategory.title) },
                )
            }
        }
    }
}