package pl.mendroch.crossplatform.desktop.view

import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections.observableArrayList
import javafx.util.Callback
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.javafx.JavaFx
import org.controlsfx.control.table.TableFilter
import pl.mendroch.crossplatform.common.model.TableObject
import pl.mendroch.crossplatform.desktop.utils.HttpUtil
import pl.mendroch.crossplatform.respositories.TableDataProvider
import pl.mendroch.crossplatform.view.table.TableView
import tornadofx.*

class TableObjectView : View("Table View") {
    private val api: HttpUtil by inject()
    private val view = TableView(Dispatchers.JavaFx, TableDataProvider(api), this::showTable)
    private val objects = observableArrayList<TableObject>()
    override val root = tableview(objects) {
        readonlyColumn("id", TableObject::_id)
        readonlyColumn("index", TableObject::index)
        readonlyColumn("guid", TableObject::guid)
        readonlyColumn("isActive", TableObject::isActive)
        readonlyColumn("balance", TableObject::balance)
        readonlyColumn("age", TableObject::age)
        readonlyColumn("eyeColor", TableObject::eyeColor)
        readonlyColumn("name", TableObject::name)
        readonlyColumn("gender", TableObject::gender)
        readonlyColumn("company", TableObject::company)
        readonlyColumn("email", TableObject::email)
        readonlyColumn("phone", TableObject::phone)
        readonlyColumn("address", TableObject::address)
        readonlyColumn("about", TableObject::about)
        readonlyColumn("registered", TableObject::about) {
            cellValueFactory = Callback {
                val stringProperty = SimpleObjectProperty<String>()
                stringProperty.value = it.value.registered.toDateFormatString()
                stringProperty
            }
        }
        readonlyColumn("latitude", TableObject::latitude)
        readonlyColumn("longitude", TableObject::longitude)
        readonlyColumn("tags", TableObject::about) {
            cellValueFactory = Callback {
                val stringProperty = SimpleObjectProperty<String>()
                stringProperty.value = it.value.tags.joinToString(", ")
                stringProperty
            }
        }

        TableFilter.forTableView(this).apply()
    }

    init {
        view.onCreate()
    }

    private fun showTable(list: Array<TableObject>) {
        objects.setAll(list.asList())
    }
}
