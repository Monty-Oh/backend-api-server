import {configureStore} from '@reduxjs/toolkit'
import tokenReducer from '../features/auth/authSlice';

export default configureStore({
    reducer: {
        token: tokenReducer
    },

});