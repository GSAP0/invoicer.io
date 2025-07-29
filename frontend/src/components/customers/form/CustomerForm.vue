<template>
  <n-form
    ref="formRef"
    :model="customerStore.form"
    :rules="rules"
    label-width="120"
    label-placement="top"
    require-mark-placement="right-hanging"
  >
    <n-tabs
      type="line"
      animated
    >
      <n-tab-pane name="general" tab="General">
        <GeneralTab></GeneralTab>
      </n-tab-pane>
      <n-tab-pane name="address" tab="Addresses">
        <AddressTab></AddressTab>
      </n-tab-pane>
    </n-tabs>


      <div class="form-actions">
        <n-button @click="$emit('cancel')">Cancel</n-button>
        <n-button type="primary" @click="handleSubmit">Save</n-button>
      </div>
  </n-form>
</template>

<script setup>
import { watch,  useTemplateRef} from 'vue'
import {useMessage} from "naive-ui";
import { useCustomerStore } from "@/stores/customers.js";
import GeneralTab from "@/components/customers/form/GeneralTab.vue";
import AddressTab from "@/components/customers/form/AddressTab.vue";

const props = defineProps({
  modelValue: Object
})

const emit = defineEmits(['submit', 'cancel'])

const message = useMessage()
const customerStore = useCustomerStore()

const formRef = useTemplateRef("formRef")

watch(
  () => props.modelValue,
  (val) => {
    if (val) Object.assign(customerStore.form, val)
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

async function handleSubmit(e) {
  e.preventDefault()
  const errors = await formRef.value?.validate()
  if (errors.length > 0) {
    message.error('Please check the form for errors')
    console.error(errors)
    return
  }
  emit('submit', {...customerStore.form})
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
