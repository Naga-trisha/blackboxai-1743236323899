package com.example.myapp.data.repositories

import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor() : CounterRepository {
    private var currentCount = 0

    override suspend fun incrementCount(current: Int): Int {
        currentCount = current + 1
        return currentCount
    }

    override suspend fun getCurrentCount(): Int {
        return currentCount
    }
}