package jp.ac.jec.cm0199.android_ski_app.ui.screens

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Main : Screen("main")
}
