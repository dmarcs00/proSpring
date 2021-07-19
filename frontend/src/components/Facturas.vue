<template>
  <v-container>
    <v-sheet
        class="mx-auto"
        max-width="900"
    >
        <v-slide-group
            center-active
            show-arrows
            v-model="model"
        >
        <v-slide-item
            v-for="n in modelMes+1"
            :key="n"
            v-slot="{ active, toggle }"
        >
            <v-btn
            class="mx-2"
            :input-value="active"
            active-class="teal white--text"
            depressed
            
            @click="toggle"
            >
            {{meses[n-1]}} 2021
            </v-btn>
        </v-slide-item>
        </v-slide-group>
    </v-sheet>

    <v-data-table
        :headers="headers"
        :items="facturasAux"
        class="elevation-1 mt-4"
        hide-default-footer
    >
    <template slot="items" slot-scope="props">
        <td class="text-xs-right">{{ props.item.fecha }}</td>
        <td class="text-xs-right">{{ props.item.nombre_serie }}</td>
        <td class="text-xs-right">{{ props.item.temporada_x_capitulo }}</td>
        <td class="text-xs-right">{{ props.item.precio }}</td>
        </template>
    </v-data-table>
    <div class="mr-2 mt-4" style="text-align: right;">
        <v-btn flat dark color="teal" x-large >Precio: {{importe}}€ {{model}}</v-btn> 
    </div>
  </v-container>
</template>

<script>
  export default {
      props: {
        prop:{
            type: Object,
        } 
      },
      name:'Factura',
      data: () => ({
        facturas: null,
        model: 6,
        meses:['Enero','Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        headers: [
            { text: 'Fecha', value: 'fecha' },
            { text: 'Serie', value: 'nombre_serie' },
            { text: 'Episodio', value: 'temporada_x_capitulo' },
            { text: 'Precio (€)', value: 'precio' },
            ],
        facturasAux: [],
    }),
    mounted(){
        //Hay que leer el numero de factura para saber si en el mes actual hay que meter datos
        this.model = this.modelMes;
        this.facturas = this.prop[0].facturas;
        this.facturas.forEach(element => {
            var mes = element.num_factura.split("");
            if(parseInt(mes[1],10) == this.model+1){ //para enseñar solo las facturas del mes seleccionado
                
                this.facturasAux = element.capitulos_vistos_factura;
            }
        })
    },
    watch:{
        model:function(){
            this.facturasAux = [];
            this.facturas.forEach(element => {
                var mes = element.num_factura.split("");
                if(parseInt(mes[1],10) == this.model+1){ //para enseñar solo las facturas del mes seleccionado    
                    this.facturasAux = element.capitulos_vistos_factura;
                }
            })

        }
    },
    computed:{
      importe: function(){
        let sumaImportes = 0;
        if(!this.es_vip){
            this.facturasAux.forEach(element => {
                sumaImportes += element.precio;
            });
        }else{
            sumaImportes = 20;
        }
        return sumaImportes;
      },
      es_vip: function () {
          return this.prop[0].vip;
      },
      modelMes: function(){
          var mes = new Date();
          return mes.getMonth(); // para pasar el mes a la bbdd (getFacturasMes) es +1 ya que con mayo devuelve 4...
      }
    },
  }
</script>