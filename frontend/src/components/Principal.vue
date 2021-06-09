<template>
    <v-container>
      <v-row dense>
        <v-col cols="7">
          <v-card
            elevation="24"          
          >
            <v-card-title class="text-h5">
              Pendientes
            </v-card-title>

            <v-card-subtitle>
              <v-list color="transparent">
                <v-list-item-group
                  color="teal"
                >
                  <v-list-item
                    v-for="(serieP, i) in seriesPendientes"
                    :key="i"
                    @click="mostrarSerie('pendiente',serieP)"
                  >
                    <v-list-item-content>
                      <v-list-item-title v-text="serieP.nombre"></v-list-item-title>
                      <v-divider class="mt-1"></v-divider>
                    </v-list-item-content>
                  </v-list-item>
                </v-list-item-group>
              </v-list>
            </v-card-subtitle>
          </v-card>
        </v-col>

        <v-col cols="7">
          <v-card
            elevation="24"
          >
            <v-card-title class="text-h5">
              Empezadas
            </v-card-title>

            <v-card-subtitle>
              <v-list color="transparent">
                <v-list-item-group
                  color="teal"
                >
                  <v-list-item
                    v-for="(serieE, j) in seriesEmpezadas"
                    :key="j"
                    @click="mostrarSerie('pendiente',serieE)"
                  >
                    <v-list-item-content>
                      <v-list-item-title v-text="serieE.nombre"></v-list-item-title>
                      <v-divider class="mt-1"></v-divider>
                    </v-list-item-content>
                  
                  </v-list-item>
                </v-list-item-group>
              </v-list>
            </v-card-subtitle>
          </v-card>
        </v-col>

        <v-col cols="7">
          <v-card
            elevation="24"
          >
            <v-card-title class="text-h5">
              Finalizadas
            </v-card-title>

            <v-card-subtitle>
              <v-list color="transparent">
                <v-list-item-group
                  color="teal"
                >
                  <v-list-item
                    v-for="(serieF, k) in seriesFinalizadas"
                    :key="k"
                    @click="mostrarSerie('pendiente',serieF)"
                  >
                    <v-list-item-content>
                      <v-list-item-title v-text="serieF.nombre"></v-list-item-title>
                       <v-divider  class="mt-1"></v-divider>
                    </v-list-item-content>
                  </v-list-item>
                </v-list-item-group>
              </v-list>
            </v-card-subtitle>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
</template>

<script>
  export default {
    props: {
      prop:{
          type: Object,
      } 
    },
    name:'Principal',
    methods:{
      mostrarSerie(tipo, serie){
        if(tipo == 'pendiente'){
          this.$router.push({ name: 'verSerie', params: {serie: serie }})
        }
        
      }
    },
    data: () => ({
      result:'jiji',
      color: '#01579B',
      seriesPendientes: [],
     /* seriesPendientes: [
        {
          nombre : "serie 1",
          temporadas: [
            {
              numero: 1,
              capitulos:[
                {
                  numero:1,
                  descripcion: "hola soy una descripccion 1"
                  
                },
                {
                  numero:2,
                  descripcion: "hola soy una descripccion 2"
                },
                {
                  numero:3,
                  descripcion: "hola soy una descripccion 3"
                },
              ]
            },
            {
              numero: 2,
              capitulos:[
                {
                  numero:1,
                  descripcion: "hola soy una descripccion 1"
                },
                {
                  numero:2,
                  descripcion: "hola soy una descripccion 2"
                },
                {
                  numero:3,
                  descripcion: "hola soy una descripccion 3"
                },
              ]
            },
            {
              numero: 3,
              capitulos:[
                {
                  numero:1,
                  descripcion: "hola soy una descripccion 1"
                },
                {
                  numero:2,
                  descripcion: "hola soy una descripccion 2"
                },
                {
                  numero:3,
                  descripcion: "hola soy una descripccion 3"
                },
                {
                  numero:4,
                  descripcion: "hola soy una descripccion 4"
                },
                {
                  numero:5,
                  descripcion: "hola soy una descripccion 5"
                },
              ]
            },
           
          ]
        },
        {
          nombre : "serie 2"
        },
        {
          nombre : "serie 3"
        },
        {
          nombre : "serie 4"
        },
      ],
      seriesEmpezadas:  [
        {
          nombre : "serie 5"
        },
        {
          nombre : "serie 6"
        },
        {
          nombre : "serie 7"
        },
        {
          nombre : "serie 8"
        },
      ],*/
      seriesFinalizadas: [
        {
          nombre : "serie 9"
        },
        {
          nombre : "serie 10"
        },
      ],
      
    }),
  }
</script>

<style>
.theme--light .v-card {
  border-left: 7px solid teal !important;
}
</style>
