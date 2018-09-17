import {Component, ViewChild} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import {Nav} from 'ionic-angular';

@Component({
    template: `
        <ion-nav #content [root]="rootPage"></ion-nav>`
})
export class MyApp {
    rootPage = "EntryPage";

    @ViewChild(Nav) nav: Nav;

    pages: any[] = [
        {title: 'Entry Page', component: 'EntryPage'}
    ];

    constructor(private translate: TranslateService) {
        this.initTranslate();
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
        // Reset the content nav to have just this page
        // we wouldn't want the back button to show in this scenario
        this.nav.setRoot(page.component);
    }
}
