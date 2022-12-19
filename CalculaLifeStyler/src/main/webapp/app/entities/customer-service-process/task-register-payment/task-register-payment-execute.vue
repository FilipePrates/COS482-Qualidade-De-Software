<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('calculaLifeStylerApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('calculaLifeStylerApp.taskRegisterPayment.name')"
                for="task-register-payment-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-register-payment-name"
                readonly
                data-cy="name"
                :class="{
                  valid: !$v.taskContext.customerServiceProcess.customerService.name.$invalid,
                  invalid: $v.taskContext.customerServiceProcess.customerService.name.$invalid,
                }"
                v-model="$v.taskContext.customerServiceProcess.customerService.name.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('calculaLifeStylerApp.taskRegisterPayment.serviceDate')"
                for="task-register-payment-serviceDate"
                >Service Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-register-payment-serviceDate"
                  readonly
                  data-cy="serviceDate"
                  type="text"
                  class="form-control"
                  name="serviceDate"
                  :class="{
                    valid: !$v.taskContext.customerServiceProcess.customerService.serviceDate.$invalid,
                    invalid: $v.taskContext.customerServiceProcess.customerService.serviceDate.$invalid,
                  }"
                  v-model="$v.taskContext.customerServiceProcess.customerService.serviceDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('calculaLifeStylerApp.taskRegisterPayment.customerSatisfaction')"
                for="task-register-payment-customerSatisfaction"
                >Customer Satisfaction</label
              >
              <input
                type="checkbox"
                class="form-check"
                name="customerSatisfaction"
                id="task-register-payment-customerSatisfaction"
                data-cy="customerSatisfaction"
                :class="{
                  valid: !$v.taskContext.customerServiceProcess.customerService.customerSatisfaction.$invalid,
                  invalid: $v.taskContext.customerServiceProcess.customerService.customerSatisfaction.$invalid,
                }"
                v-model="$v.taskContext.customerServiceProcess.customerService.customerSatisfaction.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('calculaLifeStylerApp.taskRegisterPayment.orderDescription')"
                for="task-register-payment-orderDescription"
                >Order Description</label
              >
              <input
                type="text"
                class="form-control"
                name="orderDescription"
                id="task-register-payment-orderDescription"
                data-cy="orderDescription"
                :class="{
                  valid: !$v.taskContext.customerServiceProcess.customerService.orderDescription.$invalid,
                  invalid: $v.taskContext.customerServiceProcess.customerService.orderDescription.$invalid,
                }"
                v-model="$v.taskContext.customerServiceProcess.customerService.orderDescription.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('calculaLifeStylerApp.taskRegisterPayment.isThereExtraExpenses')"
                for="task-register-payment-isThereExtraExpenses"
                >Is There Extra Expenses</label
              >
              <input
                type="checkbox"
                class="form-check"
                name="isThereExtraExpenses"
                id="task-register-payment-isThereExtraExpenses"
                data-cy="isThereExtraExpenses"
                :class="{
                  valid: !$v.taskContext.customerServiceProcess.customerService.isThereExtraExpenses.$invalid,
                  invalid: $v.taskContext.customerServiceProcess.customerService.isThereExtraExpenses.$invalid,
                }"
                v-model="$v.taskContext.customerServiceProcess.customerService.isThereExtraExpenses.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('calculaLifeStylerApp.taskRegisterPayment.paymentValue')"
                for="task-register-payment-paymentValue"
                >Payment Value</label
              >
              <input
                type="number"
                class="form-control"
                name="paymentValue"
                id="task-register-payment-paymentValue"
                data-cy="paymentValue"
                :class="{
                  valid: !$v.taskContext.customerServiceProcess.customerService.paymentValue.$invalid,
                  invalid: $v.taskContext.customerServiceProcess.customerService.paymentValue.$invalid,
                }"
                v-model.number="$v.taskContext.customerServiceProcess.customerService.paymentValue.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('calculaLifeStylerApp.taskRegisterPayment.paymentDescription')"
                for="task-register-payment-paymentDescription"
                >Payment Description</label
              >
              <input
                type="text"
                class="form-control"
                name="paymentDescription"
                id="task-register-payment-paymentDescription"
                data-cy="paymentDescription"
                :class="{
                  valid: !$v.taskContext.customerServiceProcess.customerService.paymentDescription.$invalid,
                  invalid: $v.taskContext.customerServiceProcess.customerService.paymentDescription.$invalid,
                }"
                v-model="$v.taskContext.customerServiceProcess.customerService.paymentDescription.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-register-payment-execute.component.ts"></script>
