<template>
  <div>
    <add-info-sales ref="infoSales" :info="salesInfo" disabled />
    <v-container fluid class="py-0 px-3">
      <v-layout>
        <v-flex xs12 md4>
          <v-text-field :value="client1" label="擬被保人" disabled />
        </v-flex>
      </v-layout>
    </v-container>
    <v-container fluid class="my-2">
      <v-layout>
        <v-flex v-for="(td, tdIndex) in headers" :key="tdIndex" :class="widths[tdIndex]">
          <strong>{{ td }}</strong>
        </v-flex>
      </v-layout>
      <v-divider />
      <!-- 基本计划 basePlan -->
      <v-layout class="py-2 lighten-3" align-center>
        <v-flex class="xs12 md2 offset-md1">
          <v-checkbox
            label="基本計劃"
            input-value="true"
            disabled
            primary
            hide-details
            class="mt-0 pt-0"
          />
        </v-flex>
        <v-flex class="xs12 md3 mr-5">
          <span v-if="plan.yearName == ''" class="subheading">{{ planName }}</span>
          <span v-else class="subheading">{{ planName + '-' + plan.yearName }}</span>
        </v-flex>
        <v-flex class="xs12 md1">
          <v-checkbox
            v-show="isShow"
            v-model="basePlan.free"
            :disabled="previewed"
            primary
            hide-details
            class="mt-0 pt-0 freeColor"
            @change="changeRemit(basePlan.free)"
          />
        </v-flex>
        <v-flex class="xs12 md1 mr-5">
          <v-text-field
            v-if="basisInput"
            v-model.number="basePlan.inputPremium"
            class="text_fr"
            :disabled="previewed"
            maxlength="10"
            solo
            hide-details
            @input="inputChange"
            @blur="baseBlur"
            @focus="baseFocus($event)"
          />
        </v-flex>
        <v-flex class="xs12 md1">
          <v-text-field
            v-model.number="basePlan.premium"
            class="text_fr"
            :disabled="true"
            solo
            hide-details
          />
        </v-flex>
      </v-layout>
      <!-- 附加计划 -->
      <v-layout
        v-for="(addPlanItem, index) in addPlan"
        :key="`tr-${index}`"
        class="py-1"
        :class="index % 2 == 0 && 'grey lighten-3'"
        align-center
      >
        <v-flex class="xs12 md2 offset-md1">
          <v-checkbox
            v-model="addPlanItem.selected"
            :label="addPlanItem.type"
            :disabled="addPlanItem.isDisabled || previewed"
            primary
            hide-details
            class="mt-0 pt-0 baseColor"
            @change="isChecked(addPlan[index])"
          />
        </v-flex>
        <v-flex class="xs12 md3 mr-5">
          <v-select
            v-model="addPlanItem.value"
            :items="addPlanItem.options"
            :disabled="!addPlanItem.selected || !addPlanItem.isRemitDisabled || previewed"
            hide-details
            return-object
            @change="isSelected(addPlan[index])"
          />
        </v-flex>
        <v-flex class="xs12 md1">
          <v-checkbox
            v-if="addPlanItem.key === 'LTR'"
            v-model="basisChecked"
            :disabled="true"
            primary
            hide-details
            class="mt-0 pt-0"
          />
        </v-flex>
        <v-flex class="xs12 md1 mr-5">
          <v-text-field
            v-if="addPlanItem.showSumInsured == 'Y'"
            v-model.number="addPlanItem.inputPremium"
            class="text_fr"
            maxlength="10"
            :disabled="!addPlanItem.selected || previewed"
            solo
            hide-details
            @input="inputChange"
            @blur="planBlur"
            @focus="planFocus($event)"
          />
        </v-flex>
        <v-flex class="xs12 md1">
          <v-text-field
            v-model.number="addPlanItem.sumPremium"
            class="text_fr"
            :disabled="true"
            solo
            hide-details
          />
        </v-flex>
      </v-layout>

      <v-divider class="my-2" />
      <v-layout row wrap align-center>
        <v-spacer />
        <h3>總保費：</h3>
        <v-flex md1 d-flex>
          <v-text-field
            class="text_fr"
            :value="summation.premiums"
            :disabled="true"
            solo
            hide-details
          />
        </v-flex>
      </v-layout>

      <v-layout row wrap align-center mt-2>
        <v-btn v-show="!previewed" style="background: #52a5b5;color: #fff;" @click="pre()">
          <v-icon>arrow_back</v-icon>上一步
        </v-btn>
        <v-spacer />
        <v-btn v-show="previewed" class="blueColor" @click="add">
          <v-icon class="mr-1">add</v-icon>新增
        </v-btn>
        <v-btn v-show="previewed" class="blueColor" @click="edit">
          <v-icon class="mr-1">edit</v-icon>修改
        </v-btn>
        <v-btn
          v-show="isPrint"
          class="printColor"
          @click="printf"
        >
          <v-icon class="mr-1">print</v-icon>預覽（PDF）
        </v-btn>
        <v-btn v-show="!previewed" style="background: #52a5b5;color: #fff;" @click="sum">
          <v-icon class="mr-1">monetization_on</v-icon>計算
        </v-btn>
        <h3>每年總保費：</h3>
        <v-flex md1 d-flex>
          <v-text-field
            class="text_fr"
            :value="summation.premiumsPerYear"
            :disabled="true"
            solo
            hide-details
          />
        </v-flex>
      </v-layout>
      <add-detail-dialog :show.sync="showDialog" :message="message" />
      <div v-if="overlay">
        <div class="bgLoad">
          <div class="loading">
            <v-progress-circular indeterminate size="64" />
          </div>
        </div>
      </div>
    </v-container>
  </div>
