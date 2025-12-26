package jp.ac.jec.cm0199.android_ski_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkiTripDetailScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("スキートリップ") }
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
                    model = "https://lh3.googleusercontent.com/aida-public/AB6AXuB9lY9ZSYo1cCncCyWzy1DRy0TOpHCt6TILb548KGJJhAkX2KTPtO0ECjqYgjKbjnmSqLXXnkULmcmQG4X8XAOjL7k3ZtB6IP4Sp1cZkPf2X3V9ctEAT1CZ-_FDPJNhRhtuVqkSFawc-xJV_nG-Av5IpU6tyDFlR-bJVQy7wCbIyv3OGTOfvcGhSGLZuYItsT7AaHGUH6I5EkGSw8WbqlTL85SSVNVuZ3Nv7Z57DL78mqCbyyO5i41Fs15nLI5tC1IG-jAYykekC8f3",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                        .clip(MaterialTheme.shapes.medium)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TripSummary()
                Spacer(modifier = Modifier.height(16.dp))
                TripDetails()
            }
        }
    }
}

@Composable
fun TripSummary() {
    Column {
        Text(
            text = "トリップの概要",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        DetailRow("日付", "2024年1月20日")
        DetailRow("時間", "10:00 - 16:00")
        DetailRow("距離", "15km")
        DetailRow("成功したリフト", "5")
    }
}

@Composable
fun TripDetails() {
    Column {
        Text(
            text = "トリップの詳細",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        DetailRow("最高速度", "60km/h")
        DetailRow("平均速度", "30km/h")
        DetailRow("消費カロリー", "800kcal")
        DetailRow("最大標高", "2500m")
        DetailRow("最小標高", "1500m")
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = MaterialTheme.colorScheme.tertiary)
        Text(text = value, color = MaterialTheme.colorScheme.onBackground)
    }
}
