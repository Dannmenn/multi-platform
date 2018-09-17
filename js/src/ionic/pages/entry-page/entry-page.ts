import {Component} from '@angular/core';
import {IonicPage} from 'ionic-angular';
import {Tab1Root, Tab2Root, Tab3Root} from "../../../common/pages";

@IonicPage()
@Component({
    selector: 'entry-page',
    templateUrl: 'entry-page.html'
})
export class EntryPage {
    tab1: any = Tab1Root;
    tab2: any = Tab2Root;
    tab3: any = Tab3Root;

    title1 = "List";
    title2 = "Table";
    title3 = "Download";
}
