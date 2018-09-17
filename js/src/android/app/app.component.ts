import {Component, ViewChild} from '@angular/core';
import {SplashScreen} from '@ionic-native/splash-screen';
import {StatusBar} from '@ionic-native/status-bar';
import {TranslateService} from '@ngx-translate/core';
import {Nav, Platform} from 'ionic-angular';
import {Api} from "../../common/providers";

@Component({
    template: `
        <ion-nav #content [root]="rootPage"></ion-nav>`
})
export class MyApp {
    rootPage = "MainView";

    @ViewChild(Nav) nav: Nav;

    pages: any[] = [
        {title: 'Main Page', component: 'MainView'}
    ];

    constructor(public api: Api, private translate: TranslateService, platform: Platform, private statusBar: StatusBar, private splashScreen: SplashScreen) {
        api.url = "http://10.0.2.2:8080/api/v1";
        platform.ready().then(() => {
            this.statusBar.styleDefault();
            this.splashScreen.hide();
        });
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
