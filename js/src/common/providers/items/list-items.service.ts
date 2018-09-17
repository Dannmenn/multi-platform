import {Injectable} from '@angular/core';
import {Api} from '..';

@Injectable()
export class ListItems {

    constructor(public api: Api) {
    }

    query(params?: any) {
        return this.api.get('/data/list', params);
    }
}
