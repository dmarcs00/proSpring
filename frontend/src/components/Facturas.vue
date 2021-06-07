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
            v-for="(mes , n) in meses"
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
            {{mes}} 2021
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
        <v-btn outlined color="teal" x-large >Precio: {{importe}}€ {{model}}</v-btn> 
    </div>
  </v-container>
</template>

<script>
  export default {
      model: 5,
      nem:'Factura',
      data: () => ({
        facturas: null,
        model: 5,
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
        var self = this;
       this.axios.get("http://localhost:8080/api/usuarios/usr1/facturas").then((result) => {  
        self.facturas = result.data[0].capitulosVistosFactura;
        self.facturas.forEach(element => {
                var fecha = element.fecha.split("/");
                if(parseInt(fecha[1],10) == self.model+1){ //para enseñar solo las facturas del mes seleccionado
                    
                    self.facturasAux.push(element);
                }
            });
       
    })
    },
    watch:{
        model:function(){
            this.facturasAux = [];
            
            this.facturas.forEach(element => {
                var fecha = element.fecha.split("/");
                if(parseInt(fecha[1],10) == this.model+1){ //para enseñar solo las facturas del mes seleccionado
                    
                    this.facturasAux.push(element);
                }
            });

        }
    },
    computed:{
      importe: function(){
        let sumaImportes = 0;
        this.facturas.forEach(element => {
            sumaImportes += element.precio;
        });
        return sumaImportes;
      },
      modelMes: function(){
          var mes = new Date();
          return mes.getMonth(); // para pasar el mes a la bbdd (getFacturasMes) es +1 ya que con mayo devuelve 4...
      }
    },
  }
</script>