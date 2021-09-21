package com.rayout.mvi.execution.flow

import kotlinx.coroutines.CoroutineDispatcher

interface ExecutionThread {

    fun uiThread(): CoroutineDispatcher

    fun ioThread(): CoroutineDispatcher

}