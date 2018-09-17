package pl.mendroch.crossplatform

interface Provider<T> {
    suspend fun getData(): T
}