package com.rayout.mvi.execution.rxjava

import com.rayout.mvi.execution.ExecutionThreadEnvironment
import com.rayout.mvi.execution.ExecutionThreadEnvironment.APPLICATION
import com.rayout.mvi.execution.ExecutionThreadEnvironment.TESTING

object ExecutionThreadFactory {

    fun makeExecutionThread(environment: ExecutionThreadEnvironment): ExecutionThread =
        when (environment) {
            APPLICATION -> AppExecutionThread()
            TESTING     -> FakeExecutionThread()
        }

}