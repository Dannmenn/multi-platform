import {NgModule} from '@angular/core';
import {TranslateModule} from '@ngx-translate/core';
import {IonicPageModule} from 'ionic-angular';

import {ContentPage} from './download';

@NgModule({
    declarations: [
        ContentPage,
    ],
    imports: [
        IonicPageModule.forChild(ContentPage),
        TranslateModule.forChild()
    ],
    exports: [
        ContentPage
    ]
})
export class ContentPageModule {
}
