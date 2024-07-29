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
  <v-app>
    <div>
      <header>
        <h1>로그인 페이지</h1>
        <hr/>
      </header>
      <v-card
        class="mx-auto pa-12 pb-8"
        elevation="8"
        max-width="448"
        width="448"
        rounded="lg"
      >
        <h2>로그인</h2>
        <v-text-field
          id="text-field-id"
          label="ID"
          v-model="inputId"
          density="compact"
          class="w-100"
        />
        <v-text-field
          label="password"
          v-model="inputPassword"
          type="password"
          density="compact"
        />
        <v-btn
          class="mb-8"
          color="blue"
          size="large"
          variant="tonal"
          block
          @click="loginButton"
        >
          로그인
        </v-btn>
      </v-card>
      <div>
        <p>Access_Token: {{ store.getters.getAccessToken() }}</p>
        <p>Refresh_Token: {{ store.getters.getRefreshToken() }}</p>
      </div>
      <p>
        <a href="" target="_blank">게스트로 오셨다면?</a>
      </p>
    </div>
  </v-app>
</template>

<style>
</style>
