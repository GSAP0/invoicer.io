<template>
  <div>
    <h1 style="margin-top: 0">Customers</h1>
    <n-data-table bordered
                  :loading size="small"
                  :columns="columns"
                  :data="customers"
                  :pagination="pagination"
                  :row-key="rowKey"
    />
  </div>
</template>

<script setup>
import {h, ref} from 'vue'
import {getCustomers} from '@/api/customers'
import {NButton} from "naive-ui";
import RowActionDropdown from "@/components/RowActionDropdown.vue";

const loading = ref(true)
const customers = ref([])

const rowKey = (row) => row.id

getCustomers()
  .then((res) => customers.value = res.data)
  .finally(() => loading.value = false)


const columns = [
  {
    type: 'selection'
  },
  {
    title: '#',
    key: 'id'
  },
  {
    title: 'Name',
    key: 'name'
  },
  {
    title: 'Action',
    key: 'actions',
    render(row) {
      return h(RowActionDropdown, {
        row,
        onAction: ({ action, row }) => {
          switch (action) {
            case 'view':
              // open view modal or navigate
              break
            case 'edit':
              // open edit form
              break
            case 'delete':
              // show confirm dialog
              break
          }
        }
      })
    }
  }
]

const pagination = {pageSize: 10}
</script>
