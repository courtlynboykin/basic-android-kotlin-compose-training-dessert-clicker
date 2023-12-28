package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.data.DessertUiState
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DessertClickerViewModel : ViewModel() {

    //Dessert UI State
    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()


    /**
     * Determine which dessert to show.
     */
    fun determineDessertToShow(
        desserts: List<Dessert>,
        dessertsSold: Int
    ): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }

        return dessertToShow
    }

    fun updateAppState() {
        val desserts = Datasource.dessertList
        val dessertToShow = determineDessertToShow(desserts, uiState.value.dessertsSold)

        _uiState.value = uiState.value.copy(
            revenue = uiState.value.revenue + dessertToShow.price,
            dessertsSold = ++uiState.value.dessertsSold,
            currentDessertPrice = dessertToShow.price,
//                                     currentDessertIndex = dessertToShow.startProductionAmount,
            currentDessertImageId = dessertToShow.imageId
        )
    }


}