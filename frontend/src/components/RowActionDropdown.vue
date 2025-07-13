<template>
  <n-dropdown :options="dropdownOptions" @select="onSelect">
    <n-button size="small" quaternary>
      Actions ▾
    </n-button>
  </n-dropdown>
</template>

<script setup>
import { h } from 'vue'
import { useDialog, NIcon } from 'naive-ui'
import { Eye, Edit3, Trash2 } from 'lucide-vue-next'

const props = defineProps({
  row: { type: Object, required: true },
  actions: {
    type: Array,
    default: () => [
      { label: 'View', key: 'view', icon: Eye },
      { label: 'Edit', key: 'edit', icon: Edit3 },
      { label: 'Delete', key: 'delete', icon: Trash2 }
    ]
  }
})

const emit = defineEmits(['action'])
const dialog = useDialog()

const dropdownOptions = props.actions.map(action => ({
  label: action.label,
  key: action.key,
  icon: () => h(NIcon, null, { default: () => h(action.icon) })
}))

function onSelect(key) {
  if (key === 'delete') {
    dialog.warning({
      title: 'Confirm Deletion',
      content: 'Are you sure you want to delete this item?',
      positiveText: 'Delete',
      negativeText: 'Cancel',
      onPositiveClick: () => {
        emit('action', { action: key, row: props.row })
      }
    })
  } else {
    emit('action', { action: key, row: props.row })
  }
}
</script>
