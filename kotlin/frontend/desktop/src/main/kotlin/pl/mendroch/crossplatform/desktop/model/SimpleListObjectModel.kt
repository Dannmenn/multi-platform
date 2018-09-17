package pl.mendroch.crossplatform.desktop.model

import javafx.beans.property.SimpleStringProperty
import pl.mendroch.crossplatform.common.model.ListObject
import tornadofx.*

class SimpleListObjectModel : ItemViewModel<ListObject>() {
    val company = bind(ListObject::company)
    val name = bind(ListObject::name)
    val phone = bind(ListObject::phone)
    val email = bind(ListObject::email)
    val registered = bind(ListObject::registered)
    val date = SimpleStringProperty()

    init {
        registered.onChange {
            date.value = it?.toDateFormatString() ?: ""
        }
    }
}
