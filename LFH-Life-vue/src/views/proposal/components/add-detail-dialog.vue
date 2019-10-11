<template>
  <v-dialog v-model="dialogShow" width="700">
    <v-card>
      <v-card-title class="headline">
        錯誤
      </v-card-title>
      <v-divider />
      <v-card-text>
        <!-- <p class="error--text"><v-icon color="error">error</v-icon> 「世」心終身壽險計劃-最低投保額：MOP$80,000</p> -->
        <p v-for="(item, index) in errorMessage" :key="index" class="error--text"><v-icon color="error">error</v-icon>{{ item }}</p>
        <p v-if="!!loginMessage" class="error--text"><v-icon color="error">error</v-icon>{{ loginMessage }}</p>
      </v-card-text>

      <v-divider />
      <v-card-actions>
        <v-spacer />
        <v-btn color="primary" @click="dialogShow = false">
          确定
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>
<script type = 'text/javascript'>
export default {
  name: 'ProposalAddDetailDialog',
  props: {
    show: {
      type: Boolean,
      default: false
    },
    message: {
      type: Array,
      default: function() {
        return []
      }
    },
    loginMessage: {
      type: String,
      default: ''
    }
  },
  data() {
    return {
      dialogShow: this.show,
      errorMessage: []
    }
  },
  computed: {

  },
  watch: {
    show(val) {
      this.dialogShow = val
    },
    message(val) {
      this.errorMessage = val
    },
    loginMessage(val) {
      this.loginMessage = val
    },
    dialogShow(val) {
      this.$emit('update:show', val)
    }
  },
  created() {},
  methods: {}
}
</script>
<style lang='scss' scoped>
</style>
