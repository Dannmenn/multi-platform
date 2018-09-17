package pl.mendroch.crossplatform.desktop.view

import javafx.scene.control.TextInputControl
import javafx.scene.input.Clipboard
import javafx.scene.input.KeyCode.C
import javafx.scene.input.KeyCode.V
import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.KeyCombination.CONTROL_DOWN
import javafx.stage.FileChooser
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import pl.mendroch.crossplatform.desktop.utils.HttpUtil
import pl.mendroch.crossplatform.desktop.utils.copyToClipboard
import pl.mendroch.crossplatform.respositories.BigFileProviderImpl
import pl.mendroch.crossplatform.respositories.FileProviderImpl
import pl.mendroch.crossplatform.respositories.SmallFileProviderImpl
import tornadofx.*
import java.nio.file.Files

class ApplicationView : View("List view") {
    private val api: HttpUtil by inject()
    private val smallFileProvider = SmallFileProviderImpl(api)
    private val bigFileProvider = BigFileProviderImpl(api)
    override val root = borderpane {
        top {
            prefHeight = 25.0
            menubar {
                menu("File") {
                    item("Quit") {
                        action {
                            close()
                        }
                    }
                }
                menu("Edit") {
                    item("Copy", KeyCodeCombination(C, CONTROL_DOWN)) {
                        action {
                            copyToClipboard(scene.focusOwner)
                        }
                    }
                    item("Paste", KeyCodeCombination(V, CONTROL_DOWN)) {
                        action {
                            val systemClipboard = Clipboard.getSystemClipboard()
                            if (systemClipboard.hasString()) {
                                val focusOwner = scene.focusOwner
                                if (focusOwner is TextInputControl) {
                                    focusOwner.text = systemClipboard.string
                                }
                            }
                        }
                    }
                }
                menu("Download") {
                    item("Small File") {
                        action {
                            downloadFile(smallFileProvider)
                        }
                    }
                    item("Big File") {
                        action {
                            downloadFile(bigFileProvider)
                        }
                    }
                }
            }
        }
        center<MainContentView>()
        bottom<RestProgressBar>()
    }

    private fun downloadFile(provider: FileProviderImpl) {
        GlobalScope.launch {
            val downloadedFile = provider.getData()
            runLater {
                val allExtensions = arrayOf(FileChooser.ExtensionFilter("Excel file", "*.xlsx"))
                val chooseFile = chooseFile("Select place to save file", allExtensions, FileChooserMode.Save)
                if (!chooseFile.isEmpty()) {
                    Files.copy(downloadedFile, chooseFile.first().toPath())
                }
            }
        }
    }
}