<template>
  <div class="change-lang">
    <span
      :class="{ 'active-lang': currentLang === 'zh-CN' }"
      @click="switchLang('zh-CN')"
    >
      中文
    </span> /
    <span
      :class="{ 'active-lang': currentLang === 'en' }"
      @click="switchLang('en')"
    >
      En
    </span>
  </div>
</template>

<script>
export default {
  name: 'LangBar',
  data() {
    return {
      currentLang: this.$i18n.locale
    }
  },
  methods: {
    switchLang(lang = 'zh-CN') {
      this.currentLang = lang
      this.$locale.use(lang)
    }
  }
}
</script>

<style lang="scss" scoped>
.change-lang {
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;

  span {
    cursor: pointer;
    padding: 0 2px;
    color: #c0c4cc;

    &.active-lang {
      color: #0302f5;
    }
  }
}
</style>
