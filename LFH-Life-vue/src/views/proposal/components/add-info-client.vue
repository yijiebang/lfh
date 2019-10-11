<template>
  <v-card>
    <v-card-title :class="color">
      <v-icon color="white" class="mr-2">
        person
      </v-icon>
      <span class="subheading white--text">{{ title }}</span>
    </v-card-title>
    <v-card-text>
      <v-form>
        <v-text-field v-model.trim="$v.formData.name.$model" :disabled="clientDisabled || payInput" :error-messages="nameErrors" :counter="100" label="姓名" />
        <v-text-field v-model.number="$v.formData.age.$model" :disabled="clientDisabled" :error-messages="ageErrors" label="年齡" />
        <v-radio-group v-model="formData.gender" :disabled="clientDisabled" class="mt-1" row>
          <v-radio v-for="item in genderItems" :key="`gender-${item.value}`" v-bind="item" />
        </v-radio-group>
        <v-radio-group v-model="formData.isSmoker" :disabled="clientDisabled" class="mt-1" row>
          <v-radio v-for="item in smokerItems" :key="`smoker-${item.value}`" v-bind="item" />
        </v-radio-group>
      </v-form>
    </v-card-text>
    <v-card-actions v-if="actions">
      <v-spacer />
      <!-- <v-btn @click="$emit('cancel')">取消</v-btn> -->
      <v-btn :color="color" @click="$emit('cancel')">確定</v-btn>
    </v-card-actions>
  </v-card>
</template>
<script type = 'text/javascript'>
import { validationMixin } from 'vuelidate'
import { required, maxLength, between } from 'vuelidate/lib/validators'
import { SMOKER, GENDER } from '@/filters/proposal'
export default {
  name: 'ProposalAddInfoClient',
  mixins: [validationMixin],
  props: {
    title: {
      type: String,
      default: 'Title'
    },
    color: {
      type: String,
      default: ''
    },
    actions: {
      type: Boolean,
      default: false
    },
    info: {
      type: Object,
      default: function() {
        return {}
      }
    },
    valite: {
      type: Boolean,
      default: true
    },
    clientDisabled: {
      type: Boolean,
      default: false
    },
    payInput: {
      type: Boolean
    }
  },
  validations: {
    formData: {
      name: { required, maxLength: maxLength(100) },
      age: { required, between: between(0, 70) }
    }
  },
  data() {
    return {
      formData: {
        name: '',
        age: '',
        gender: '',
        isSmoker: ''
      },
      smokerItems: SMOKER,
      genderItems: GENDER
    }
  },

  computed: {
    nameErrors() {
      const name = this.$v.formData.name
      if (!name.maxLength) return '請輸入合法的名字'
      if (this.valite) {
        if (!name.$dirty) return ''
        if (!name.required) return '請輸入名字'
      }
      return ''
    },
    ageErrors() {
      const age = this.$v.formData.age
      if (!age.between) return '請輸入合法的年齡'
      if (this.valite) {
        if (!age.$dirty) return ''
        if (!age.required) return '請輸入年齡'
      }
      return ''
    }
  },
  watch: {
    info(val) {
      this.formData = { ...this.formData, ...this.info }
    }
  },
  created() {
    this.formData = { ...this.formData, ...this.info }
  },
  methods: {
    getData() {
      const v = this.$v
      v.$touch()
      if (!v.$error) {
        return { ...this.formData }
      }
    },
    getData2() {
      const v = this.$v
      v.$touch()
      return { ...this.formData }
    },
    reset() {
      console.log({ ...this.$v })
      this.$v.$reset()
    }
  }
}
</script>
