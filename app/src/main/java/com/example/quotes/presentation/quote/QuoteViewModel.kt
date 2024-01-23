package com.example.quotes.presentation.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotes.domain.repository.QuoteRepository
import com.example.quotes.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val repository: QuoteRepository
): ViewModel() {

    private val _state = MutableStateFlow(QuoteState())
    val state = _state.asStateFlow()

    init {
        getquote()
    }

    private fun getquote(){
        viewModelScope.launch {
            repository.getQuote().collectLatest { quote ->
                when(quote){
                    is Resource.Error -> {
                        _state.update {
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _state.update {
                            it.copy(
                                isLoading = true
                            )
                        }
                    }
                    is Resource.Success -> {
                        _state.update {
                            it.copy(
                                quote = quote.data
                            )
                        }
                    }
                }
            }
        }
    }

}