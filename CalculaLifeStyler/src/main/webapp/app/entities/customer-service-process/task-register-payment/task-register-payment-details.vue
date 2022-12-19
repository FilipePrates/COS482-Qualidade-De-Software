<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('calculaLifeStylerApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterPayment.name')">name</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="name"
                id="customer-service-name"
                data-cy="name"
                v-model="taskContext.customerServiceProcess.customerService.name"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterPayment.serviceDate')">serviceDate</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="serviceDate"
                id="customer-service-serviceDate"
                data-cy="serviceDate"
                v-model="taskContext.customerServiceProcess.customerService.serviceDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterPayment.customerSatisfaction')"
                >customerSatisfaction</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="customerSatisfaction"
                id="customer-service-customerSatisfaction"
                data-cy="customerSatisfaction"
                v-model="taskContext.customerServiceProcess.customerService.customerSatisfaction"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterPayment.orderDescription')"
                >orderDescription</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="orderDescription"
                id="customer-service-orderDescription"
                data-cy="orderDescription"
                v-model="taskContext.customerServiceProcess.customerService.orderDescription"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterPayment.isThereExtraExpenses')"
                >isThereExtraExpenses</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="isThereExtraExpenses"
                id="customer-service-isThereExtraExpenses"
                data-cy="isThereExtraExpenses"
                v-model="taskContext.customerServiceProcess.customerService.isThereExtraExpenses"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterPayment.paymentValue')">paymentValue</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="paymentValue"
                id="customer-service-paymentValue"
                data-cy="paymentValue"
                v-model="taskContext.customerServiceProcess.customerService.paymentValue"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterPayment.paymentDescription')"
                >paymentDescription</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="paymentDescription"
                id="customer-service-paymentDescription"
                data-cy="paymentDescription"
                v-model="taskContext.customerServiceProcess.customerService.paymentDescription"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/CustomerServiceProcess/task/TaskRegisterPayment/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-register-payment-details.component.ts"></script>
