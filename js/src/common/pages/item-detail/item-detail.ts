import {Component} from '@angular/core';
import {IonicPage, NavController, NavParams} from 'ionic-angular';
import {Item} from "../../models/item";

@IonicPage()
@Component({
    selector: 'page-item-detail',
    templateUrl: 'item-detail.html'
})
export class ItemDetailPage {
    item: Item;

    constructor(public navCtrl: NavController, navParams: NavParams) {
        this.item = navParams.get('item') || {};
    }
}
