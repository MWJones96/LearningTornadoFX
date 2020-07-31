import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.*

class MyApp: App(MyView::class)

class MyView: View() {
    val controller: MyController by inject()

    override val root = vbox {
        val textField = textfield()
        button("Update Text") {
            action {
                runAsync {
                    controller.loadText()
                } ui { loadedText ->
                    textField.text = loadedText
                }
            }
        }
    }
}

class MyController: Controller() {
    fun loadText(): String {
        return "Asynchronous text"
    }
}

fun main(args: Array<String>) {
    launch<MyApp>(args)
}