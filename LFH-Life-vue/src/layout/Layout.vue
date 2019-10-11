
<template>
  <v-app>
    <app-navbar />
    <v-content>
      <v-container fluid>
        <!-- <v-slide-y-transition mode="out-in"> -->
        <router-view />
        <!-- </v-slide-y-transition> -->
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import AppNavbar from './AppNavbar.vue'

export default {
  name: 'Layout',
  components: {
    AppNavbar
  },
  data() {
    return {}
  },
  methods: {}
}
</script>
