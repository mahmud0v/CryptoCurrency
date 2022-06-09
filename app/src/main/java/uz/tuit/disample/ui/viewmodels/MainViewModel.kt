package uz.tuit.disample.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.tuit.disample.model.CryptoCurrency
import uz.tuit.disample.repository.CryptoCurrencyRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val cryptoCurrencyRepository:CryptoCurrencyRepository
):ViewModel() {
    private var cryptoCurrencyEmitter = MutableLiveData<List<CryptoCurrency>>()
    val cryptoCurrency:LiveData<List<CryptoCurrency>> = cryptoCurrencyEmitter

    init {
        loadCryptoCurrency()
    }


    private fun loadCryptoCurrency(){
        cryptoCurrencyEmitter.value = cryptoCurrencyRepository.getCryptoCurrency()
    }



}