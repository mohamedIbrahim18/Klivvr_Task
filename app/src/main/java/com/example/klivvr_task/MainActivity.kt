package com.example.klivvr_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.klivvr_task.ui.theme.Klivvr_TaskTheme
import com.example.klivvr_task.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.klivvr_task.composable.CityListScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Klivvr_TaskTheme {
                val viewModel: HomeViewModel = hiltViewModel()
                MainScreen(viewModel)
            }
        }
    }
}
@Composable
fun MainScreen(viewModel: HomeViewModel) {
    viewModel.fetchCities()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            CityListScreen(
                viewModel = viewModel,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )
        }
    )
}

