package jp.ac.jec.cm0199.android_ski_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun OnboardingScreen(onGetStarted: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = "https://lh3.googleusercontent.com/aida-public/AB6AXuCJaQSc5VcAEhmOl6nzR_puoxiXJV_cyHQRiXMC6RIn_jmn7Lw3Wqg0KAx70xRvrjFiG4I9GAM15RcSOPio_RAsWgURVuQldfal1lITnQjR5zy7L9gK1wusTmTMsznT8bIZyfJgkuamhzPAi8A80m6r9PspRo1kEVYVBff8EPN98-N4jvpOZLBY8Bb3PffE9_OfmirsHMP1hlm340Yh_XeqtOkvX9MuWaYtKqSXj3gyOIYcipi2celtVt74sjEgsnJPwB-S86emdoLC",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "アルプスでスキーを愛する人々のためのモバイルアプリ",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "アルプスの美しい雪景色を背景に、アプリの魅力を伝えるキャッチーなコピーを配置。",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            Button(
                onClick = onGetStarted,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(text = "はじめる")
            }
        }
    }
}
