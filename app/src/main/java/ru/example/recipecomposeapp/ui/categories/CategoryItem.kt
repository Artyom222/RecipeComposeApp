package ru.example.recipecomposeapp.ui.categories

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.example.recipecomposeapp.R
import ru.example.recipecomposeapp.theme.Dimens

@Composable
fun CategoryItem(
    image: Painter,
    category: String,
    description: String,
){
    Card(
        modifier = Modifier
            .padding(Dimens.PaddingMedium),
        shape = RoundedCornerShape(Dimens.PaddingMedium),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface)
    ) {
        Image(
            painter = image,
            contentDescription = "Категория: $category",
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = category.uppercase(),
            modifier = Modifier
                .padding(Dimens.PaddingMedium),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = description,
            modifier = Modifier
                .padding(
                    start = Dimens.PaddingMedium,
                    end = Dimens.PaddingMedium,
                    bottom = Dimens.PaddingMedium,
                    ),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview(){
    CategoryItem(
        image = painterResource(id = R.drawable.bcg_categories),
        category = "Бургеры",
        description = "Рецепты всех популярных видов бургеров"
    )
}