import {NgModule} from '@angular/core';
import {IonicPageModule} from 'ionic-angular';
import {TranslateModule} from '@ngx-translate/core';
import {SliderPage} from "./slider";
import {ItemObjectModule} from "../../components/item-object/item-object.module";

@NgModule({
    declarations: [
        SliderPage,
    ],
    imports: [
        IonicPageModule.forChild(SliderPage),
        TranslateModule.forChild(),
        ItemObjectModule
    ],
    exports: [
        SliderPage
    ]
})
export class SliderPageModule {
}
