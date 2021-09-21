package com.rayout.mvi.rxjava

import com.rayout.mvi.events.MviUiState
import com.rayout.mvi.events.MviUserIntent
import io.reactivex.Observable

interface MviUi<TUserIntent: MviUserIntent, in TUiState: MviUiState> {

    fun userIntents(): Observable<TUserIntent>

    fun renderUiStates(uiState: TUiState)

}