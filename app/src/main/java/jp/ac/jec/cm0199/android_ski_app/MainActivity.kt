package jp.ac.jec.cm0199.android_ski_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.ac.jec.cm0199.android_ski_app.ui.screens.MainScreen
import jp.ac.jec.cm0199.android_ski_app.ui.screens.OnboardingScreen
import jp.ac.jec.cm0199.android_ski_app.ui.screens.Screen
import jp.ac.jec.cm0199.android_ski_app.ui.theme.AndroidskiappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidskiappTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Onboarding.route) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(onGetStarted = {
                navController.navigate(Screen.Main.route) {
                    popUpTo(Screen.Onboarding.route) {
                        inclusive = true
                    }
                }
            })
        }
        composable(Screen.Main.route) {
            MainScreen()
        }
    }
}

