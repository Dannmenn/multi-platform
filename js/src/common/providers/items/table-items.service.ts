import {Injectable} from '@angular/core';
import {Api} from '..';

@Injectable()
export class TableItems {

    constructor(public api: Api) {
    }

    query(params?: any) {
        return this.api.get('/data/table', params);
    }
}
