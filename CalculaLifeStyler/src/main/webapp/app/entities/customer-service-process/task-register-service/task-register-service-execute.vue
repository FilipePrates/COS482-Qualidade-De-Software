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
                v-text="$t('calculaLifeStylerApp.taskRegisterService.name')"
                for="task-register-service-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-register-service-name"
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
                v-text="$t('calculaLifeStylerApp.taskRegisterService.serviceDate')"
                for="task-register-service-serviceDate"
                >Service Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-register-service-serviceDate"
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
                v-text="$t('calculaLifeStylerApp.taskRegisterService.orderDescription')"
                for="task-register-service-orderDescription"
                >Order Description</label
              >
              <input
                type="text"
                class="form-control"
                name="orderDescription"
                id="task-register-service-orderDescription"
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
                v-text="$t('calculaLifeStylerApp.taskRegisterService.customerName')"
                for="task-register-service-customerName"
                >Customer Name</label
              >
              <input
                type="text"
                class="form-control"
                name="customerName"
                id="task-register-service-customerName"
                data-cy="customerName"
                :class="{
                  valid: !$v.taskContext.customerServiceProcess.customerService.customerName.$invalid,
                  invalid: $v.taskContext.customerServiceProcess.customerService.customerName.$invalid,
                }"
                v-model="$v.taskContext.customerServiceProcess.customerService.customerName.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('calculaLifeStylerApp.taskRegisterService.employeeName')"
                for="task-register-service-employeeName"
                >Employee Name</label
              >
              <input
                type="text"
                class="form-control"
                name="employeeName"
                id="task-register-service-employeeName"
                data-cy="employeeName"
                :class="{
                  valid: !$v.taskContext.customerServiceProcess.customerService.employeeName.$invalid,
                  invalid: $v.taskContext.customerServiceProcess.customerService.employeeName.$invalid,
                }"
                v-model="$v.taskContext.customerServiceProcess.customerService.employeeName.$model"
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

<script lang="ts" src="./task-register-service-execute.component.ts"></script>
