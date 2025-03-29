package com.example.myapp.data.repositories

interface CounterRepository {
    suspend fun incrementCount(current: Int): Int
    suspend fun getCurrentCount(): Int
}