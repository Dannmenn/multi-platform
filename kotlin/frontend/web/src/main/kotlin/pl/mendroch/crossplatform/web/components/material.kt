@file:JsModule("@material-ui/core")

package pl.mendroch.crossplatform.web.components


import org.w3c.dom.events.Event
import react.Component
import react.RProps
import react.RState
import react.ReactElement

@JsName("Icon")
external class MaterialIcon : Component<MaterialIconProps, RState> {
    override fun render(): ReactElement?
}

external interface MaterialIconProps : RProps {
    var color: String //enum: 'inherit', 'primary', 'secondary', 'action', 'error', 'disabled'
}

@JsName("Button")
external class MaterialButton : Component<MaterialButtonProps, RState> {
    override fun render(): ReactElement?
}

external interface MaterialButtonProps : RProps {
    var id: String?
    var variant: String //enum: 'text', 'flat', 'outlined', 'contained', 'raised', 'fab', 'extendedFab'
    var size: String //enum: 'small', 'medium', 'large'
    var href: String
    var color: String //enum: 'default', 'inherit', 'primary', 'secondary'
    var onClick: () -> Unit
}

@JsName("TextField")
external class MaterialTextField : Component<MaterialTextFieldProps, RState> {
    override fun render(): ReactElement?
}

external interface MaterialTextFieldProps : RProps {
    var onChange: (e: Event) -> Unit
    var id: String
    var value: String
    var label: String
    var rows: Int
    var multiline: Boolean
    var fullWidth: Boolean
    var margin: String
}

@JsName("BottomNavigation")
external class MaterialBottomNavigation : Component<MaterialBottomNavigationProps, RState> {
    override fun render(): ReactElement?
}

external interface MaterialBottomNavigationProps : RProps {
    var onChange: (e: Event, value: Any) -> Unit
    var className: String
    var showLabels: Boolean
    var value: Any
}

@JsName("BottomNavigationAction")
external class MaterialBottomNavigationAction : Component<MaterialBottomNavigationActionProps, RState> {
    override fun render(): ReactElement?
}

external interface MaterialBottomNavigationActionProps : RProps {
    var icon: Any
    var label: Any
    var showLabel: Boolean
    var value: Any
}

@JsName("Paper")
external class MaterialPaper : Component<MaterialPaperProps, RState> {
    override fun render(): ReactElement?
}

external interface MaterialPaperProps : RProps {
    var elevation: Int
}

@JsName("AppBar")
external class MaterialAppBar : Component<MaterialAppBarProps, RState> {
    override fun render(): ReactElement?
}

external interface MaterialAppBarProps : RProps {
    var color: String //enum: 'inherit' | 'primary' | 'secondary' | 'default'
    var position: String //enum: 'fixed', 'absolute', 'sticky', 'static', 'relative'
}

@JsName("Toolbar")
external class MaterialToolbar : Component<RProps, RState> {
    override fun render(): ReactElement?
}