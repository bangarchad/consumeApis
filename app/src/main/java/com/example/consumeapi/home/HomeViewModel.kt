package com.example.consumeapi.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.consumeapi.network.GithubApi
import com.example.consumeapi.network.GithubData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel : ViewModel() {

    private val _items = MutableLiveData<List<GithubData>>()
    val items: LiveData<List<GithubData>>
        get() = _items

    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
        initData()
    }


    private fun initData() {
        crScope.launch {
            try {
                val result = GithubApi.retrofitService.showList()

                if(result.size > 0){
                    _items.value = result
                }

            } catch (t: Throwable) {

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }

}