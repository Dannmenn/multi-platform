import {Component} from '@angular/core';
import {IonicPage} from 'ionic-angular';
import {Item} from "../../models/item";
import {TableItems} from "../../providers";

@IonicPage()
@Component({
    selector: 'slider',
    templateUrl: 'slider.html'
})
export class SliderPage {
    slides: Item[] = [];

    constructor(public items: TableItems) {
        let observable = this.items.query();
        observable
            .subscribe(data => {
                this.slides = [...data["list"]]
            })
    }
}
