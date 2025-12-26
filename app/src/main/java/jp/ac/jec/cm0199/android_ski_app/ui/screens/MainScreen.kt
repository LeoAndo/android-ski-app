package jp.ac.jec.cm0199.android_ski_app.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Dashboard : BottomNavItem("dashboard", Icons.Default.Dashboard, "ホーム")
    object SkiResortList : BottomNavItem("ski_resort_list", Icons.Default.List, "スキー場")
    object Records : BottomNavItem("records", Icons.Default.Notes, "記録")
    object Settings : BottomNavItem("settings", Icons.Default.Settings, "設定")
}

val bottomNavItems = listOf(
    BottomNavItem.Dashboard,
    BottomNavItem.SkiResortList,
    BottomNavItem.Records,
    BottomNavItem.Settings
)

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavItems.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.label) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = BottomNavItem.Dashboard.route,
            Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Dashboard.route) { DashboardScreen() }
            composable(BottomNavItem.SkiResortList.route) { SkiResortListScreen(onBack = { navController.popBackStack() }) }
            composable(BottomNavItem.Records.route) { SkiTripDetailScreen(onBack = { navController.popBackStack() }) }
            composable(BottomNavItem.Settings.route) { SettingsScreen(onBack = { navController.popBackStack() }) }
        }
    }
}
