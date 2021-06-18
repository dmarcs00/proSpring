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
        v-if="model != -1"
        min-height="100"
        tile
      >
        <div 
          class="s-flex pb-4"
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
              <v-expansion-panel-header
                disable-icon-rotate 
                style="color:teal"
              >
                  Capitulo {{i+1}}
                <template v-slot:actions>
                  <v-btn :disabled="estaVisto(capitulo.numero_capitulo)" icon>
                    <v-icon color="teal">mdi-eye</v-icon>
                  </v-btn>
                </template>
              </v-expansion-panel-header>
              <v-expansion-panel-content>
                {{capitulo.descripcion}}
                <v-btn :disabled="false" small outlined color="teal" >
                  Ver
                  <v-icon small>mdi-play</v-icon>
                </v-btn>
              </v-expansion-panel-content>
            </v-expansion-panel>
          </v-expansion-panels>
        </div>
      </v-sheet>
    </v-expand-transition>
    {{model}}
  </v-sheet>
</template>

<script>
  export default {
    name: 'verSerie',
    props: {
      serie:{
        type: Object,
      },
      capitulosVisto:{ //puede ser 0, >0 o null. con esto distinguiremos que tipo de serie es la que es.
        default: null,
        type: Number,
      }

    },
    data: () => ({
      vistoDisabled: false,
      model: -1,
      expmodel: null,
      contador: 0,
      boolIcon: false, //si es true el capitulo se ha visto
    }),
    methods:{
      estaVisto: function (numero_capitulo) {
        if((numero_capitulo - this.primerId) < this.capitulosVisto){
          return true;
        }
        return false;
      }
    },
    computed:{
      numeroTemporadas: function(){
        return this.serie.temporadas.length;
      },
      numeroCapitulos: function(){
        return this.serie.temporadas[this.model].capitulos.length; 
      },
      capitulos: function(){
        return this.serie.temporadas[this.model].capitulos;
      },
      primerId: function(){
        return this.serie.temporadas[0].capitulos[0].numero_capitulo;
      }
    },
    watch:{
      model: function(){
        this.expmodel = null; //sirve para que los expasion panels se cierren cada vez que clickemos en temporadas diferentes. Asi, el capitulo no queda "expandido"     
      },
    },
  }
</script>
<style>
.theme--light .v-expansion-panel {
  border-left: 7px solid teal !important;
}
</style>