import {IonicPage} from 'ionic-angular';
import {Item} from "../../../common/models/item";
import {TableItems} from "../../../common/providers";
import {Component, ViewChild} from '@angular/core';
import {DatatableComponent} from "@swimlane/ngx-datatable";

@IonicPage()
@Component({
    selector: 'table',
    templateUrl: 'table.html'
})
export class TablePage {
    columns: any = [{prop: "_id", name: "id"},
        {prop: "index"},
        {prop: "isActive"},
        {prop: "balance"},
        {prop: "age"},
        {prop: "eyeColor"},
        {prop: "name"},
        {prop: "gender"},
        {prop: "company"},
        {prop: "email"},
        {prop: "phone"},
        {prop: "address"},
        {prop: "registered"},
        {prop: "latitude"},
        {prop: "longitude"},
        {prop: "tags"}];
    rows: Item[] = [];
    temp: Item[] = [];

    @ViewChild(DatatableComponent) table: DatatableComponent;

    constructor(public items: TableItems) {
        let observable = this.items.query();
        observable
            .subscribe(data => {
                this.temp = [...data["list"]];
                this.rows = [...data["list"]];
                console.log(this.temp)
            })
    }

    updateFilter(event) {
        const val = event.target.value.toLowerCase();

        const temp = this.temp.filter(function (d) {
            return d.name.toLowerCase().indexOf(val) !== -1 || !val;
        });

        this.rows = temp;
        this.table.offset = 0;
    }
}
