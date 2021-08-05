<template>
    <v-container>
      <v-row dense>
        <v-col cols="7">
        <h1>Series de {{prop.usuarioId}} {{prop.password}}</h1> 
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
                      <v-list-item-title v-text="serieP.nombre_serie"></v-list-item-title>
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
                    v-for="(serieE, j) in (seriesEmpezadas)"
                    :key="j"
                    @click="mostrarSerie('empezada',serieE.serie, serieE.ultimo_capitulo_visto)"
                  >
                    <v-list-item-content>
                      <v-list-item-title v-text="serieE.serie.nombre_serie"></v-list-item-title>
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
                    @click="mostrarSerie('finalizada',serieF, 0)"
                  >
                    <v-list-item-content>
                      <v-list-item-title v-text="serieF.nombre_serie"></v-list-item-title>
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
          type: Object
      }, 
    },
    name:'Principal',
    data: () => ({
      result:'jiji',
      color: '#01579B',
      seriesPendientes:null,
      seriesFinalizadas: null,
      seriesEmpezadas: null,
    }),
    methods:{
      mostrarSerie(tipo, serie, capitulosVisto){
        if(tipo == 'pendiente'){
          this.$router.push({ name: 'verSerie', params: {serie: serie, capitulosVisto: 0 }})
        }else if(tipo == 'empezada'){
          this.$router.push({ name: 'verSerie', params: {serie: serie, capitulosVisto: capitulosVisto}})
        }else if (tipo == 'finalizada'){
         for (let i = 0; i < serie.temporadas.length; i++) {
            capitulosVisto += serie.temporadas[i].capitulos.length;
          }
          this.$router.push({ name: 'verSerie', params: {serie: serie, capitulosVisto: capitulosVisto, flag: 1}})
         }
        }        
      },
  created(){//cada vez que se vuelve al inicio por router, se llama aqui
      this.seriesPendientes = this.prop.series_pendientes;
      this.seriesEmpezadas = this.prop.series_empezadas;
      this.seriesFinalizadas = this.prop.series_finalizadas;
  },
  updated(){// al inicio de la aplicacion para cargar las series
      this.seriesPendientes = this.prop.series_pendientes;
      this.seriesEmpezadas = this.prop.series_empezadas
      this.seriesFinalizadas = this.prop.series_finalizadas;
  },
  }
</script>

<style>
.theme--light .v-card {
  border-left: 7px solid teal !important;
}
</style>
