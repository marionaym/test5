<script setup>
import { reactive,onMounted } from "vue";

const emptyUser ={
    email:"",
    first_name:"",
    last_name:"", 
    password:"",
};

const data = reactive({
  user: {...emptyUser},
});

defineExpose({
  data,
});


function register(){
 const fetchOptions = {
 method: "POST",
 body:JSON.stringify( data.user), 
 headers: {
      "Content-Type": "application/json",
    },
 }; 
 fetch("http://localhost:8989/api/auth/signup", fetchOptions)
    .then((response)=>{
      return response.json();
    })
    .then((json)=>{
        data.user={...emptyUser};
    })
    .catch((error)=>console.log("register : " + error));
}

onMounted(()=>{register()});

</script>
<template>
    <div class="register">
    <form @submit.prevent="register">
        
        <h2><label id="register">Page d'inscription</label></h2>
        <label><b>Email</b></label>
        <input id="email" type="email" v-model="data.user.email" placeholder="Email"/>
        <label><b>Prénom</b></label>
        <input id="first_name" type="text" v-model="data.user.first_name" placeholder="Prénom"/>
        <label><b>Nom</b></label>
        <input id="last_name" type="text" v-model="data.user.last_name" placeholder="Nom"/>
        <label><b>Mot de passe</b></label>
        <input id="password" type="password" v-model="data.user.password" placeholder="Mot de passe"/>
        <input id="inscrire" type="submit" value="Inscrire">
    </form>
    </div>
</template>

