<template>
  <n-layout has-sider position="absolute" content-style="">
    <n-layout-sider
      bordered
      width="220"
      collapse-mode="width"
      show-trigger
      :native-scrollbar="false"
    >
      <div class="">
        <!-- Top Section: Logo + User -->
        <n-space vertical align="start" size="large" style="padding: 0 1rem;">
          <div style="font-size: 1.5rem; font-weight: bold;">Invoicer</div>

          <n-dropdown :options="userMenu" trigger="hover">
            <n-button quaternary> User (user@user.com)</n-button>
          </n-dropdown>
        </n-space>

        <n-divider style="margin-top:10px;margin-bottom: 10px"></n-divider>

        <!-- Bottom Section: Navigation -->
        <NavigationMenu />
      </div>
    </n-layout-sider>

    <n-layout content-style="background: #fafafa">
      <n-layout-content style="padding: 1rem;background: #fafafa;" content-style="background: #fafafa">
        <slot></slot>
      </n-layout-content>
    </n-layout>
  </n-layout>
</template>

<script setup>
import NavigationMenu from '@/components/NavigationMenu.vue'

const userMenu = [
  { label: 'Profile', key: 'profile' },
  { label: 'Logout', key: 'logout' }
]
</script>
