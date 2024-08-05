package com.example.klivvr_task.composable

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.domain.model.City
import com.example.klivvr_task.viewmodel.HomeViewModel

@Composable
fun CityListScreen(viewModel: HomeViewModel, modifier: Modifier) {
    val filteredCities by viewModel.filteredCities.collectAsState()
    val loading by viewModel.loading.collectAsState()
    var searchText by remember { mutableStateOf("") }
    LaunchedEffect(loading) {
        Log.d("HomeViewModelLoadingInScreen", "Loading state: $loading")
    }

    Column(modifier) {
        SearchBar(
            query = searchText,
            onQueryChanged = {
                searchText = it
                viewModel.filterCities(it)
            }
        )

        if (loading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn {
                items(filteredCities) { city ->
                    CityListItem(city = city)
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit
) {
    TextField(
        value = query,
        onValueChange = { newQuery ->
            onQueryChanged(newQuery)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = {
            Text("Search cities...")
        },
        singleLine = true
    )
}

@Composable
fun CityListItem(city: City) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // Open Google Maps with city coordinates
                val uri =
                    "geo:${city.coordinates.latitude},${city.coordinates.longitude}?q=${city.coordinates.latitude},${city.coordinates.longitude}(${city.name}, ${city.country})"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                context.startActivity(intent)
            }
            .padding(16.dp)
    ) {
        Column {
            Text(text = "${city.name}, ${city.country}", fontWeight = FontWeight.Bold)
            Text(text = "Coordinates: ${city.coordinates.latitude}, ${city.coordinates.longitude}")
        }
    }
}
