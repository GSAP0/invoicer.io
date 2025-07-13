<template>
  <n-form
    ref="formRef"
    :model="form"
    :rules="rules"
    label-width="120"
    label-placement="left"
    require-mark-placement="right-hanging"
  >
    <n-divider>General info</n-divider>
    <n-grid x-gap="12" :cols="2">
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

      <n-gi :span="2">
        <n-form-item label="Notes" path="notes">
          <n-input
            v-model:value="form.notes"
            type="textarea"
            placeholder="Optional internal notes"
          />
        </n-form-item>
      </n-gi>
    </n-grid>

    <n-divider>Addresses</n-divider>

    <n-dynamic-input
      v-model:value="form.addresses"
      :on-create="createAddress"
      item-style="margin-bottom: 16px"
    >
      <template #default="{ value, index }">
        <n-grid x-gap="12" :cols="2">
          <n-gi>
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
            <n-checkbox v-model:checked="value.isPrimary" @update:checked="() => setPrimary(index)">
              Primary Address
            </n-checkbox>
          </n-gi>
        </n-grid>
      </template>
    </n-dynamic-input>

    <div class="form-actions">
      <n-button @click="$emit('cancel')">Cancel</n-button>
      <n-button type="primary" @click="handleSubmit">Save</n-button>
    </div>
  </n-form>
</template>

<script setup>
import {reactive, watch, computed, useTemplateRef} from 'vue'
import {useMessage} from "naive-ui";

const props = defineProps({
  modelValue: Object
})

const emit = defineEmits(['submit', 'cancel'])

const message = useMessage()

const formRef = useTemplateRef("formRef")

const form = reactive({
  name: '',
  email: '',
  phone: '',
  company: '',
  taxId: '',
  country: '',
  notes: '',
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

watch(
  () => props.modelValue,
  (val) => {
    if (val) Object.assign(form, val)
  },
  {immediate: true}
)

const rules = {
  name: [{required: true, message: 'Name is required', trigger: 'blur'}],
  email: [
    {required: true, message: 'Email is required', trigger: 'blur'},
    {type: 'email', message: 'Invalid email format', trigger: 'blur'}
  ]
}

const countryOptions = [
  {label: 'Greece', value: 'GR'},
  {label: 'USA', value: 'US'},
  {label: 'Germany', value: 'DE'},
  {label: 'UK', value: 'UK'}
]

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
  form.addresses.forEach((addr, i) => {
    addr.isPrimary = i === index
  })
}

async function handleSubmit(e) {
  e.preventDefault()
  const errors = await formRef.value?.validate()
  if (errors.length > 0) {
    message.error('Please check the form for errors')
    console.error(errors)
    return
  }
  emit('submit', {...form})
}
</script>

<style scoped>
.form-actions {
  margin-top: 1.5rem;
  display: flex;
  justify-content: flex-end;
  gap: 0.75rem;
}
</style>
