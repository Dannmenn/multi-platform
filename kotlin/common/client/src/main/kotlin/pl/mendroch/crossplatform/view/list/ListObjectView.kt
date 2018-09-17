package pl.mendroch.crossplatform.view.list

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.respositories.ListDataProvider
import pl.mendroch.crossplatform.view.BaseView
import kotlin.coroutines.experimental.CoroutineContext

class ListObjectView(
        private val uiContext: CoroutineContext,
        private val id: String,
        private val dataProvider: ListDataProvider,
        private val showObject: (ListObject) -> Unit
) : BaseView() {
    override fun onCreate() {
        jobs += GlobalScope.launch {
            try {
                val value = dataProvider.getObject(id)
                GlobalScope.launch(uiContext) {
                    showObject(value)
                }
            } catch (e: Throwable) {
                showError(e.message)
            }
        }
    }
}