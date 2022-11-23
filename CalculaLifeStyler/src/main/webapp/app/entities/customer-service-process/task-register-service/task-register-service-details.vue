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
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterService.name')">name</label>
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
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterService.serviceDate')">serviceDate</label>
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
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterService.orderDescription')"
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
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterService.customerName')">customerName</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="customerName"
                id="customer-service-customerName"
                data-cy="customerName"
                v-model="taskContext.customerServiceProcess.customerService.customerName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('calculaLifeStylerApp.taskRegisterService.employeeName')">employeeName</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="employeeName"
                id="customer-service-employeeName"
                data-cy="employeeName"
                v-model="taskContext.customerServiceProcess.customerService.employeeName"
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
          :to="`/process-definition/CustomerServiceProcess/task/TaskRegisterService/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-register-service-details.component.ts"></script>
