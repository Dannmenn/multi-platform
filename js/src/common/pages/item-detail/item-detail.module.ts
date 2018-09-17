import {NgModule} from '@angular/core';
import {TranslateModule} from '@ngx-translate/core';
import {IonicPageModule} from 'ionic-angular';

import {ItemDetailPage} from './item-detail';
import {ItemObjectModule} from "../../components/item-object/item-object.module";

@NgModule({
    declarations: [
        ItemDetailPage,
    ],
    imports: [
        IonicPageModule.forChild(ItemDetailPage),
        TranslateModule.forChild(),
        ItemObjectModule
    ],
    exports: [
        ItemDetailPage
    ]
})
export class ItemDetailPageModule {
}
