<template>
  <div>
    <n-dynamic-input
      v-model:value="form.addresses"
      :on-create="createAddress"
      item-style="margin-bottom: 1rem; border-bottom: 1px solid rgba(0,0,0,0.1)"
      show-sort-button
    >
      <template #default="{ value, index }">
        <n-grid x-gap="12" :cols="6" responsive="self">
          <n-gi span="1 m:2 l:4">
            <n-form-item :label="'Street'" :path="`addresses[${index}].street`">
              <n-input v-model:value="value.street" placeholder="Street address"/>
            </n-form-item>
          </n-gi>
          <n-gi>
            <n-form-item :label="'City'" :path="`addresses[${index}].city`">
              <n-input v-model:value="value.city" placeholder="City"/>
            </n-form-item>
          </n-gi>
          <n-gi>
            <n-form-item :label="'Postal Code'" :path="`addresses[${index}].postalCode`">
              <n-input v-model:value="value.postalCode" placeholder="e.g. 10001"/>
            </n-form-item>
          </n-gi>
          <n-gi>
            <n-form-item :label="'Country'" :path="`addresses[${index}].country`">
              <n-select
                v-model:value="value.country"
                :options="countryOptions"
                placeholder="Select country"
              />
            </n-form-item>
          </n-gi>
          <n-gi :span="2">
            <n-form-item :label="'Primary Address'" :path="`addresses[${index}].isPrimary`">
            <n-checkbox v-model:checked="value.isPrimary"
                        @update:checked="() => setPrimary(index)">
            </n-checkbox>
            </n-form-item>
          </n-gi>
        </n-grid>
      </template>
    </n-dynamic-input>
  </div>
</template>

<script setup>
import {useCustomerStore} from "@/stores/customers.js";
import {storeToRefs} from "pinia";

const customerStore = useCustomerStore()
const { countryOptions } = customerStore
const { form } = storeToRefs(customerStore)

function createAddress() {
  return {
    street: '',
    city: '',
    postalCode: '',
    country: '',
    isPrimary: false
  }
}

function setPrimary(index) {
  form.value.addresses.forEach((addr, i) => {
    addr.isPrimary = i === index
  })
}
</script>
