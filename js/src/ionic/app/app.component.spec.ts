import {async, TestBed} from '@angular/core/testing';
import {IonicModule} from 'ionic-angular';

import {MyApp} from './app.component';
import {TranslateFakeLoader, TranslateLoader, TranslateModule} from "@ngx-translate/core";
import {HttpClientModule} from "@angular/common/http";

describe('MyApp Component', () => {
    let fixture;
    let component;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [MyApp],
            imports: [
                HttpClientModule,
                TranslateModule.forRoot({
                    loader: {provide: TranslateLoader, useClass: TranslateFakeLoader}
                }),
                IonicModule.forRoot(MyApp)
            ],
            providers: []
        })
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(MyApp);
        component = fixture.componentInstance;
    });

    it('should be created', () => {
        expect(component instanceof MyApp).toBe(true);
    });

    it('should have two pages', () => {
        expect(component.pages.length).toBe(1);
    });

});