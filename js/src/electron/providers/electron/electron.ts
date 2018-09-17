import * as electron from 'electron';
import {Injectable} from '@angular/core';

@Injectable()
export class ElectronProvider {
    currentZoom: number = 0;

    constructor() {
    }

    zoomIn() {
        electron.webFrame.setZoomLevel(++this.currentZoom);
    }

    zoomOut() {
        electron.webFrame.setZoomLevel(--this.currentZoom);
    }

}
