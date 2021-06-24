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
  {{serie.nombre_serie}}
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
                <v-btn
                  :disabled="esSerieFinalizada"
                  small
                  outlined
                  color="teal"
                  @click="verCapitulo(capitulo.numero_capitulo)"
                >
                  Ver
                  <v-icon small>mdi-play</v-icon>
                </v-btn>
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
      },
      capitulosVisto:{ 
        default: null,
        type: Number,
      },
      flag:{
        default: 0,
        type:Number,
      }

    },
    data: () => ({
      vistoDisabled: false,
      model: -1,
      capitulos_vistos: 0,
      expmodel: null,
      contador: 0,
    }),
    methods:{
      estaVisto: function (numero_capitulo) {
        if((numero_capitulo - this.primerId) < this.capitulos_vistos){
          return true;
        }
        return false;
      },
      calcularModel: function(){
        this.capitulos_vistos = this.capitulosVisto
        var contador = 0;
        var encontrado = false;
        if(this.capitulos_vistos == 0){
          this.model = 0;
        }if(this.flag == 1){
          this.model = this.numeroTemporadas-1;
        }else{
          for (let i = 0; i < this.serie.temporadas.length && !encontrado; i++){
            for (let j = 0; j < this.serie.temporadas[i].capitulos.length; j++) {
              if(contador++ >= this.capitulos_vistos){
                this.model = i;
                encontrado = true;
              }
            } 
          }
        }
      },
      verCapitulo: function(numero_capitulo){
        //meter aqui el post para agregar la serie a la lista de empezadas. Se le pasará el id del capitulo y el id de la serie
        //primero hay que hacer un for o un calculo para actualizar la vista. Esto es por si se ve un capitulo más avanzado para que todos los anteriores queden vistos
        //tambien puede que se le pase el numero de capitulos visto, ya que este al estar calculado aqui, no es necesario calcularlo en el backend
        //primer paso prevenir si se pulsa un capitulo cualquiera que todos los anteriores queden vistos.
        this.capitulos_vistos = numero_capitulo - this.primerId + 1;
        this.axios.put("http://localhost:8080/api/usuarios/usr1/ver-capitulo-"+this.capitulos_vistos+"/"+this.serie.numero_serie, ).then((result) => {
          console.log(result);
         });
      }
    },
    mounted(){
      this.calcularModel();
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
      },
      esSerieFinalizada: function(){
        var contador = 0;
          for (let i = 0; i < this.serie.temporadas.length; i++) {
            contador += this.serie.temporadas[i].capitulos.length;
          }
          if(contador == this.capitulos_vistos){
            return true;
          }
          return false;
      },
    },
    watch:{
      model: function(){
        this.expmodel = null; //sirve para que los expasion panels se cierren cada vez que clickemos en temporadas diferentes. Asi, el capitulo no queda "expandido"     
      },
    }
  }
</script>
<style>
.theme--light .v-expansion-panel {
  border-left: 7px solid teal !important;
}
</style>