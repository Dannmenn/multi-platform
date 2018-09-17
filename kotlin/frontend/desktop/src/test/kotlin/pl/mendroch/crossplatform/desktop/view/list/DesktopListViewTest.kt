package pl.mendroch.crossplatform.desktop.view.list

import org.junit.Test
import kotlin.test.expect

class DesktopListViewTest {
    @Test
    fun validateTitle() {
        val test = DesktopListView()
        expect("List view") { test.title }
    }
}