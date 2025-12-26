package jp.ac.jec.cm0199.android_ski_app.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("スキーダッシュボード") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle menu click */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                AsyncImage(
                    model = "https://lh3.googleusercontent.com/aida-public/AB6AXuAIrM7GkIdrZF5BnVA3UuOZUkMxOEbfJMHp1SmT9po8jx6KgEqUVCXVwrXMI7pt7EI4eyfM_o509HuxNlVu8rEUgVZIoz0qBKo8bH9k_epeeAIqb9nA0CdFNRGbzEVXBzCsROR7mK6KbVMJ9XaEeeNc1m64QKn-g7Af8z8nvCqGQlCvHehvAe7Ll9_kBn2PY2fL9VSDAgPCko5x4IUUo5bsSOpejELzWl0BV8_P4N-UuyPSBWuwGw7Jin5qtCwFC3oNNKSktOz1SU7B",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                        .clip(MaterialTheme.shapes.medium)
                )
                Spacer(modifier = Modifier.height(24.dp))
                SkiDataSection()
                Spacer(modifier = Modifier.height(24.dp))
                SkiHistorySection()
            }
        }
    }
}

@Composable
fun SkiDataSection() {
    Column {
        Text(
            text = "スキーデータ",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SkiDataCard("滑走距離", "15.2km", Modifier.weight(1f))
            SkiDataCard("滑走時間", "2時間30分", Modifier.weight(1f))
            SkiDataCard("最高速度", "65km/h", Modifier.weight(1f))
        }
    }
}

@Composable
fun SkiDataCard(title: String, value: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SkiHistorySection() {
    Column {
        Text(
            text = "スキー履歴",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "週間滑走距離",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "15.2km",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Text(
                        text = "今週",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "+10%",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
                // Placeholder for the graph
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(vertical = 16.dp)
                        .border(1.dp, MaterialTheme.colorScheme.tertiary, MaterialTheme.shapes.small),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Graph placeholder", color = MaterialTheme.colorScheme.tertiary)
                }
            }
        }
    }
}
