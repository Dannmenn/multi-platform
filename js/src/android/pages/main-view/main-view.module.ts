import {NgModule} from '@angular/core';
import {TranslateModule} from '@ngx-translate/core';
import {IonicPageModule} from 'ionic-angular';
import {MainView} from "./main-view";

@NgModule({
    declarations: [
        MainView,
    ],
    imports: [
        IonicPageModule.forChild(MainView),
        TranslateModule.forChild()
    ],
    exports: [
        MainView
    ]
})
export class MainViewModule {
}
