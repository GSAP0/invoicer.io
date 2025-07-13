<template>
  <div>
    <h2>Create Customer</h2>
    <CustomerForm @submit="handleSubmit" @cancel="goBack"/>
  </div>
</template>

<script setup>
import CustomerForm from '@/components/customers/CustomerForm.vue'
import {useRouter} from 'vue-router'
import {useLoadingBar, useMessage} from 'naive-ui'
import {createCustomer} from '@/api/customers'

const router = useRouter()
const message = useMessage()
const loadingBar = useLoadingBar()

async function handleSubmit(data) {
  loadingBar.start()
  await createCustomer(data)
  message.success('Customer created')
  loadingBar.finish()
  await router.push('/customers')
}

function goBack() {
  router.back()
}
</script>
