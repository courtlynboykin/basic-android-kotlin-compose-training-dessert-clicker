package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.DessertUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DessertClickerViewModel : ViewModel() {

    //Dessert UI State
    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

//    how would i know what goes into the view model?

//In the context of your Dessert Clicker app, you can determine what goes into the ViewModel by identifying the data and logic that is responsible for managing the UI state and business logic. In the provided code, it seems like the DessertUiState class is a good candidate for the ViewModel's state, and the functions related to determining the dessert to show and sharing dessert information can be part of the ViewModel's logic.

//Here's a suggested approach to organize your ViewModel:


//class DessertClickerViewModel : ViewModel() {
//    // Define a MutableStateFlow to hold the UI state
//    private val _uiState = MutableStateFlow(DessertUiState())
//    val uiState = _uiState.asStateFlow()
//
//    // Function to handle dessert click logic
//    fun onDessertClicked(desserts: List<Dessert>) {
//        // Update the revenue and dessertsSold
//        _uiState.value = _uiState.value.copy(
//            revenue = _uiState.value.revenue + _uiState.value.currentDessertPrice,
//            dessertsSold = _uiState.value.dessertsSold + 1
//        )
//
//        // Determine the next dessert to show
//        viewModelScope.launch {
//            val dessertToShow = determineDessertToShow(desserts, _uiState.value.dessertsSold)
//            _uiState.value = _uiState.value.copy(
//                currentDessertPrice = dessertToShow.price,
//                currentDessertImageId = dessertToShow.imageId
//            )
//        }
//    }
//
//    // Function to handle sharing dessert information
//    fun onShareButtonClicked(context: Context) {
//        shareSoldDessertsInformation(
//            intentContext = context,
//            dessertsSold = _uiState.value.dessertsSold,
//            revenue = _uiState.value.revenue
//        )
//    }
//}


}