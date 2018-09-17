package pl.mendroch.crossplatform.desktop.view.list

import javafx.collections.FXCollections.observableArrayList
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.javafx.JavaFx
import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.desktop.utils.HttpUtil
import pl.mendroch.crossplatform.respositories.ListDataProvider
import pl.mendroch.crossplatform.view.list.ListView
import tornadofx.*

class DesktopListView : View("List view") {
    private val api: HttpUtil by inject()
    private val view = ListView(Dispatchers.JavaFx, ListDataProvider(api), this::showList)
    private val data = observableArrayList<ListObject>()
    override val root = listview(data) {
        onDoubleClick {
            if (selectedItem != null) {
                ListObjectForm(selectedItem!!).openModal()
            }
        }
        cellFragment(ListFragment::class)
    }

    init {
        view.onCreate()
    }

    private fun showList(list: Array<ListObject>) {
        data.setAll(list.asList())
    }
}