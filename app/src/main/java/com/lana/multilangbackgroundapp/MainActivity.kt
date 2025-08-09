package com.lana.multilangbackgroundapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.lana.multilangbackgroundapp.ui.navigation.AppNavHost
import com.lana.multilangbackgroundapp.ui.theme.MultiLangBackgroundAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiLangBackgroundAppTheme {
                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }
}
