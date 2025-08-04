<template>
  <div>
    <n-dynamic-input
      v-model:value="form.notes"
      :on-create="createNote"
      item-style="margin-bottom: 1rem; border-bottom: 1px solid rgba(0,0,0,0.1)"
      show-sort-button
    >
      <template #default="{ value, index }">
        <div style="flex-grow: 1">
        <n-input type="textarea" v-model:value="value.content" placeholder="What is the note?"/> <br>
        <n-icon><Edit3></Edit3></n-icon>{{value.updatedAt}}
        </div>

      </template>
    </n-dynamic-input>
  </div>
</template>

<script setup>
import {useCustomerStore} from "@/stores/customers.js";
import {storeToRefs} from "pinia";
import { Edit3 } from 'lucide-vue-next'

const customerStore = useCustomerStore()
const {form} = storeToRefs(customerStore)

function createNote() {
  return {
    content: '',
  }
}
</script>
