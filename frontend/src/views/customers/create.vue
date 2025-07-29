<template>
  <div>
    <h2>Create Customer</h2>
    <CustomerForm @submit="handleSubmit" @cancel="goBack"/>
  </div>
</template>

<script setup>
import CustomerForm from '@/components/customers/form/CustomerForm.vue'
import {useRouter} from 'vue-router'
import {useLoadingBar, useMessage} from 'naive-ui'
import {createCustomer} from '@/api/customers'

const router = useRouter()
const message = useMessage()
const loadingBar = useLoadingBar()

async function handleSubmit(data) {
  loadingBar.start()
  try {
    await createCustomer(data)
    message.success('Customer created')
    await router.push('/customers')
  }catch(e){
    message.error(e.message)
  }finally {
    loadingBar.finish()
  }
}

function goBack() {
  router.back()
}
</script>
