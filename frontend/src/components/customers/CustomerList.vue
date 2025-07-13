<template>
  <div>

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
import {getCustomers, deleteCustomer} from '@/api/customers'
import RowActionDropdown from "@/components/RowActionDropdown.vue";
import {useRouter} from "vue-router";
import {useMessage} from "naive-ui";

const router = useRouter()
const message = useMessage()

const loading = ref(true)
const customers = ref([])

const rowKey = (row) => row.id

function fetchCustomers() {
  return getCustomers()
    .then((res) => customers.value = res.data)
    .finally(() => loading.value = false)
}

fetchCustomers()

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
    title: 'Email',
    key: 'email'
  },
  {
    title: 'Action',
    key: 'actions',
    render(row) {
      return h(RowActionDropdown, {
        row,
        onAction: ({action, row}) => {
          switch (action) {
            case 'view':
              router.push(`/customers/${row.id}`)
              break
            case 'edit':
              router.push(`/customers/${row.id}/edit`)
              break
            case 'delete':
              deleteCustomer(row.id)
                .then(fetchCustomers)
                .then(() => message.success("Customer deleted"))

              break
          }
        }
      })
    }
  }
]

const pagination = {pageSize: 10}
</script>
