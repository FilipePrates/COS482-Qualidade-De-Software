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
                v-text="$t('calculaLifeStylerApp.taskRegisterExpenses.name')"
                for="task-register-expenses-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-register-expenses-name"
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
                v-text="$t('calculaLifeStylerApp.taskRegisterExpenses.serviceDate')"
                for="task-register-expenses-serviceDate"
                >Service Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-register-expenses-serviceDate"
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
                v-text="$t('calculaLifeStylerApp.taskRegisterExpenses.expenseValue')"
                for="task-register-expenses-expenseValue"
                >Expense Value</label
              >
              <input
                type="number"
                class="form-control"
                name="expenseValue"
                id="task-register-expenses-expenseValue"
                data-cy="expenseValue"
                :class="{
                  valid: !$v.taskContext.customerServiceProcess.customerService.expenseValue.$invalid,
                  invalid: $v.taskContext.customerServiceProcess.customerService.expenseValue.$invalid,
                }"
                v-model.number="$v.taskContext.customerServiceProcess.customerService.expenseValue.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('calculaLifeStylerApp.taskRegisterExpenses.expenseDescription')"
                for="task-register-expenses-expenseDescription"
                >Expense Description</label
              >
              <input
                type="text"
                class="form-control"
                name="expenseDescription"
                id="task-register-expenses-expenseDescription"
                data-cy="expenseDescription"
                :class="{
                  valid: !$v.taskContext.customerServiceProcess.customerService.expenseDescription.$invalid,
                  invalid: $v.taskContext.customerServiceProcess.customerService.expenseDescription.$invalid,
                }"
                v-model="$v.taskContext.customerServiceProcess.customerService.expenseDescription.$model"
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

<script lang="ts" src="./task-register-expenses-execute.component.ts"></script>
