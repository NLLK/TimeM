package com.nllk.timem.viewModel

import com.nllk.timem.repository.EntranceRepository

class MainPageViewModel(repository: EntranceRepository){
    fun onEnterButtonClicked() {
        println("enter")
    }

    fun onExitButtonClicked() {
        TODO("Not yet implemented")
    }
}