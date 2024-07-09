import {createApp} from 'vue'
import App from './App.vue'
import store from './store'

//  Vue Application Setting
createApp(App)
    .use(store)
    .mount('#app')
;
