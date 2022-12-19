<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="customerServiceProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="customerServiceProcessDetailsHeading">
          <span v-text="$t('calculaLifeStylerApp.customerServiceProcess.detail.title')">CustomerServiceProcess</span>
          {{ customerServiceProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="customerServiceProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('calculaLifeStylerApp.customerServiceProcess.detail.title')">CustomerServiceProcess</span> #{{
              customerServiceProcess.id
            }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="customerServiceProcess.customerService">
              <h5 class="card-header">
                <span class="title"> Customer Service #{{ customerServiceProcess.customerService.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('calculaLifeStylerApp.customerServiceProcess.name')">name</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="name"
                    id="customer-service-name"
                    data-cy="name"
                    v-model="customerServiceProcess.customerService.name"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('calculaLifeStylerApp.customerServiceProcess.serviceDate')"
                    >serviceDate</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="serviceDate"
                    id="customer-service-serviceDate"
                    data-cy="serviceDate"
                    v-model="customerServiceProcess.customerService.serviceDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('calculaLifeStylerApp.customerServiceProcess.customerName')"
                    >customerName</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="customerName"
                    id="customer-service-customerName"
                    data-cy="customerName"
                    v-model="customerServiceProcess.customerService.customerName"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('calculaLifeStylerApp.customerServiceProcess.employeeName')"
                    >employeeName</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="employeeName"
                    id="customer-service-employeeName"
                    data-cy="employeeName"
                    v-model="customerServiceProcess.customerService.employeeName"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('calculaLifeStylerApp.customerServiceProcess.customerSatisfaction')"
                    >customerSatisfaction</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="customerSatisfaction"
                    id="customer-service-customerSatisfaction"
                    data-cy="customerSatisfaction"
                    v-model="customerServiceProcess.customerService.customerSatisfaction"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('calculaLifeStylerApp.customerServiceProcess.isThereExtraExpenses')"
                    >isThereExtraExpenses</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="isThereExtraExpenses"
                    id="customer-service-isThereExtraExpenses"
                    data-cy="isThereExtraExpenses"
                    v-model="customerServiceProcess.customerService.isThereExtraExpenses"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('calculaLifeStylerApp.customerServiceProcess.orderDescription')"
                    >orderDescription</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="orderDescription"
                    id="customer-service-orderDescription"
                    data-cy="orderDescription"
                    v-model="customerServiceProcess.customerService.orderDescription"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('calculaLifeStylerApp.customerServiceProcess.paymentValue')"
                    >paymentValue</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="paymentValue"
                    id="customer-service-paymentValue"
                    data-cy="paymentValue"
                    v-model="customerServiceProcess.customerService.paymentValue"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('calculaLifeStylerApp.customerServiceProcess.paymentDescription')"
                    >paymentDescription</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="paymentDescription"
                    id="customer-service-paymentDescription"
                    data-cy="paymentDescription"
                    v-model="customerServiceProcess.customerService.paymentDescription"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('calculaLifeStylerApp.customerServiceProcess.expenseValue')"
                    >expenseValue</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="expenseValue"
                    id="customer-service-expenseValue"
                    data-cy="expenseValue"
                    v-model="customerServiceProcess.customerService.expenseValue"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('calculaLifeStylerApp.customerServiceProcess.expenseDescription')"
                    >expenseDescription</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="expenseDescription"
                    id="customer-service-expenseDescription"
                    data-cy="expenseDescription"
                    v-model="customerServiceProcess.customerService.expenseDescription"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./customer-service-process-details.component.ts"></script>
