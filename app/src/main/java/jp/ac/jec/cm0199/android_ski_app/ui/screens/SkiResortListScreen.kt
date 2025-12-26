package jp.ac.jec.cm0199.android_ski_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

data class SkiResort(
    val name: String,
    val description: String,
    val imageUrl: String,
    val country: String
)

val skiResorts = listOf(
    SkiResort("Dolomiti", "イタリアのスキーリゾートで、ドロミテの心臓部に位置しています。", "https://lh3.googleusercontent.com/aida-public/AB6AXuAxjRNWzzP-YF80Pz-fx7PqsqUAcEYWEjezSjBvj2tVMyYQnqJDM28MJBZ0kOYfmNGuxOH0bSItgF4atG4TOZiQcd5bEijCiEBuk5cNYuoYCkkWAlMWxCA64KN3SN5OmLCQ4Rv824n1giulkSuohDe9u-GTJvIWa4zZksvv0m-f0KMo8hHJUW-xiHCfAhTy7qo4CMTpGqrHN6_WQNkR_rO0ucCAM6BNGXLEEs1_-4xPzVz3IMXOEtzXAfajlCeGM47bgYZoS-Ic5pC6", "Italy"),
    SkiResort("Cortina d'Ampezzo", "イタリアのスキーリゾートで、ドロミテの心臓部に位置しています。", "https://lh3.googleusercontent.com/aida-public/AB6AXuBzQJe2GxpL0I4XIx2K9jEtkq1ONm8LpV-OSbolQabf8rFnrfkKU5vPV5rIjd-WkMLdkluZ6TD9FI8_shAL00IgsWvii5Sf4hkgj6BF-NrCF5z7J4Ct6S4FkO8MfG4irA9vk4sjTjHetJe4RyC1vTZOX1TIU8ScVjlQbX3ju7Wiv_g0lQLwAjmGFeJgP-wXS2puoUT5adr0F5MgR2Zrjwlv5Ooz3_bTWyX-CoOmsaJ0yGTZEKK0KBPlu9EQuioQkjo5hIEFRgO9Sif5", "Italy"),
    SkiResort("Chamonix", "フランスのスキーリゾートで、モンブランの基部に位置しています。", "https://lh3.googleusercontent.com/aida-public/AB6AXuAPablW8trdyPltSfWvikCc3HIXo1uIoLcNeshVCmhGR6YNpsi0L1ObTUIR14Zhmk6ZK5hPc1JlkLDZ3pGl5x4AlmvxPniUYmDK1AZBxCgv5pOvghUWWSR4XlVIgutgI1WUMuBqApnPyACa_8DyOORgtryRY_hyneu2H6_-Vm24FatdSkXOQ9UJjumhQJvowJtFhAMWbJ_WiCTCIoEQjo_qjy_ZRCIS4YFpaU58LABB9_KdIZLLZEIVg8KimX01JSGlW1zKESrsrDpn", "France"),
    SkiResort("Albertville", "フランスのスキーリゾートで、アルプスの心臓部に位置しています。", "https://lh3.googleusercontent.com/aida-public/AB6AXuBoH-Nf8h6XqhPjWbPi5U34sjneMkvyTMaOqGN1orqJbsgtpVR7D9y_6FLaiUg24GvQrMX5SK2BpCdEyojxOmUEI9RsIQDpIVrfQ3S88iNlw-024oX_iX6SA43rzhZsxh2IIUlx1C2OwhHbVQW71nsSR3WznwLqZPkgTj6adaJfn0K64NFb7v5UxRZ1XiGUX4KNaL59GBHzVqKDteeVYS9T0bM5rh2TuVOr3C-_3ygh7Ly8jQYUr-mVgshcEO4URYkoda2SCTKKAwL9", "France"),
    SkiResort("Zermatt", "スイスのスキーリゾートで、スイスアルプスの心臓部に位置しています。", "https://lh3.googleusercontent.com/aida-public/AB6AXuCm32VG-q2ZyQgmJpXDvvtal8x21BjD2mMXCoMOXUjglYW0V9XfsVxPx16DqOW6YP4Q2xOPjdVtX06e1vASfqZ21es4Qlr99Mryk-tgvftShGtqTcHQ8zQd4wRd7NlHS6A1Ha26F7gef9Nq_CMTkO5OXsQVYMwFoj-jK1EBGNu37_YAKRML7IlvmkPfse3pOVjy_XrsFJ0AIdbdDtg3UxHIs_LJK3BTmOc27rsB1S-D794vz6VDzzXRnVdmJjqncYnl9431PkRLH149", "Switzerland"),
    SkiResort("Gstaad", "スイスのスキーリゾートで、スイスアルプスの心臓部に位置しています。", "https://lh3.googleusercontent.com/aida-public/AB6AXuD1Buuyu_HknE4Juhty3SMVg5Jy06jCOy7FmZ5-KjnZljY_uxojO9By3amgnBh2Cde1Eg0WElSqpvE81vbRhGFvw4t6KOFKOMaVRPx0nlzigzQ3HJRPCDTQJYCEg_8LqJkMnY-1VkcqhSWBwaPFQ3giutF8O2J5qyxV0uDAnz8C8HCqAjCLXgdtEyy7g8y8oTgI9WRfK2DChSG73Q2QoBgfqiZivkEa93b3ufWWewdODdOOYhAzYQ_Ouaw1g6gWMbv_rZsgQtHbremI", "Switzerland")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkiResortListScreen(onBack: () -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCountry by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("スキー場") }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            // Search bar
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("スキー場を検索", color = MaterialTheme.colorScheme.tertiary) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = MaterialTheme.colorScheme.tertiary) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            // Country filters
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip("イタリア", selectedCountry == "Italy") { selectedCountry = if (selectedCountry == "Italy") null else "Italy" }
                FilterChip("フランス", selectedCountry == "France") { selectedCountry = if (selectedCountry == "France") null else "France" }
                FilterChip("スイス", selectedCountry == "Switzerland") { selectedCountry = if (selectedCountry == "Switzerland") null else "Switzerland" }
            }

            // Ski resort list
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                val filteredResorts = skiResorts.filter { resort ->
                    (selectedCountry == null || resort.country == selectedCountry) &&
                            (searchQuery.isBlank() || resort.name.contains(searchQuery, ignoreCase = true))
                }.groupBy { it.country }

                filteredResorts.forEach { (country, resorts) ->
                    item {
                        Text(
                            text = when(country) {
                                "Italy" -> "イタリア"
                                "France" -> "フランス"
                                "Switzerland" -> "スイス"
                                else -> ""
                                                          },
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                    }
                    items(resorts) { resort ->
                        SkiResortItem(resort)
                    }
                }
            }
        }
    }
}

@Composable
fun FilterChip(text: String, selected: Boolean, onClick: () -> Unit) {
    SuggestionChip(
        onClick = onClick,
        label = { Text(text) },
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = if(selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            labelColor = if(selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
        )
    )
}

@Composable
fun SkiResortItem(resort: SkiResort) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(2f)) {
            Text(
                text = "スキー場",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = resort.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = resort.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        AsyncImage(
            model = resort.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f) // to make it square
                .clip(MaterialTheme.shapes.medium)
        )
    }
}
