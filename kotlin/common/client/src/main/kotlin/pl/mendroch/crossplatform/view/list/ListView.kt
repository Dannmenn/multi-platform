package pl.mendroch.crossplatform.view.list

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.respositories.ListDataProvider
import pl.mendroch.crossplatform.view.BaseView
import kotlin.coroutines.experimental.CoroutineContext

class ListView(
        private val uiContext: CoroutineContext,
        private val dataProvider: ListDataProvider,
        private val showList: (Array<ListObject>) -> Unit
) : BaseView() {
    override fun onCreate() {
        jobs += GlobalScope.launch {
            try {
                val list = dataProvider.getData().list
                GlobalScope.launch(uiContext) {
                    showList(list)
                }
            } catch (e: Throwable) {
                showError(e.message)
            }
        }
    }
}