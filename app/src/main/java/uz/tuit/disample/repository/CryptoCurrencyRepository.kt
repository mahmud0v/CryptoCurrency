package uz.tuit.disample.repository

import uz.tuit.disample.model.CryptoCurrency


interface CryptoCurrencyRepository  {

    fun getCryptoCurrency():List<CryptoCurrency>
}