package com.example.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavigationComposable(navController: NavHostController){
    val hasUserData = hasUserDataInSharedPreference()
    NavHost(navController = navController, startDestination = if (hasUserData) OnboardDestination.route else HomeDestination.route ){

    }
}

@Composable
fun hasUserDataInSharedPreference(): Boolean {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(USER_PROFILE, Context.MODE_PRIVATE)
    val email = sharedPreferences.getString(EMAIL, "") ?: ""
    return email.isNotBlank()
}