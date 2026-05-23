package ru.example.recipecomposeapp.ui.categories

import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import ru.example.recipecomposeapp.R
import ru.example.recipecomposeapp.core.ui.ScreenHeader
import ru.example.recipecomposeapp.data.repository.getCategories
import ru.example.recipecomposeapp.theme.Dimens
import ru.example.recipecomposeapp.ui.categories.model.toUiModel

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    onCategoryClick: (Int) -> Unit
) {
    Column(modifier = modifier) {
        ScreenHeader(
            imagePainter = painterResource(id = R.drawable.bcg_categories),
            contentDescription = "Категории",
            title = "Категории"
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(Dimens.PaddingMedium)
        ) {
            items(getCategories()) { category ->
                CategoryItem(
                    category = category.toUiModel(),
                    onClick = { onCategoryClick(category.id) },
                    modifier = modifier,
                )
            }
        }
    }
}