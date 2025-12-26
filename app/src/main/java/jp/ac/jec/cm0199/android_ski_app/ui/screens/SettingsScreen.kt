package jp.ac.jec.cm0199.android_ski_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("設定") }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                ProfileSection()
                Spacer(modifier = Modifier.height(24.dp))
                SettingsSection("アカウント", accountSettings)
                Spacer(modifier = Modifier.height(24.dp))
                SettingsSection("アプリ", appSettings)
            }
        }
    }
}

@Composable
fun ProfileSection() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = "https://lh3.googleusercontent.com/aida-public/AB6AXuDbVi9cykSlUDShVS-wtAgZnNczbcZJAVI0KQRXbLTnONaofLYmmPaQCIvZLx8fzaZhlaVOdmDZlWlMmQSxR4Bl6wJaOsmzso1RrUggolGGjHbYf_0QPjd_5OBicSowyxUDYewA3EtMYjxy4ogg_vUUvk-Sc3QhEnzLlMrIUe7r5WLw7Z-rtRW3qraYBowe3t0Yq2GBTrhVavftWNhrIjMTBCJLVPG6Ik13sgmSX-DO9FKnG-yJwsY_Sw-rJiyrsuUoChwnCQmuF9MU",
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = "Emily Carter",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Emily",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Composable
fun SettingsSection(title: String, items: List<SettingItem>) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        items.forEach { item ->
            SettingItemRow(item)
        }
    }
}

@Composable
fun SettingItemRow(item: SettingItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .size(40.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = item.title,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

data class SettingItem(val icon: ImageVector, val title: String)

val accountSettings = listOf(
    SettingItem(Icons.Default.Person, "プロフィールを編集"),
    SettingItem(Icons.Default.Lock, "パスワードを変更")
)

val appSettings = listOf(
    SettingItem(Icons.Default.Notifications, "通知"),
    SettingItem(Icons.Default.Straighten, "単位"),
    SettingItem(Icons.Default.Info, "アプリについて")
)
