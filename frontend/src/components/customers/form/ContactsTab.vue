<template>
  <div>
    <n-dynamic-input
      v-model:value="form.contactPeople"
      :on-create="createContact"
      item-style="margin-bottom: 1rem; border-bottom: 1px solid rgba(0,0,0,0.1)"
      show-sort-button
    >
      <template #default="{ value, index }">
        <n-grid x-gap="12" :cols="'1 600:2 800:4'" item-responsive>
          <n-gi>
            <n-form-item label="Name" :path="`contactPeople[${index}].fullName`">
              <n-input v-model:value="value.fullName" placeholder="Name of the person"/>
            </n-form-item>
          </n-gi>
          <n-gi >
            <n-form-item :label="'Phone'" :path="`contactPeople[${index}].phone`">
              <n-input v-model:value="value.phone" placeholder="Phone"/>
            </n-form-item>
          </n-gi>
          <n-gi>
            <n-form-item :label="'Email'" :path="`contactPeople[${index}].email`">
              <n-input v-model:value="value.email" placeholder="Email"/>
            </n-form-item>
          </n-gi>
          <n-gi>
            <n-form-item :label="'Role'" :path="`contactPeople[${index}].role`">
              <n-input v-model:value="value.role" placeholder="eg. Account Manager"/>
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
const { form } = storeToRefs(customerStore)

function createContact() {
  return {
    label: '',
    street: '',
    city: '',
    postalCode: '',
    country: '',
    primaryAddress: false
  }
}
</script>
