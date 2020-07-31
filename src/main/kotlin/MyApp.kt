import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.Parent
import javafx.stage.StageStyle
import tornadofx.*

class MyApp: App(MyView1::class)

class MyView1: View() {
    override val root = vbox {
        button("Go to View2") {
            action {
                replaceWith(MyView2::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.RIGHT))
            }
        }
    }

    override fun onDock() {
        println("Docking View1")
    }

    override fun onUndock() {
        println("Undocking View1")
    }
}

class MyView2: View() {
    override val root = vbox {
        button("Go to View1") {
            action {
                replaceWith(MyView1::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))
            }
        }
    }
    override fun onDock() {
        println("Docking View2")
    }

    override fun onUndock() {
        println("Undocking View2")
    }

}

fun main(args: Array<String>) {
    launch<MyApp>(args)
}