</template>
<script type = 'text/javascript'>
import axios from 'axios'
import deepCopy from 'deepcopy'
import { baseUrl } from '@/config/app'
import { mapState, mapMutations } from 'vuex'
import { formatMoney, toThousands, getCaption } from '@/filters/index'
import { filterSmoker, filterGender } from '@/filters/proposal'

import AddDetailDialog from './add-detail-dialog'
import AddInfoSales from './add-info-sales'

export default {
  name: 'ProposalAddDetail',
  components: { AddDetailDialog, AddInfoSales },
  props: {
    step: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      overlay: true,
      showDialog: false,
      isPrint: false,
      isShow: true,
      basisChecked: false,
      basisInput: true,
      isRemit: [],
      isBasis: {},
      isBasisLtr: {},
      message: [],
      widths: ['xs12 md2 offset-md1', 'xs12 md3 mr-5', 'xs12 md1', 'xs12 md1 mr-5', 'xs12 md2'],
      basePlan: {
        free: false,
        inputPremium: '0',
        premium: '0.00'
      },
      addPlan: [],
      summation: {
        premiums: '0.00',
        premiumsPerYear: '0.00'
      },
      valiteParam: [],
      baseData: {},
      planArr: [],
      planData: {},
      sumMoney: 0
    }
  },
  inject: ['reload'],
  computed: {
    ...mapState({
      currentStep: state => state.proposal.currentStep,
      salesInfo: state => state.proposal.salesInfo,
      client1Info: state => state.proposal.client1Info,
      client2Info: state => state.proposal.client2Info,
      client3Info: state => state.proposal.client3Info,
      plan: state => state.proposal.plan,
      previewed: state => state.proposal.previewed
    }),
    headers() {
      const m = this.plan.money
      return ['保障類型', '計劃名稱', '豁免保費', `保額（${m}）`, `年繳保費（${m}）`]
    },
    client1() {
      const { name, age, gender, isSmoker } = this.client1Info
      if (!name) {
        return ''
      }
      const genderVal = filterGender(gender)
      const smokerVal = filterSmoker(isSmoker)
      return `${name}，${age}歲，${genderVal}，${smokerVal}`
    },
    planName() {
      const { planName } = this.plan
      const baseName = getCaption(planName)
      return `${baseName}`
    }
  },
  watch: {
    currentStep(val) {
      if (val === 3) {
        // 说明激活了当前组件所在的步骤
        this.getItems()
        this.getDetail()
        if (this.plan.year !== this.baseData.covCode) {
          this.basePlan.inputPremium = '0'
          this.clearPremium()
          this.basePlan.free = false
          this.basisChecked = false
        }
        // this.valite()
      }
    }
  },
  created() {
    if (this.currentStep === 3) {
      // 说明激活了当前组件所在的步骤
      axios.all([this.getItems(), this.getDetail()]).then(res => {
        if (this.$router.query.detail) {
          this.sum()
        }
      })
    }
  },
  methods: {
    ...mapMutations(['proposal/UPDATE_STEP', 'proposal/UPDATE_PREVIEWED', 'proposal/RESET_STATE']),
    pre() {
      this.$emit('pre')
    },
    edit() {
      this['proposal/UPDATE_STEP'](1)
    },
    add() {
      this.$router.push({ name: 'ProposalAdd', params: {} })
      this['proposal/UPDATE_STEP'](1)
      this.reload()
    },
    async getItems() {
      const { money, plan, basePlan, wppb, year } = this.plan
      const { proposalId } = this.salesInfo
      const { age } = this.client1Info
      const subAge = this.client2Info.age
      const payerAge = this.client3Info.age
      const res = await this.$api.getAdditionalInsurance({
        quplanNo: proposalId,
        ccy: money,
        basePlan: basePlan,
        wppb: wppb,
        covCodeDisp: plan,
        covCode: year,
        age: age,
        subAge: subAge,
        payerAge: payerAge
      })
      if (res) {
        this.overlay = false
      } else {
        this.overlay = true
      }
      const data = res.body
      const list = this.formatData(data)
      // 是否豁免
      if (res.hmflag) {
        this.isShow = true
        this.isRemit = list.pop()
        this.isRemit.selected = true
        this.isRemit.isDisabled = true
        this.isRemit.value = this.isRemit.options[0]
      } else {
        this.isShow = false
      }
      if (res.sumInd === 'N') {
        this.basisInput = false
      } else {
        this.basisInput = true
      }
      if (this.basePlan.free) {
        list.push(this.isRemit)
      }
      // 是否定期
      this.addPlan = [...list]
      const basis = this.addPlan.findIndex(item => item.key === 'LTR-T')
      if (basis !== -1) {
        this.isBasis = this.addPlan.splice(basis, 1)[0]
      }
      this.isBasisLtr = this.addPlan.filter(item => item.key === 'LTR')[0]
      this.isBasis.selected = true
      this.isBasis.isDisabled = true
      this.isBasis.isRemitDisabled = false
      if (this.basisChecked) {
        const remitList = await this.$api.getRemitList({ covCode: year, covCodeDEDQ: this.isBasisLtr.value.value })
        const remitValue = remitList.body[0]
        this.isBasis.value = { text: remitValue.classNameOth, value: remitValue.covClass }
        this.addPlan.push(this.isBasis)
      } else {
        if (this.isBasis.options) {
          this.isBasis.value = this.isBasis.options[0]
        }
      }
    },
    // 格式化接口返回的数据
    formatData(obj) {
      const list = []
      for (const key in obj) {
        const arrVal = obj[key]
        if (Array.isArray(arrVal) && arrVal.length) {
          const { money } = this.plan
          const basePlan = Number(this.plan.basePlan)
          const wppb = Number(this.plan.wppb)
          const { gender, isSmoker, age } = this.client1Info
          const options = arrVal.map(({ classNameOth, covClass }) => {
            return { text: classNameOth, value: covClass }
          })
          const covCode = arrVal[0].covCode
          const covClass = arrVal[0].covClass
          const defaultval = arrVal[0].defaultval
          const type = arrVal[0].covNameOth
          const showSumInsured = arrVal[0].showSumInsured
          const covTermRiderInd = arrVal[0].covTermRiderInd
          const itemVal = arrVal.find(param => param.selected)
          const item = {
            key,
            covCode,
            basePlan: basePlan,
            wppb: wppb,
            covClass,
            type,
            showSumInsured,
            covTermRiderInd,
            options,
            selected: false,
            isDisabled: false,
            isRemitDisabled: true,
            value: '',
            inputPremium: 0,
            sumPremium: 0,
            sex: gender,
            smoke: isSmoker,
            ccy: money,
            issAge: age,
            defaultval: defaultval
          }
          item.sumPremium = item.sumPremium.toFixed(2)
          if (itemVal) {
            item.value = { value: itemVal.covClass, text: itemVal.classNameOth }
            item.selected = true
            item.inputPremium = itemVal.inputPremium
            item.sumPremium = formatMoney(String(itemVal.sumPremium))
            if (itemVal.showSumInsured === 'W') {
              this.basePlan.free = true
            }
            if (itemVal.showSumInsured === 'F') {
              this.basisChecked = true
              this.isBasis.value = { value: itemVal.covClass, text: itemVal.classNameOth }
            }
          }
          list.push(item)
        }
      }
      return list
    },
    // 是否需要豁免
    async changeRemit(val) {
      this.clearPremium()
      if (val) {
        this.addPlan.push(this.isRemit)
        const { year } = this.plan
        if (this.isBasisLtr) {
          if (this.isBasisLtr.selected) {
            const remitList = await this.$api.getRemitList({ covCode: year, covCodeDEDQ: this.isBasisLtr.value.value })
            const remitValue = remitList.body[0]
            this.isBasis.value = { text: remitValue.classNameOth, value: remitValue.covClass }
            this.basisChecked = true
            this.addPlan.push(this.isBasis)
          }
        }
      } else {
        if (this.basisChecked) {
          this.basisChecked = false
          this.addPlan.splice(this.addPlan.findIndex(item => item.covClass === '*' && item.showSumInsured === 'W'), 1)
          this.addPlan.splice(this.addPlan.findIndex(item => item.key === 'LTR-T'), 1)
        } else {
          this.addPlan.pop()
        }
      }
    },
    baseFocus(event) {
      event.currentTarget.select()
    },
    // 基本计划失去焦点格式化货币
    baseBlur() {
      if (String(this.basePlan.inputPremium).indexOf(',') === -1) {
        this.basePlan.inputPremium = toThousands(this.basePlan.inputPremium)
      }
    },
    planFocus(event) {
      event.currentTarget.select()
    },
    // 附加计划失去焦点格式化货币
    planBlur() {
      this.addPlan.forEach(item => {
        if (String(item.inputPremium).indexOf(',') === -1) {
          item.inputPremium = toThousands(item.inputPremium)
        }
      })
    },
    // 监听checkbox勾选
    isChecked(val) {
      this.clearPremium()
      if (val.selected === false) {
        val.inputPremium = 0
        val.sumPremium = '0.00'
        val.value = ''
      } else {
        val.value = val.options[0]
      }
      if (this.basePlan.free && val.key === 'LTR') {
        if (val.selected) {
          this.basisChecked = true
          this.addPlan.push(this.isBasis)
        } else {
          this.basisChecked = false
          this.addPlan.splice(this.addPlan.findIndex(item => item.key === 'LTR-T'), 1)[0]
        }
      }
    },
    // 监听select选择
    async isSelected(val) {
      this.clearPremium()
      const { year } = this.plan
      if (val.key === 'LTR') {
        const covCodeDEDQ = val.value.value
        const remitList = await this.$api.getRemitList({ covCode: year, covCodeDEDQ: covCodeDEDQ })
        const remitValue = remitList.body[0]
        this.isBasis.value = { text: remitValue.classNameOth, value: remitValue.covClass }
      }
    },
    // 监听保额输入
    inputChange() {
      this.clearPremium()
    },
    // 清空计算之后的保费
    clearPremium() {
      this.isPrint = false
      this.planArr.forEach(item => {
        item.sumPremium = '0.00'
      })
      this.summation.premiumsPerYear = this.summation.premiums = this.basePlan.premium = '0.00'
    },
    async valite() {
      const { plan, money, planName } = this.plan
      const resParam = this.addPlan.filter(item => item.selected)
      const basePlanValite = {
        planDesc: getCaption(planName),
        plan: plan,
        ccy: money,
        amount: Number(this.basePlan.inputPremium.replace(/,/g, ''))
      }
      this.valiteParam.push(basePlanValite)
      if (resParam.length > 0) {
        for (let i = 0; i < resParam.length; i++) {
          const valiteList = {}
          valiteList.planDesc = resParam[i].type + ' - ' + resParam[i].value.text
          valiteList.plan = resParam[i].key
          valiteList.ccy = resParam[i].ccy
          if (resParam[i].inputPremium === '0') {
            valiteList.amount = 0
          }
          if (String(resParam[i].inputPremium).indexOf(',') !== -1) {
            valiteList.amount = Number(resParam[i].inputPremium.replace(/,/g, ''))
          } else {
            valiteList.amount = Number(resParam[i].inputPremium)
          }
          this.valiteParam.push(valiteList)
        }
      }
      const res = await this.$api.insuredamount(this.valiteParam)
      this.valiteParam = []
      if (res.responseCode === 1000) {
        this.isPrint = true
        this.showDialog = false
        this.sum()
      } else {
        if (res.body.desc.length > 0) {
          this.message = res.body.desc
        }
      }
    },
    async sum() {
      if (this.isPrint) {
        const { year, plan, money, planName } = this.plan
        const basePlan = Number(this.plan.basePlan)
        const wppb = Number(this.plan.wppb)
        const { gender, isSmoker, age } = this.client1Info
        this.baseData = {
          inputPremium: Number(this.basePlan.inputPremium.replace(/,/g, '')),
          basePlan: basePlan,
          wppb: wppb,
          covCode: year,
          type: '基本计划',
          value: { text: planName, value: plan },
          planCode: plan,
          sex: gender,
          smoke: isSmoker,
          ccy: money,
          issAge: age,
          covClass: '*',
          showSumInsured: 'Y',
          defaultval: '',
          covTermRiderInd: 'N'
        }
        this.isRemit.inputPremium = this.baseData.inputPremium
        let newArr = deepCopy(this.planArr)
        newArr = this.addPlan.filter(item => item.selected)
        for (var i in newArr) {
          newArr[i].ccy = money
          newArr[i].covClass = newArr[i].value.value
          if (newArr[i].key === 'LTR-T') {
            const inputSumLtr = newArr.find(item => item.key === 'LTR').inputPremium
            newArr[i].inputPremium = inputSumLtr
          }
          if (String(newArr[i].sumPremium).indexOf(',', 0) !== -1) {
            newArr[i].sumPremium = Number(newArr[i].sumPremium.replace(/,/g, ''))
          }
          if (String(newArr[i].inputPremium).indexOf(',', 0) !== -1) {
            newArr[i].inputPremium = Number(newArr[i].inputPremium.replace(/,/g, ''))
          }
        }
        newArr.unshift(this.baseData)

        const premium = await this.$api.getSumPremium(newArr)
        newArr.shift(this.baseData)

        const baseSumRes = formatMoney(String(premium.body[0].sumPremium))
        this.basePlan.premium = baseSumRes
        const planItemRes = premium.body.slice(1, premium.body.length)

        var copyTargetVal = function(sourceArr, targetArr, matchKey, targetKey) {
          const map = {}
          for (const item of targetArr) {
            map[item[matchKey]] = item[targetKey]
          }
          sourceArr.map(item => {
            item[targetKey] = map[item[matchKey]]
          })
        }
        copyTargetVal(this.addPlan, planItemRes, 'covCode', 'sumPremium')
        this.planArr = [...newArr]
        this.addPlan.forEach(item => {
          if (String(item.inputPremium).indexOf(',') === -1) {
            item.inputPremium = toThousands(item.inputPremium)
          }
          if (item.sumPremium === undefined) {
            item.sumPremium = '0.00'
          } else {
            item.sumPremium = formatMoney(String(item.sumPremium))
          }
        })
        // 计算总保费
        this.sumMoney = planItemRes.reduce((pre, cur) => {
          return pre + cur.sumPremium
        }, 0)
        this.sumMoney = Number(this.sumMoney) + premium.body[0].sumPremium
        this.summation.premiumsPerYear = this.summation.premiums = formatMoney(this.sumMoney.toFixed(2))

        // 校验总保费
        if (premium && premium.responseCode === 1000) {
          const prinf = await this.$api.premiumamount({ mode: 'A', ccy: money, amount: this.sumMoney, code: year })
          if (prinf.responseCode === 1000) {
            this.isPrint = true
            // 新增第三步
            const { proposalId } = this.salesInfo
            this.planData = {
              quotNo: proposalId,
              quotPlanCode: premium.body[0].value.value,
              quotPlanCodeDesc: premium.body[0].value.text,
              quotTotalPrem: this.sumMoney,
              quotTotalPremAnn: this.sumMoney,
              quotplanList: [
                {
                  quplanRiderCode: year,
                  quplanRiderCodeDesc: premium.body[0].value.text,
                  quplanRiderClass: year,
                  quplanRiderClassDesc: premium.body[0].value.text,
                  quplanSumInsured: Number(this.basePlan.inputPremium.replace(/,/g, '')),
                  quplanAnnPremium: premium.body[0].sumPremium,
                  quplanTermRiderIndex: 'Y'
                }
              ]
            }
            // 是否需要豁免
            if (this.basePlan.free === true) {
              this.planData.quotPlanWaiver = 'Y'
            } else {
              this.planData.quotPlanWaiver = ''
            }
            // 是否有附加计划
            if (this.planArr.length > 0) {
              for (let i = 0; i < planItemRes.length; i++) {
                var quotplanList = {}
                quotplanList.quplanRiderCode = planItemRes[i].key
                quotplanList.quplanRiderCodeDesc = planItemRes[i].type
                quotplanList.quplanRiderClass = planItemRes[i].value.value
                quotplanList.quplanRiderClassDesc = planItemRes[i].value.text
                if (planItemRes[i].showSumInsured === 'W' || planItemRes[i].showSumInsured === 'F') {
                  quotplanList.quplanSumInsured = 0
                } else {
                  quotplanList.quplanSumInsured = planItemRes[i].inputPremium
                }
                quotplanList.quplanAnnPremium = planItemRes[i].sumPremium
                quotplanList.quplanTermRiderIndex = planItemRes[i].covTermRiderInd
                this.planData.quotplanList.push(quotplanList)
              }
            }
            const insertData = await this.$api.insertPlan(this.planData)
            console.log(insertData)
          } else {
            this.isPrint = false
            this.showDialog = true
            this.message = []
            if (prinf.responseCode === 1064) {
              this.message[0] = getCaption(planName) + '- 年繳保費少於' + money + '$' + prinf.body.amount.toLocaleString() + ' 限額！'
            } else if (prinf.responseCode === 1065) {
              this.message[0] = getCaption(planName) + '- 年繳保費大於' + money + '$' + prinf.body.amount.toLocaleString() + ' 限額！'
            }
          }
        }
      } else {
        this.showDialog = true
        this.valite()
      }
    },
    printf() {
      this.overlay = true
      axios
        .post(baseUrl.dev + '/mailMerge/proposalDownload.json', { quotNo: this.salesInfo.proposalId }, { responseType: 'blob' })
        .then(res => {
          this.overlay = false
          if (res.status === 200) {
            this['proposal/UPDATE_PREVIEWED'](true)
            const aTag = document.createElement('a')
            const blob = new Blob([res.data], {
              type: `application/pdf;charset-UTF-8`
            })
            const pdfName = this.salesInfo.proposalId.replace('-', '')
            aTag.setAttribute('download', pdfName)
            aTag.href = window.URL.createObjectURL(blob)
            document.body.appendChild(aTag)
            aTag.click()
          }
        })
    },
    async getDetail() {
      const res = await this.$api.showquotdetail({ quotNo: this.salesInfo.proposalId })
      if (res.body.planList.length > 0) {
        this.basePlan.inputPremium = toThousands(res.body.planList[0].quplanSumInsured)
        this.basePlan.premium = formatMoney(String(res.body.planList[0].quplanAnnPremium))
        this.sumMoney = res.body.planList.reduce((pre, cur) => {
          return pre + cur.quplanAnnPremium
        }, 0)
        this.summation.premiumsPerYear = this.summation.premiums = formatMoney(this.sumMoney.toFixed(2))
        axios.all([this.getItems()]).then(res => {
          if (this.basisChecked) {
            this.addPlan.splice(this.addPlan.findIndex(item => item.key === 'LTR-T'), 1)[0]
          }
          this.sum()
          this.isPrint = true
        })
      } else {
        this.basePlan.free = false
        this.basisChecked = false
        if (this.addPlan.find(item => item.key === 'LTR-T') !== undefined) {
          this.addPlan.splice(this.addPlan.findIndex(item => item.covClass === '*' && item.showSumInsured === 'W'), 1)
        }
        this.clearPremium()
        this.basePlan.inputPremium = '0'
        this.isPrint = false
      }
    }
  }
}
</script>
<style lang='scss'>
.text_fr input {
  text-align: right !important;
}
.baseColor .accent--text {
  color: #D99A56 !important;
}
.freeColor .accent--text {
  color: #52a5b5 !important;
}
.printColor {
  background: #1ab394 !important;
  color: #fff !important;
}
.blueColor {
  background: #52a5b5 !important;
  color: #fff !important;
}
.bgLoad {
  opacity: 0.46;
  background-color: rgb(33, 33, 33);
  border-color: rgb(33, 33, 33);
  border-radius: inherit;
  bottom: 0;
  height: 100%;
  left: 0;
  position: absolute;
  right: 0;
  top: 0;
  transition: inherit;
  width: 100%;
  .loading {
    align-items: center;
    border-radius: inherit;
    display: flex;
    justify-content: center;
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    pointer-events: none;
    transition: .3s cubic-bezier(.25,.8,.5,1),
    z-index 1ms;
    color: #fff;
  }
}
</style>
