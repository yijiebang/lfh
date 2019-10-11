// import parseTime, formatTime and set to filter
// export { parseTime, formatTime } from '@/utils'

/**
 * Show plural label if time is plural number
 * @param {number} time
 * @param {string} label
 * @return {string}
 */
function pluralize(time, label) {
  if (time === 1) {
    return time + label
  }
  return time + label + 's'
}

/**
 * @param {number} time
 */
export function timeAgo(time) {
  const between = Date.now() / 1000 - Number(time)
  if (between < 3600) {
    return pluralize(~~(between / 60), ' minute')
  } else if (between < 86400) {
    return pluralize(~~(between / 3600), ' hour')
  } else {
    return pluralize(~~(between / 86400), ' day')
  }
}

/**
 * Number formatting
 * like 10000 => 10k
 * @param {number} num
 * @param {number} digits
 */
export function numberFormatter(num, digits) {
  const si = [
    { value: 1E18, symbol: 'E' },
    { value: 1E15, symbol: 'P' },
    { value: 1E12, symbol: 'T' },
    { value: 1E9, symbol: 'G' },
    { value: 1E6, symbol: 'M' },
    { value: 1E3, symbol: 'k' }
  ]
  for (let i = 0; i < si.length; i++) {
    if (num >= si[i].value) {
      return (num / si[i].value + 0.1).toFixed(digits).replace(/\.0+$|(\.[0-9]*[1-9])0+$/, '$1') + si[i].symbol
    }
  }
  return num.toString()
}

/**
 * 10000 => "10,000"
 * @param {number} num
 */
export function formatMoney(s) {
  if (/[^0-9\.]/.test(s)) return 'invalid value'
  s = s.replace(/^(\d*)$/, '$1.')
  s = (s + '00').replace(/(\d*\.\d\d)\d*/, '$1')
  s = s.replace('.', ',')
  var re = /(\d)(\d{3},)/
  while (re.test(s)) {
    s = s.replace(re, '$1,$2')
  }
  s = s.replace(/,(\d\d)$/, '.$1')
  return s.replace(/^\./, '0.')
}

export function toThousands(num) {
  var result = []; var counter = 0
  num = (num || 0).toString().split('')
  for (var i = num.length - 1; i >= 0; i--) {
    counter++
    result.unshift(num[i])
    if (!(counter % 3) && i !== 0) { result.unshift(',') }
  }
  return result.join('')
}
// 截取‘-’之后的字符串
export function getCaption(obj) {
  var index = obj.indexOf('\-')
  obj = obj.substring(index + 1, obj.length)
  return obj
}
// 防止页面后退
export function disableHistory(url) {
  history.pushState(null, null, url)
  window.addEventListener('popstate', function() {
    history.pushState(null, null, url)
  })
}
