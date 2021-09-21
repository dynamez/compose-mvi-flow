package com.rayout.mvi.rxjava

import com.rayout.mvi.events.MviUiState
import com.rayout.mvi.events.MviUserIntent
import io.reactivex.Observable

interface MviPresentation<TUserIntent: MviUserIntent, TUiState: MviUiState> {

    fun processUserIntents(userIntents: Observable<TUserIntent>)

    fun uiStates(): Observable<TUiState>

}