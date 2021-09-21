package com.rayout.mvi

import com.rayout.mvi.events.MviResult
import com.rayout.mvi.events.MviUiState

interface MviReducer<TUiState : MviUiState, TResult: MviResult> {

    infix fun TUiState.reduceWith(result: TResult): TUiState

}