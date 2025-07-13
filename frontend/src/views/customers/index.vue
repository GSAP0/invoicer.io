<template>
  <div>
    <h1 style="margin-top: 0">Customers</h1>
    <router-link to="/customers/create">
    <n-button style="margin-bottom: 1rem">Create new customer</n-button>
    </router-link>
  <CustomerList></CustomerList>
  </div>
</template>
<script setup lang="ts">
import CustomerList from "@/components/customers/CustomerList.vue";
</script>
