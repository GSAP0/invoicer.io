<script setup>
import {RouterLink, RouterView} from 'vue-router'
import DefaultLayout from "@/layouts/DefaultLayout.vue";
</script>

<template>
  <DefaultLayout>
    <n-config-provider>
      <n-loading-bar-provider>
      <n-message-provider>
        <n-dialog-provider>
          <RouterView/>
        </n-dialog-provider>
      </n-message-provider>
      </n-loading-bar-provider>
    </n-config-provider>
  </DefaultLayout>
</template>
