package ru.example.recipecomposeapp.ui.categories

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import ru.example.recipecomposeapp.R
import ru.example.recipecomposeapp.data.model.CategoryDto
import ru.example.recipecomposeapp.theme.Dimens
import ru.example.recipecomposeapp.ui.categories.model.CategoryUiModel
import ru.example.recipecomposeapp.ui.categories.model.toUiModel
import java.util.Locale


@Composable
fun CategoryItem(
    category: CategoryUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.PaddingMedium)
            .clickable { onClick() },
        shape = RoundedCornerShape(Dimens.PaddingMedium),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
    ) {
        AsyncImage(
            model = category.imageUrl,
            contentDescription = "Категория: ${category.title}",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.2f),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.img_placeholder),
            error = painterResource(R.drawable.img_error),
        )
        Text(
            text = category.title.uppercase(),
            modifier = Modifier
                .padding(Dimens.PaddingMedium),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = category.description,
            modifier = Modifier
                .padding(
                    start = Dimens.PaddingMedium,
                    end = Dimens.PaddingMedium,
                    bottom = Dimens.PaddingMedium,
                    ),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview(){
    CategoryItem(
        category = CategoryDto(0, "Бургеры", "Рецепты всех популярных видов бургеров", "burger.png").toUiModel(),
        onClick = {},
        modifier = Modifier
    )
}