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
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterExpenses.name')">name</label>
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
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterExpenses.serviceDate')">serviceDate</label>
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
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterExpenses.expenseValue')">expenseValue</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="expenseValue"
                id="customer-service-expenseValue"
                data-cy="expenseValue"
                v-model="taskContext.customerServiceProcess.customerService.expenseValue"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterExpenses.expenseDescription')"
                >expenseDescription</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="expenseDescription"
                id="customer-service-expenseDescription"
                data-cy="expenseDescription"
                v-model="taskContext.customerServiceProcess.customerService.expenseDescription"
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
          :to="`/process-definition/CustomerServiceProcess/task/TaskRegisterExpenses/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-register-expenses-details.component.ts"></script>
