package pl.mendroch.crossplatform.view.table

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import pl.mendroch.crossplatform.common.model.TableObject
import pl.mendroch.crossplatform.respositories.TableDataProvider
import pl.mendroch.crossplatform.view.BaseView
import kotlin.coroutines.experimental.CoroutineContext

class TableView(
        private val uiContext: CoroutineContext,
        private val dataProvider: TableDataProvider,
        private val showTable: (Array<TableObject>) -> Unit
) : BaseView() {
    override fun onCreate() {
        jobs += GlobalScope.launch {
            try {
                val data = dataProvider.getData().list
                GlobalScope.launch(uiContext) {
                    showTable(data)
                }
            } catch (e: Throwable) {
                showError(e.message)
            }
        }
    }
}