<script setup>
import {RouterLink, RouterView} from 'vue-router'
import DefaultLayout from "@/layouts/DefaultLayout.vue";
</script>

<template>
  <DefaultLayout>
    <n-config-provider>
    <n-dialog-provider>
      <RouterView/>
    </n-dialog-provider>
    </n-config-provider>
  </DefaultLayout>
</template>
