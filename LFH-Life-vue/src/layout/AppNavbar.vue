<template>
  <header>
    <v-toolbar app>
      <v-toolbar-title class="d-flex">
        <img
          :src="require('@/assets/images/logo.png')"
          height="50"
          class="d-block"
          style="cursor: pointer;"
          @click="goHome()"
        />
      </v-toolbar-title>
      <v-spacer />
      <v-toolbar-items>
        <v-menu v-show="isLogin" attach offset-y bottom left nudge-bottom="14">
          <v-toolbar-title v-if="$vuetify && $vuetify.breakpoint.smAndUp" slot="activator">
            <!-- <v-avatar size="40">
              <img :src="user.avatar" alt="" />
            </v-avatar> -->
            <span style="margin-left: 10px;">{{ user }}</span>
            <v-icon>arrow_drop_down</v-icon>
          </v-toolbar-title>
          <v-btn v-else slot="activator" icon dark>
            <v-icon>more_vert</v-icon>
          </v-btn>
          <v-list>
            <v-list-tile class="hidden-sm-and-up">
              <v-list-tile-title>
                <base-langbar />
              </v-list-tile-title>
            </v-list-tile>
            <v-list-tile @click="password">
              <v-list-tile-avatar>
                <v-icon>account_circle</v-icon>
              </v-list-tile-avatar>
              <v-list-tile-content>
                <v-list-tile-title>
                  {{ $t('common.account') }}
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
            <v-list-tile @click="logout">
              <v-list-tile-avatar>
                <v-icon>lock_open</v-icon>
              </v-list-tile-avatar>
              <v-list-tile-content>
                <v-list-tile-title>
                  {{ $t('common.logout') }}
                </v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
          </v-list>
        </v-menu>
        <!-- <base-langbar v-if="$vuetify && $vuetify.breakpoint.smAndUp" /> -->
      </v-toolbar-items>
    </v-toolbar>
  </header>
</template>

<script>
import { mapState, mapMutations } from 'vuex'

import BaseLangbar from '@/components/widgets/BaseLangbar.vue'
import { homeName } from '@/config/app'

export default {
  name: 'AppNavbar',
  components: {
    BaseLangbar
  },
  props: {
    toggleBtn: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      drawerRight: true,
      badgeLen: 0,
      homeName,
      isLogin: false
    }
  },
  computed: {
    ...mapState({
      user: state => state.user.info,
      plan: state => state.proposal.plan
    })
  },
  watch: {
    user(val) {
      if (val === '') {
        this.isLogin = false
      } else {
        this.isLogin = true
      }
    }
  },
  created() {
    if (this.user === '') {
      this.isLogin = false
    } else {
      this.isLogin = true
    }
  },
  inject: ['reload'],
  methods: {
    ...mapMutations(['proposal/RESET_STATE', 'proposal/UPDATE_STEP']),
    password() {
      this.$router.push({ name: 'Password' })
    },
    logout() {
      console.log('logout')
      this.$router.push({ name: 'Login' })
    },
    goHome() {
      this.$router.push({ name: 'ProposalAdd', params: {} })
      this['proposal/UPDATE_STEP'](1)
      this.reload()
      // this['proposal/RESET_STATE'](state)
    }
  }
}
</script>

