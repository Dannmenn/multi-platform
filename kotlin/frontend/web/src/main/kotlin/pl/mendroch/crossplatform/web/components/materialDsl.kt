package pl.mendroch.crossplatform.web.components

import react.RBuilder
import react.RHandler
import react.RProps

fun RBuilder.materialIcon(handler: RHandler<MaterialIconProps>) = child(MaterialIcon::class) {
    attrs {
        color = "inherit"
    }
    handler()
}

fun RBuilder.materialButton(handler: RHandler<MaterialButtonProps>) = child(MaterialButton::class) {
    attrs {
        this.variant = "text"
        this.size = "medium"
        this.color = "default"
    }
    handler()
}

fun RBuilder.materialTextField(handler: RHandler<MaterialTextFieldProps>) = child(MaterialTextField::class) {
    attrs { margin = "normal" }
    handler()
}

fun RBuilder.materialBottomNavigation(handler: RHandler<MaterialBottomNavigationProps>) = child(MaterialBottomNavigation::class) {
    attrs {
        this.showLabels = true
    }
    handler()
}

fun RBuilder.materialBottomNavigationAction(handler: RHandler<MaterialBottomNavigationActionProps>) = child(MaterialBottomNavigationAction::class) {
    attrs {
        this.showLabel = true
    }
    handler()
}

fun RBuilder.materialPaper(handler: RHandler<MaterialPaperProps>) = child(MaterialPaper::class) {
    attrs {
        elevation = 2
    }
    handler()
}

fun RBuilder.materialAppBar(handler: RHandler<MaterialAppBarProps>) = child(MaterialAppBar::class) {
    attrs {
        color = "default"
        position = "static"
    }
    handler()
}

fun RBuilder.materialToolbar(handler: RHandler<RProps>) = child(MaterialToolbar::class) { handler() }