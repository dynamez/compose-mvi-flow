package com.rayout.mvi

import com.rayout.mvi.events.MviResult
import com.rayout.mvi.events.MviUiState

class UnsupportedReduceException(state: MviUiState, result: MviResult) :
        RuntimeException("Cannot reduce state: $state with result: $result")