import {Component, Input} from '@angular/core';
import {Item} from "../../models/item";

@Component({
    selector: 'item-object',
    templateUrl: 'item-object.html'
})
export class ItemObjectComponent {
    @Input() item: Item;
}
