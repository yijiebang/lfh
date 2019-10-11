<template>
  <div class="panel-wrapper">
    <span class="logo">
      <img src="../../assets/images/logo.png" alt="" />
    </span>

    <div class="slogan-wrapper">
      <div class="slogan">
        <img src="../../assets/svgs/login-bg3.png" alt="" />
        <!-- <v-carousel>
          <v-carousel-item
            v-for="(item,i) in items"
            :key="i"
            :src="item"
            reverse-transition="fade-transition"
            transition="fade-transition"
          ></v-carousel-item>
        </v-carousel> -->
      </div>
    </div>

    <div class="panel-content">
      <v-app class="login-con">
        <!-- <v-spacer></v-spacer> -->
        <v-content>
          <base-langbar />
          <v-container fluid fill-height>
            <v-layout align-center justify-center>
              <v-flex class="frame">
                <h1 v-if="!isMobile">
                  {{ $t('common.loginN') }}
                </h1>
                <v-form>
                  <v-text-field
                    v-model.trim="$v.form.username.$model"
                    prepend-icon="person"
                    :error-messages="userErrors"
                    clearable
                    :label="$t('common.username')"
                    required
                    @keyup.enter.native="login"
                  />
                  <v-text-field
                    v-model.trim="$v.form.password.$model"
                    prepend-icon="lock"
                    :error-messages="passErrors"
                    :append-icon="showPwd ? 'visibility_off' : 'visibility'"
                    :type="showPwd ? 'text' : 'password'"
                    :label="$t('common.password')"
                    required
                    @click:append="showPwd = !showPwd"
                    @keyup.enter.native="login"
                  />
                  <v-layout column wrap justify-end align-end>
                    <v-flex>
                      <v-btn flat small color="primary" @click="redirectForgotPassword">
                        {{ $t('common.forgetPassword') }}
                      </v-btn>
                    </v-flex>
                    <v-flex>
                      <v-btn :loading="loginLoading" color="primary" @click="login">
                        <span slot="loader">Loading...</span>
                        {{ $t('common.login') }}
                      </v-btn>
                    </v-flex>
                  </v-layout>
                </v-form>
              </v-flex>
            </v-layout>
            <add-detail-dialog :show.sync="showDialog" :login-message="loginMessage" />
          </v-container>
        </v-content>

        <v-footer color="#fbfbfb" height="auto">
          <v-layout>
            <v-flex text-xs-center>
              <!-- {{ $t('common.copyrightMessage', { currentYear }) }} -->
            </v-flex>
          </v-layout>
        </v-footer>
      </v-app>
    </div>
  </div>
</template>

<script>
import { isMobile } from '@/utils/util'
import { validationMixin } from 'vuelidate'
import { required } from 'vuelidate/lib/validators'
import BaseLangbar from '@/components/widgets/BaseLangbar.vue'
import AddDetailDialog from '../proposal/components/add-detail-dialog'
export default {
  name: 'Login',
  components: {
    BaseLangbar, AddDetailDialog
  },
  mixins: [validationMixin],
  validations: {
    form: {
      username: { required },
      password: { required }
    }
  },
  data() {
    return {
      currentYear: new Date().getFullYear(),
      showDialog: false,
      loginMessage: '',
      showPwd: false,
      form: {
        username: '',
        password: ''
      },
      loginLoading: false
    }
  },
  computed: {
    isMobile() {
      return isMobile()
    },
    userErrors() {
      const user = this.$v.form.username
      console.log(user)
      if (!user.$dirty) return ''
      if (!user.required) return '請輸入用户名'
      return ''
    },
    passErrors() {
      const pass = this.$v.form.password
      if (!pass.$dirty) return ''
      if (!pass.required) return '請輸入密码'
      return ''
    }
  },
  methods: {
    async login() {
      // this.loginLoading = true
      const v = this.$v
      v.$touch()
      if (!v.$error) {
        const bean = await this.$api.login({loginId: this.form.username, loginPwd: this.form.password})
        if (bean.responseCode === 1300) {
          this.showDialog = true
          this.loginMessage = '用戶名或密碼輸入錯誤'
        } else {
          this.$router.push('/')
        }
      }
      // this.loginLoading = false
    },
    redirectForgotPassword() {
      this.$router.push({ name: 'Password' })
    }
  }
}
</script>

<style lang="scss">
@import '../../styles/_login.scss';
</style>
