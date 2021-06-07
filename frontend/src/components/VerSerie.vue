<template>
  <v-sheet
    class="mx-auto"
    elevation="8"
    max-width="1000"
  >
  <br/>
  <h1
    class="display-1 ml-5"
  >
  {{serie.nombre}}
  </h1>
    <v-slide-group
      v-model="model"
      class="pa-4"
      center-active
      show-arrows
    >
      <v-slide-item
        v-for="(temporada,n) in numeroTemporadas"
        :key="n"
        v-slot="{ active, toggle }"
      >
        <v-card
          :color="active ? 'teal' : 'grey lighten-1'"
          dark
          class="ma-4"
          height="100"
          width="200"
          @click="toggle"
        >
          <v-row
            class="fill-height"
            justify="center"
            align="center"
          >
            <v-scale-transition>
              <h3
                class="mt-5 font-weight-light"
                v-text="'Temporada '+(n+1)"
              ></h3>
            </v-scale-transition>
          </v-row>
        </v-card>
      </v-slide-item>
    </v-slide-group>

    <v-expand-transition>
      <v-sheet
        v-if="model != null"
        min-height="100"
        tile
      >
        <div 
          class="text-center d-flex pb-4"
          justify="center"
          aling="center "
        >
          <v-expansion-panels 
            focusable
            style="width:96%"
            class="ml-5"
            v-model="expmodel"
          >
            <v-expansion-panel
              v-for="(capitulo, i) in capitulos"
              :key="i"
            >
              <v-expansion-panel-header style="color:teal">
                Capitulo {{i+1}}
                <template v-slot:actions>
                  <v-icon color="teal" >
                    $expand
                  </v-icon>
                </template>
              </v-expansion-panel-header>
              <v-expansion-panel-content>
                {{capitulo.descripcion}}
              </v-expansion-panel-content>
            </v-expansion-panel>
          </v-expansion-panels>
        </div>
      </v-sheet>
    </v-expand-transition>
  </v-sheet>
</template>

<script>
  export default {
    name: 'verSerie',
    props: {
      serie:{
        type: Object,
      } 
    },
    data: () => ({
      model: null,
      expmodel: null,
    }),
    computed:{
      numeroTemporadas: function(){
        return this.serie.temporadas.length;
      },
      numeroCapitulos: function(){
        return this.serie.temporadas[this.model].capitulos.length;
      },
      capitulos: function(){
        return this.serie.temporadas[this.model].capitulos;
      }
    },
    watch:{
      model: function(){
        this.expmodel = null; //sirve para que los expasion panels se cierren cada vez que clickemos en temporadas diferentes. Asi, el capitulo no queda "expandido"
      }
    },
  }
</script>
<style>
.theme--light .v-expansion-panel {
  border-left: 7px solid teal !important;
}
</style>