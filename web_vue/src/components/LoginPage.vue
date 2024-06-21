<script setup>
  import {store} from "@/store/index.js";

  function loginButton() {
    store.commit('FETCH_STATE')
  }
</script>

<template>
  <header>
    <h1>LOGIN PAGE</h1>
    <hr>
  </header>
  <div>
    <fieldset>
      <legend>
        <h2>로그인</h2>
      </legend>
      <div>
        <h3>
          ID: <input>
        </h3>
      </div>
      <div>
        <h3>
          Password: <input>
        </h3>
      </div>
      <button @click="loginButton">로그인</button>
    </fieldset>
  </div>
</template>