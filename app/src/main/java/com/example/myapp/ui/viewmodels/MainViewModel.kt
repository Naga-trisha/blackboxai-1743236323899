package com.example.myapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.repositories.CounterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CounterRepository
) : ViewModel() {
    private val _clickCount = MutableStateFlow(0)
    val clickCount: StateFlow<Int> = _clickCount.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    init {
        loadInitialCount()
    }

    private fun loadInitialCount() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _clickCount.value = repository.getCurrentCount()
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load count: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun incrementCount() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _clickCount.value = repository.incrementCount(_clickCount.value)
            } catch (e: Exception) {
                _errorMessage.value = "Failed to increment count: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun clearError() {
        _errorMessage.value = null
    }
}
