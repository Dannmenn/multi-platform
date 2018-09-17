import {Component} from '@angular/core';
import {IonicPage, ModalController, NavController} from 'ionic-angular';

import {Item} from '../../models/item';
import {ListItems} from '../../providers';

@IonicPage()
@Component({
    selector: 'page-list-master',
    templateUrl: 'list-master.html'
})
export class ListMasterPage {
    currentItems: Item[] = [];

    constructor(public navCtrl: NavController, public items: ListItems, public modalCtrl: ModalController) {
        let observable = this.items.query();
        observable
            .subscribe(data => {
                this.currentItems = [...data["list"]]
            })
    }

    openItem(item: Item) {
        this.navCtrl.push('ItemDetailPage', {
            item: item
        });
    }
}
