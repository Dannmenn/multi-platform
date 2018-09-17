import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {IonicPageModule} from 'ionic-angular';
import {TranslateModule} from '@ngx-translate/core';
import {TablePage} from "./table";
import {ItemObjectModule} from "../../../common/components/item-object/item-object.module";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";

@NgModule({
    declarations: [
        TablePage,
    ],
    imports: [
        IonicPageModule.forChild(TablePage),
        TranslateModule.forChild(),
        ItemObjectModule,
        NgxDatatableModule
    ],
    exports: [
        TablePage
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TablePageModule {
}
