import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/verSerie',
    name: 'verSerie',
    component: () => import(/* webpackChunkName: "about" */ '../components/VerSerie.vue'),
    props: true
  },
  {
    path: '/facturas',
    name: 'Facturas',
    component: () => import(/* webpackChunkName: "about" */ '../components/Facturas.vue')
  },
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
