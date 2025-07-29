<template>
  <div v-if="customer">
    <h2>Edit Customer</h2>
    <CustomerForm :model-value="customer" @submit="handleSubmit" @cancel="goBack" />
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { getCustomerById, updateCustomer } from '@/api/customers'
import CustomerForm from '@/components/customers/form/CustomerForm.vue'
import { useMessage } from 'naive-ui'

const route = useRoute()
const router = useRouter()
const message = useMessage()
const customer = ref(null)

onMounted(() => {
  const id = route.params.id
  getCustomerById(id).then((res) => {
    customer.value = res.data
  })
})

function handleSubmit(data) {
  updateCustomer(route.params.id, data).then(() => {
    message.success('Customer updated')
    router.push('/customers')
  })
}

function goBack() {
  router.back()
}
</script>
