<script setup>

import store from "@/store/index.js";
import {ref} from "vue";

const inputId = ref('');
const inputPassword = ref('');

function loginButton() {
  if (inputId.value === '' || inputPassword.value === '') {
    alert('아이디 또는 패스워드를 입력해주세요.')
    return;
  }
  store.dispatch('REQUEST_LOGIN', {
    id: inputId.value,
    password: inputPassword.value
  });
}
</script>

<template>
  <header>
    <h1>LOGIN PAGE</h1>
    <hr>
  </header>
  <main>
    <div>
      <fieldset>
        <legend>
          <h2>로그인</h2>
        </legend>
        <div>
          <h3>
            <input v-model="inputId" placeholder="ID">
          </h3>
        </div>
        <div>
          <h3>
            <input type="password" v-model="inputPassword" placeholder="Password">
          </h3>
        </div>
        <button @click="loginButton">로그인</button>
      </fieldset>
      <div>
        <p>Access_Token: {{store.getters.getAccessToken()}}</p>
        <p>Refresh_Token: {{store.getters.getRefreshToken()}}</p>
      </div>
      <p>
        <a href="" target="_blank">게스트로 오셨다면?</a>
      </p>
    </div>
  </main>
</template>