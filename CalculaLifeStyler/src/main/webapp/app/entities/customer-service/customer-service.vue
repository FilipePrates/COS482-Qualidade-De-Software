<template>
  <div>
    <h2 id="page-heading" data-cy="CustomerServiceHeading">
      <span v-text="$t('calculaLifeStylerApp.customerService.home.title')" id="customer-service-heading">Customer Services</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('calculaLifeStylerApp.customerService.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && customerServices && customerServices.length === 0">
      <span v-text="$t('calculaLifeStylerApp.customerService.home.notFound')">No customerServices found</span>
    </div>
    <div class="table-responsive" v-if="customerServices && customerServices.length > 0">
      <table class="table table-striped" aria-describedby="customerServices">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('calculaLifeStylerApp.customerService.name')">Name</span></th>
            <th scope="row"><span v-text="$t('calculaLifeStylerApp.customerService.serviceDate')">Service Date</span></th>
            <th scope="row"><span v-text="$t('calculaLifeStylerApp.customerService.customerName')">Customer Name</span></th>
            <th scope="row"><span v-text="$t('calculaLifeStylerApp.customerService.employeeName')">Employee Name</span></th>
            <th scope="row"><span v-text="$t('calculaLifeStylerApp.customerService.customerSatisfaction')">Customer Satisfaction</span></th>
            <th scope="row">
              <span v-text="$t('calculaLifeStylerApp.customerService.isThereExtraExpenses')">Is There Extra Expenses</span>
            </th>
            <th scope="row"><span v-text="$t('calculaLifeStylerApp.customerService.orderDescription')">Order Description</span></th>
            <th scope="row"><span v-text="$t('calculaLifeStylerApp.customerService.paymentValue')">Payment Value</span></th>
            <th scope="row"><span v-text="$t('calculaLifeStylerApp.customerService.paymentDescription')">Payment Description</span></th>
            <th scope="row"><span v-text="$t('calculaLifeStylerApp.customerService.expenseValue')">Expense Value</span></th>
            <th scope="row"><span v-text="$t('calculaLifeStylerApp.customerService.expenseDescription')">Expense Description</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="customerService in customerServices" :key="customerService.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CustomerServiceView', params: { customerServiceId: customerService.id } }">{{
                customerService.id
              }}</router-link>
            </td>
            <td>{{ customerService.name }}</td>
            <td>{{ customerService.serviceDate }}</td>
            <td>{{ customerService.customerName }}</td>
            <td>{{ customerService.employeeName }}</td>
            <td>{{ customerService.customerSatisfaction }}</td>
            <td>{{ customerService.isThereExtraExpenses }}</td>
            <td>{{ customerService.orderDescription }}</td>
            <td>{{ customerService.paymentValue }}</td>
            <td>{{ customerService.paymentDescription }}</td>
            <td>{{ customerService.expenseValue }}</td>
            <td>{{ customerService.expenseDescription }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'CustomerServiceView', params: { customerServiceId: customerService.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="calculaLifeStylerApp.customerService.delete.question"
          data-cy="customerServiceDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-customerService-heading" v-text="$t('calculaLifeStylerApp.customerService.delete.question', { id: removeId })">
          Are you sure you want to delete this Customer Service?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-customerService"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeCustomerService()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./customer-service.component.ts"></script>
