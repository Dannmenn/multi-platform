const electron = require('electron');
const {app} = electron;
const {BrowserWindow} = electron;
let win;

function createWindow() {
    win = new BrowserWindow({
        width: 1200,
        height: 800
    });
    let url = 'file://' + __dirname + '/../www_electron/index.html';
    win.loadURL(url);
    // Open the DevTools.
    win.webContents.openDevTools();
    win.on('closed', () => win = null);
    const {Menu} = require('electron');

    const template = [
        {
            label: 'Edit',
            submenu: [
                {role: 'undo'},
                {role: 'redo'},
                {type: 'separator'},
                {role: 'cut'},
                {role: 'copy'},
                {role: 'paste'}
            ]
        },
        {
            label: 'View',
            submenu: [
                {
                    label: "List",
                    click: () => win.webContents.send('openPage', 'ListMasterPage')
                },
                {
                    label: "Table",
                    click: () => win.webContents.send('openPage', 'TablePage')
                },
                {
                    label: "Download",
                    click: () => win.webContents.send('openPage', 'ContentPage')
                },
                {type: 'separator'},
                {role: 'reload'},
                {role: 'forcereload'},
                {role: 'toggledevtools'},
                {type: 'separator'},
                {role: 'resetzoom'},
                {role: 'zoomin'},
                {role: 'zoomout'},
                {type: 'separator'},
                {role: 'togglefullscreen'}
            ]
        },
        {
            role: 'window',
            submenu: [
                {role: 'minimize'},
                {role: 'close'}
            ]
        }
    ];

    const menu = Menu.buildFromTemplate(template);
    Menu.setApplicationMenu(menu)
}

app.on('ready', createWindow);
app.on('window-all-closed', () => app.quit());
app.on('activate', () => {
    if (win === null) {
        createWindow();
    }
});