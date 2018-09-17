import {HttpClient, HttpClientModule} from '@angular/common/http';
import {CUSTOM_ELEMENTS_SCHEMA, ErrorHandler, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {IonicApp, IonicErrorHandler, IonicModule} from 'ionic-angular';

import {Api, ListItems, TableItems} from '../../common/providers';
import {MyApp} from './app.component';

// The translate loader needs to know where to load i18n files
// in Ionic's static asset pipeline.
export function createTranslateLoader(http: HttpClient) {
    return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
    declarations: [
        MyApp
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        TranslateModule.forRoot({
            loader: {
                provide: TranslateLoader,
                useFactory: (createTranslateLoader),
                deps: [HttpClient]
            }
        }),
        IonicModule.forRoot(MyApp)
    ],
    bootstrap: [IonicApp],
    entryComponents: [
        MyApp
    ],
    providers: [
        Api,
        ListItems,
        TableItems,
        // Keep this to enable Ionic's runtime error handling during development
        {provide: ErrorHandler, useClass: IonicErrorHandler}
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule {
}
