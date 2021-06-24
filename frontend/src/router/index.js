import Vue from 'vue'
import VueRouter from 'vue-router'
import Principal from '../components/Principal.vue'

Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'Principal',
    component: Principal,
    props: true,
  },
  {
    path: '/series',
    name: 'Series',
    component: () => import('../views/Series.vue')
  },
  {
    path: '/verSerie',
    name: 'verSerie',
    component: () => import('../components/VerSerie.vue'),
    props: true
  },
  {
    path: '/facturas',
    name: 'Facturas',
    component: () => import('../components/Facturas.vue'),
    props: true,
  },
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
