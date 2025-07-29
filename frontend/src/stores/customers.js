import {defineStore} from "pinia";
import {reactive} from "vue";

export const useCustomerStore = defineStore('customers-store', () => {
  const form = reactive({
    id: null,
    name: '',
    email: '',
    phone: '',
    company: '',
    taxId: '',
    country: '',
    status: 'ACTIVE',
    addresses: [
      {
        street: '',
        city: '',
        postalCode: '',
        country: '',
        isPrimary: true
      }
    ]
  })

  const countryOptions = [
    {label: 'Greece', value: 'GR'},
    {label: 'USA', value: 'US'},
    {label: 'Germany', value: 'DE'},
    {label: 'UK', value: 'UK'}
  ]

  return {
    form,
    countryOptions
  }
})
