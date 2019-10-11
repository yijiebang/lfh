'use strict'
const path = require('path')
const VuetifyLoaderPlugin = require('vuetify-loader/lib/plugin')
const { title } = require('./src/config/app')
function resolve(dir) {
  return path.join(__dirname, dir)
}

// https://cli.vuejs.org/config/
module.exports = {
  publicPath: '/lfh-life/',
  outputDir: 'dist',
  assetsDir: '',
  lintOnSave: false,
  productionSourceMap: false,
  devServer: {
    host: 'localhost',
    port: 3000,
    proxy: {
      // detail: https://cli.vuejs.org/config/#devserver-proxy
      '^/lfh': {
        target: 'http://share.tpddns.cn:8899/',
        changeOrigin: true
      }
    }
    // after: require('./mock/index.js')
  },
  configureWebpack: {
    name: title,
    resolve: {
      alias: {
        // 别名，例如在项目中  import foo from '@/components/foo' , 就是引入的 'src/components/foo'
        '@': resolve('src')
      }
    },
    plugins: [new VuetifyLoaderPlugin()]
  },
  css: {
    loaderOptions: {
      sass: {
        data: `
        @import "~@/styles/var.scss";
        @import "~@/styles/mixin.scss";
        `
      }
    }
  },
  chainWebpack(config) {
    config.plugins.delete('preload') // TODO: need test
    config.plugins.delete('prefetch') // TODO: need test

    // set preserveWhitespace
    config.module
      .rule('vue')
      .use('vue-loader')
      .loader('vue-loader')
      .tap(options => {
        options.compilerOptions.preserveWhitespace = true
        return options
      })
      .end()

    // config
    //   // https://webpack.js.org/configuration/devtool/#development
    //   .when(process.env.NODE_ENV === 'development', config =>
    //     config.devtool('cheap-source-map')
    //   )

    config.when(process.env.NODE_ENV !== 'development', config => {
      config
        .plugin('ScriptExtHtmlWebpackPlugin')
        .after('html')
        .use('script-ext-html-webpack-plugin', [
          {
            // `runtime` must same as runtimeChunk name. default is `runtime`
            inline: /runtime\..*\.js$/
          }
        ])
        .end()
      config.optimization.splitChunks({
        chunks: 'all',
        cacheGroups: {
          vue: {
            test: /[\\/]node_modules[\\/](vue|vue-router|vuex|axios)[\\/]/,
            name: 'vendor-vue',
            priority: 20, // 权重要大于上面的chunk-libs
            chunks: 'all'
          },
          ui: {
            test: /[\\/]node_modules[\\/]_?vuetify(.*)/,
            name: 'vendor-ui',
            priority: 20 // 权重要大于上面的chunk-libs
          },
          commons: {
            name: 'chunk-commons',
            test: resolve('src/components'),
            minChunks: 3, //  分割前必须共享模块的最小块数。
            priority: 5,
            reuseExistingChunk: true // 如果当前块包含已从主束拆分的模块，则将重用它而不是生成新的块。这可能会影响块的结果文件名。
          }
        }
      })
      config.optimization.runtimeChunk('single')
    })
  }
}
