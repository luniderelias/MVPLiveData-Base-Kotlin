package com.example.mvp_livedata_base_kotlin.main

import androidx.lifecycle.MutableLiveData
import com.example.mvp_livedata_base_kotlin.base.extensions.launchIO
import com.example.mvp_livedata_base_kotlin.data.ExampleData
import com.example.mvp_livedata_base_kotlin.data.ExampleRepositoryMock
import kotlinx.coroutines.*

class MainPresenter(
    override var view: MainContract.View,
    private val repository: ExampleRepositoryMock
) : MainContract.Presenter {

    var response = MutableLiveData<ExampleData>()

    override fun init() {
        loadData()
    }

    override fun loadData() {
        launchIO {
            response.postValue(repository.getExample())
        }
    }

    override fun observeForExampleData(): MutableLiveData<ExampleData> {
        return response
    }
}