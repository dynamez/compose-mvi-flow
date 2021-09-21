package com.rayout.mvi.flow

import com.rayout.mvi.events.MviUiState
import com.rayout.mvi.events.MviUserIntent
import kotlinx.coroutines.flow.Flow

interface MviPresentation<TUserIntent: MviUserIntent, TUiState: MviUiState> {

    fun processUserIntentsAndObserveUiStates(userIntents: Flow<TUserIntent>): Flow<TUiState>

}