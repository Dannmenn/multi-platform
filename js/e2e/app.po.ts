import {browser, by, element} from 'protractor';

export class Page {

    navigateTo(destination) {
        return browser.get(destination);
    }

    getTitle() {
        return browser.getTitle();
    }

    getActiveTabTitleText() {
        return element(by.tagName('entry-page')).element(by.css('a[aria-selected=true]')).getText();
    }
}