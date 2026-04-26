package ru.example.recipecomposeapp.navigation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.example.recipecomposeapp.theme.Dimens
import ru.example.recipecomposeapp.theme.RecipesAppTheme
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigation(
    onCategoriesClick: () -> Unit,
    onFavoriteClick: () -> Unit,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = Dimens.PaddingMain,
                vertical = Dimens.PaddingMedium,
                )
            .navigationBarsPadding()
    ) {
        Button(
            onClick = onCategoriesClick,
            modifier = Modifier
                .padding(end = Dimens.PaddingSmall)
                .weight(1f),
            shape = RoundedCornerShape(Dimens.PaddingMedium),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary)
        ) {
            Text(
                text = "Категории",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onTertiary
            )
        }
        Button(
            onClick = onFavoriteClick,
            modifier = Modifier
                .weight(1f),
            shape = RoundedCornerShape(Dimens.PaddingMedium),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error)
        ) {
            Text(
                text = "Избранное",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onError
            )
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun BottomNavigationPreviewLight() {
    RecipesAppTheme {
        BottomNavigation(
            onFavoriteClick = {},
            onCategoriesClick = {}
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BottomNavigationPreviewDark() {
    RecipesAppTheme {
        BottomNavigation(
            onFavoriteClick = {},
            onCategoriesClick = {}
        )
    }
}