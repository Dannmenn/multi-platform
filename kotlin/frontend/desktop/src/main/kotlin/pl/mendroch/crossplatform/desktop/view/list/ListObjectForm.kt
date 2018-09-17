package pl.mendroch.crossplatform.desktop.view.list

import javafx.beans.property.SimpleObjectProperty
import javafx.scene.control.Label
import javafx.util.converter.DoubleStringConverter
import javafx.util.converter.IntegerStringConverter
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.javafx.JavaFx
import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.desktop.model.ListObjectModel
import pl.mendroch.crossplatform.desktop.utils.HttpUtil
import pl.mendroch.crossplatform.respositories.ListDataProvider
import pl.mendroch.crossplatform.view.list.ListObjectView
import tornadofx.*

class ListObjectForm(item: ListObject) : View("List Object view") {
    private val api: HttpUtil by inject()
    private val view = ListObjectView(Dispatchers.JavaFx, item._id, ListDataProvider(api), this::showObject)
    private val valueProperty = SimpleObjectProperty<ListObject>()
    private val model = ListObjectModel(valueProperty)

    override val root = vbox {
        prefWidth = 600.0
        prefHeight = 600.0
        style {
            padding = box(5.px)
        }
        val op: Label.() -> Unit = {
            style {
                padding = box(5.px)
            }
        }
        hbox {
            vbox {
                label("id", op = op)
                label(model._id, op = op)
            }
            vbox {
                label("index", op = op)
                label(model.index, op = op, converter = IntegerStringConverter())
            }
        }
        hbox {
            vbox {
                label("name", op = op)
                label(model.name, op = op)
            }
            vbox {
                label("company", op = op)
                label(model.company, op = op)
            }
            vbox {
                label("email", op = op)
                label(model.email, op = op)
            }
        }
        hbox {
            vbox {
                label("balance", op = op)
                label(model.balance, op = op)
            }
            vbox {
                label("age", op = op)
                label(model.age, op = op, converter = IntegerStringConverter())
            }
            vbox {
                label("eyeColor", op = op)
                label(model.eyeColor, op = op)
            }
        }
        hbox {
            vbox {
                label("phone", op = op)
                label(model.phone, op = op)
            }
            vbox {
                label("address", op = op)
                label(model.address, op = op)
            }
            vbox {
                label("date", op = op)
                label(model.date, op = op)
            }
        }
        hbox {
            vbox {
                label("latitude", op = op)
                label(model.latitude, op = op, converter = DoubleStringConverter())
            }
            vbox {
                label("longitude", op = op)
                label(model.longitude, op = op, converter = DoubleStringConverter())
            }
            vbox {
                label("tags", op = op)
                label(model.tags, op = op)
            }
        }
        vbox {
            label("about", op = op)
            label(model.about, op = op)
        }
        button("Close") {
            action { close() }
        }
    }

    init {
        view.onCreate()
    }

    private fun showObject(valueObject: ListObject) {
        valueProperty.value = valueObject
    }
}