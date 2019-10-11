<template>
  <v-layout justify-center class="mt-5">
    <v-card width="600">
      <v-form ref="form" v-model="valid" lazy-validation>
        <v-card-title primary-title class="headline">
          修改密碼
        </v-card-title>
        <v-card-text>
          <v-text-field v-model="oldPassword" :counter="12" :rules="oldPasswordRules" label="舊密碼" required />
          <v-text-field v-model="newPassword" :counter="12" :rules="newPasswordRules" label="新密碼" required />
          <v-text-field v-model="newPassword2" :counter="12" :rules="newPasswordRules2" label="確認新密碼" required />
        </v-card-text>
        <v-card-actions>
          <v-spacer />
          <v-btn outline @click="$router.go(-1)">
            返回
          </v-btn>
          <v-btn :disabled="!valid" color="success" @click="validate">
            確定
          </v-btn>
        </v-card-actions>
      </v-form>
    </v-card>
  </v-layout>
</template>
<script>
import Vue from 'vue'
export default {
  data: () => ({
    valid: true,
    oldPassword: '',
    oldPasswordRules: [v => !!v || '請輸入舊密碼'],
    newPassword: '',
    newPasswordRules: [v => !!v || '請輸入新秘密'],
    newPassword2: ''
  }),
  computed: {
    newPasswordRules2() {
      const rule1 = v => !!v || '請再次輸入新密碼'
      const rule2 = v => v === this.newPassword || '兩次輸入的密碼不一致'
      return [rule1, rule2]
    }
  },
  methods: {
    async validate() {
      if (this.$refs.form.validate()) {
        const updatePwd = await this.$api.updatePwd({loginPwd: this.oldPassword, loginNewPswd: this.newPassword})
        if (updatePwd.responseCode !== 1000) {
          Vue.prototype.$message({
            text: '舊密碼錯誤',
            type: 'error'
          })
        } else {
          Vue.prototype.$message({
            text: '密碼修改成功',
            type: 'success'
          })
          this.$router.push('/login')
        }
      }
    },
    reset() {
      this.$refs.form.reset()
    },
    resetValidation() {
      this.$refs.form.resetValidation()
    }
  }
}
</script>

<style lang="scss">
@import '../../styles/_login.scss';
</style>
