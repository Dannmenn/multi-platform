import {Component, ViewChild} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import {Nav} from 'ionic-angular';

@Component({
    template: `
        <ion-nav #content [root]="rootPage"></ion-nav>`
})
export class MyApp {
    rootPage = 'ListMasterPage';

    @ViewChild(Nav) nav: Nav;

    pages: any[] = [
        {title: 'List Page', component: 'ListMasterPage'},
        {title: 'Table Page', component: 'TablePage'},
        {title: 'Download Page', component: 'ContentPage'},
    ];

    constructor(private translate: TranslateService) {
        this.initTranslate();
        require('electron').ipcRenderer.on('openPage', (event, message) => {
            this.nav.setRoot(message);
        })
    }

    initTranslate() {
        this.translate.setDefaultLang('en');
        const browserLang = this.translate.getBrowserLang();

        if (browserLang) {
            this.translate.use(browserLang);
        } else {
            this.translate.use('en');
        }
    }

    openPage(page) {
        this.nav.setRoot(page.component);
    }
}
