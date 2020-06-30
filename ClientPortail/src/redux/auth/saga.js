
import { all, call, fork, put, takeEvery } from 'redux-saga/effects';
//import { auth } from '../../helpers/Firebase';
import { login, signup } from "./auth"
import axios from 'axios'
import { ACCESS_TOKEN } from '../../constants/defaultValues'

import {
    LOGIN_USER,
    REGISTER_USER,
    LOGOUT_USER,
    FORGOT_PASSWORD,
    RESET_PASSWORD,
} from '../actions';

import {
    loginUserSuccess,
    loginUserError,
    registerUserSuccess,
    registerUserError,
    forgotPasswordSuccess,
    forgotPasswordError,
    resetPasswordSuccess,
    resetPasswordError
} from './actions';


export function* watchLoginUser() {
    yield takeEvery(LOGIN_USER, loginWithEmailPassword);
}

/*const loginWithEmailPasswordAsync = async (email, password) =>
    await auth.signInWithEmailAndPassword(email, password)
        .then(authUser => authUser)
        .catch(error => error);
*/


function* loginWithEmailPassword({ payload }) {
    const { email, password } = payload.user;
    const { history } = payload;
    try {
        
        //const loginUser = yield call(loginWithEmailPasswordAsync, email, password);
        debugger;
        const loginUser = yield call(login , { 
            "email": email, 
            "password": password
        }) 
        debugger;
        // Hard coded values smell. But this should do it.
        console.log(loginUser.user) 
       /// console.log(loginUser.user.authorities[0].authority);
        if (!loginUser.message) {
           // localStorage.setItem('user_id', loginUser.user.uid);
            localStorage.setItem(ACCESS_TOKEN, loginUser.accessToken);
           // localStorage.setItem('tokenType',loginUser.tokenType)
            localStorage.setItem('Role' ,loginUser.user.authorities[0].authority)
            yield put(loginUserSuccess(loginUser.user));
            console.log(loginUser.user)
           
            
            history.push('/');
            window.location.reload(true);
        } else {
            yield put(loginUserError(loginUser.message));
        }
    } catch (error) {
        yield put(loginUserError(error));

    }
}


export function* watchRegisterUser() {
    yield takeEvery(REGISTER_USER, registerWithEmailPassword);
}

/*
const registerWithEmailPasswordAsync = async (email, password) =>
    await auth.createUserWithEmailAndPassword(email, password)
        .then(authUser => authUser)
        .catch(error => error);
*/

function* registerWithEmailPassword({ payload }) {
    debugger;
    const { email, password, name, role } = payload.user;
    const { history } = payload
    console.log(payload.user)
    try {
        const registerUser = yield call(signup , { 
            "email": email,
            "password": password,
            "name": name,
             "role": role 
        });
        console.log(role)

        if (!registerUser.message) {
           // localStorage.setItem('user_id', registerUser.user.uid);
           // localStorage.setItem(ACCESS_TOKEN, registerUser.token);
            yield put(registerUserSuccess(registerUser.user));
           // yield put(loginUserSuccess(registerUser.user));
           console.log("this user is added")
           axios.post("http://localhost:8080/feedback",{"name":name,"password":password,"email":email}).then(
               response=>{console.log(response)
               })
           
            history.push('/user/login')
        } else {
            yield put(registerUserError(registerUser.message));
        }
    } catch (error) {
        yield put(registerUserError(error));
    }
}



export function* watchLogoutUser() {
    yield takeEvery(LOGOUT_USER, logout);
}

/*
const logoutAsync = async (history) => {
    await auth.signOut().then(authUser => authUser).catch(error => error);
    history.push('/')
}
*/

function* logout({ payload }) {
    const { history } = payload
    try {
        // yield call(logoutAsync, history);
        localStorage.removeItem('user_id');
       // localStorage.removeItem('token');
        localStorage.removeItem(ACCESS_TOKEN);
        localStorage.removeItem('Role')

        history.push('/user/login')
    } catch (error) {
    }
}

export function* watchForgotPassword() {
    yield takeEvery(FORGOT_PASSWORD, forgotPassword);
}

/*
const forgotPasswordAsync = async (email) => {
    return await auth.sendPasswordResetEmail(email)
        .then(user => user)
        .catch(error => error);
}
*/

function* forgotPassword({ payload }) {
    const { email } = payload.forgotUserMail;
    try {
        /*
        const forgotPasswordStatus = yield call(forgotPasswordAsync, email);
        if (!forgotPasswordStatus) {
            yield put(forgotPasswordSuccess("success"));
        } else {
            yield put(forgotPasswordError(forgotPasswordStatus.message));
        }
        */
    } catch (error) {
        yield put(forgotPasswordError(error));

    }
}

export function* watchResetPassword() {
    yield takeEvery(RESET_PASSWORD, resetPassword);
}

/*
const resetPasswordAsync = async (resetPasswordCode, newPassword) => {
    return await auth.confirmPasswordReset(resetPasswordCode, newPassword)
        .then(user => user)
        .catch(error => error);
}
*/

function* resetPassword({ payload }) {
    const { newPassword, resetPasswordCode } = payload;
    try {
        /*
        const resetPasswordStatus = yield call(resetPasswordAsync, resetPasswordCode, newPassword);
        if (!resetPasswordStatus) {
            yield put(resetPasswordSuccess("success"));
        } else {
            yield put(resetPasswordError(resetPasswordStatus.message));
        }
        */
    } catch (error) {
        yield put(resetPasswordError(error));

    }
}

export default function* rootSaga() {
    yield all([
        fork(watchLoginUser),
        fork(watchLogoutUser),
        fork(watchRegisterUser),
        fork(watchForgotPassword),
        fork(watchResetPassword),
    ]);
}