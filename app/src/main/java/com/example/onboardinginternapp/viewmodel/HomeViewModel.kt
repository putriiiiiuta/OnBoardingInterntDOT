package com.example.onboardinginternapp.viewmodel

import androidx.lifecycle.*
import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieResponse
import com.example.onboardinginternapp.data.remote.network.ApiHelperImpl
import com.example.onboardinginternapp.data.remote.repository.RemoteRepository
import com.example.onboardinginternapp.utils.NetworkHelper
import com.example.onboardinginternapp.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel(
    private val remoteRepository: RemoteRepository
) : ViewModel() {

    private val _movie = MutableLiveData<Resource<MovieResponse>>() //CRUD
    val movie = _movie


//    private val _movie = MutableLiveData<List<Movie>>()
//    val movie: LiveData<List<Movie>> = _movie

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading // read aja, gk bisa ngapus gk bisa nambah

    companion object {
        const val API_KEY = "1c9c88a7ed857e63d5aaab264c8d0169"
    }

    init { // buat ngejalanin function yg dijalanin pertama kali
//        fetchData()
//        getMovie()
        fetchMovies()
    }


    private fun fetchMovies() {
        viewModelScope.launch {
            remoteRepository.fetchPopMovies().collect {
                _movie.value = it
            }
        }
    }


//    fun getMovieViewModel() {
//
//        viewModelScope.launch {
//            _movie.postValue(Resource.loading(null))
//            if (networkHelper.isNetworkConnected()) {
//
//                try {
//
//                    val params = HashMap<String, String>()
//                    params["api_key"] = API_KEY
//                    val response = ApiHelperImpl.getMovieRemake(params)
//                    val moviee = response[0].results
//                    _movie.postValue(Resource.success(moviee))
//
//                }
//                catch (e: Exception) {
//                    _movie.postValue(
//                        Resource.error(
//                            "failed to get data from server",
//                            null
//                        )
//                    )
//                }
//
//            } else {
//
////                val response = ApiHelperImpl.getMovieRemake(params)
////                _movie.postValue(Resource.success(response))
//
//            }
//        }
//    }


//    fun getMovie() {
//        viewModelScope.launch {
//            _movie.postValue(Resource.loading(null))
//            if (networkHelper.isNetworkConnected()) {
//                try {
//                    val params = API_KEY
////                    val params = HashMap<String, String>()
////                    params["api_key"] = API_KEY
//                    val response = remoteRepository.getMovieBoundResource(params)
//                    _movie.postValue(Resource.success(response))
//                } catch (e: Exception) {
//                    _movie.postValue(
//                        Resource.error(
//                            "failed to get data from server",
//                            null
//                        )
//                    )
//                }
//            } else {
//                val response = remoteRepository.getMovieOffline()
//                _movie.postValue(Resource.success(response))
//            }
//        }
//    }

//        fun fetchData() {
//        _isLoading.value = true
//          viewModelScope.launch {
//
//        val client = remoteRepository.getMovieRemote().getMovie(API_KEY)
////        val client = ApiConfig.getApiService().getMovie(API_KEY)
//        client.enqueue(object : retrofit2.Callback<MovieResponse> {
//            //enque buat action/jalanin req api nya(client ke server), callback dari server ke kita (server ke client)
//            //buat buka jalurnya
//            override fun onResponse(
//                call: Call<MovieResponse>,
//                response: Response<MovieResponse>
//            ) {
//                if (response.isSuccessful) {
//                    _isLoading.value = false
//                    _movie.value = response.body()?.results
//                } else {
//                    Log.e(TAG, "onFailure: ${response.message()}")
//                }
//            }
//
//            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//                _isLoading.value = false
//                Log.e(TAG, "onFailure: ${t.message.toString()}")
//            }
//        })
//
//          }
//    }
}

