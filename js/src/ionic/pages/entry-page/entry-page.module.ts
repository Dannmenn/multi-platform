import {NgModule} from '@angular/core';
import {TranslateModule} from '@ngx-translate/core';
import {IonicPageModule} from 'ionic-angular';
import {EntryPage} from "./entry-page";

@NgModule({
    declarations: [
        EntryPage,
    ],
    imports: [
        IonicPageModule.forChild(EntryPage),
        TranslateModule.forChild()
    ],
    exports: [
        EntryPage
    ]
})
export class EntryPageModule {
}
