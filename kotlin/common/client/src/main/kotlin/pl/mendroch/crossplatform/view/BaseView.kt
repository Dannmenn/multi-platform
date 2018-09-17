package pl.mendroch.crossplatform.view

import kotlinx.coroutines.experimental.Job

abstract class BaseView {
    var jobs: List<Job> = emptyList()

    open fun onCreate() {}
    open fun showError(message: String?) {
        println(message)
    }

    protected open fun onDestroy() {}

    fun preDestroy() {
        jobs.filter { !it.isCancelled }.forEach { it.cancel(Error("BaseView.preDestroy")) }
        onDestroy()
    }
}