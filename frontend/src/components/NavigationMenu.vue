<template>
  <n-menu
    :options="menuOptions"
    :default-value="defaultMenu"
    :collapsed="false"
    @update:value="onSelect"
  />
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()
const defaultMenu = 'dashboard'

const menuOptions = [
  {
    label: 'Dashboard',
    key: 'dashboard'
  },
  {
    label: 'Customers',
    key: 'customers'
  },
  {
    label: 'Invoices',
    key: 'invoices'
  },
  {
    label: 'Reports',
    key: 'reports'
  }
]

function onSelect(key) {
  router.push(`/${key}`)
}
</script>
