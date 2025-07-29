<template>
  <div>
    <n-grid x-gap="12" :cols="'1 400:2 800:4'" item-responsive>
      <n-gi>
        <n-form-item label="Name" path="name">
          <n-input v-model:value="form.name" placeholder="Enter full name" required/>
        </n-form-item>
      </n-gi>
      <n-gi>
        <n-form-item label="Email" path="email">
          <n-input v-model:value="form.email" placeholder="e.g. john@domain.com" required/>
        </n-form-item>
      </n-gi>
      <n-gi>
        <n-form-item label="Phone" path="phone">
          <n-input v-model:value="form.phone" placeholder="Phone number"/>
        </n-form-item>
      </n-gi>
      <n-gi>
        <n-form-item label="Company" path="company">
          <n-input v-model:value="form.company" placeholder="e.g. Invoicer Inc."/>
        </n-form-item>
      </n-gi>

      <n-gi>
        <n-form-item label="Tax ID" path="taxId">
          <n-input v-model:value="form.taxId" placeholder="Optional tax ID"/>
        </n-form-item>
      </n-gi>
      <n-gi>
        <n-form-item label="Country" path="country">
          <n-select
            v-model:value="form.country"
            :options="countryOptions"
            placeholder="Select country"
          />
        </n-form-item>
      </n-gi>
      <n-gi>
        <n-form-item label="Status" path="status">
          <n-select
            v-model:value="form.status"
            :options="statusOptions"
            placeholder="Select status"
          />
        </n-form-item>
      </n-gi>
    </n-grid>
  </div>
</template>
<script setup lang="ts">
import {storeToRefs} from "pinia";
import { useCustomerStore } from "@/stores/customers"

const customerStore = useCustomerStore()
const { countryOptions } = customerStore
const { form } = storeToRefs(customerStore)

const statusOptions = [
  {label: 'Active', value: 'ACTIVE'},
  {label: 'Inactive', value: 'INACTIVE'},
  {label: 'Blacklisted', value: 'BLACKLISTED'},
]

</script>
