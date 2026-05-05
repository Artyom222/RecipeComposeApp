package ru.example.recipecomposeapp.ui.recipes

import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import ru.example.recipecomposeapp.core.ui.ScreenHeader

@Composable
fun RecipesScreen(modifier: Modifier = Modifier){
    Column {
        val context = LocalContext.current
        val imagePainter = remember {
            val inputStream = context.assets.open("burger.png")
            val bitmap = BitmapFactory.decodeStream(inputStream)
            BitmapPainter(bitmap.asImageBitmap())
        }
        ScreenHeader(
            imagePainter = imagePainter,
            contentDescription = "Рецепты",
            title = "Рецепты"
        )
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Скоро будут рецепты",
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}