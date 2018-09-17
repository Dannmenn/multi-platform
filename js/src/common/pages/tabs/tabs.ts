import {Component} from '@angular/core';
import {IonicPage, NavController} from 'ionic-angular';

import {Tab1Root, Tab2Root, Tab3Root} from '../index';

@IonicPage()
@Component({
    selector: 'page-tabs',
    templateUrl: 'tabs.html'
})
export class TabsPage {
    tab1Root: any = Tab1Root;
    tab2Root: any = Tab2Root;
    tab3Root: any = Tab3Root;

    tab1Title = "List";
    tab2Title = "Table";
    tab3Title = "Download";

    constructor(public navCtrl: NavController) {
    }
}
