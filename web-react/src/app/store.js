import {configureStore} from '@reduxjs/toolkit'
import tokenReducer from '../features/login/loginSlice';

export default configureStore({
    reducer: {
        token: tokenReducer
    }
});