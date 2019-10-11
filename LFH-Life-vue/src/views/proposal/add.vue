<template>
  <v-stepper :value="currentStep" @input="updateStep">
    <v-stepper-header>
      <template v-for="(item, index) in steps">
        <v-stepper-step
          :key="`step-header-${index}`"
          :editable="(currentStep > index + 1) && !previewed"
          :step="index + 1"
        >{{ item }}</v-stepper-step>
        <v-divider v-if="index < steps.length - 1" :key="`header-divider-${index}`" />
      </template>
    </v-stepper-header>
    <v-stepper-items v-for="(item, index) in components" :key="index">
      <v-stepper-content :key="`${index}-content`" :step="index + 1">
        <component :is="item" @pre="preHandler(index + 1)" @next="nextHandler(index + 1)" />
      </v-stepper-content>
    </v-stepper-items>
  </v-stepper>
</template>
<script type = 'text/javascript'>
import AddInfo from './components/add-info'
import AddPlan from './components/add-plan'
import AddDetail from './components/add-detail'
import { mapMutations, mapState } from 'vuex'
export default {
  name: '',
  data() {
    return {
      steps: ['客戶資料', '保險計劃', '計劃詳情'],
      components: [AddInfo, AddPlan, AddDetail]
    }
  },
  computed: {
    ...mapState({
      currentStep: state => state.proposal.currentStep,
      previewed: state => state.proposal.previewed
    })
  },
  beforeDestroy() {
    this.updateStep(1)
    this['proposal/RESET_STATE']()
  },
  methods: {
    ...mapMutations(['proposal/UPDATE_STEP', 'proposal/RESET_STATE']),
    updateStep(step) {
      this['proposal/UPDATE_STEP'](step)
    },
    preHandler(step) {
      this['proposal/UPDATE_STEP'](this.currentStep - 1)
    },
    nextHandler(step) {
      if (step !== this.components.length) {
        this['proposal/UPDATE_STEP'](this.currentStep + 1)
        return
      }
      // 最后一项
      console.log('要計算了')
    }
  }
}
</script>
<style lang='scss'>
.v-stepper__step {
  padding: 20px;
}
.v-stepper__step__step {
  width: 34px;
  height: 34px;
}
.v-stepper__step--active .primary {
  background-color: #ff5252 !important;
  border-color: #ff5252 !important;
}
.theme--light.v-stepper
  .v-stepper__step:not(.v-stepper__step--active):not(.v-stepper__step--complete):not(.v-stepper__step--error)
  .v-stepper__step__step {
  background: #1976d2;
}
.v-stepper__label {
  font-size: 16px;
}
</style>
