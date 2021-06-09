<template>
  <v-app>
    <v-main>
      <v-app-bar
        elevate-on-scroll
        scroll-target="#scrolling"
        dark
      >
        <v-toolbar-title class=" display-1">Polaflix</v-toolbar-title>

        <v-spacer></v-spacer>
        <h2 class=" display-2">Bienvenido Usuario</h2>
        <v-spacer></v-spacer>
         <template 
          v-slot:extension>
        <v-tabs
         v-model="tab"
         align-with-title
         slider-size = "4"
         >
          <v-tabs-slider
           color="teal"
           />
          <v-tab to="/">Inicio</v-tab>
          <v-tab to="/about">Agregar Serie</v-tab>
          <v-tab to="/facturas">Facturas</v-tab>
          <v-tab v-show="isSelected" to="/verSerie"></v-tab>
        </v-tabs>
      </template>
      </v-app-bar>
      <router-view v-bind="myProps"></router-view>
      {{usuario}}
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  tab: null,
  
  data: () => ({
    usuario: null,
  }),
  created(){
      var self = this;
      this.axios.get("http://localhost:8080/api/usuarios/usr1").then((result) => {  
         self.usuario = result.data;
      });
  },
  computed:{
    myProps() {
      if (this.$route.name === 'Principal') { 
        let prop = this.usuario;
        return { prop: prop }
        }
      if(this.$route.name ==='Facturas'){
        let prop=[
          {
            facturas: this.usuario.facturas,
            vip:this.usuario.es_VIP
          }
        ]
         return { prop: prop }
        }
      else { return null}
    }
  }
 
};
</script>

<style>
.scale-enter-active,
.scale-leave-active {
  transition: all 0.5s ease;
}


.scale-enter-from,
.scale-leave-to {
  opacity: 0;
  transform: scale(0.9);
}
</style>
