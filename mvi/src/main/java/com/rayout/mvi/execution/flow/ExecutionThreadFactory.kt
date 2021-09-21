package com.rayout.mvi.execution.flow

import com.rayout.mvi.execution.ExecutionThreadEnvironment
import com.rayout.mvi.execution.ExecutionThreadEnvironment.APPLICATION
import com.rayout.mvi.execution.ExecutionThreadEnvironment.TESTING
import com.rayout.mvi.execution.flow.AppExecutionThread
import com.rayout.mvi.execution.flow.ExecutionThread

object ExecutionThreadFactory {

    fun makeExecutionThread(environment: ExecutionThreadEnvironment): ExecutionThread =
        when (environment) {
            APPLICATION -> AppExecutionThread()
            TESTING -> AppExecutionThread()
        }

}