package com.example.klivvr_task.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.City
import com.example.domain.usecase.GetAllCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCitiesUseCase: GetAllCitiesUseCase
) : ViewModel() {
    private val _cities = MutableStateFlow<List<City>>(emptyList())

    private val _filteredCities = MutableStateFlow<List<City>>(emptyList())
    val filteredCities = _filteredCities.asStateFlow()

    private val _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()

    init {
        runCatching {
            _loading.value = true
            viewModelScope.launch {
                Log.d("HomeViewModel", "Fetching cities...")
                val cityList = getAllCitiesUseCase()
                _cities.value = cityList
                _filteredCities.value = cityList
                delay(5.seconds)
                _loading.value = false
            }
        }.onFailure {
            _loading.value = false

        }
    }


    fun filterCities(prefix: String) {
        val lowerCasePrefix = prefix.lowercase()
        _filteredCities.value = _cities.value.filter {
            it.name.lowercase().startsWith(lowerCasePrefix) || it.country.lowercase()
                .startsWith(lowerCasePrefix)
        }
    }
}

