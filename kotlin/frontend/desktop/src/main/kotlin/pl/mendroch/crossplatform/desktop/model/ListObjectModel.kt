package pl.mendroch.crossplatform.desktop.model

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleStringProperty
import pl.mendroch.crossplatform.common.model.ListObject
import tornadofx.*

class ListObjectModel(property: ObjectProperty<ListObject>) : ItemViewModel<ListObject>(itemProperty = property) {
    val _id = bind(ListObject::_id)
    val index = bind(ListObject::index)
    val balance = bind(ListObject::balance)
    val age = bind(ListObject::age)
    val eyeColor = bind(ListObject::eyeColor)
    val name = bind(ListObject::name)
    val company = bind(ListObject::company)
    val email = bind(ListObject::email)
    val phone = bind(ListObject::phone)
    val address = bind(ListObject::address)
    val about = bind(ListObject::about)
    val dateProperty = bind(ListObject::registered)
    val date = SimpleStringProperty()
    val latitude = bind(ListObject::latitude)
    val longitude = bind(ListObject::longitude)
    val tagsProperty = bind(ListObject::tags)
    val tags = SimpleStringProperty()

    init {
        dateProperty.onChange {
            date.value = it?.toDateFormatString() ?: ""
        }
        tagsProperty.onChange {
            tags.value = it?.joinToString(", ") ?: ""
        }
    }
}
