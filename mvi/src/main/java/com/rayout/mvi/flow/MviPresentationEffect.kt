package com.rayout.mvi.flow

import com.rayout.mvi.events.MviEffect
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.SharedFlow

@Suppress("USELESS_CAST")
@FlowPreview
@ExperimentalCoroutinesApi
interface MviPresentationEffect<TUiEffect : MviEffect> {
    fun uiEffect(): SharedFlow<TUiEffect>
}