export const GENDER = [{ label: '男', value: 'M' }, { label: '女', value: 'F' }]
export function filterGender(val) {
  const matchItem = GENDER.find(item => item.value === val)
  return matchItem ? matchItem.label : ''
}

export const SMOKER = [{ label: '吸煙者', value: 'Y'}, { label: '非吸煙者', value: 'N' }]
export function filterSmoker(val) {
  const matchItem = SMOKER.find(item => item.value === val)
  return matchItem ? matchItem.label : ''
}
