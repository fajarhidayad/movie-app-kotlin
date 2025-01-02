package id.my.suryadev.movieapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _apiKey = Constants.API_KEY

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                Log.d("MovieViewModel", "Starting API call")

                val response = MovieApiClient.api.getPopularMovies(apiKey = _apiKey)
                Log.d("MovieViewModel", "Received ${response.results.size} movies")

                _movies.value = response.results
            } catch (e: Exception) {
                Log.e("MovieViewModel", "Error loading movies", e)
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}