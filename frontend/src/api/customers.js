import api from './index'

export const getCustomers = () => api.get('/crm/customers')
export const getCustomerById = (id) => api.get(`/crm/customers/${id}`)
export const createCustomer = (data) => api.post('/crm/customers', data)
export const updateCustomer = (id, data) => api.put(`/crm/customers/${id}`, data)
export const deleteCustomer = (id) => api.delete(`/crm/customers/${id}`)
