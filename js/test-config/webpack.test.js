const webpack = require('webpack');
const path = require('path');

module.exports = {
    devtool: 'inline-source-map',

    resolve: {
        extensions: ['.ts', '.js', '.json'],
        modules: [path.resolve('node_modules')]
    },

    module: {
        rules: [{
            test: /\.ts$/,
            loaders: [{
                loader: 'ts-loader'
            }, 'angular2-template-loader']
        },
            {
                test: /.+\.ts$/,
                exclude: /(index.ts|mocks.ts|\.spec\.ts$)/,
                loader: 'istanbul-instrumenter-loader',
                enforce: 'post',
                query: {
                    esModules: true
                }
            },
            {
                test: /\.html$/,
                loader: 'html-loader?attrs=false'
            },
            {
                test: /\.(png|jpe?g|gif|svg|woff|woff2|ttf|eot|ico)$/,
                loader: 'null-loader'
            }
        ]
    }
};

function root(localPath) {
    return path.resolve(__dirname, localPath);
}