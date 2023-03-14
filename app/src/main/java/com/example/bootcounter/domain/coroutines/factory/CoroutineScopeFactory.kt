package com.example.bootcounter.domain.coroutines.factory

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class CoroutineScopeFactory {

    fun create(): CoroutineScope = CoroutineScope(Dispatchers.IO)

}